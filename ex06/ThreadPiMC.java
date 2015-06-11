import java.util.Random;

public class ThreadPiMC implements Runnable {

  private static final int NUM_THREAD = 8;

  // disk radius
  private static final double r = 1.0;
  private static double totalSum = 0.0;
  private static int totalNumSamples = 0;

  private int numSamples = 0;

  public ThreadPiMC(int numSamples) {
    this.numSamples = numSamples;
  }

  public double doMonteCarlo(int numSamples) {
    double sum = 0.0;
    // Pseudo random number generator
    Random rng = new Random();

    for (int i = 0; i < numSamples; ++i) {
      // Generate random samples from uniform distribution [-1,1]
      double xs = -1.0 + 2.0*rng.nextDouble();
      double ys = -1.0 + 2.0*rng.nextDouble();

      if ( (xs*xs+ys*ys) <= (r*r) ) {
        sum = sum + 1.0;
      }
    }

    // return (4.0 / num_samples * sum);
    return sum;
  }

  public void run() {
    double sum = doMonteCarlo(numSamples);
    totalSum += sum;
  }

  public static void main(String[] args) {
    if (args.length != 1) {
      System.out.println("PiMC num_samples");
      System.exit(1);
    }

    totalNumSamples = Integer.parseInt(args[0]);
    int numThreadSamples = totalNumSamples / NUM_THREAD;

    // Prepare threads
    Runnable[] runnables = new Runnable[NUM_THREAD];
    for ( int i = 0; i < NUM_THREAD; ++ i ) {
      if ( i + 1 < NUM_THREAD ) {
        runnables[i] = new ThreadPiMC(numThreadSamples);
      } else {
        runnables[i] = new ThreadPiMC(numThreadSamples + totalNumSamples % numThreadSamples);
      }
    }

    // Create threads
    Thread[] threads = new Thread[NUM_THREAD];
    for ( int i = 0; i < NUM_THREAD; ++ i ) {
      threads[i] = new Thread(runnables[i]);
    }

    // Run threads
    for ( int i = 0; i < NUM_THREAD; ++ i ) {
      threads[i].start();
    }

    // Wait threads
    try {
      for ( int i = 0; i < NUM_THREAD; ++ i ) {
        threads[i].join();
      }
    } catch(Exception e) {
      e.printStackTrace();
    }

    // Merge result: Calculate PI
    double piTilde = 4.0 / totalNumSamples * totalSum;
    System.out.println("Pi ~ " + piTilde);
  }
}

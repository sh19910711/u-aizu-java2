import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ThreadPiMC implements Runnable {

  private static final int NUM_THREAD = 8;

  // disk radius
  private static final double r = 1.0;
  private static int totalNumSamples = 0;

  public double sum = 0.0;
  private int numSamples = 0;

  public ThreadPiMC(int numSamples) {
    this.numSamples = numSamples;
  }

  public double doMonteCarlo(int numSamples) {
    double count = 0.0;
    // Pseudo random number generator
    // Random rng = new Random();

    for (int i = 0; i < numSamples; ++i) {
      // Generate random samples from uniform distribution [-1,1]
      double xs = -1.0 + 2.0*ThreadLocalRandom.current().nextDouble();
      double ys = -1.0 + 2.0*ThreadLocalRandom.current().nextDouble();

      if ( (xs*xs+ys*ys) <= (r*r) ) {
        count = count + 1.0;
      }
    }

    return count;
  }

  public void run() {
    sum = doMonteCarlo(numSamples);
  }

  public static void main(String[] args) {
    if (args.length != 1) {
      System.out.println("PiMC num_samples");
      System.exit(1);
    }

    totalNumSamples = Integer.parseInt(args[0]);
    int numThreadSamples = totalNumSamples / NUM_THREAD;

    // Prepare threads
    ThreadPiMC[] runnables = new ThreadPiMC[NUM_THREAD];
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
    double totalSum = 0.0;
    for ( int i = 0; i < NUM_THREAD; ++ i ) {
      totalSum += runnables[i].sum;
    }
    double piTilde = 4.0 / totalNumSamples * totalSum;
    System.out.println("Pi ~ " + piTilde);
  }
}

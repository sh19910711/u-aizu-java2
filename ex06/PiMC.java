import java.util.Random;

public class PiMC {
  // Estimate Pi by computing the area of a unit disk
  public static double estimateMC(int num_samples) {
    // disk radius
    double r = 1.0;
    double sum = 0.0;

    // Pseudo random number generator
    Random rng = new Random();

    for (int i = 0; i < num_samples; ++i) {
      // Generate random samples from uniform distribution [-1,1]
      double xs = -1.0 + 2.0*rng.nextDouble();
      double ys = -1.0 + 2.0*rng.nextDouble();

      if ( (xs*xs+ys*ys) <= (r*r) ) {
        sum = sum + 1.0;
      }
    }

    return (4.0 / num_samples * sum);
  }

  public static void main(String[] args) {
    if (args.length != 1) {
      System.out.println("PiMC num_samples");
      System.exit(1);
    }

    int num_samples = Integer.parseInt(args[0]);
    double pi_tilde = estimateMC(num_samples);
    System.out.println("Pi ~ " + pi_tilde);
  }
}

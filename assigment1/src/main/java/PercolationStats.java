import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private static final double COEFFICIENT = 1.96;

    private final int trials;
    private final double mean, stddev;

    public PercolationStats(int n, int trials) {   // perform trials independent experiments on an n-by-n grid
        if (n < 1 || trials < 1) {
            throw new IllegalArgumentException("Grid size and number of trials should be greater than 0");
        }

        this.trials = trials;
        double[] threshold = new double[trials];
        for (int i = 0; i < trials; i++) {
            Percolation percolation = new Percolation(n);
            while (!percolation.percolates()) {
                percolation.open(StdRandom.uniform(n) + 1, StdRandom.uniform(n) + 1);
            }
            threshold[i] = percolation.numberOfOpenSites() / Math.pow(n, 2);
        }
        mean = StdStats.mean(threshold);
        stddev = StdStats.stddev(threshold);
    }

    public static void main(String[] args) {       // test client (described below)
        StdOut.println("Please enter size of the grid");
        int n = StdIn.readInt();
        StdOut.println("Please enter number of trials");
        int trials = StdIn.readInt();
        PercolationStats percolationStats = new PercolationStats(n, trials);
        System.out.println("mean = " + percolationStats.mean());
        System.out.println("stddev = " + percolationStats.stddev());
        System.out.println(String.format("95%% confidence interval = [%4.3f, %4.3f]",
                percolationStats.confidenceLo(), percolationStats.confidenceHi()));
    }

    public double mean() {                         // sample mean of percolation threshold
        return mean;
    }

    public double stddev() {                        // sample mean of percolation threshold
        return stddev;          // sample standard deviation of percolation threshold
    }

    public double confidenceLo() {                 // low  endpoint of 95% confidence interval
        return mean - (COEFFICIENT * stddev / Math.sqrt(trials));
    }

    public double confidenceHi() {                 // high endpoint of 95% confidence interval
        return mean + (COEFFICIENT * stddev / Math.sqrt(trials));
    }
}
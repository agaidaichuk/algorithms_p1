import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private static final int TOP = 0;
    private final int bottom;
    private final int size;
    private final WeightedQuickUnionUF uf;
    private Integer[][] system;
    private int openCount = 0;

    public Percolation(int n) {                  // create n-by-n grid, with all sites blocked
        size = n;
        bottom = (size * size) + 1;
        if (n < 1) {
            throw new IllegalArgumentException("n should be greater than 0");
        }
        init();
        uf = new WeightedQuickUnionUF(size * size + 2);
    }

    public static void main(String[] args) {    // test client (optional)
    }

    public void open(int row, int col) {     // open site (row, col) if it is not open already
        verifyInput(row, col);
        if (!isOpen(row, col)) {
            system[row - 1][col - 1] = 0;
            openCount++;
            connectWithNeibourghs(row, col);
        }
    }

    private void connectWithNeibourghs(int row, int col) {
        int curr = (row - 1) * size + col;

        if (row == 1 || isOpen(row - 1, col)) {
            int up = row == 1 ? TOP : curr - size;
            uf.union(up, curr);
        }


        if (col != 1 && isOpen(row, col - 1)) {
            uf.union(curr - 1, curr);
        }

        if (col != size && isOpen(row, col + 1)) {
            uf.union(curr + 1, curr);
        }

        if (row == size) {
            uf.union(bottom, curr);
        } else if (isOpen(row + 1, col)) {
            uf.union(curr + size, curr);
        }
    }

    public boolean isOpen(int row, int col) {    // is site (row, col) open?
        verifyInput(row, col);
        return system[row - 1][col - 1] != null;
    }

    public boolean isFull(int row, int col) {   // is site (row, col) full?
        verifyInput(row, col);
        return isOpen(row, col) && uf.connected(TOP, (row - 1) * size + col);
    }

    public int numberOfOpenSites() {            // number of open sites
        return openCount;
    }

    public boolean percolates() {               // does the uf percolate?
        return uf.connected(TOP, bottom);
    }

    private void init() {
        system = new Integer[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                system[i][j] = null;
            }
        }
    }

    private void verifyInput(int row, int col) {
        if (row < 1 || row > size || col < 1 || col > size) {
            throw new IllegalArgumentException("Row and Col should be in the range between 1 and " + size);
        }
    }
}

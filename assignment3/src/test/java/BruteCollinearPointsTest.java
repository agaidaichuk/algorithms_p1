import org.junit.Test;


public class BruteCollinearPointsTest {

    @Test(expected = IllegalArgumentException.class)
    public void verifyNull() {

        new BruteCollinearPoints(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void verifyNullPoint() {

        new BruteCollinearPoints(new Point[]{null});
    }

    @Test(expected = IllegalArgumentException.class)
    public void verifyDuplicates() {
        Point p = new Point(1, 1);
        Point q = new Point(1, 2);
        Point r = new Point(2, 1);
        Point s = new Point(1, 1);
        new BruteCollinearPoints(new Point[]{p, q, r, s});
    }
}
import java.util.ArrayList;
import java.util.Arrays;

public class BruteCollinearPoints {
    private final ArrayList<LineSegment> lineSegments;

    public BruteCollinearPoints(Point[] originalPoints) {   // finds all line segments containing 4 points
        validateInput(originalPoints);
        lineSegments = new ArrayList<>();
        Point[] points = Arrays.copyOf(originalPoints, originalPoints.length);
        Arrays.sort(points);
        for (int i = 0; i < points.length - 3; i++) {
            for (int j = i + 1; j < points.length - 2; j++) {
                for (int k = j + 1; k < points.length - 1; k++) {
                    for (int m = k + 1; m < points.length; m++) {
                        Point p = points[i];
                        Point q = points[j];
                        Point r = points[k];
                        Point s = points[m];
                        if (Double.compare(p.slopeTo(q), p.slopeTo(r)) == 0 &&
                                Double.compare(p.slopeTo(r), p.slopeTo(s)) == 0) {
                            lineSegments.add(new LineSegment(p, s));
                        }
                    }
                }
            }
        }
    }

    public int numberOfSegments() {                 // the number of line segments
        return lineSegments.size();
    }

    public LineSegment[] segments() {               // the line segments
        return lineSegments.toArray(new LineSegment[0]);
    }

    private void validateInput(Point[] points) {
        if (points == null) {
            throw new IllegalArgumentException("Inout array is null");
        }
        for (int i = 0; i < points.length; i++) {
            if (points[i] == null) {
                throw new IllegalArgumentException("Input contains null element");
            }
            for (int j = i + 1; j < points.length; j++) {
                if (points[j] == null) {
                    throw new IllegalArgumentException("Input contains null element");
                }
                if (points[i].compareTo(points[j]) == 0) {
                    throw new IllegalArgumentException("There are duplicates in the input");
                }
            }
        }
    }
}
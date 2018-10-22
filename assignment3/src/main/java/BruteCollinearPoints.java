import java.util.ArrayList;
import java.util.Arrays;

public class BruteCollinearPoints {
    private ArrayList<LineSegment> lineSegments;

    public BruteCollinearPoints(Point[] points) {   // finds all line segments containing 4 points
        validateInput(points);
        lineSegments = new ArrayList<>();
        Arrays.sort(points);
        for (int i = 0; i < points.length - 3; i++) {
            for (int j = i + 1; j < points.length - 2; j++) {
                for (int k = j + 1; k < points.length - 1; k++) {
                    for (int l = k + 1; l < points.length; l++) {
                        Point p = points[i];
                        Point q = points[j];
                        Point r = points[k];
                        Point s = points[l];
                        if (p.slopeTo(q) == p.slopeTo(r) && p.slopeTo(r) == p.slopeTo(s)) {
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

    static void validateInput(Point[] points) {
        if (points == null) {
            throw new IllegalArgumentException("Inout array is null");
        }
        if (points.length < 4) {
            throw new IllegalArgumentException("Less than 4  points were entered");
        }
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i] == null || points[j] == null) {
                    throw new IllegalArgumentException("Input contains null element");
                }
                if (points[i].compareTo(points[j]) == 0) {
                    throw new IllegalArgumentException("There are duplicates in the input");
                }
            }
        }
    }
}
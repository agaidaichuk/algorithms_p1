import java.util.ArrayList;
import java.util.Arrays;

public class FastCollinearPoints {
    private final ArrayList<LineSegment> lineSegments;

    public FastCollinearPoints(Point[] originalPoints) {    // finds all line segments containing 4 or more points
        validateInput(originalPoints);
        lineSegments = new ArrayList<>();

        Point[] points = Arrays.copyOf(originalPoints, originalPoints.length);
        Arrays.sort(points);

        for (Point p : points) {
            Point[] rest = Arrays.copyOf(points, points.length);
            Arrays.sort(rest, p.slopeOrder());
            int min = 1;
            int max = 2;
            while (max < rest.length) {
                if (Double.compare(p.slopeTo(rest[min]), p.slopeTo(rest[max])) != 0) {
                    if (max - min >= 3 && p.compareTo(rest[min]) < 0) {
                        lineSegments.add(new LineSegment(p, rest[max - 1]));
                    }
                    min = max;
                }
                max++;
            }
            if (max - min >= 3 && p.compareTo(rest[min]) < 0) {
                lineSegments.add(new LineSegment(p, rest[max - 1]));
            }
        }
    }

    public int numberOfSegments() {       // the number of line segments
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
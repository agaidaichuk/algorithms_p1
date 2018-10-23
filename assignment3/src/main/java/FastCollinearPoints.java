import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class FastCollinearPoints {
    private LinkedList<LineSegment> lineSegments;
    private Map<Point, LinkedList<Double>> endpoints;

    public FastCollinearPoints(Point[] points) {    // finds all line segments containing 4 or more points
        BruteCollinearPoints.validateInput(points);
        endpoints = new HashMap<>();
        lineSegments = new LinkedList<>();

        Arrays.sort(points);

        for (Point p : points) {
            int count = 0;
            int n = points.length - 1;
            Point[] rest = new Point[n];
            Arrays.sort(rest, p.slopeOrder());
            for (int i = 0; i < n - 1; i++) {
                if (Double.compare(p.slopeTo(rest[i]), p.slopeTo(rest[i + 1])) == 0) {
                    count++;
                } else {
                    if (count > 2) {
                        addSegment(p, rest[i]);
                    }
                    count = 0;
                }
            }
            if (count > 2) {
                addSegment(p, rest[n - 1]);
            }
        }
    }

    private void addSegment(Point p, Point that) {
        Double slope = p.slopeTo(that);
        LinkedList<Double> slopes = endpoints.getOrDefault(that, new LinkedList<>());
        if (!slopes.contains(slope)) {
            lineSegments.add(new LineSegment(p, that));
            slopes.add(slope);
            endpoints.put(that, slopes);
        }
    }

    public int numberOfSegments() {       // the number of line segments
        return lineSegments.size();
    }

    public LineSegment[] segments() {               // the line segments
        return lineSegments.toArray(new LineSegment[0]);
    }
}
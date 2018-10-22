import java.util.ArrayList;

public class FastCollinearPoints {
    private ArrayList<LineSegment> lineSegments;

    public FastCollinearPoints(Point[] points) {    // finds all line segments containing 4 or more points
        BruteCollinearPoints.validateInput(points);
        lineSegments = new ArrayList<>();

        for (int i = 0; i < points.length - 3; i++) {
            points = sort(points);

        }
    }

    private Point[] sort(Point[] in) {
        int n = in.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (in[i].slopeOrder().compare(in[j], in[j + 1]) < 0) {
                    Point swap = in[j];
                    in[j] = in[j + 1];
                    in[j + 1] = swap;
                }
            }
        }
        return null;
    }

    public int numberOfSegments() {       // the number of line segments
        return lineSegments.size();
    }

    public LineSegment[] segments() {               // the line segments
        return lineSegments.toArray(new LineSegment[0]);
    }
}
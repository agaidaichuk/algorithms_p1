import edu.princeton.cs.algs4.StdOut;
import org.junit.Before;
import org.junit.Test;

public class DequeTest {

    private Deque<String> deque;

    @Before
    public void setUp() {
        deque = new Deque<>();
    }

    @Test
    public void randomCallsWithFirst() {
        deque.addFirst("A");
        StdOut.println(deque.isEmpty());
        deque.addFirst("B");
        StdOut.println(deque.isEmpty());
        StdOut.println(deque.removeFirst());
        StdOut.println(deque.isEmpty());
        StdOut.println(deque.removeFirst());
        StdOut.println(deque.isEmpty());
        deque.addFirst("B");
        StdOut.println(deque.removeFirst());
        StdOut.println(deque.isEmpty());
    }

    @Test
    public void randomCallsWithLast() {
        deque.addLast("A");
        StdOut.println(deque.isEmpty());
        deque.addLast("B");
        StdOut.println(deque.isEmpty());
        StdOut.println(deque.removeLast());
        StdOut.println(deque.isEmpty());
        StdOut.println(deque.removeLast());
        StdOut.println(deque.isEmpty());
        deque.addLast("B");
        StdOut.println(deque.removeLast());
        StdOut.println(deque.isEmpty());
    }

    @Test
    public void randomCallsAddFirstRemoveLast() {
        deque.addFirst("A");
        StdOut.println(deque.isEmpty());
        deque.addFirst("B");
        StdOut.println(deque.isEmpty());
        StdOut.println(deque.removeLast());
        StdOut.println(deque.isEmpty());
        StdOut.println(deque.removeLast());
        StdOut.println(deque.isEmpty());
        deque.addFirst("B");
        StdOut.println(deque.removeLast());
        StdOut.println(deque.isEmpty());
    }

    @Test
    public void randomCallsAddLastRemoveFirst() {
        deque.addLast("A");
        StdOut.println(deque.isEmpty());
        deque.addLast("B");
        StdOut.println(deque.isEmpty());
        StdOut.println(deque.removeFirst());
        StdOut.println(deque.isEmpty());
        StdOut.println(deque.removeFirst());
        StdOut.println(deque.isEmpty());
        deque.addLast("B");
        StdOut.println(deque.removeFirst());
        StdOut.println(deque.isEmpty());
    }
}
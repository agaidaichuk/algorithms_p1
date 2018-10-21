import edu.princeton.cs.algs4.StdOut;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

public class RandomizedQueueTest {

    private RandomizedQueue<String> queue;

    @Before
    public void setUp() {
        queue = new RandomizedQueue<>();
    }

    @Test
    public void randomCallsWithFirst() {
        queue.enqueue("A");
        StdOut.println(queue.sample());
        StdOut.println(queue.isEmpty());
        queue.enqueue("B");
        StdOut.println(queue.isEmpty());
        StdOut.println(queue.dequeue());
        StdOut.println(queue.sample());
        StdOut.println(queue.isEmpty());
        StdOut.println(queue.dequeue());
        StdOut.println(queue.isEmpty());
        queue.enqueue("B");
        StdOut.println(queue.sample());
        StdOut.println(queue.dequeue());
        StdOut.println(queue.isEmpty());
    }

    @Test
    public void iter() {
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        queue.enqueue("D");
        queue.enqueue("E");
        queue.enqueue("F");
        queue.enqueue("G");
        queue.enqueue("H");
        for (Object aQueue : queue) {
            StdOut.println(aQueue);
        }
    }

}
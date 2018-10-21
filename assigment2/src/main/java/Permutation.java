import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {

    public static void main(String[] args) {
        RandomizedQueue<String> deque = new RandomizedQueue<>();
        while (!StdIn.isEmpty()) {
            deque.enqueue(StdIn.readString().trim());
        }

        int k = Integer.parseInt(args[0]);

        if (k > deque.size()) {
            throw new IllegalArgumentException("k could not be greater than size of the queue");
        }

        for (int i = 0; i < k; i++) {
            StdOut.println(deque.dequeue());
        }
    }
}
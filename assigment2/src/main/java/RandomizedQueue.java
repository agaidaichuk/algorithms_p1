import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] queue;
    private int size;


    public RandomizedQueue() {                // construct an empty randomized queue
        queue = (Item[]) new Object[2];
    }

    public boolean isEmpty() {                // is the randomized queue empty?
        return size == 0;
    }

    public int size() {                       // return the number of items on the randomized queue
        return size;
    }

    public void enqueue(Item item) {          // add the item
        if (item == null) {
            throw new IllegalArgumentException("You try to add null as a value");
        }
        queue[size] = item;
        size++;

        if (size == queue.length) {
            resize(2 * size);
        }

    }

    public Item dequeue() {                   // remove and return a random item
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        int rand = StdRandom.uniform(size);

        Item item = queue[rand];
        queue[rand] = queue[size - 1];
        queue[size - 1] = null;
        size--;

        if (size == queue.length / 4) {
            resize(queue.length / 2);
        }

        return item;
    }

    public Item sample() {                    // return a random item (but do not remove it)
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return queue[StdRandom.uniform(size)];
    }

    public Iterator<Item> iterator() {        // return an independent iterator over items in random order
        return new RandomIterator(size);
    }

    private void resize(int capacity) {
        Item[] temp = (Item[]) new Object[capacity];

        if (size >= 0) System.arraycopy(queue, 0, temp, 0, size);

        queue = temp;
    }

    private class RandomIterator implements Iterator<Item> {
        int index = 0;
        int[] rand;

        public RandomIterator(int capacity) {
            rand = new int[capacity];

            for (int i = 0; i < capacity; i++) {
                rand[i] = i;
            }

            StdRandom.shuffle(rand);
        }

        @Override
        public boolean hasNext() {
            return index < rand.length;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Queue is empty");
            }
            return queue[rand[index++]];
        }
    }
}
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node first, last;
    private int size;

    public Deque() {                          // construct an empty deque
        size = 0;
    }

    public static void main(String[] args) {  // unit testing (optional)
    }

    public boolean isEmpty() {                // is the deque empty?
        return size == 0;
    }

    public int size() {                       // return the number of items on the deque
        return size;
    }

    public void addFirst(Item item) {         // add the item to the front
        if (item == null) {
            throw new IllegalArgumentException("You try to add null as a value");
        }
        Node newNode = new Node(item);
        if (first != null) {
            newNode.setNext(first);
            first.setPrevious(newNode);
        } else {
            last = newNode;
        }
        first = newNode;
        size++;
    }

    public void addLast(Item item) {          // add the item to the end
        if (item == null) {
            throw new IllegalArgumentException("You try to add null as a value");
        }
        Node newNode = new Node(item);
        if (last != null) {
            newNode.setPrevious(last);
            last.setNext(newNode);
        } else {
            first = newNode;
        }
        last = newNode;
        size++;
    }

    public Item removeFirst() {               // remove and return the item from the front
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }

        Node node = first;
        if (size != 1) {
            first = first.getNext();
            first.setPrevious(null);
        } else {
            first = null;
            last = null;
        }
        size--;

        return node.getValue();
    }

    public Item removeLast() {                // remove and return the item from the end
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        Node node = last;
        if (size != 1) {
            last = last.getPrevious();
            last.setNext(null);
        } else {
            first = null;
            last = null;
        }
        size--;

        return node.getValue();
    }

    public Iterator<Item> iterator() {        // return an iterator over items in order from front to end
        return new Iterator<Item>() {
            Node currNode = first;

            public boolean hasNext() {
                return currNode != null;
            }

            public Item next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("There is no next element");
                }
                Item item = currNode.getValue();
                currNode = currNode.getNext();
                return item;
            }
        };
    }

    private class Node {

        private final Item value;
        private Node previous, next;

        private Node(Item value) {
            this.value = value;
        }

        private Item getValue() {
            return value;
        }

        private Node getPrevious() {
            return previous;
        }

        private void setPrevious(Node previous) {
            this.previous = previous;
        }

        private Node getNext() {
            return next;
        }

        private void setNext(Node next) {
            this.next = next;
        }
    }

}
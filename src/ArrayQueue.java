import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayQueue {
    private int[] items;
    private int f;
    private int r;
    private int count;

    public ArrayQueue(int size) {
        items = new int[size];
    }

    public void enqueue(int item) {
        if (isFull()) {
            throw new IllegalStateException();
        }

        items[r] = item;
        r = (r + 1) % items.length;
        count++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        int item = items[f];
        items[f] = 0;
        f = (f + 1) % items.length;
        count--;
        return item;
    }

    public Integer peek() {
        if (isEmpty()) {
            return null;
        }
        return items[f];
    }

    public boolean isEmpty() {
        return count == 0; //changed from r == f;
    }

    private boolean isFull() {
        return count == items.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}

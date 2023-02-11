import java.util.Arrays;
import java.util.EmptyStackException;

public class PriorityQueue {
    int[] items;
    int count;

    public PriorityQueue(int capacity) {
        items = new int[capacity];

    }

    public void enqueue(int item) {
        if (isFull()) {
            throw new IllegalStateException();
        }

        if (isEmpty()) {
            items[0] = item;
            count++;
            return;
        }

        //shifting items
        int i = shiftItemsToInsert(item);
        items[i] = item;
        count++;
    }

    private int shiftItemsToInsert(int item) {
        int i;
        for (i = count - 1; i >= 0; i--) {
            if (items[i] > item)
                items[i + 1] = items[i];
            else
                break;
        }
        return i + 1;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        return items[--count];
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

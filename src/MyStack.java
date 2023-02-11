import java.util.Arrays;
import java.util.EmptyStackException;

public class MyStack {
    private int[] array = new int[5];
    private int size;

    public void push(int value) {
        if (isFull())
            throw new StackOverflowError();

        array[size++] = value;
    }

    public int pop() {
        if (isEmpty()) throw new EmptyStackException();

        return array[--size];
    }

    @Override
    public String toString() {
        int[] content = Arrays.copyOfRange(array, 0, size);
        return Arrays.toString(content);
    }

    public int peek() {
        if (isEmpty()) throw new EmptyStackException();

        return array[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return size == array.length;
    }
}

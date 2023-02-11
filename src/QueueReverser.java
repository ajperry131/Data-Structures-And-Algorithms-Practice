import java.util.Queue;
import java.util.Stack;

public class QueueReverser {

    public void reverse(Queue<Integer> queue, int k) {
        //queue = [10, 20, 30, 40, 50], k = 3
        //stack  [10, 20, 30] dequeue/push into stack until k= 3
        //queue  [40, 50, 30, 20, 10] pop/enqueue into queue until stack is empty
        //queue  [30, 20, 10, 40, 50] dequeue/enqueue remaining items
        if (k > queue.size())
            throw new IllegalStateException();
        if (k <= 0)
            return;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < k; i++) {
            stack.add(queue.remove());
        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        int remainingItems = queue.size() - k;
        for (int i =0; i < remainingItems; i++) {
            queue.add(queue.remove());
        }

    }
}

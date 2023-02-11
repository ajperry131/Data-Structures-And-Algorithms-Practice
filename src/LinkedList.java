import java.util.NoSuchElementException;

public class LinkedList {
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node() {}
    }

    private Node first;
    private Node last;
    private int size;

    private boolean isEmpty() {
        return first == null;
    }

    //addFirst
    public void addFirst(int item) {
        Node node = new Node(item);

        //if first does not exist, then last does not exist, set node to both
        if (isEmpty()) {
            first = last = node;
        }
        else { //if first exists, then assign the new node.next to the first, then set first to the new node
            node.next = first;
            first = node;
        }

        size++;
    }
    //addLast
    public void addLast(int item) {
        Node node = new Node(item);

        //if last does not exist, then first does not exist, set node to both
        if (isEmpty()) {
            first = last = node;
        }
        else { //if last exists, then assign to last.next to the new node, then set last to the new node
            last.next = node;
            last = node;
        }

        size++;
    }

    //deleteFirst
    public void deleteFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("there is no node to delete");
        }
        if (first == last) {
            first = last = null;
        }
        else {
            Node second = first.next;
            first.next = null;
            first = second;
        }

        size--;
    }

    //deleteLast
    public void deleteLast() {
        //if there is no node in the linked list
        if (last == null) {
            throw new NoSuchElementException("there is no node to delete");
        }
        //if there is only one node in the linked list
        if (first == last) {
            first = last = null;
        }
        else {
            Node previousNode = getPrevious(last);
            last = previousNode;
            last.next = null;
        }

        size--;
    }

    private Node getPrevious(Node node) {
        Node currentNode = first;
        while (currentNode.next != null) {
            if (currentNode.next == node) return currentNode;
            currentNode = currentNode.next;
        }

        return null;
    }

    //contains
    public boolean contains(int item) {
        return indexOf(item) != -1;
    }

    //indexOf
    public int indexOf(int item) {
        int index = 0;
        Node currentNode = first;
        while (currentNode != null) {
            if (currentNode.value == item) {
                return index;
            }
            else {
                currentNode = currentNode.next;
                index++;
            }
        }

        return -1;
    }

    public int size() {
        return size;
    }

    public int[] toArray() {
        int[] array = new int[size];

        int index = 0;
        Node currentNode = first;
        while (currentNode != null) {
            array[index] = currentNode.value;
            index++;
            currentNode = currentNode.next;
        }

        return array;
    }

    public void reverse() {
        Node previous = first;
        Node current = first.next;
        while (current != null) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        last = first;
        last.next = null;
        first = previous;
    }

    public int getKthFromTheEnd(int k) {
        if (isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (k > size) throw new IllegalArgumentException();

        Node kthNode = first;
        Node currentNode = first;
        int index = 0;

        for (int i = 0; i < k - 1; i++) {
            currentNode = currentNode.next;
        }

        while (currentNode != last) {
            kthNode = kthNode.next;
            currentNode = currentNode.next;
        }

        return kthNode.value;
    }

    public void printMiddle() {
        if (isEmpty()) {throw new IllegalStateException();}

        Node a = first;
        Node b = first;

        while (b != last && b.next != last) {
            a = a.next;
            b = b.next.next;
        }

        if (b == last) {
            System.out.println(a.value);
        }
        else {
            System.out.println(a.value + ", " + a.next.value);
        }
    }

    public boolean hasLoop() {
        if (isEmpty()) {throw new IllegalStateException();}

        Node slow = first;
        Node fast = first;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }

        return false;
    }

    public static LinkedList createWithLoop() {
        LinkedList list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        // Get a reference to 30
        Node node = list.last;

        list.addLast(40);
        list.addLast(50);

        // Create the loop
        list.last.next = node;

        return list;
    }
}

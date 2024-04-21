public class MyLinkedList {
    private Node head;
    private Node tail;
    private int numElements;
    private static final int MAX_SIZE = 10;

    public MyLinkedList() {
        head = null;
        tail = null;
        numElements = 0;
    }

    public int size() {
        return numElements;
    }

    public boolean isEmpty() {
        return numElements == 0;
    }

    public boolean add(Appointment appointment) {
        if (numElements >= MAX_SIZE) {
            return false;  // List is full
        }
        Node newNode = new Node(appointment);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        numElements++;
        return true;
    }

    public Appointment get(int pos) {
        if (pos < 0 || pos >= numElements) {
            throw new IndexOutOfBoundsException("Index " + pos + " out of bounds");
        }
        Node current = head;
        for (int i = 0; i < pos; i++) {
            current = current.next;
        }
        return current.data;
    }

    public Appointment tail() {
        return tail != null ? tail.data : null;
    }

    private class Node {
        private Appointment data;
        private Node next;

        public Node(Appointment data) {
            this.data = data;
            this.next = null;
        }
    }
}

public class MemoryLocalityLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;

    public MemoryLocalityLinkedList() {
        head = null;
        tail = null;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void remove(T data) {
        if (head == null) {
            return;
        }

        if (head.data == data) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return;
        }

        Node<T> current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                if (current.next == null) {
                    tail = current;
                }
                return;
            }
            current = current.next;
        }
    }

    public T get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }

    public int size() {
        int size = 0;
        Node<T> current = head;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    private static class Node<T> {

        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }
}
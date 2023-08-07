import java.util.ArrayList;
import java.util.Objects;

/**
 * The LinkedList<T> class represents a doubly-linked list.
 */
public class LinkedList<T> {
    private int size;
    private LinkedListNode<T> head;
    private LinkedListNode<T> tail;

    public LinkedList() {}

    public int getSize() {
        return size;
    }

    public LinkedListNode<T> getFirst() {
        return head;
    }

    public LinkedListNode<T> getLast() {
        return tail;
    }

    public void add(T value) {
        size++;

        var listNode = new LinkedListNode<T>(value, this);
        if (Objects.isNull(head) && Objects.isNull(tail)) {
            head = listNode;
        } else {
            listNode.setPrevious(tail);
            tail.setNext(listNode);
        }

        tail = listNode;
    }

    public void add(int index, T value) throws IllegalArgumentException {
        if (!isValidIndex(index)) {
            throw new IllegalArgumentException("index must be less than the size and no less than zero");
        }

        LinkedListNode<T> node;

        if (size / (index + 1) >= 2) {
            node = head;
            for (int i = 0; i < index; i++) {
                node = node.getNext();
            }
        } else {
            node = tail;
            for (int i = size - 1; i > index; i--) {
                node = node.getPrevious();
            }
        }

        var listNode = new LinkedListNode<T>(value, this);
        listNode.setNext(node);

        if (!Objects.isNull(node.getPrevious())) {
            listNode.setPrevious(node.getPrevious());
            node.getPrevious().setNext(listNode);
        } else {
            head = listNode;
        }

        node.setPrevious(listNode);

        size++;
    }

    public void addFirst(T value) {
        size++;

        var listNode = new LinkedListNode<T>(value, this);
        listNode.setNext(head);
        head.setPrevious(listNode);
        head = listNode;
    }

    public void addLast(T value) {
        size++;

        var listNode = new LinkedListNode<T>(value, this);
        listNode.setPrevious(tail);
        tail.setNext(listNode);
        tail = listNode;
    }

    public T remove(int index) throws IllegalArgumentException {
        if (!isValidIndex(index)) {
            throw new IllegalArgumentException("index must be less than the size and no less than zero");
        }

        LinkedListNode<T> node;

        if (size / (index + 1) >= 2) {
            node = head;
            for (int i = 0; i < index; i++) {
                node = node.getNext();
            }
        } else {
            node = tail;
            for (int i = size - 1; i > index; i--) {
                node = node.getPrevious();
            }
        }

        var next = node.getNext();
        var prev = node.getPrevious();

        if (Objects.isNull(next) && Objects.isNull(prev)) {
            tail = null;
            head = null;
        } else if (Objects.isNull(next)) {
            prev.setNext(null);
            tail = prev;
        } else if (Objects.isNull(prev)) {
            next.setPrevious(null);
            head = next;
        } else {
            next.setPrevious(prev);
            prev.setNext(next);
        }

        size--;

        return node.getValue();
    }

    public T removeFirst() {
        size--;

        var result = head;
        head = result.getNext();
        head.setPrevious(null);

        return result.getValue();
    }

    public T removeLast() {
        size--;

        var result = tail;
        tail = result.getPrevious();
        tail.setNext(null);

        return result.getValue();
    }

    public void set(int index, T value) throws IllegalArgumentException {
        if (!isValidIndex(index)) {
            throw new IllegalArgumentException("index must be less than the size and no less than zero");
        }

        LinkedListNode<T> node;

        if (size / (index + 1) >= 2) {
            node = head;
            for (int i = 0; i < index; i++) {
                node = node.getNext();
            }
        } else {
            node = tail;
            for (int i = size - 1; i > index; i--) {
                node = node.getPrevious();
            }
        }

        node.setValue(value);
    }

    public void clear() {
        size = 0;
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public ArrayList<T> toArray() {
        var arr = new ArrayList<T>(size);

        var node = head;
        for (int index = 0; !Objects.isNull(node); index++) {
            arr.add(index, node.getValue());
            node = node.getNext();
        }

        return arr;
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index < size;
    }
}


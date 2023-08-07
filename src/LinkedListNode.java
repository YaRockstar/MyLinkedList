/**
 * The LinkedListNode<T> class represents an element of a double-linked LinkedList<T> list.
 */
public class LinkedListNode<T> {
    private T value;
    private LinkedListNode<T> next;
    private LinkedListNode<T> previous;
    private final LinkedList<T> list;

    public LinkedListNode(T value, LinkedList<T> list) {
        this.value = value;
        this.list = list;
    }

    public T getValue() {
        return value;
    }

    public LinkedListNode<T> getNext() {
        return next;
    }

    public LinkedListNode<T> getPrevious() {
        return previous;
    }

    public LinkedList<T> getList() {
        return list;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setNext(LinkedListNode<T> next) {
        this.next = next;
    }

    public void setPrevious(LinkedListNode<T> previous) {
        this.previous = previous;
    }
}

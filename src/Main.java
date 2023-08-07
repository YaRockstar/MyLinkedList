import java.util.Objects;

public class Main {
    public static <T> void printLinkedListNode(LinkedListNode<T> node) {
        System.out.println("Previous value: " +
                (Objects.isNull(node.getPrevious()) ? "null" : node.getPrevious().getValue()));
        System.out.println("Value: " + node.getValue());
        System.out.println("Next value: " +
                (Objects.isNull(node.getNext()) ? "null" : node.getNext().getValue()));
        System.out.println("#########################");
    }

    public static <T> void printLinkedList(LinkedList<T> linkedList) {
        if (linkedList.isEmpty()) {
            System.out.println("List is empty");
            System.out.println("#######################################");
            return;
        }

        System.out.println("Head value: " + linkedList.getFirst().getValue());
        System.out.println("Tail value: " + linkedList.getLast().getValue());
        System.out.println("Size: " + linkedList.getSize());
        System.out.println("#######################################");

        var node = linkedList.getFirst();
        while (!Objects.isNull(node)) {
            printLinkedListNode(node);
            node = node.getNext();
        }
    }

    public static void main(String[] args) {
        var linkedList = new LinkedList<Integer>();

        printLinkedList(linkedList);
        System.out.println(linkedList.toArray().toString());
    }
}
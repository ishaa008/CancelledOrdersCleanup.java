
public class CancelledOrdersCleanup {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Remove every node containing the given code
    static Node removeAll(Node head, int code) {

        // Remove matching nodes from the beginning
        while (head != null && head.data == code) {
            head = head.next;
        }

        // Remove matching nodes from the remaining list
        Node current = head;

        while (current != null && current.next != null) {
            if (current.next.data == code) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }

    // Add a node at the end
    static Node addLast(Node head, int value) {
        Node newNode = new Node(value);

        if (head == null) {
            return newNode;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
        return head;
    }

    // Display the linked list
    static void display(Node head) {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head = null;

        // Sample 1: 5 -> 3 -> 5 -> 8 -> 5
        head = addLast(head, 5);
        head = addLast(head, 3);
        head = addLast(head, 5);
        head = addLast(head, 8);
        head = addLast(head, 5);

        int code = 5;

        System.out.println("Original orders:");
        display(head);

        head = removeAll(head, code);

        System.out.println("After removing code " + code + ":");
        display(head);
    }
}

package lr3.Task7;

public class CreateHead {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this(data, null);
        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static Node createHeadRec(int[] arr, int index) {
        if (index == arr.length) return null;
        Node node = new Node(arr[index]);
        node.next = createHeadRec(arr, index + 1);
        return node;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Node head = createHeadRec(arr, 0);

        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}

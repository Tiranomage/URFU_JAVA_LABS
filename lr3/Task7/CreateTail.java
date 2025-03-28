package lr3.Task7;

public class CreateTail {
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

    public static Node createTailRec(int[] arr, int index) {
        if (index == arr.length - 1) return new Node(arr[index]);
        Node tail = createTailRec(arr, index + 1); 
        Node head = new Node(arr[index]);          
        head.next = tail;                         
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Node head = createTailRec(arr, 0); 

        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}

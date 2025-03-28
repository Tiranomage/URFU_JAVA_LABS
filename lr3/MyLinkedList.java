package lr3;

public class MyLinkedList {
    private Node head;

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void createHead(int[] arr) {
        for (int num : arr) {
            Node newNode = new Node(num);
            newNode.next = head;
            head = newNode;
        }
    }

    public void createTail(int[] arr) {
        Node current = head;
        for (int num : arr) {
            Node newNode = new Node(num);
            if (head == null) {
                head = newNode;
                current = head;
            } else {
                current.next = newNode;
                current = current.next;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.data).append(" -> ");
            current = current.next;
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 4) : "Empty list";
    }

    public void AddFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void AddLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void Insert(int index, int data) {
        if (index == 0) {
            AddFirst(data);
            return;
        }
        Node newNode = new Node(data);
        Node prev = head;
        for (int i = 0; i < index - 1; i++) {
            if (prev == null) {
                throw new IndexOutOfBoundsException();
            }
            prev = prev.next;
        }
        newNode.next = prev.next;
        prev.next = newNode;
    }

    public void RemoveFirst() {
        if (head == null) return;
        head = head.next;
    }

    public void RemoveLast() {
        if (head == null || head.next == null) {
            head = null;
            return;
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    public void Remove(int index) {
        if (index == 0) {
            RemoveFirst();
            return;
        }
        Node prev = head;
        for (int i = 0; i < index - 1; i++) {
            if (prev == null) {
                throw new IndexOutOfBoundsException();
            }
            prev = prev.next;
        }
        if (prev.next == null) {
            throw new IndexOutOfBoundsException();
        }
        prev.next = prev.next.next;
    }

    public void createHeadRec(int[] arr, int index) {
        if (index >= arr.length) return;
        Node newNode = new Node(arr[index]);
        newNode.next = head;
        head = newNode;
        createHeadRec(arr, index + 1);
    }

    public Node createTailRec(int[] arr, int index) {
        if (index >= arr.length) return null;
        Node tail = createTailRec(arr, index + 1);
        Node newNode = new Node(arr[index]);
        newNode.next = tail;
        return newNode;
    }

    public String toStringRec() {
        return toStringRecHelper(head);
    }

    private String toStringRecHelper(Node current) {
        if (current == null) return "";
        if (current.next == null) return String.valueOf(current.data);
        return current.data + " -> " + toStringRecHelper(current.next);
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        int[] arr = {1, 2, 3};
        list.createHead(arr); 
        System.out.println("Создание с головы (цикл): " + list);

        list = new MyLinkedList();
        list.createTail(arr); 
        System.out.println("Создание с хвоста (цикл): " + list);

        list.AddFirst(0); 
        list.AddLast(4); 
        list.Insert(2, 10); 
        System.out.println("После вставки: " + list);

        list.RemoveFirst(); 
        list.RemoveLast(); 
        list.Remove(2); 
        System.out.println("После удаления: " + list);

        list = new MyLinkedList();
        list.createHeadRec(arr, 0); 
        System.out.println("Создание с головы (рекурсия): " + list);

        list = new MyLinkedList();
        list.head = list.createTailRec(arr, 0);
        System.out.println("Создание с хвоста (рекурсия): " + list);

        System.out.println("Рекурсивный вывод: " + list.toStringRec());
    }
}
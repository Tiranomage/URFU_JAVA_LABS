package lr3.Task1;

public class Example2 {
    public static void printReverse(int x) {
        if (x >= 20) return;
        printReverse(2 * x + 1);
        System.out.print(x + " ");
    }

    public static void main(String[] args) {
        printReverse(0);
    }
}

package lr3.Task1;

public class Example1 {
    public static void printSequence(int x) {
        if (x >= 20) return;
        System.out.print(x + " ");
        printSequence(2 * x + 1);
    }

    public static void main(String[] args) {
        printSequence(0); 
    }
}
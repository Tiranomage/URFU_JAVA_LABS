package lr6;

public class Task4 {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            int threadNumber = i;
            new Thread(() -> {
                System.out.println("Номер потока: " + threadNumber);
            }).start();
        }
    }
}

package lr6;

public class Task2 {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Число: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }
}

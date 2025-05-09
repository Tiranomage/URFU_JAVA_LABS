package lr6;

public class Task3 {
    private static final Object lock = new Object();
    private static int number = 1;

    public static void main(String[] args) {
        Thread evenThread = new Thread(() -> {
            while (number <= 10) {
                synchronized (lock) {
                    if (number % 2 == 0) {
                        System.out.println("Четное: " + number++);
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        Thread oddThread = new Thread(() -> {
            while (number <= 10) {
                synchronized (lock) {
                    if (number % 2 != 0) {
                        System.out.println("Нечетное: " + number++);
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        evenThread.start();
        oddThread.start();
    }
}

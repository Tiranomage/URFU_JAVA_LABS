package lr6;

import java.util.concurrent.*;

public class Task6 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum = sumArray(array);
        System.out.println("Сумма элементов массива: " + sum);
    }

    public static int sumArray(int[] array) throws InterruptedException, ExecutionException {
        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(cores);
        int chunkSize = array.length / cores;
        Future<Integer>[] futures = new Future[cores];

        for (int i = 0; i < cores; i++) {
            int start = i * chunkSize;
            int end = (i == cores - 1) ? array.length : start + chunkSize;
            futures[i] = executor.submit(new SumTask(array, start, end));
        }

        int sum = 0;
        for (Future<Integer> future : futures) {
            sum += future.get();
        }

        executor.shutdown();
        return sum;
    }

    static class SumTask implements Callable<Integer> {
        private final int[] array;
        private final int start;
        private final int end;

        public SumTask(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        public Integer call() {
            int sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            return sum;
        }
    }
}

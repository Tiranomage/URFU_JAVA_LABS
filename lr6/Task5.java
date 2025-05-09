package lr6;

import java.util.concurrent.*;

public class Task5 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int[] array = {3, 7, -2, 10, 5, 8, 15, 0, 4, 12};
        int max = findMax(array);
        System.out.println("Максимальный элемент в массиве: " + max);
    }

    public static int findMax(int[] array) throws InterruptedException, ExecutionException {
        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(cores);
        int chunkSize = array.length / cores;
        Future<Integer>[] futures = new Future[cores];

        for (int i = 0; i < cores; i++) {
            int start = i * chunkSize;
            int end = (i == cores - 1) ? array.length : start + chunkSize;
            futures[i] = executor.submit(new MaxTask(array, start, end));
        }

        int max = Integer.MIN_VALUE;
        for (Future<Integer> future : futures) {
            max = Math.max(max, future.get());
        }

        executor.shutdown();
        return max;
    }

    static class MaxTask implements Callable<Integer> {
        private final int[] array;
        private final int start;
        private final int end;

        public MaxTask(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        public Integer call() {
            int max = array[start];
            for (int i = start + 1; i < end; i++) {
                max = Math.max(max, array[i]);
            }
            return max;
        }
    }
}

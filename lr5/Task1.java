package lr5;

import java.util.Arrays;

public class Task1 {
    public static int[] filterEvenNumbers(int[] array) {
        return Arrays.stream(array)
                     .filter(x -> x % 2 == 0)
                     .toArray();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] even = filterEvenNumbers(arr);
        System.out.println("Четные числа: " + Arrays.toString(even));
    }
}
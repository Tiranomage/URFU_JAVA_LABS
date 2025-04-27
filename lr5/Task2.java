package lr5;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Task2 {
    public static int[] commonElements(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>(Arrays.stream(arr2).boxed().toList());
        return Arrays.stream(arr1)
                     .filter(set::contains)
                     .toArray();
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {3, 4, 5};
        int[] common = commonElements(arr1, arr2);
        System.out.println("Общие элементы: " + Arrays.toString(common));
    }
}

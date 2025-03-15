package lr2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        Random rnd = new Random();
        System.out.print("Массив: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(20) - 10; // [-10, 10]
            System.out.print(arr[i] + " ");
        }
        
        int min = arr[0];
        List<Integer> indices = new ArrayList<>();
        indices.add(0);
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                indices.clear();
                indices.add(i);
            } else if (arr[i] == min) {
                indices.add(i);
            }
        }
        
        System.out.println("\nМинимальное значение: " + min);
        System.out.println("Индексы: " + indices);
    }
}
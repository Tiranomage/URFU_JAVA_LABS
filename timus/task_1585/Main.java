package timus.task_1585;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        
        Map<String, Integer> counts = new HashMap<>();
        counts.put("Emperor Penguin", 0);
        counts.put("Little Penguin", 0);
        counts.put("Macaroni Penguin", 0);
        
        for (int i = 0; i < n; i++) {
            String type = scanner.nextLine();
            counts.put(type, counts.get(type) + 1);
        }
        
        String mostPopular = null;
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostPopular = entry.getKey();
            }
        }
        
        System.out.println(mostPopular);
    }
}
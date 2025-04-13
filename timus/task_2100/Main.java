package timus.task_2100;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int guests = 2; // Маршалл и Лили
        
        for (int i = 0; i < n; i++) {
            String response = scanner.nextLine();
            if (response.contains("+one")) {
                guests += 2; // Друг и его пара
            } else {
                guests += 1; // Только друг
            }
        }
        
        // Если гостей ровно 13, добавляем манекена
        if (guests == 13) {
            guests++;
        }
        
        System.out.println(guests * 100);
    }
}

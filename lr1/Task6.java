package lr1;

import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Введите имя:");
        String name = in.nextLine();

        System.out.println("Введите год рождения:");
        int birthYear = in.nextInt();

        int currentYear = java.time.Year.now().getValue();
        int age = currentYear - birthYear;

        System.out.println("Имя: " + name + ", возраст: " + age);

        in.close();
        
    }
}

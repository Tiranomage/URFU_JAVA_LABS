package lr1;

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Введите год рождения:");
        int birthYear = in.nextInt();

        int currentYear = java.time.Year.now().getValue();
        int age = currentYear - birthYear;

        System.out.println("Ваш возраст: " + age);

        in.close();
        
    }
}

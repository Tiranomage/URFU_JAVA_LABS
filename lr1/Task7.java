package lr1;

import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Введите возраст:");
        int age = in.nextInt();

        int currentYear = java.time.Year.now().getValue();
        int birthYear = currentYear - age;

        System.out.println("Год рождения: " + birthYear);

        in.close();
        
    }
}

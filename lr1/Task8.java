package lr1;

import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Введите первое число:");
        int num1 = in.nextInt();

        System.out.println("Введите второе число:");
        int num2 = in.nextInt();

        System.out.println("Сумма: " + (num1 + num2));

        in.close();
        
    }
}

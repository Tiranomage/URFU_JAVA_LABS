package timus.task_1409;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);

        int harryShot = in.nextInt();
        int larryShot = in.nextInt();

        int totalCans = harryShot + larryShot - 1;

        int harryMissed = totalCans - harryShot;
        int larryMissed = totalCans - larryShot;

        System.out.println(harryMissed + " " + larryMissed);

        in.close();
    }
}

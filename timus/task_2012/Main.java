package timus.task_2012;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);

        int f = in.nextInt();

        int remainingTasks = 12 - f;

        int timeNeeded = remainingTasks * 45;

        int availableTime = 4 * 60;

        if (timeNeeded <= availableTime) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        in.close();

    }
}

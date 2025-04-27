package timus.task_1880;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int n = Integer.parseInt(sc.nextLine());
            String line = sc.nextLine().trim();
            String[] parts = line.split("\\s+");
            List<Integer> currentList = new ArrayList<>();
            for (String s : parts) {
                currentList.add(Integer.parseInt(s));
            }
            if (i == 0) {
                list1 = currentList;
            } else if (i == 1) {
                list2 = currentList;
            } else {
                list3 = currentList;
            }
        }


        List<Integer> minList = list1;
        if (list2.size() < minList.size()) {
            minList = list2;
        }
        if (list3.size() < minList.size()) {
            minList = list3;
        }

        List<Integer> other1, other2;
        if (minList == list1) {
            other1 = list2;
            other2 = list3;
        } else if (minList == list2) {
            other1 = list1;
            other2 = list3;
        } else {
            other1 = list1;
            other2 = list2;
        }

        int count = 0;
        for (int num : minList) {
            boolean inOther1 = Collections.binarySearch(other1, num) >= 0;
            boolean inOther2 = Collections.binarySearch(other2, num) >= 0;
            if (inOther1 && inOther2) {
                count++;
            }
        }

        System.out.println(count);
    }
}

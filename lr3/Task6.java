package lr3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Task6 {
    public static int solveJosephusArrayList(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) list.add(i);
        int index = 0;
        while (list.size() > 1) {
            index = (index + 1) % list.size();
            list.remove(index);
        }
        return list.get(0);
    }

    public static int solveJosephusLinkedList(int n) {
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) list.add(i);
        ListIterator<Integer> iter = list.listIterator();
        while (list.size() > 1) {
            iter.next();
            iter.remove();
            if (!iter.hasNext()) iter = list.listIterator();
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        System.out.println("Результаты:");
        System.out.println("ArrayList: " + solveJosephusArrayList(1_000));
        System.out.println("LinkedList: " + solveJosephusLinkedList(1_000));
    }
}

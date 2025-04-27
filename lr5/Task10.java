package lr5;

import java.util.List;

public class Task10 {
    public static List<Integer> filterLessThan(List<Integer> numbers, int value) {
        return numbers.stream()
                      .filter(x -> x < value)
                      .toList();
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 5, 10, 15);
        List<Integer> filtered = filterLessThan(numbers, 10);
        System.out.println("Меньше 10: " + filtered);
    }
}
package lr5;

import java.util.List;

public class Task8 {
    public static List<Integer> filterGreaterThan(List<Integer> numbers, int value) {
        return numbers.stream()
                      .filter(x -> x > value)
                      .toList();
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 5, 10, 15);
        List<Integer> filtered = filterGreaterThan(numbers, 7);
        System.out.println("Больше 7: " + filtered);
    }
}

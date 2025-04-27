package lr5;

import java.util.List;

public class Task4 {
    public static List<Integer> squareNumbers(List<Integer> numbers) {
        return numbers.stream()
                      .map(x -> x * x)
                      .toList();
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4);
        List<Integer> squares = squareNumbers(numbers);
        System.out.println("Квадраты: " + squares);
    }
}
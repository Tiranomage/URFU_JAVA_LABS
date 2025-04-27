package lr5;

import java.util.List;

public class Task6 {
    public static List<Integer> divisibleNumbers(List<Integer> numbers, int divisor) {
        return numbers.stream()
                      .filter(x -> x % divisor == 0)
                      .toList();
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(3, 6, 9, 12);
        List<Integer> divisible = divisibleNumbers(numbers, 3);
        System.out.println("Делятся на 3: " + divisible);
    }
}

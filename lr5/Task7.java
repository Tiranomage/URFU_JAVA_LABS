package lr5;

import java.util.List;

public class Task7 {
    public static List<String> filterByLength(List<String> strings, int minLength) {
        return strings.stream()
                      .filter(s -> s.length() > minLength)
                      .toList();
    }

    public static void main(String[] args) {
        List<String> strings = List.of("a", "test", "example");
        List<String> filtered = filterByLength(strings, 3);
        System.out.println("Длиной > 3: " + filtered);
    }
}
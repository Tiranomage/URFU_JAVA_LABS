package lr5;

import java.util.List;

public class Task5 {
    public static List<String> filterBySubstring(List<String> strings, String substring) {
        return strings.stream()
                      .filter(s -> s.contains(substring))
                      .toList();
    }

    public static void main(String[] args) {
        List<String> strings = List.of("apple", "banana", "apricot");
        List<String> filtered = filterBySubstring(strings, "ap");
        System.out.println("Строки с 'ap': " + filtered);
    }
}

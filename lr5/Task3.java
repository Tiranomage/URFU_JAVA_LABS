package lr5;

import java.util.List;

public class Task3 {
    public static List<String> filterCapitalizedStrings(List<String> strings) {
        return strings.stream()
                      .filter(s -> !s.isEmpty() && Character.isUpperCase(s.charAt(0)))
                      .toList();
    }

    public static void main(String[] args) {
        List<String> strings = List.of("apple", "Banana", "cherry");
        List<String> result = filterCapitalizedStrings(strings);
        System.out.println("Строки с заглавной буквы: " + result);
    }
}

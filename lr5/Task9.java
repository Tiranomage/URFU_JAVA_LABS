package lr5;

import java.util.List;

public class Task9 {
    public static List<String> filterAlphabeticStrings(List<String> strings) {
        return strings.stream()
                      .filter(s -> s.matches("[A-Za-z]+"))
                      .toList();
    }

    public static void main(String[] args) {
        List<String> strings = List.of("abc", "123", "test123", "JAVA");
        List<String> filtered = filterAlphabeticStrings(strings);
        System.out.println("Только буквы: " + filtered);
    }
}
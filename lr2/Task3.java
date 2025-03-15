package lr2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//Работает только на английском, UTF-8 оказался сильнее

public class Task3 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("Введите текст для шифрования: ");
        String text = reader.readLine();
        System.out.print("Введите ключ: ");
        int shift = Integer.parseInt(reader.readLine());
        
        String encrypted = encrypt(text, shift);
        System.out.println("Текст после преобразования: " + encrypted);
        
        while (true) {
            System.out.print("Выполнить обратное преобразование? (y/n): ");
            String choice = reader.readLine().toLowerCase();
            
            if (choice.equals("y")) {
                System.out.println("Расшифрованный текст: " + encrypt(encrypted, 26 - shift));
                break;
            } else if (choice.equals("n")) {
                System.out.println("До свидания!");
                break;
            } else {
                System.out.println("Введите корректный ответ");
            }
        }
    }

    private static String encrypt(String text, int shift) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                sb.append((char) ((c - base + shift) % 26 + base));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
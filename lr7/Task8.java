package lr7;

import java.io.*;

class User implements Serializable {
    private String username;
    private boolean active;

    public User(String username, boolean active) {
        this.username = username;
        this.active = active;
    }

    @Override
    public String toString() {
        return "User{username='" + username + "', active=" + active + "}";
    }
}

public class Task8 {
    public static void main(String[] args) {
        User user = new User("admin", true);
        File file = new File("user.ser");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(user);
            System.out.println("Объект сериализован");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            User deserialized = (User) ois.readObject();
            System.out.println("Десериализованный объект: " + deserialized);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (file.delete()) System.out.println("Файл удален");
    }
}

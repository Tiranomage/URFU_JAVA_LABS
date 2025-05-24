package lr7;

import java.io.*;

class Person implements Serializable {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

public class Example1_7 {
    public static void main(String[] args) {
        Person person = new Person("Alice", 30);
        File file = new File("person.ser");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(person);
            System.out.println("Объект сериализован");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Person deserialized = (Person) ois.readObject();
            System.out.println("Десериализованный объект: " + deserialized);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (file.delete()) System.out.println("Файл удален");
    }
}

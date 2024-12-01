package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.*;

@Setter
@Getter
@AllArgsConstructor
public class Person implements Serializable {
    private String name;
    private int age;
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + '}';
    }
    // Сериализация
    public static void serialize(Person person, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(person);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Десериализация
    public static Person deserialize(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (Person) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}

package org.example;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Yuliya", 41);

        // Сериализация
        String filename = "person.ser";
        Person.serialize(person, filename);

        // Десериализация
        Person deserializedPerson = Person.deserialize(filename);
        System.out.println("Десериализованный объект: " + deserializedPerson);

    }
}
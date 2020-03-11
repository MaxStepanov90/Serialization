package com.company;

import java.io.*;

public class Person implements Serializable, ObjectInputValidation {

    private String name;
    private int age;
    private double height;
    private transient boolean married;

    public Person(String name, int age, double height, boolean married) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.married = married;
    }

    // Encrypt
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        age = age >> 2;
        objectOutputStream.defaultWriteObject();
    }

    // Decrypt
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        age = age << 2;
        objectInputStream.defaultReadObject();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }

    public boolean isMarried() {
        return married;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", married=" + married +
                '}';
    }

    // Проверка десериализованного объекта
    @Override
    public void validateObject() throws InvalidObjectException {
        if (age < 39 || age > 60) {
            throw new InvalidObjectException("Invalid age");
        }
    }
}

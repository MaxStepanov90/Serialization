package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InvalidObjectException {

        String fileName = "people.dat";

        List<Person> people = new ArrayList<>();
        people.add(new Person("Mike", 25, 180.0, false));
        people.add(new Person("Frank", 45, 200.0, true));

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(people);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<Person>newPeople = new ArrayList<>();


        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
          newPeople = ((ArrayList<Person>) ois.readObject());
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Person person:newPeople){
            System.out.println(person);
            person.validateObject();
        }
    }
}

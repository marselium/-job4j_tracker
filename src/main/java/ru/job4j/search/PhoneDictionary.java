package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.*;
public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> rsl = new ArrayList<>();
        Predicate<Person> name = t -> t.getName().contains(key);
        Predicate<Person> surname = t -> t.getSurname().contains(key);
        Predicate<Person> phone = t -> t.getPhone().contains(key);
        Predicate<Person> address = t -> t.getAddress().contains(key);
        Predicate<Person> combine = name.or(surname).or(phone).or(address);
        for (var person : persons) {
            if (combine.test(person)) {
                rsl.add(person);
            }
        }
        return rsl;
    }
}

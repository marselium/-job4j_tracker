package ru.job4j.item;

public class NamesList {
    private String name;

    public NamesList(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Job{"
                + "name='" + name
                + '}';
    }
}

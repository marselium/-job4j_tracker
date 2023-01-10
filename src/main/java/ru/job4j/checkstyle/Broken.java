package ru.job4j.checkstyle;

public class Broken {
    private String name;
    private int sizeOfEmpty = 10;
    private String surname;
    public static final String NEWVALUE = "";

    public void echo() {
    }

    public void media(Object obj) {
        if (obj != null) {
            System.out.println(obj);
        }
    }

    public void method(int a, int b, int c, int d, int e, int f, int g) {
    }

    public Broken() {
    }
}
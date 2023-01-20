package ru.job4j.ex;

public class Fact {
    public int calc(int n) {
        int rsl = 1;
        if (n < 0) {
            throw new IllegalArgumentException("Переменная n не может быть отрицательной.");
        }
        for (int index = 2; index <= n; index++) {
            rsl *= index;
        }
        return rsl;
    }

    public static void main(String[] args) {
        new Fact().calc(-1);
    }
}
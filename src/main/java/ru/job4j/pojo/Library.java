package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book cervantes = new Book("Don Quixote", 1170);
        Book homer = new Book("The Odyssey", 328);
        Book tolstoy = new Book("War and Peace", 1274);
        Book unnamed = new Book("Clean Code", 100);
        Book[] lib = new Book[4];
        lib[0] = cervantes;
        lib[1] = homer;
        lib[2] = tolstoy;
        lib[3] = unnamed;
        System.out.println("Содержимое массива через цикл for + i");
        for (Book book : lib) {
            System.out.println(book.getName() + "," + book.getPages());
        }

        System.out.println("-------------");
        System.out.println("Переставляем книги с 0 и 3 индексом");
        lib[0] = unnamed;
        lib[3] = cervantes;
        for (Book book : lib) {
            System.out.println(book.getName() + "," + book.getPages());
        }

        System.out.println("-------------");
        System.out.println("Только Clean Code");
        for (Book bk : lib) {
            if (bk == unnamed) {
                System.out.println(bk.getName() + "," + bk.getPages());
            }
        }
    }

}

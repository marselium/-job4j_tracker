package ru.job4j.oop;

public class College {
    public static void main(String[] args) {
        Freshman freshman = new Freshman();  /* создаем объекта класса новичок*/
        Student2 student = freshman;         /* приведение к родительскому классу студентов*/
        Object obj = freshman;              /* приведение к родительскому классу обЪекты*/
    }
}

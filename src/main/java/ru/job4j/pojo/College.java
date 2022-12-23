package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student alex = new Student();
        alex.setFullName("Александр Сергеевич Пушкин");
        alex.setGroup("ЛГ/2");
        alex.setDate("11 июня 1991");
        System.out.println("Студент " + alex.getFullName() + " "
                + alex.getDate() + " поступил в группу " + alex.getGroup() + ".");
    }
}

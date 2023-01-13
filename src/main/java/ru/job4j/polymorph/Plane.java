package ru.job4j.polymorph;

public class Plane implements Vehicle2 {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName()
                + " - Летает по воздуху");
    }
}

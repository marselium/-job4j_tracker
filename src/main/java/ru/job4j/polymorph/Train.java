package ru.job4j.polymorph;

public class Train implements Vehicle2 {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName()
                + " - передвигается по рельсам");
    }
}

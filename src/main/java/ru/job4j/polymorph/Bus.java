package ru.job4j.polymorph;

public class Bus implements Vehicle2 {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName()
                + " - двигается по скоростным трассам");
    }
}

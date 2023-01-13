package ru.job4j.polymorph;

public class PolyUsage {
    public static void main(String[] args) {
        Vehicle2 plane = new Plane();
        Vehicle2 train = new Train();
        Vehicle2 bus = new Bus();

        Vehicle2[] vehicle = new Vehicle2[] {plane, train, bus};
        for (Vehicle2 v: vehicle) {
            v.move();
        }
    }
}

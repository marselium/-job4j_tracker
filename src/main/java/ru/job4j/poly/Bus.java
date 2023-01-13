package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public String drive() {
        return null;
    }

    @Override
    public void passengers(int count) {
        count = 20;
        System.out.println("Вместимость = " + count + " прссажиров.");
    }

    @Override
    public void refill(float liters, float price) {
        liters = 30;
        price = 49.5f;
        float sum = liters * price;
        System.out.println("Цена за " + liters + "л. бензина"
                + " будет составлять " + sum + " рублей.");
    }
}

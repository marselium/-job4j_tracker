package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public String drive() {
        return null;
    }

    @Override
    public void passengers(int count) {
        System.out.println("Вместимость = " + count + " прссажиров.");
    }

    @Override
    public float refill(float liters, float price) {
        float sum = liters * price;
        System.out.println("Цена за " + liters + "л. бензина"
                + " будет составлять " + sum + " рублей.");
        return sum;
    }
}

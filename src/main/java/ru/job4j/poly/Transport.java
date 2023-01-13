package ru.job4j.poly;

public interface Transport {

    String drive();

    void passengers(int count);

    float refill(float liters, float price);
}

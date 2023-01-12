package ru.job4j.poly;

public interface Transport {

    String drive();

    int passengers(int count);

    int refill(int liters, int price);
}

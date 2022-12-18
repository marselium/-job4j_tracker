package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int divide(int a) {
        return a / x;
    }

    public int sumAllOperation(int a) {
        return sum(a) + minus(a) + this.multiply(a) + this.divide(a);
    }

    public static void main(String[] args) {
        int result = Calculator.sum(10);
        System.out.println(result);
        Calculator calculator = new Calculator();
        int rsl = calculator.multiply(5);
        System.out.println(rsl);
        int min = Calculator.minus(15);
        System.out.println(min);
        Calculator divide = new Calculator();
        int div = divide.divide(15);
        System.out.println(div);
        Calculator sumAllOperation = new Calculator();
        int sumAll = sumAllOperation.sumAllOperation(5);
        System.out.println(sumAll);
    }
}
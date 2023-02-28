package ru.job4j.function;

import java.util.function.*;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class FunctionInterfaceUsage {
    public static void main(String[] args) {
        System.out.println("----------------------SUPPLIER-------------------------");
        Supplier<String> sup = () -> "New 1 String For Interface. Supplier";
        System.out.println(sup.get());
        System.out.println("----------------------CONSUMER-------------------------");
        Supplier<String> sup1 = () -> "New 2 String For Interface. Consumer";
        Consumer<String> consumer1 = (s) -> System.out.println(s);
        consumer1.accept(sup1.get());
        System.out.println("---------------------BICONSUMER------------------------");
        Supplier<String> sup2 = () -> "New String For Interface. BiConsumer";
        BiConsumer<String, String> consumer2 = (s, s1) -> System.out.println(s + s1);
        consumer2.accept(sup2.get(), " and Second String");
        System.out.println("---------------------INTERFACE-------------------------");
        List<String> list = List.of("one", "two", "three", "one", "two", "three");
        Supplier<Set<String>> sup3 = () -> new HashSet<>(list);
        BiConsumer<Integer, String> consumer = (s, s1) -> System.out.println(s + s1);
        Set<String> strings = sup3.get();
        int i = 1;
        for (String s : strings) {
            consumer.accept(i++, " is " + s);
        }
        System.out.println("------------------------PREDICATE-------------------------");
        Predicate<String> pred = s -> s.isEmpty();
        System.out.println("Строка пустая: " + pred.test(""));
        System.out.println("Строка пустая: " + pred.test("test"));
        System.out.println("-----------------------BI PREDICATE-----------------------");
        BiPredicate<String, Integer> cond = (s, j) -> s.contains(j.toString());
        System.out.println("Строка содержит подстроку: " + cond.test("Name123", 123));
        System.out.println("Строка содержит подстроку: " + cond.test("Name", 123));
        System.out.println("-----------------------FUNCTION---------------------------");
        Function<String, Character> func = s -> s.charAt(2);
        System.out.println("Третий символ в строке: " + func.apply("first"));
        System.out.println("Третий символ в строке: " + func.apply("second"));
        System.out.println("----------------------BI FUNCTION-------------------------");
        BiFunction<String, Integer, String> biFunc = (s, k) -> s.concat(" ").concat(k.toString());
        System.out.println("Результат работы бифункции: " + biFunc.apply("Name", 123));
        System.out.println("Результат работы бифункции: " + biFunc.apply("String number", 12345));
        UnaryOperator<StringBuilder> builder = b -> b.reverse();
        System.out.println("---------------------UNARY OPERATOR-----------------------");
        System.out.println("Строка после реверса: " + builder.apply(new StringBuilder("String for test")));
        System.out.println("Строка после реверса: " + builder.apply(new StringBuilder("tset rof gnirtS")));
        System.out.println("---------------------BINARY OPERATOR----------------------");
        BinaryOperator<StringBuilder> builder1 = (b1, b2) -> b1.append(" ").append(b2);
        System.out.println(
                "Строка после объединения: " + builder1.apply(
                        new StringBuilder("First string"),
                        new StringBuilder("Second string")
                )
        );
    }
}
package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> fio = new HashMap<>();
        fio.put(".", "Yumagulov Marsel Maratovich");
        fio.put(".", "Yumagulov Marsel Maratovich");
        fio.put("=", "Ivanov Ivan Ivanovich");
        fio.put("=", "Ivanov Ivan Ivanovich");
        for (String fios : fio.keySet()) {
            String name = fio.get(".");
            System.out.println(fios + " = " + name);
            String name1 = fio.get("=");
            System.out.println(fios + " = " + name1);
        }
    }
}

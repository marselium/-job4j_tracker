package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> fio = new HashMap<>();
        fio.put(".", "Yumagulov Marsel Maratovich");
        for (String myFio : fio.keySet()) {
            String name = fio.get(".");
            System.out.println(myFio + "=" + name);
        }
    }
}

package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] leftRsl = left.split("\\.");
        String[] rightRsl = right.split("\\.");
        return Integer.compare(Integer.parseInt(leftRsl[0]), Integer.parseInt(rightRsl[0]));
    }
}
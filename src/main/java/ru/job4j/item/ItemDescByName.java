package ru.job4j.item;

import  java.util.Comparator;

public class ItemDescByName implements Comparator<NamesList> {
    public int compare(NamesList left, NamesList right) {
        return right.getName().compareTo(left.getName());
    }
}

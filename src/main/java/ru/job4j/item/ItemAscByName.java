package ru.job4j.item;

import ru.job4j.collection.Job;

import java.util.Comparator;

public class ItemAscByName implements Comparator<NamesList> {
    public int compare(Job left, Job right) {
        return left.getName().compareTo(right.getName());
    }

    @Override
    public int compare(NamesList itemFirst, NamesList itemSecond) {
        return itemFirst.getName().compareTo(itemSecond.getName());
    }
}

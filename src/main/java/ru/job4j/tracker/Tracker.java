package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();

    public Item add(Item item) {
        items.add(item);
        return item;
    }

    public List<Item> findAll() {
        return List.copyOf(items);
    }

    public List<Item> findByName(String key) {
        List<Item> arr = new ArrayList<>();
        for (Item elem : items) {
            if (key.equals(elem.getName())) {
                arr.add(elem);
            }
        }
        return arr;
    }

    private Item indexOf(int id) {
        Item rsl = null;
        for (Item item : items) {
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        return indexOf(id);
    }

    public boolean replace(int id, Item item) {
        Item index = indexOf(id);
        boolean rsl = index != null;
        if (rsl) {
            item.setId(id);
            items.remove(index);
            items.add(item);
        }
        return rsl;
    }

    public boolean delete(int id) {
        Item index = indexOf(id);
        boolean rsl = index != null;
        if (rsl) {
            items.remove(index);
        }
        return rsl;
    }
}
package ru.job4j.tracker;

import java.util.List;

public class SingleTracker {

    private Tracker tracker = new Tracker();

    private static SingleTracker instance = null;

    private SingleTracker() {
    }

    public static SingleTracker getInstance() {
        if (instance == null) {
            instance = new SingleTracker();
        }
        return instance;
    }

    public Item createAction(Item item) {
        return tracker.add(item);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public List<Item> show() {
        return tracker.findAll();
    }

    public boolean edit(int id, Item item) {
        return tracker.replace(id, item);
    }

    public Item delete(Item item) {
        return tracker.add(item);
    }

    public List<Item> findByName(String key) {
        return tracker.findByName(key);
    }
}
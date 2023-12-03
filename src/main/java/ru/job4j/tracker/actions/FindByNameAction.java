package ru.job4j.tracker.actions;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Input;
import ru.job4j.tracker.Output;
import ru.job4j.tracker.Store;

import java.util.List;

public class FindByNameAction implements UserAction {

    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find items by name ====";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        String name = input.askStr("Enter name: ");
        List<Item> items = tracker.findByName(name);
        for (Item item: items) {
            out.println(item);
        }
        return true;
    }
}

package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tracker {
    private List<Item> items = new ArrayList<>(100);
    private int position = 0;
    private static final Random RN = new Random();

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
        return item;
    }

    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    public boolean update(String id, Item item) {
        boolean temp = false;
        for (int index = 0; index < items.size(); index++) {
            if (this.items.get(index).getId().equals(id)) {
                this.items.set(index, item);
                temp = true;
                break;
            }
        }
        return temp;
    }

    public boolean delete(String id) {
        boolean temp = false;
        for (int index = 0; index < items.size(); index++) {
            if (this.items.get(index).getId().equals(id)) {
                this.items.remove(index);
                temp = true;
                break;
            }
        }
        return temp;
    }

    public List<Item> getAll() {
        return items;
    }

    public List<Item> findByName(String key) {

        List<Item> result = new ArrayList<>(items.size());
        for (Item item : items) {
            if (item != null && item.getName().equals(key)) {
                result.add(item);
            }
        }
        return result;
    }

    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }
}

package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Tracker {
    private List<Item> items = new ArrayList<>(100);
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
        return items.stream()
                .filter(item -> item.getName().equals(key))
                .collect(Collectors.toList());
    }

    public Item findById(String id) {
        return items.stream()
                .filter(item -> item.getId().contains(id))
                .findFirst()
                .orElse(null);
    }
}

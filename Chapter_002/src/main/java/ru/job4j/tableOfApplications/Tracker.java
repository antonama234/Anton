package ru.job4j.tableOfApplications;

import java.util.Random;

public class Tracker {
    private final Item[] items = new Item[100];
    private int position = 0;
    private static final Random RN = new Random();

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    public void update(String id, Item item) {
        for (int index = 0; index != this.position; index++) {
            if (this.items[index].getId().equals(id)) {
                item.setId(id);
                this.items[index] = item;
                break;
            }
        }
    }

    public void delete(String id) {
        for (int index = 0; index != this.position; index++) {
            if (this.items[index].getId().equals(id)) {
                this.items[index] = null;
            }
        }
        Item[] newArray = new Item[items.length - 1];
        System.arraycopy(items, 0, newArray, 0, 99);
    }

    public Item[] getAll() {
        Item[] result = new Item[this.position];
        for (int i = 0; i != this.position; i++) {
            result[i] = this.items[i];
        }
        return this.items;
    }

    public Item[] findByName(String key) {
        int i = 0;
        Item[] result = null;
        for (Item item : items) {
            if(item != null && item.getName().equals(key)) {
                result[i] = item;
                i++;
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

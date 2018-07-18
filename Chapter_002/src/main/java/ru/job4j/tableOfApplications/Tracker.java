package ru.job4j.tableofapplications;

import java.util.Random;
import java.util.Arrays;

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

    public boolean update(String id, Item item) {
        boolean temp = false;
        for (int index = 0; index != this.position; index++) {
            if (this.items[index].getId().equals(id)) {
                item.setId(id);
                this.items[index] = item;
                temp = true;
                break;
            }
        }
        return temp;
    }

    public boolean delete(String id) {
        boolean temp = false;
        int foundPosition;
        for (int index = 0; index != this.position; index++) {
            if (this.items[index].getId().equals(id)) {
                foundPosition = index;
                System.arraycopy(items, foundPosition + 1, items, foundPosition, position - foundPosition);
                this.position--;
                temp = true;
                break;
            }
        }
        return temp;
    }

    public Item[] getAll() {
        return Arrays.copyOf(this.items, position);
    }

    public Item[] findByName(String key) {
        int i = 0;
        Item[] result = new Item[items.length];
        for (Item item : items) {
            if (item != null && item.getName().equals(key)) {
                result[i] = item;
                i++;
            }
        }
        return Arrays.copyOf(result, i);
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

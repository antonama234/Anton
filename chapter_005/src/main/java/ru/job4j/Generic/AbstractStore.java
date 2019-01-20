package ru.job4j.Generic;

public class AbstractStore<T extends Base> implements Store<T> {
    private final SimpleArray<T> simpleArray;

    public AbstractStore(int size) {
        this.simpleArray = new SimpleArray<>(size);
    }

    public int findIndex(String id) {
        int index = 0;
        for (int i = 0; i != simpleArray.size(); i++) {
            if (simpleArray.get(i).getId().equals(id)) {
                i = index;
            }
        }
        return index;
    }

    public T get(int index) {
        return simpleArray.get(index);
    }

    @Override
    public void add(T model) {
        simpleArray.add(model);
    }

    @Override
    public boolean replace(String id, T model)  {
        boolean rst = false;
        if (id != null) {
            simpleArray.set(findIndex(id), model);
            rst = true;
        }

        return rst;
    }

    @Override
    public boolean delete(String id) {
        boolean rst = false;
        if (id != null) {
            simpleArray.remove(findIndex(id));
            rst = true;
        }

        return rst;
    }

    @Override
    public T findById(String id) {
        T rst = null;
        for (T i : simpleArray) {
            if (i.getId().equals(id)) {
                 rst = i;
                 break;
            }
        }
        return rst;
    }
}

package ru.job4j.synchronization;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.ArrayList;
import java.util.List;

@ThreadSafe
public class UserStorage {
    @GuardedBy("this")
    private List<User> store = new ArrayList<>();

    public synchronized boolean add(User user) {
        return store.add(user);
    }

    public synchronized boolean update(User user) {
        boolean rst = false;
        for (int i = 0; i != store.size(); i++) {
            if (store.get(i).getId() == user.getId()) {
                store.set(i, user);
                rst = true;
            }
        }
        return rst;
    }

    public synchronized boolean delete(User user) {
        return store.remove(user);
    }

    public synchronized void transfer(int fromId, int toId, int amount) {
        User from = store.get(fromId);
        User to = store.get(toId);
        if (from.getAmount() < amount) {
            throw new NotHaveEnoughMoney("This customer have not enough money");
        } else {
            from.setAmount(from.getAmount() - amount);
            to.setAmount(to.getAmount() + amount);
        }
    }

    public synchronized User findById(int id) {
        User rst = null;
        for (User user : store) {
            if (user.getId() == id) {
                rst = user;
            }
        }
        return rst;
    }
}

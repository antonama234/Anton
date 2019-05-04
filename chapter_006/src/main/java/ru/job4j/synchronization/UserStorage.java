package ru.job4j.synchronization;

import net.jcip.annotations.ThreadSafe;

import java.util.ArrayList;
import java.util.List;

@ThreadSafe
public class UserStorage {
    private List<User> store = new ArrayList<>();

    boolean add(User user) {
        return store.add(user);
    }

    boolean update(User user) {
        boolean rst = false;
        for (User us : store) {
            if (us.getId() != user.getId()) {
                throw new UserNotFound("We have not this customer");
            } else {
                user = us;
                rst = true;
            }
        }
        return rst;
    }

    boolean delete(User user) {
        boolean rst = false;
        for (User us : store) {
            if (us.getId() != user.getId()) {
                throw new UserNotFound("We have not this customer");
            } else {
                store.remove(user);
                rst = true;
            }
        }
        return rst;
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
}

package ru.job4j.search.banktransfer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankSystem {
    private Map<User, List<Account>> users = new HashMap<>();

    public User findByPass(String passport) {
        User rst = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                rst = user;
            }
        }
        return rst;
    }

    public Account findByRequisites(String requisites, String passport) {
        Account rst = null;
        List<Account> accounts  = getUserAccounts(passport);
        for (Account account : accounts) {
            if (account.getRequisites().equals(requisites)) {
                rst = account;
            }
        }
        return rst;
    }

    public void addUser(User user) {
        this.users.put(user, new ArrayList<>());
    }

    public void deleteUser(User user) {
        this.users.remove(user);
    }

    public void addAccountToUser(String passport, Account account) {
        User user = findByPass(passport);
        users.get(user).add(account);
    }

    public void deleteAccountFromUser(String passport, Account account) {
        User user = findByPass(passport);
        users.get(user).remove(account);
    }

    public List<Account> getUserAccounts(String passport) {
        List<Account> rst = new ArrayList<>();
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                rst = users.get(user);
            }
        }
        return rst;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        boolean rst = false;
        Account fromAcc = this.findByRequisites(srcRequisite, srcPassport);
        Account toAcc = this.findByRequisites(dstRequisite, destPassport);
        if (fromAcc.getValue() > amount && users.get(findByPass(srcPassport)) != null) {
            fromAcc.setValue(toAcc.getValue() - amount);
            toAcc.setValue(toAcc.getValue() + amount);
            rst = true;
        }
        return rst;
    }
}

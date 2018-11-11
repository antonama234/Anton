package ru.job4j.search;

import org.junit.Test;
import ru.job4j.search.banktransfer.Account;
import ru.job4j.search.banktransfer.BankSystem;
import ru.job4j.search.banktransfer.User;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BankSystemTest {
    @Test
    public void whenAddUser() {
        BankSystem bankSystem = new BankSystem();
        User user = new User("Anton", "234567");
        bankSystem.addUser(user);
        assertThat(bankSystem.findByPass("234567").getName(), is("Anton"));
    }

    @Test
    public void whenDeleteUser() {
        BankSystem bankSystem = new BankSystem();
        User first = new User("Anton", "234567");
        User second = new User("Roma", "978534");
        User third = new User("Kate", "963325");
        bankSystem.addUser(first);
        bankSystem.addUser(second);
        bankSystem.addUser(third);
        bankSystem.deleteUser(second);
        assertThat(bankSystem.users.size(), is(2));
    }

    @Test
    public void whenAddAccountToUser() {
        BankSystem bankSystem = new BankSystem();
        User first = new User("Anton", "234567");
        Account firstAccount = new Account(500, "40817810100");
        Account secondAccount = new Account(1000, "40817810900");
        bankSystem.addUser(first);
        bankSystem.addAccountToUser("234567", firstAccount);
        bankSystem.addAccountToUser("234567", secondAccount);
        assertThat(bankSystem.users.get(first).get(0).getValue(), is(500.0));
    }

    @Test
    public void whenDeleteAccountFromUser() {
        BankSystem bankSystem = new BankSystem();
        User first = new User("Anton", "234567");
        Account firstAccount = new Account(500.0, "40817810100");
        Account secondAccount = new Account(1000.0, "40817810900");
        bankSystem.addUser(first);
        bankSystem.addAccountToUser("234567", firstAccount);
        bankSystem.addAccountToUser("234567", secondAccount);
        bankSystem.deleteAccountFromUser("234567", firstAccount);
        assertThat(bankSystem.users.get(first).get(0).getValue(), is(1000.0));
    }

    @Test
    public void whenFindAllAccountsOfUser() {
        BankSystem bankSystem = new BankSystem();
        User first = new User("Anton", "234567");
        bankSystem.addUser(first);
        Account firstAccount = new Account(500.0, "40817810100");
        Account secondAccount = new Account(1000.0, "40817810900");
        bankSystem.addAccountToUser("234567", firstAccount);
        bankSystem.addAccountToUser("234567", secondAccount);
        List<Account> expect = new ArrayList<>();
        expect.add(firstAccount);
        expect.add(secondAccount);
        List<Account> rst = bankSystem.getUserAccounts("234567");
        assertThat(rst, is(expect));
    }

    @Test
    public void whenTransferMoneyToAnotherUser() {
        BankSystem bankSystem = new BankSystem();
        User first = new User("Anton", "234567");
        User second = new User("Roma", "978534");
        bankSystem.addUser(first);
        bankSystem.addUser(second);
        bankSystem.addAccountToUser("234567", new Account(500.0, "40817810100"));
        bankSystem.addAccountToUser("978534", new Account(1000.0, "40817810900"));
        bankSystem.transferMoney("978534", "40817810900", "234567", "40817810100", 300.0);
        assertThat(bankSystem.users.get(first).get(0).getValue(), is(800.0));
    }
}

package ru.job4j.search;

import org.junit.Test;
import ru.job4j.search.BankTransfer.Account;
import ru.job4j.search.BankTransfer.BankSystem;
import ru.job4j.search.BankTransfer.User;
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
        assertThat(bankSystem.users.get(1).size(), is(2));
    }

    @Test
    public void whenAddAccountToUser() {
        BankSystem bankSystem = new BankSystem();
        User first = new User("Anton", "234567");
        User second = new User("Roma", "978534");
        Account firstAccount = new Account(500, "40817810100");
        Account secondAccount = new Account(1000, "40817810900");
        bankSystem.addUser(first);
        bankSystem.addUser(second);
        bankSystem.addAccountToUser("234567", firstAccount);
        bankSystem.addAccountToUser("978534", secondAccount);
        assertThat(bankSystem.findByRequisites("40817810100", "234567").getValue(), is(500));
    }
}

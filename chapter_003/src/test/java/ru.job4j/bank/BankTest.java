package ru.job4j.bank;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class BankTest {

    @Test
    public void whenAddUser() {
        User rst = new User();
        User rst1 = new User();
        rst.setName("Petrov");
        rst1.setName("Morgov");
        rst.setPassport("FB124123");
        rst1.setPassport("FB124155");
        Account account = new Account(100, "CY143400");
        Account account1 = new Account(10, "CY143411");
        Account account2 = new Account(10, "CY143411");
        Bank bank = new Bank();
        bank.addUser(rst);
        bank.addUser(rst1);
        bank.addAccount(rst, account);
        bank.addAccount(rst1, account1);
        bank.addAccount(rst1, account2);
       // bank.transfer(rst, account, rst1, account1, 50);
        bank.transfer("FB14123", "CY143400", "FB124155", "CY143411", 50);
        //bank.getAccounts(rst1);
        //bank.deleteAccount(rst1, account);
       // bank.deleteUser(rst1);
       // bank.getAccounts();
        System.out.println(bank.getAccounts(rst));
       System.out.println(bank.transfer("FB124123", "CY143400", "FB124155", "CY143411", 50));
       // Assert.assertThat(rst, is(expect));

    }
}

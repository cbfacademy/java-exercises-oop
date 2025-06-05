package com.cbfacademy.accounts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BankTest {
    private Bank bank;

    @BeforeEach
    public void setUp() {
        // Initialize the bank with a 3% interest rate and a $1000 overdraft limit
        bank = new Bank(0.03, 1000);
    }

    @Test
    public void testOpenBasicAccount() {
        Account account = bank.openAccount(500, "basic");
        assertNotNull(account);
        assertEquals(500, account.getBalance());
        assertTrue(isFound(bank, account));
    }

    @Test
    public void testOpenSavingsAccount() {
        Account account = bank.openAccount(1000, "savings");
        assertNotNull(account);
        assertEquals(1000, account.getBalance());
        assertTrue(account instanceof SavingsAccount);
        assertEquals(0.03, ((SavingsAccount) account).getInterestRate());
        assertTrue(isFound(bank, account));
    }

    @Test
    public void testOpenCurrentAccount() {
        Account account = bank.openAccount(500, "current");
        assertNotNull(account);
        assertEquals(500, account.getBalance());
        assertTrue(account instanceof CurrentAccount);
        assertEquals(1000, ((CurrentAccount) account).getOverdraftLimit());
        assertTrue(isFound(bank, account));
    }

    @Test
    public void testCloseAccount() {
        Account account = bank.openAccount(500, "basic");
        bank.closeAccount(account.getAccountNumber());
        assertFalse(isFound(bank, account));
    }

    @Test
    public void testUpdateSavingsAccount() {
        Account account = bank.openAccount(1000, "savings");
        bank.update();
        assertThat(account.getBalance(), closeTo(1030, 0.01)); // Account balance after applying interest
    }

    // @Test
    // public void testUpdateCurrentAccountOverdrawn() {
    //     Account account = bank.openAccount(-500, "current");
    //     bank.update();
    //     // Check if overdraft letter is sent (you may need to capture system output and check)
    // }

    @Test
    public void testPayDividend() {
        Account account1 = bank.openAccount(500, "basic");
        Account account2 = bank.openAccount(1000, "savings");

        bank.payDividend(200);

        assertThat(account1.getBalance(), closeTo(700, 0.01));
        assertThat(account2.getBalance(), closeTo(1200, 0.01));
    }

    @Test
    public void testGetAccount() {
        Account account = bank.openAccount(500, "basic");
        int accountNumber = account.getAccountNumber();
        Account retrievedAccount = bank.getAccount(accountNumber);
        assertNotNull(retrievedAccount);
        assertEquals(account, retrievedAccount);
    }

    // @Test
    // public void testGetAccountNumbers() {
    //     bank.openAccount(500, "basic");
    //     bank.openAccount(1000, "savings");
    //     List<Integer> accountNumbers = getList(bank.getAccountNumbers());

    //     assertEquals(10000001, accountNumbers.get(0));
    //     assertThat(accountNumbers, containsInAnyOrder(10000001, 1000002)); // Adjust account numbers as needed
    // }

    // Add more test methods to cover other scenarios
    private Boolean isFound(Bank bank, Account account) {
        List<Integer> intList = getList(bank.getAccountNumbers());

        return intList.contains(account.getAccountNumber());
    }
    
    private List<Integer> getList(int[] array) {
        return Arrays.stream(bank.getAccountNumbers())
                .boxed()
                .collect(Collectors.toList());
    }

}

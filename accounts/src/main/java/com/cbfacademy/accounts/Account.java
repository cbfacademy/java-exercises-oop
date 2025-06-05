package com.cbfacademy.accounts;

/**
 * The Account class represents a generic bank account with an account number
 * and a balance.
 * It provides methods to deposit, withdraw, and retrieve account information.
 */
public class Account {
    protected int accountNumber;
    protected double balance;

    /**
     * Constructs a new Account object with the specified account number and initial
     * balance.
     *
     * @param accountNumber The account number to be assigned to the new account.
     * @param balance       The initial balance of the new account.
     */
    public Account(int accountNumber, double balance) {
        this.accountNumber = Math.abs(accountNumber);
        this.balance = Math.abs(balance);
    }

    /**
     * Deposits the specified amount into the account and updates the balance.
     *
     * @param amount The amount to be deposited. A positive value is expected.
     * @return The updated balance after the deposit.
     */
    public double deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }

        return balance;
    }

    /**
     * Withdraws the requested amount from the account if sufficient funds are
     * available.
     *
     * @param requested The amount to be withdrawn. A positive value is expected.
     * @return The amount actually withdrawn from the account. If the withdrawal is
     *         successful,
     *         the returned value will be equal to the requested amount. Otherwise,
     *         it will be 0.
     */
    public double withdraw(double requested) {
        double granted = 0;

        if (requested <= 0) {
            return granted;
        }

        if (balance >= requested) {
            balance -= requested;
            granted = requested;
        }

        return granted;
    }

    /**
     * Retrieves the account number associated with this account.
     *
     * @return The account number.
     */
    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     * Retrieves the current balance of this account.
     *
     * @return The account balance.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Returns a string representation of the Account object.
     *
     * @return A formatted string displaying the account number and balance.
     */
    @Override
    public String toString() {
        return String.format("Account no: %s. Balance: £%.2f", accountNumber, balance);
    }
}

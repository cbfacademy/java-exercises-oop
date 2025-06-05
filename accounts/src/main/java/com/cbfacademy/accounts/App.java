package com.cbfacademy.accounts;

public class App {
    public static void main(String[] args) {
        Bank bank = new Bank(0.05, 1000);
        double[] transactions = { 20, -10, -100, 73.11, -11, 5 };

        bank.openAccount(100, "basic");
        bank.openAccount(2.5, "basic");
        bank.openAccount(1000, "savings");
        bank.openAccount(200, "savings");
        bank.openAccount(1, "current");
        bank.openAccount(100, "current");

        int[] accountNumbers = bank.getAccountNumbers();

        for (int i = 0; i < accountNumbers.length; i++) {
            Account account = bank.getAccount(accountNumbers[i]);
            double transaction = transactions[i];

            if (transactions[i] < 0) {
                account.withdraw(Math.abs(transaction));
            } else {
                account.deposit(transaction);
            }
        }

        bank.report();
        bank.update();
        bank.report();
        bank.payDividend(30d);
        bank.report();
    }
}

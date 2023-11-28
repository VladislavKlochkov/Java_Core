package ru.geekbrains.lesson4;

public class Transaction {
    public static void transfer(Account fromAccount, Account toAccount, double amount) {
        try {
            fromAccount.withdrawal(amount);
            toAccount.deposit(amount);
            System.out.println("The transfer was successful!");
        } catch (Exception e) {
            System.out.println("Translation failed" + e.getMessage());
        }
    }
}

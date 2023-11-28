package ru.geekbrains.lesson4;

public abstract class Account {
    protected double balance;

    public Account(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("The initial balance cannot be negative!");
        }
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public abstract void deposit(double amount);

    public abstract void withdrawal(double amount);

}

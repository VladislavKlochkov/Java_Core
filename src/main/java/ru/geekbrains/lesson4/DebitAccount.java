package ru.geekbrains.lesson4;

public class DebitAccount extends Account {
    public DebitAccount(double balance) {
        super(balance);
    }

    @Override
    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("The deposit amount cannot be negative!");
        }
        balance += amount;
    }

    @Override
    public void withdrawal(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds! Current balance: " + balance);
        }
        balance -= amount;
    }
}

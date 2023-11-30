package ru.geekbrains.lesson4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter initial balance: ");
        double initialBalance = sc.nextDouble();

        CreditAccount account;
        try {
            account = new CreditAccount(initialBalance);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        while (true) {
            System.out.println("1. Check balance");
            System.out.println("2. Make a deposit");
            System.out.println("3. Withdraw amount");
            System.out.println("4. Exit");
            System.out.print("Select an action: ");

            int action = sc.nextInt();
            if (action == 1) {
                System.out.println("Balance: " + account.getBalance());
            } else if (action == 2) {
                System.out.print("Enter the deposit amount: ");
                double depositAmount = sc.nextDouble();
                try {
                    account.deposit(depositAmount);
                    System.out.println("Deposit made successfully!");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } else if (action == 3) {
                System.out.print("Enter the withdrawal amount: ");
                double withdrawalAmount = sc.nextDouble();
                try {
                    account.withdrawal(withdrawalAmount);
                    System.out.println("Withdrawal was successful!");
                } catch (InsufficientFundsException e) {
                    System.out.println(e.getMessage());
                }
            } else if (action == 4) {
                break;
            } else {
                System.out.println("Invalid input!");
            }
        }

        Account creditAccount = new CreditAccount(1700);
        Account debitAccount = new DebitAccount(500);
//        Account creditAccount = new CreditAccount(700);
//        Account debitAccount = new DebitAccount(1500);

        double transferAmount = 1000;

        System.out.println("Initial balances: ");
        System.out.println("Credit account " + creditAccount.getBalance());
        System.out.println("Debit account " + debitAccount.getBalance());

        Transaction.transfer(creditAccount, debitAccount, transferAmount);

        System.out.println("Final balances: ");
        System.out.println("Credit account " + creditAccount.getBalance());
        System.out.println("Debit account " + debitAccount.getBalance());
    }
}

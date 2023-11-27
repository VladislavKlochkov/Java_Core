package ru.geekbrains.lesson3;

public class Worker extends Employee {
    private double fixedMonthlyPayment;

    public Worker(String firstName, String lastName, int age, double fixedMonthlyPayment) {
        super(firstName, lastName, age);
        this.fixedMonthlyPayment = fixedMonthlyPayment;
    }

    public double getFixedMonthlyPayment() {
        return fixedMonthlyPayment;
    }

    public void setFixedMonthlyPayment(double fixedMonthlyPayment) {
        this.fixedMonthlyPayment = fixedMonthlyPayment;
    }

    @Override
    public double calculateAverageMonthlySalary() {
        return fixedMonthlyPayment;
    }

    @Override
    public String toString() {
        return "\n" + "Worker{" +
                "firstName: '" + firstName + '\'' +
                ", lastName: '" + lastName + '\'' +
                ", age: '" + age + '\'' +
                ", fixedMonthlyPayment: " + fixedMonthlyPayment +
                '}';
    }
}

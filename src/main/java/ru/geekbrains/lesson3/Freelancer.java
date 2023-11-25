package ru.geekbrains.lesson3;

public class Freelancer extends Employee {
    private double hourlyRate;

    public Freelancer(String firstName, String lastName, int age, double hourlyRate) {
        super(firstName, lastName, age);
        this.hourlyRate = hourlyRate;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateAverageMonthlySalary() {
        return 20.8 * 8 * hourlyRate;
    }

    @Override
    public String toString() {
        return "\n" + "Freelancer{" +
                "firstName: '" + firstName + '\'' +
                ", lastName: '" + lastName + '\'' +
                ", age: '" + age + '\'' +
                ", hourlyMonthlyPayment: " + calculateAverageMonthlySalary() +
                '}';
    }
}

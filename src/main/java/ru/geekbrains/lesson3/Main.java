package ru.geekbrains.lesson3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        Employee employee1 = new Worker("Ivan", "Ivanov", 30, 10_000);
        Employee employee2 = new Worker("Marina", "Romashkina", 18, 13_500);
        Employee employee3 = new Freelancer("Petr", "Petrov", 25, 50);
        Employee employee4 = new Freelancer("Sveta", "Sidorova", 51, 75);

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);

        System.out.println(employees);
        System.out.println();

        employees.sort(new EmployeeAgeComparator());
        System.out.println(employees);
        System.out.println();

        System.out.println("Iterations by last name:");
        for (Employee employee : employees) {
            System.out.println(employee.getLastName());
        }
    }
}

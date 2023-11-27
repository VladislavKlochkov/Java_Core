package ru.geekbrains.lesson3;

import java.util.Comparator;

public class EmployeeAgeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee employee1, Employee employee2) {
        return Integer.compare(employee1.age, employee2.age);
    }
}


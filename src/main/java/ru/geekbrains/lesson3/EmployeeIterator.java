package ru.geekbrains.lesson3;

import java.util.Iterator;
import java.util.List;

public class EmployeeIterator implements Iterator<Employee> {

    private List<Employee> employeeList;
    private int counter;

    public EmployeeIterator(EmployeeCollection employeeCollection) {
        this.employeeList = employeeCollection.getEmployeesList();
        this.counter = 0;
    }


    @Override
    public boolean hasNext() {
        return counter < employeeList.size() - 1;
    }

    @Override
    public Employee next() {
        if (hasNext()) {
            return employeeList.get(counter++);
        }
        return null;
    }
}


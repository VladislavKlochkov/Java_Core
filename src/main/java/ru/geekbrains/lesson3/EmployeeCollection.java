package ru.geekbrains.lesson3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmployeeCollection implements Iterable<Employee> {
    private List<Employee> employeesList;

    public EmployeeCollection(List<Employee> employeesList) {
        this.employeesList = new ArrayList<>();
    }

    public int getSize() {
        return employeesList.size();
    }

    public List<Employee> getEmployeesList() {
        return employeesList;
    }

    public void setEmployeesList(List<Employee> employeesList) {
        this.employeesList = employeesList;
    }

    @Override
    public Iterator<Employee> iterator() {
        return new EmployeeIterator(this);
    }
}

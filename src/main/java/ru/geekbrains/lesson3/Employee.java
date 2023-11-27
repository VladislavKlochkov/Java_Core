package ru.geekbrains.lesson3;

public abstract class Employee implements Comparable<Employee> {
    private int AGE_LIMIT = 16;
    protected String firstName;
    protected String lastName;
    protected int age;
    protected double salary;

    public Employee(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public Employee(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Employee() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() < 2) {
            throw new RuntimeException("Invalid first name!");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() < 2) {
            throw new RuntimeException("Invalid last name!");
        }
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < AGE_LIMIT) {
            throw new RuntimeException("The employee cannot be under " + AGE_LIMIT + " years of age!");
        }
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public abstract double calculateAverageMonthlySalary();

    @Override
    public String toString() {
        return "Employee{" + "\n" +
                "firstName: '" + firstName + '\'' +
                ", lastName: '" + lastName + '\'' +
                ", age: '" + age + '\'' +
                ", salary: " + salary +
                '}';
    }

    @Override
    public int compareTo(Employee otherEmployee) {
        if (this.age > otherEmployee.age)
            return 1;
        else if (this.age < otherEmployee.age)
            return -1;
        else return 0;
    }
}

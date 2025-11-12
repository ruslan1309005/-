package org.example.employees;

public abstract class Employee {
    public int id;
    public String fullname;

    public Employee(int id, String fullname) {
        this.id = id;
        this.fullname = fullname;
    }

    public abstract double getAverageMonthlySalary();
}



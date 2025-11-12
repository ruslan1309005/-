package org.example.employees;

public class FixedSalaryEmployee extends Employee {
    public double fixedSalary;

    public FixedSalaryEmployee(int id, String fullname, double fixedSalary) {
        super(id, fullname);
        this.fixedSalary = fixedSalary;
    }

    @Override
    public double getAverageMonthlySalary() {
        return fixedSalary;
    }
}



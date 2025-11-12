package org.example.employees;

public class HourlySalaryEmployee extends Employee {
    public double hourlyRate;

    public HourlySalaryEmployee(int id, String fullname, double hourlyRate) {
        super(id, fullname);
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double getAverageMonthlySalary() {
        return 20.8 * 8 * hourlyRate;
    }
}



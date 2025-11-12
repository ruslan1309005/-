package org.example;

public class HourlySalaryEmployee extends Employee {
    private final double hourlyRate;
    private final int hoursWorked;

    public HourlySalaryEmployee(String name, double oklad, double hourlyRate, int hoursWorked) throws org.example.exceptions.OkladException, org.example.exceptions.NameException {
        super(name, oklad);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    public double getHourlyRate() { return hourlyRate; }
    public int getHoursWorked() { return hoursWorked; }

    @Override
    public double computeSalary() {
        try {
            return getOklad() + hourlyRate * hoursWorked;
        } catch (Exception e) {
            System.out.println("Ошибка при расчёте зарплаты (контракт): " + e.getMessage());
            return 0.0;
        }
    }
}



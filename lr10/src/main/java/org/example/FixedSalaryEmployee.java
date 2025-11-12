package org.example;

import org.example.exceptions.PremiyaException;

public class FixedSalaryEmployee extends Employee {
    private final double bonus; // Премия

    public FixedSalaryEmployee(String name, double oklad, double bonus) throws org.example.exceptions.OkladException, org.example.exceptions.NameException {
        super(name, oklad);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    @Override
    public double computeSalary() {
        double result = 0.0;
        try {
            if (bonus < 0) {
                throw new PremiyaException("Премия не может быть отрицательной: " + bonus);
            }
            result = getOklad() + bonus;
        } catch (PremiyaException e) {
            System.out.println("Ошибка при расчёте зарплаты (штатный, премия): " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ошибка при расчёте зарплаты (штатный): " + e.getMessage());
        }
        return result;
    }
}



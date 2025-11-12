package model;

import exceptions.PremiyaException;

public class SalariedEmployee extends Employee {
	private final double bonus;

	public SalariedEmployee(String name, double oklad, double bonus) throws exceptions.OkladException {
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
			// основной расчет
			result = getOklad() + bonus;
		} catch (PremiyaException e) {
			System.out.println("Ошибка при расчете зарплаты (штатный сотрудник, премия): " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Ошибка при расчете зарплаты (штатный сотрудник): " + e.getMessage());
		}
		return result;
	}
}



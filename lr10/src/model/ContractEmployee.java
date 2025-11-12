package model;

public class ContractEmployee extends Employee {
	private final double hourlyRate;
	private final int hoursWorked;

	public ContractEmployee(String name, double oklad, double hourlyRate, int hoursWorked) throws exceptions.OkladException {
		super(name, oklad);
		this.hourlyRate = hourlyRate;
		this.hoursWorked = hoursWorked;
	}

	public double getHourlyRate() { return hourlyRate; }
	public int getHoursWorked() { return hoursWorked; }

	@Override
	public double computeSalary() {
		try {
			if (hoursWorked < 0) {
				throw new IllegalArgumentException("Количество часов не может быть отрицательным: " + hoursWorked);
			}
			if (hourlyRate < 0) {
				throw new IllegalArgumentException("Ставка не может быть отрицательной: " + hourlyRate);
			}
			return getOklad() + hourlyRate * hoursWorked;
		} catch (Exception e) {
			System.out.println("Ошибка при расчете зарплаты (контрактный сотрудник): " + e.getMessage());
			return 0.0;
		}
	}
}



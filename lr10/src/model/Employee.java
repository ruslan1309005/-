package model;

import exceptions.OkladException;

public abstract class Employee {
	protected final String name;
	protected final double oklad;

	public Employee(String name, double oklad) throws OkladException {
		this.name = name;
		if (oklad < 0) {
			throw new OkladException(oklad);
		}
		this.oklad = oklad;
	}

	public String getName() {
		return name;
	}

	public double getOklad() {
		return oklad;
	}

	public abstract double computeSalary();
}



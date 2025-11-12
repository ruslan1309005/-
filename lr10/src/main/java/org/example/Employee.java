package org.example;

import org.example.exceptions.NameException;
import org.example.exceptions.OkladException;

public abstract class Employee {
    private final String name;
    private final double oklad;

    public Employee(String name, double oklad) throws OkladException, NameException {
        if (name == null || name.trim().isEmpty()) {
            throw new NameException("Имя сотрудника не может быть пустым");
        }
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



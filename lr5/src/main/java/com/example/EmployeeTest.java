package com.example;

import com.example.domain.Employee;
import com.example.domain.City;
import com.example.domain.CapitalCity;
import com.example.domain.CoastalCity;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.setEmpId(101);
        emp.setName("Jane Smith");
        emp.setSalary(120_345.27);
        emp.setSsn("012-34-5678");

        System.out.println("ID сотрудника: " + emp.getEmpId());
        System.out.println("Имя сотрудника: " + emp.getName());
        System.out.println("Номер соц. страхования: " + emp.getSsn());
        System.out.println("Зарплата сотрудника: " + emp.getSalary());

        City city = new City("Минск", 350000,"Лукашенко");
        CapitalCity capital = new CapitalCity("Столичинск", 1200000, "Россия");
        CoastalCity coastal = new CoastalCity("Приморск", 500000, "Тихий океан");

        System.out.println(city.getInfo());
        System.out.println(capital.getInfo());
        System.out.println(coastal.getInfo());
    }
}



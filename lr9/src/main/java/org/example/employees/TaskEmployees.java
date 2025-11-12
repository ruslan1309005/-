package org.example.employees;

import java.util.Arrays;
import java.util.List;

public class TaskEmployees {
    public static void run() {
        List<Employee> employees = Arrays.asList(
            new FixedSalaryEmployee(1, "Илюкевич", 500.53),
            new HourlySalaryEmployee(2, "Сухой", 15),
            new FixedSalaryEmployee(3, "Тумблер", 750.75),
            new FixedSalaryEmployee(4, "Лепешов", 750.75),
            new HourlySalaryEmployee(5, "Берёзкин", 80.50),
            new HourlySalaryEmployee(6, "Фомичёв", 40.95),
            new FixedSalaryEmployee(7, "Ольховский", 433.11)
        );
        EmployeesReport.printSortedEmployees(employees);
        EmployeesReport.printFirst5Names(employees);
        EmployeesReport.printLast3Ids(employees);
    }
}



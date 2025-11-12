package org.example.employees;

import java.util.Comparator;
import java.util.List;

public class EmployeesReport {
    public static void printSortedEmployees(List<Employee> employees) {
        employees.sort(
                Comparator.comparingDouble(Employee::getAverageMonthlySalary).reversed()
                        .thenComparing((Employee e) -> e.fullname, Comparator.reverseOrder())
        );
        System.out.println("\nСписок сотрудников (от большего к меньшему по ср. зарплате):");
        for (Employee e : employees) {
            System.out.printf("id: %d | имя: %s | ср. мес. з/п: %.2f\n", e.id, e.fullname, e.getAverageMonthlySalary());
        }
    }

    public static void printFirst5Names(List<Employee> employees) {
        System.out.println("\nПервые 5 имён работников:");
        employees.stream().limit(5).forEach(e -> System.out.println(e.fullname));
    }

    public static void printLast3Ids(List<Employee> employees) {
        System.out.println("\nПоследние 3 идентификатора работников:");
        employees.stream().skip(Math.max(0, employees.size()-3)).forEach(e -> System.out.println(e.id));
    }
}



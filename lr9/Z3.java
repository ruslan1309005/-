// Задание 3. Отчёты по сотрудникам: фикс и почасовая оплата, сортировка, вывод
import java.util.*;

abstract class Employee {
    int id;
    String fullname;
    public Employee(int id, String fullname) {
        this.id = id;
        this.fullname = fullname;
    }
    // средняя месячная з/п
    public abstract double getAverageMonthlySalary();
}

class FixedSalaryEmployee extends Employee {
    double fixedSalary;
    public FixedSalaryEmployee(int id, String fullname, double fixedSalary) {
        super(id, fullname);
        this.fixedSalary = fixedSalary;
    }
    @Override
    public double getAverageMonthlySalary() {
        return fixedSalary;
    }
}

class HourlySalaryEmployee extends Employee {
    double hourlyRate;
    public HourlySalaryEmployee(int id, String fullname, double hourlyRate) {
        super(id, fullname);
        this.hourlyRate = hourlyRate;
    }
    @Override
    public double getAverageMonthlySalary() {
        return 20.8 * 8 * hourlyRate; // как условно в задании
    }
}

class EmployeesReport {
    // a) Сортировка списка нужным образом и вывод
    public static void printSortedEmployees(List<Employee> employees) {
        // сортировка: сперва по убыванию зарплаты, затем по имени
        employees.sort(Comparator.comparingDouble(Employee::getAverageMonthlySalary).reversed()
                .thenComparing(e -> e.fullname));
        System.out.println("\nСписок сотрудников (от большего к меньшему по ср. зарплате):");
        for (Employee e : employees) {
            System.out.printf("id: %d | имя: %s | ср. месячная з/п: %.2f\n", e.id, e.fullname, e.getAverageMonthlySalary());
        }
    }
    // b) Первые 5 имён
    public static void printFirst5Names(List<Employee> employees) {
        System.out.println("\nПервые 5 имён работников:");
        employees.stream().limit(5).forEach(e -> System.out.println(e.fullname));
    }
    // c) Последние 3 id
    public static void printLast3Ids(List<Employee> employees) {
        System.out.println("\nПоследние 3 идентификатора работников:");
        employees.stream().skip(Math.max(0, employees.size()-3)).forEach(e -> System.out.println(e.id));
    }
}

public class Z3 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new FixedSalaryEmployee(1, "Илюкевич", 500.53),
            new HourlySalaryEmployee(2, "Сухой", 15),
            new FixedSalaryEmployee(3, "Тумблер", 653.76),
            new FixedSalaryEmployee(4, "Лепешов", 750.75),
            new HourlySalaryEmployee(5, "Берёзкин", 80.50),
            new HourlySalaryEmployee(6, "Фомичёв", 40.95),
            new FixedSalaryEmployee(7, "Ольховский", 433.11)
        );
        // a)
        EmployeesReport.printSortedEmployees(employees);
        // b)
        EmployeesReport.printFirst5Names(employees);
        // c)
        EmployeesReport.printLast3Ids(employees);

        // Пояснения:
        // Фиксированная з/п задаётся явно, почасовая — переводится в месяц через формулу из задания (20.8 working days * 8 часов * rate)
        // Сортировка: убывание по средней з/п, если з/п равны — по имени.
        // Выводятся id, имя, средняя з/п, потом 5 имён, потом 3 последних id.
    }
}

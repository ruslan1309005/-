package org.example;

import org.example.exceptions.NameException;
import org.example.exceptions.OkladException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Демонстрация обработки исключений\n");

        // а) Сначала корректный расчёт для штатного сотрудника
        try {
            FixedSalaryEmployee seOk = new FixedSalaryEmployee("qwe", 50000, 10000);
            System.out.println("Зарплата (штатный, корректные данные): " + seOk.computeSalary());
        } catch (OkladException | NameException e) {
            System.out.println("Ошибка при создании сотрудника: " + e.getMessage());
        }

        // Сразу под ним — демонстрация ошибки имени
        try {
            FixedSalaryEmployee noNameUnder = new FixedSalaryEmployee("  ", 30000, 3000);
            System.out.println("Зарплата (штатный, пустое имя): " + noNameUnder.computeSalary());
        } catch (NameException e) {
            System.out.println("Ошибка имени сотрудника: " + e.getMessage());
        } catch (OkladException e) {
            System.out.println("Ошибка оклада: " + e.getMessage());
        }

        // Остальные демонстрации (премия < 0 и контрактники)
        try {
            FixedSalaryEmployee seBadBonus = new FixedSalaryEmployee("Пётр", 40000, -5000);
            System.out.println("Зарплата (штатный, отрицательная премия): " + seBadBonus.computeSalary());

            HourlySalaryEmployee ceOk = new HourlySalaryEmployee("Анна", 20000, 800, 20);
            System.out.println("Зарплата (контракт, корректные данные): " + ceOk.computeSalary());

            HourlySalaryEmployee ceBadHours = new HourlySalaryEmployee("Сергей", 20000, 800, -10);
            System.out.println("Зарплата (контракт, отрицательные часы): " + ceBadHours.computeSalary());
        } catch (OkladException | NameException e) {
            System.out.println("Ошибка при создании сотрудника: " + e.getMessage());
        }

        System.out.println("\nб) Демонстрация OkladException при создании сотрудника\n");

        try {
            // Фабричный метод обрабатывает OkladException, печатает сообщение и повторно бросает
            createFixedSalaryEmployee("Николай", -30000, 5000);
        } catch (OkladException e) {
            System.out.println("main повторно поймал исключение: " + e.getMessage());
        } catch (NameException e) {
            System.out.println("main поймал ошибку имени: " + e.getMessage());
        }
    }

    // Фабрика: обрабатывает OkladException, печатает требуемое сообщение и повторно бросает
    private static FixedSalaryEmployee createFixedSalaryEmployee(String name, double oklad, double bonus) throws OkladException, NameException {
        try {
            return new FixedSalaryEmployee(name, oklad, bonus);
        } catch (OkladException e) {
            System.out.println("Невозможно создать сотрудника – указан отрицательный оклад: " + e.getAmount());
            throw e; // повторно бросаем исключение
        }
    }
}
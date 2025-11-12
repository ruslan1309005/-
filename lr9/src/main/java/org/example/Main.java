package org.example;

import org.example.countries.TaskCountries;
import org.example.employees.TaskEmployees;
import org.example.students.TaskStudents;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nВыберите задание:");
            System.out.println("1. Страны и города");
            System.out.println("2. Работа со студентами");
            System.out.println("3. Сотрудники и отчёты");
            System.out.println("0. Выйти");
            System.out.print("Введите номер: ");
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    TaskCountries.run();
                    break;
                case "2":
                    TaskStudents.run();
                    break;
                case "3":
                    TaskEmployees.run();
                    break;
                case "0":
                    System.out.println("До свидания!");
                    return;
                default:
                    System.out.println("Неверный ввод!");
            }
        }
    }
}
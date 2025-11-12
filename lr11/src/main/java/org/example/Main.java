package org.example;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DecimalFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    private static final Path DATA_DIR = Paths.get("data");

    public static void main(String[] args) {
        ensureDataDir();

        try (Scanner scanner = new Scanner(System.in)) {
            scanner.useLocale(Locale.getDefault());
            while (true) {
                System.out.println();
                System.out.println("Выберите задание:");
                System.out.println("1 — Создать файл с информацией о себе и вывести сведения о файле");
                System.out.println("2 — Ввести 15 температур, сохранить в файл и вывести среднее значение");
                System.out.println("3 — Создать файл с именами, проверить наличие и обработать исключения при чтении");
                System.out.println("0 — Выход");
                System.out.print("Ваш выбор: ");

                String choice = scanner.nextLine().trim();
                if (choice.equals("0")) {
                    System.out.println("Выход.");
                    break;
                }
                switch (choice) {
                    case "1":
                        runTask1();
                        break;
                    case "2":
                        runTask2(scanner);
                        break;
                    case "3":
                        runTask3();
                        break;
                    default:
                        System.out.println("Неизвестная команда. Повторите ввод.");
                }
            }
        }
    }

    private static void ensureDataDir() {
        try {
            Files.createDirectories(DATA_DIR);
        } catch (IOException e) {
            System.err.println("Не удалось создать рабочий каталог '" + DATA_DIR + "': " + e.getMessage());
        }
    }

    // Задание 1: Создать файл с информацией о себе. Вывести данные об этом файле. Вывести информацию из файла.
    private static void runTask1() {
        Path file = DATA_DIR.resolve("me.txt");
        List<String> lines = List.of(
                "ФИО: Иванов Иван Иванович",
                "Группа: ИВТ-01",
                "Год обучения: 2025",
                "Интересы: Java, алгоритмы, системы ввода/вывода"
        );

        try {
            Files.write(file, lines, StandardCharsets.UTF_8);
            System.out.println("Файл с информацией создан: " + file);
        } catch (IOException e) {
            System.err.println("Ошибка записи файла: " + e.getMessage());
            return;
        }

        File f = file.toFile();
        System.out.println();
        System.out.println("Сведения о файле:");
        System.out.println("Имя файла: " + f.getName());
        System.out.println("Размер файла: " + f.length() + " байт");
        System.out.println("Последняя модификация: " +
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                        .withZone(ZoneId.systemDefault())
                        .format(Instant.ofEpochMilli(f.lastModified())));
        System.out.println("Родительский каталог: " + f.getParent());
        System.out.println("Путь: " + f.getPath());
        System.out.println("Абсолютный путь: " + f.getAbsolutePath());
        System.out.println("Файл " + (f.exists() ? "существует" : "не существует"));
        System.out.println((f.canRead() ? "Разрешено чтение" : "Чтение запрещено"));
        System.out.println((f.canWrite() ? "Разрешена запись" : "Запись запрещена"));
        System.out.println((f.isDirectory() ? "Это каталог" : "Это не каталог"));
        System.out.println((f.isAbsolute() ? "Путь абсолютный" : "Путь относительный") +
                (f.isFile() ? ", обычный файл" : ", именованный канал/не файл"));

        System.out.println();
        System.out.println("Содержимое файла:");
        try {
            Files.readAllLines(file, StandardCharsets.UTF_8)
                    .forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }
    }

    // Задание 2: Ввести 15 вещественных значений температуры, сохранить в файл, затем прочитать и вывести среднее
    private static void runTask2(Scanner scanner) {
        final int count = 5;
        List<Double> temps = new ArrayList<>(count);
        System.out.println("Введите " + count + " вещественных значений температуры воздуха (через Enter):");

        while (temps.size() < count) {
            System.out.print("Температура " + (temps.size() + 1) + ": ");
            String token = scanner.nextLine().trim();
            if (token.isEmpty()) continue;
            token = token.replace(',', '.');
            try {
                double value = Double.parseDouble(token);
                temps.add(value);
            } catch (NumberFormatException nfe) {
                System.out.println("Неверный формат. Введите число, например 23.5");
            }
        }

        Path file = DATA_DIR.resolve("temperatures.txt");
        // Сохраняем с использованием буферизованного вывода
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file.toFile()))) {
            for (int i = 0; i < temps.size(); i++) {
                String line = Double.toString(temps.get(i)) + (i + 1 < temps.size() ? System.lineSeparator() : "");
                bos.write(line.getBytes(StandardCharsets.UTF_8));
            }
            bos.flush();
            System.out.println("Данные сохранены в файл: " + file);
        } catch (IOException e) {
            System.err.println("Ошибка записи файла температур: " + e.getMessage());
            return;
        }

        List<Double> readTemps = new ArrayList<>();
        try {
            for (String l : Files.readAllLines(file, StandardCharsets.UTF_8)) {
                String t = l.trim();
                if (t.isEmpty()) continue;
                t = t.replace(',', '.');
                readTemps.add(Double.parseDouble(t));
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Ошибка чтения/разбора файла температур: " + e.getMessage());
            return;
        }

        if (readTemps.isEmpty()) {
            System.out.println("Файл температур пуст.");
            return;
        }

        double sum = 0.0;
        for (double v : readTemps) sum += v;
        double avg = sum / readTemps.size();
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("Средняя температура: " + df.format(avg));
    }

    // Задание 3: Создать файл с именами. Проверить наличие файла, обработать исключения при чтении.
    private static void runTask3() {
        Path file = DATA_DIR.resolve("names.txt");

        if (!Files.exists(file)) {
            System.out.println("Файл с именами не найден. Создаю пример файла: " + file);
            List<String> names = List.of("Алексей", "Мария", "Ирина", "Дмитрий", "Сергей");
            try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file.toFile(), false))) {
                for (int i = 0; i < names.size(); i++) {
                    String line = names.get(i) + (i + 1 < names.size() ? System.lineSeparator() : "");
                    bos.write(line.getBytes(StandardCharsets.UTF_8));
                }
                bos.flush();
            } catch (IOException e) {
                System.err.println("Не удалось создать файл имен: " + e.getMessage());
                return;
            }
        }

        // Проверка существования
        if (Files.exists(file)) {
            System.out.println("Файл существует: " + file.toAbsolutePath());
        } else {
            System.out.println("Файл не существует: " + file.toAbsolutePath());
            return;
        }

        // Чтение с обработкой исключений
        try {
            List<String> names = Files.readAllLines(file, StandardCharsets.UTF_8);
            System.out.println("Содержимое файла имен:");
            if (names.isEmpty()) {
                System.out.println("(пусто)");
            } else {
                for (int i = 0; i < names.size(); i++) {
                    System.out.println((i + 1) + ". " + names.get(i));
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла имен: " + e.getMessage());
        }
    }
}
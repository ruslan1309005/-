package org.example;

public class Main {
    public static void main(String[] args) {
        // ===== Задание 1: Черепаха =====
        Turtle t = new Turtle("Терри", 3, 3);
        printTurtle("Состояние черепахи (до):", t);
        t.startMoving();
        t.setSpeedCmPerSec(5);
        t.celebrateBirthday();
        printTurtle("Состояние черепахи (после):", t);

        // ===== Задание 2: Квадрат (используются классы Точка и Отрезок) =====
        Point center = new Point(0, 0);
        Segment segment = new Segment(new Point(0,0),new Point(1,1));
        Square square = new Square(segment,center);
        printSquare("Квадрат (начальный)", square);
        square.stretch(1.5);
        square.rotate(45);
        square.compress(3);
        square.setColor(new java.awt.Color(0, 128, 255));
        printSquare("Квадрат (после операций)", square);


        // Вершины и длины рёбер
        Point[] vertices = square.getVertices();
        System.out.println("Вершины квадрата:");
        for (int i = 0; i < vertices.length; i++) {
            System.out.println("Вершина " + (i + 1) + ": " + vertices[i]);
        }
        Segment[] edges = square.getEdges();
        System.out.println("Длины рёбер:");
        for (Segment e : edges) {
            System.out.println(String.format("%.4f", e.length()));
        }
    }

    private static void printTurtle(String title, Turtle t) {
        System.out.println(title);
        System.out.println("  имя: " + t.getName());
        System.out.println("  скорость: " + t.getSpeedCmPerSec() + " см/с");
        System.out.println("  возраст: " + t.getAgeYears() + " лет");
        System.out.println("  движется: " + (t.moving ? "да" : "нет"));
    }

    private static void printSquare(String title, Square s) {
        String colorHex = String.format("#%06X", s.getColor().getRGB() & 0xFFFFFF);
        System.out.println(title + ":");
        System.out.println("  центр: " + s.getCenter());
        System.out.println("  сторона: " + String.format("%.4f", s.getSide()));
        System.out.println("  поворот: " + String.format("%.2f", s.getRotationDegrees()) + "°");
        System.out.println("  цвет: " + colorHex);
    }
}
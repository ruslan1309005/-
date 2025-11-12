package org.example;

public class Main {
    public static void main(String[] args) {
        String name = args != null && args.length > 0 ? args[0] : "ИМЯ";
        System.out.println("Привет, " + name);

        Tester t1 = new Tester();
        Tester t2 = new Tester("Новик", "Никитос");
        Tester t3 = new Tester("Жежко", "Вадим", 5, "B2", 2500.0);

        System.out.println(t1.describe());
        System.out.println(t2.describe(true));
        System.out.println(t3.describe("Сеньор"));

        Tester junior = Tester.junior("Сухой", "Илья");
        System.out.println(junior.describe());
    }
}
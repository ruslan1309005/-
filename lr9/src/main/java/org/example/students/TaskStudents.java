package org.example.students;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TaskStudents {
    public static void run() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Андрей", "Группа 1", 1, Arrays.asList(4,3,3,4)));
        students.add(new Student("Елена", "Группа 1", 2, Arrays.asList(5,5,5,5)));
        students.add(new Student("Иван", "Группа 2", 1, Arrays.asList(2,2,3,2)));
        System.out.println("---Начальный список студентов---");
        for (Student s : students) {
            System.out.println(s.name + ", курс: " + s.course + ", ср. балл: " + s.getAverageGrade());
        }
        processStudents(students);
        printStudents(students,2);
        printStudents(students,3);
    }

    public static void processStudents(List<Student> students) {
        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            Student s = it.next();
            if (s.getAverageGrade() < 3) {
                System.out.println("Удалён студент (ср. балл <3): " + s.name);
                it.remove();
            } else {
                s.course++;
                System.out.println("Студент переведён на следующий курс: " + s.name);
            }
        }
    }

    public static void printStudents(List<Student> students, int course) {
        System.out.println("\nСтуденты на курсе " + course + ":");
        for (Student s : students) {
            if (s.course == course) {
                System.out.println(s.name);
            }
        }
    }
}



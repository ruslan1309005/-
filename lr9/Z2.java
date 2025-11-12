// Задание 2. Работа со студентами
import java.util.*;

class Student {
    String name;
    String group;
    int course;
    List<Integer> grades;

    public Student(String name, String group, int course, List<Integer> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }

    public double getAverageGrade() {
        return grades.stream().mapToInt(x -> x).average().orElse(0);
    }
}

public class Z2 {
    // Удалить студентов со средним баллом < 3 и перевести остальных
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
    // Печать по курсу
    public static void printStudents(List<Student> students, int course) {
        System.out.println("\nСтуденты на курсе " + course + ":");
        for (Student s : students) {
            if (s.course == course) {
                System.out.println(s.name);
            }
        }
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Андрей", "Группа 1", 1, Arrays.asList(4,3,3,4)));
        students.add(new Student("Елена", "Группа 1", 2, Arrays.asList(5,5,5,5)));
        students.add(new Student("Иван", "Группа 2", 1, Arrays.asList(2,2,3,2)));

        System.out.println("---Начальный список студентов---");
        for (Student s : students) {
            System.out.println(s.name + ", курс: " + s.course + ", ср. балл: " + s.getAverageGrade());
        }

        processStudents(students);

        // Проверка метода печати после обработки
        printStudents(students,2); // студенты переведённые на 2 курс
        printStudents(students,3); // студенты переведённые на 3 курс
    }
    // Пояснения:
    // processStudents удаляет студентов со средним баллом <3 и переводит остальных на следующий курс.
    // printStudents печатает имена студентов, которые учатся на указанном курсе.
}

package org.example.students;

import java.util.List;

public class Student {
    public String name;
    public String group;
    public int course;
    public List<Integer> grades;

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



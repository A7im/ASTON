package Aston.lesson13;


import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Lesson13 {
    public static void main(String[] args) {
        Set<Student> student = new HashSet<>();
        student.add(new Student("Peter", "3b", 2, Arrays.asList(4, 4, 5, 6)));
        student.add(new Student("Peter", "3b", 2, Arrays.asList(4, 2, 5, 6)));
        student.add(new Student("Peter", "3b", 2, Arrays.asList(3, 2, 3, 3)));
        System.out.println("Исходник: ");

        System.out.println("Исходные данные:");
        printStudents(student, 2);

        promoteStudents(student);
        deleteStudents(student);

        System.out.println("\nПосле обработки:");
        printStudents(student, 2);
        printStudents(student, 3);

    }

    public static void deleteStudents (Collection < Student > student) {
        student.removeIf(students -> students.averageGrade() < 3.0);
    }

    public static void promoteStudents (Collection < Student > student) {
        for (Student students : student) {
            if (students.averageGrade() >= 3.0) {
                students.setCourse(students.getCourse() + 1);
            }
        }
    }

    public static void printStudents (Set < Student > student,int course){
        System.out.println("Студенты " + course + " курса");
        for (Student students : student) {
            if (students.getCourse() == course) {
                System.out.println(students.getName());
            }
        }
    }

}
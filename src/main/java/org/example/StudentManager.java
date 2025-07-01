package org.example;

import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private List<Student> students = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();
    private IGradeRepository gradeRepo;

    public StudentManager(IGradeRepository gradeRepo) {
        this.gradeRepo = gradeRepo;
    }

    public void addStudent(int id, String name) {
        students.add(new Student(id, name));
    }

    public void addCourse(int id, String name) {
        courses.add(new Course(id, name));
    }

    public void addGrade(int studentId, int courseId, double score) {
        Student student = findStudentById(studentId);
        Course course = findCourseById(courseId);
        if (student != null && course != null) {
            gradeRepo.addGrade(new Grade(student, course, score));
            System.out.println("Calificación registrada correctamente");
        } else {
            System.out.println("Estudiante o curso no encontrado");
        }
    }

    public void listGrades() {
        for (Grade g : gradeRepo.getGrades()) {
            System.out.println(g);
        }
    }

    private Student findStudentById(int id) {
        return students.stream().filter(s -> s.getId() == id).findFirst().orElse(null);
    }

    private Course findCourseById(int id) {
        return courses.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }
}
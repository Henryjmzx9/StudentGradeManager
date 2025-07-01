package org.example;

import java.util.ArrayList;
import java.util.List;

public class GradeRepository implements IGradeRepository {
    private List<Grade> grades = new ArrayList<>();

    @Override
    public void addGrade(Grade grade) {
        grades.add(grade);
    }

    @Override
    public List<Grade> getGrades() {
        return grades;
    }
}
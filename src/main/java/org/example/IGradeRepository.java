package org.example;

import java.util.List;

public interface IGradeRepository {
    void addGrade(Grade grade);
    List<Grade> getGrades();
}

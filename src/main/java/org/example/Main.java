package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IGradeRepository gradeRepo = new GradeRepository();
        StudentManager manager = new StudentManager(gradeRepo);

        int opcion;
        do {
            System.out.println("\n=== Sistema de Calificaciones ===");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Registrar curso");
            System.out.println("3. Registrar calificación");
            System.out.println("4. Ver calificaciones");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("ID del estudiante: ");
                    int sid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nombre: ");
                    String sname = sc.nextLine();
                    manager.addStudent(sid, sname);
                    break;
                case 2:
                    System.out.print("ID del curso: ");
                    int cid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nombre: ");
                    String cname = sc.nextLine();
                    manager.addCourse(cid, cname);
                    break;
                case 3:
                    System.out.print("ID del estudiante: ");
                    int sid2 = sc.nextInt();
                    System.out.print("ID del curso: ");
                    int cid2 = sc.nextInt();
                    System.out.print("Nota: ");
                    double nota = sc.nextDouble();
                    manager.addGrade(sid2, cid2, nota);
                    break;
                case 4:
                    manager.listGrades();
                    break;
                case 5:
                    System.out.println("Gracias por usar El sistema de Calificaciones");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != 5);

        sc.close();
    }
}

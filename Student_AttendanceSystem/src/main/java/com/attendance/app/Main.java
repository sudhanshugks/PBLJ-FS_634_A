package com.attendance.app;

import com.attendance.app.dao.AttendanceDAO;
import com.attendance.app.dao.StudentDAO;
import com.attendance.app.model.Attendance;
import com.attendance.app.model.Student;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== Attendance Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. List Students");
            System.out.println("3. Mark Attendance");
            System.out.println("4. View Attendance by Student");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            String choice = sc.nextLine();
            try {
                switch (choice) {
                    case "1" -> addStudent();
                    case "2" -> listStudents();
                    case "3" -> markAttendance();
                    case "4" -> viewAttendance();
                    case "0" -> System.exit(0);
                    default -> System.out.println("Invalid choice, try again.");
                }
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void addStudent() throws SQLException {
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter roll number: ");
        String roll = sc.nextLine();
        int id = StudentDAO.addStudent(new Student(name, roll));
        System.out.println("Student added with ID: " + id);
    }

    private static void listStudents() throws SQLException {
        List<Student> list = StudentDAO.listStudents();
        list.forEach(System.out::println);
    }

    private static void markAttendance() throws SQLException {
        System.out.print("Student ID: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Date (YYYY-MM-DD): ");
        Date date = Date.valueOf(sc.nextLine());
        System.out.print("Present? (y/n): ");
        boolean present = sc.nextLine().equalsIgnoreCase("y");
        AttendanceDAO.markAttendance(new Attendance(id, date, present));
        System.out.println("Attendance marked successfully!");
    }

    private static void viewAttendance() throws SQLException {
        System.out.print("Student ID: ");
        int id = Integer.parseInt(sc.nextLine());
        List<Attendance> list = AttendanceDAO.getAttendanceByStudent(id);
        list.forEach(a -> System.out.println(a.getAttendDate() + " -> " + (a.isPresent() ? "Present" : "Absent")));
    }
}

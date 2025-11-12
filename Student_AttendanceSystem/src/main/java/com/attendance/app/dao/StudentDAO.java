package com.attendance.app.dao;

import com.attendance.app.DBConnection;
import com.attendance.app.model.Student;
import java.sql.*;
import java.util.*;

public class StudentDAO {
    public static int addStudent(Student s) throws SQLException {
        String sql = "INSERT INTO students (name, roll_no) VALUES (?, ?)";
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, s.getName());
            ps.setString(2, s.getRollNo());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) return rs.getInt(1);
            }
        }
        return -1;
    }

    public static List<Student> listStudents() throws SQLException {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT id, name, roll_no FROM students";
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(new Student(rs.getInt("id"), rs.getString("name"), rs.getString("roll_no")));
            }
        }
        return list;
    }
}

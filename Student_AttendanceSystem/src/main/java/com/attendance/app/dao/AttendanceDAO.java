package com.attendance.app.dao;

import com.attendance.app.DBConnection;
import com.attendance.app.model.Attendance;
import java.sql.*;
import java.util.*;

public class AttendanceDAO {
    public static boolean markAttendance(Attendance a) throws SQLException {
        String sql = "INSERT INTO attendance (student_id, attend_date, present) VALUES (?, ?, ?) " +
                     "ON DUPLICATE KEY UPDATE present = VALUES(present)";
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, a.getStudentId());
            ps.setDate(2, a.getAttendDate());
            ps.setBoolean(3, a.isPresent());
            return ps.executeUpdate() > 0;
        }
    }

    public static List<Attendance> getAttendanceByStudent(int studentId) throws SQLException {
        List<Attendance> list = new ArrayList<>();
        String sql = "SELECT * FROM attendance WHERE student_id=?";
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, studentId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Attendance a = new Attendance();
                    a.setId(rs.getInt("id"));
                    a.setStudentId(rs.getInt("student_id"));
                    a.setAttendDate(rs.getDate("attend_date"));
                    a.setPresent(rs.getBoolean("present"));
                    list.add(a);
                }
            }
        }
        return list;
    }
}

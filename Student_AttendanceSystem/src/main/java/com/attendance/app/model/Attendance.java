package com.attendance.app.model;

import java.sql.Date;

public class Attendance {
    private int id;
    private int studentId;
    private Date attendDate;
    private boolean present;

    public Attendance() {}
    public Attendance(int studentId, Date attendDate, boolean present) {
        this.studentId = studentId;
        this.attendDate = attendDate;
        this.present = present;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }
    public Date getAttendDate() { return attendDate; }
    public void setAttendDate(Date attendDate) { this.attendDate = attendDate; }
    public boolean isPresent() { return present; }
    public void setPresent(boolean present) { this.present = present; }
}

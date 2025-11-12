package com.attendance.app.model;

public class Student {
    private int id;
    private String name;
    private String rollNo;

    public Student() {}
    public Student(String name, String rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }
    public Student(int id, String name, String rollNo) {
        this.id = id;
        this.name = name;
        this.rollNo = rollNo;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getRollNo() { return rollNo; }
    public void setRollNo(String rollNo) { this.rollNo = rollNo; }

    @Override
    public String toString() {
        return "[" + id + "] " + name + " (Roll No: " + rollNo + ")";
    }
}

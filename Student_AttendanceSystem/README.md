# 🎓 Attendance Management System (Java + JDBC + MySQL)

A simple college-level project using **Java 23**, **JDBC**, and **MySQL** — made to manage student attendance from the command line.

## 🚀 How to Run
1. Open MySQL and create database:
   ```sql
   CREATE DATABASE attendance_db;
   USE attendance_db;
   CREATE TABLE students (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(100), roll_no VARCHAR(50) UNIQUE);
   CREATE TABLE attendance (id INT AUTO_INCREMENT PRIMARY KEY, student_id INT, attend_date DATE, present BOOLEAN, FOREIGN KEY (student_id) REFERENCES students(id));
Update DB username/password in DBConnection.java

In terminal:
```bash
mvn compile
mvn exec:java

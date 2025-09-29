import java.io.*;
class Student implements Serializable {
    int studentID;
    String name;
    String grade;

    public Student(int studentID, String name, String grade) {
        this.studentID = studentID;
        this.name = name;
        this.grade = grade;
    }
    @Override
    public String toString() {
        return "StudentID: " + studentID + ", Name: " + name + ", Grade: " + grade;
    }
}
public class Main {
    public static void main(String[] args) {
        String filename = "student.ser"; 
        Student s1 = new Student(101, "Mommy", "A");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(s1);
            System.out.println("Student object serialized and saved to " + filename);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            Student s2 = (Student) ois.readObject();
            System.out.println("Student object deserialized:");
            System.out.println(s2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

import java.io.*;
import java.util.*;

class Main {
    static String file = "employees.txt";

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Add Employee\n2. Display All\n3. Exit");
            int ch = sc.nextInt(); sc.nextLine();
            if (ch == 1) {
                System.out.print("ID: "); String id=sc.nextLine();
                System.out.print("Name: "); String name=sc.nextLine();
                System.out.print("Designation: "); String des=sc.nextLine();
                System.out.print("Salary: "); String sal=sc.nextLine();
                try (FileWriter fw=new FileWriter(file,true)) {
                    fw.write(id+","+name+","+des+","+sal+"\n");
                }
                System.out.println("Employee Added");
            } 
            else if (ch == 2) {
                try (BufferedReader br=new BufferedReader(new FileReader(file))) {
                    String line; 
                    System.out.println("\n--- Employee Records ---");
                    while((line=br.readLine())!=null) System.out.println(line);
                } catch(FileNotFoundException e){ System.out.println("No records yet."); }
            } 
            else if (ch == 3) break;
            else System.out.println("Invalid Choice!");
        }
        sc.close();
    }
}

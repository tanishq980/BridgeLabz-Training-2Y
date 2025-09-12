import java.util.Scanner;
class Student {
    String name;
    int rollNo;
    int[] marks = new int[3];
    void inputDetails(Scanner sc) {
        System.out.print("Enter Name: ");
        name = sc.next();

        System.out.print("Enter Roll No: ");
        rollNo = sc.nextInt();

        System.out.print("Enter marks in 3 subjects: ");
        for (int i = 0; i < 3; i++) {
            marks[i] = sc.nextInt();
        }
    }
    int getTotalMarks() {
        int total = 0;
        for (int m : marks) {
            total += m;
        }
        return total;
    }
    void displayDetails() {
        System.out.println("\nStudent Details:");
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.print("Marks: ");
        for (int m : marks) {
            System.out.print(m + " ");
        }
        System.out.println("\nTotal Marks: " + getTotalMarks());
    }
}
public class StudentMarksSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Student " + (i + 1) + ":");
            students[i] = new Student();
            students[i].inputDetails(sc);
        }

        for (Student s : students) {
            s.displayDetails();
        }

        sc.close();
    }
}
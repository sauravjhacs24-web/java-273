import java.util.Scanner;

// Step 2: Subject class
class Subject {
    int subjectMarks;
    int credits;
    int grade;
}

// Step 3–5: Student class
class Student {
    String name;
    String usn;
    double SGPA;
    Scanner s = new Scanner(System.in);
    Subject subject[];

    // Constructor
    Student() {
        subject = new Subject[8]; // 8 subjects
        for (int i = 0; i < 8; i++) {
            subject[i] = new Subject();
        }
    }

    // Step 6: Read name and USN
    void getStudentDetails() {
        System.out.print("Enter Name: ");
        name = s.nextLine();
        System.out.print("Enter USN: ");
        usn = s.nextLine();
    }

    // Step 7: Read marks and credits, calculate grades
    void getMarks() {
        for (int i = 0; i < 8; i++) {
            System.out.println("\nEnter details for Subject " + (i + 1) + ":");
            System.out.print("Enter Marks (0–100): ");
            subject[i].subjectMarks = s.nextInt();

            System.out.print("Enter Credits: ");
            subject[i].credits = s.nextInt();

            // Calculate grade
            subject[i].grade = (subject[i].subjectMarks / 10) + 1;

            if (subject[i].grade == 11)
                subject[i].grade = 10;
            if (subject[i].grade <= 4)
                subject[i].grade = 0;

            // Invalid marks check
            if (subject[i].subjectMarks > 100 || subject[i].subjectMarks < 0) {
                System.out.println("Invalid marks! Setting grade = 0");
                subject[i].grade = 0;
            }
        }
    }

    // Step 8: Compute SGPA
    void computeSGPA() {
        int effectiveScore = 0;
        int totalCredits = 0;

        for (int i = 0; i < 8; i++) {
            effectiveScore += (subject[i].grade * subject[i].credits);
            totalCredits += subject[i].credits;
        }

        SGPA = (double) effectiveScore / totalCredits;
    }

    // Step 9–10: Display details
    void displayDetails() {
        System.out.println("\n----------------------------");
        System.out.println("Name : " + name);
        System.out.println("USN : " + usn);
        System.out.printf("SGPA : %.2f\n", SGPA);
        System.out.println("----------------------------");
    }
}

// Step 9: Main class
public class StudentSGPA {
    public static void main(String[] args) {
        Student st = new Student();
        st.getStudentDetails();
        st.getMarks();
        st.computeSGPA();
        st.displayDetails();
    }
}
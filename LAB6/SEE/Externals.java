package SEE;

import CIE.internals;
import java.util.Scanner;

public class Externals extends internals {

    protected int marks[];
    protected int finalMarks[];

    public Externals() {
        marks = new int[5];
        finalMarks = new int[5];
    }

    public void inputSEEmarks() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter 5 SEE marks: ");

        for (int i = 0; i < 5; i++) {
            System.out.print("SEE Mark in Subject " + (i + 1) + ": ");
            marks[i] = s.nextInt();
        }
    }

    public void calculateFinalMarks() {
        for (int i = 0; i < 5; i++) {
            finalMarks[i] = super.marks[i] + marks[i]/2;  // CIE + SEE
        }
    }

    public void displayFinalMarks() {
        System.out.println("\n--- Final Marks ---");
        displayStudentDetails();

        for (int i = 0; i < 5; i++) {
            System.out.println("Final Marks in Subject  " + (i + 1) + ": " + finalMarks[i]);
        }
    }
}

package CIE;
import java.util.Scanner;

public class internals extends STUDENT {

    protected int marks[] = new int[5];

    public void inputCIEmarks() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter 5 CIE marks: ");

        for (int i = 0; i < 5; i++) {
            System.out.print("CIE Mark in Subject " + (i + 1) + ": ");
            marks[i] = s.nextInt();
        }
    }
}
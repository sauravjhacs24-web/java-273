import java.util.Scanner;

class WrongAge extends Exception {
public WrongAge(String message) {
super(message);
}
}

class Father {
int fatherAge;

Father() throws WrongAge {
Scanner sc = new Scanner(System.in);
System.out.print("Enter Father's Age: ");
fatherAge = sc.nextInt();

if (fatherAge < 0) {
throw new WrongAge("Age cannot be negative");
}
}
}

class Son extends Father {
int sonAge;

Son() throws WrongAge {
super();

Scanner sc = new Scanner(System.in);
System.out.print("Enter Son's Age: ");
sonAge = sc.nextInt();

if (sonAge < 0) {
throw new WrongAge("Age cannot be negative");
}

if (sonAge >= fatherAge) {
throw new WrongAge("Son's age cannot be greater than or equal to Father's age");
}
}
}

public class InheritanceExceptionDemo {
public static void main(String[] args) {
try {
Son s = new Son();
System.out.println("Father Age: " + s.fatherAge);
System.out.println("Son Age: " + s.sonAge);
} catch (WrongAge e) {
System.out.println("Exception: " + e.getMessage());
}
}
}
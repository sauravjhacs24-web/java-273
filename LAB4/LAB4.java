import java.util.Scanner;

abstract class Shape {
int dim1, dim2;

Shape(int a, int b) {
dim1 = a;
dim2 = b;
}

abstract void printArea();
}

class Rectangle extends Shape {
Rectangle(int l, int b) {
super(l, b);
}

void printArea() {
double area = dim1 * dim2;
System.out.println("Area of Rectangle = " + area);
}
}

class Triangle extends Shape {
Triangle(int b, int h) {
super(b, h);
}

void printArea() {
double area = 0.5 * dim1 * dim2;
System.out.println("Area of Triangle = " + area);
}
}

class Circle extends Shape {
Circle(int r) {
super(r, 0);
}

void printArea() {
double area = 3.14159 * dim1 * dim1;
System.out.println("Area of Circle = " + area);
}
}

public class LAB4 {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);

System.out.println("Enter the dimensions of the rectangle (length and breadth):");
int l = sc.nextInt();
int b = sc.nextInt();
Rectangle r = new Rectangle(l, b);

System.out.println("Enter the dimensions of the triangle (base and height):");
int bt = sc.nextInt();
int h = sc.nextInt();
Triangle t = new Triangle(bt, h);

System.out.println("Enter the dimension of the circle (radius):");
int rad = sc.nextInt();
Circle c = new Circle(rad);

r.printArea();
t.printArea();
c.printArea();
}
}
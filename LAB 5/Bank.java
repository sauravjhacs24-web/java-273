import java.util.Scanner;

// Base class Account
class Account {
String customerName;
int accountNumber;
String accountType;
double balance;

Account(String name, int number, String type) {
customerName = name;
accountNumber = number;
accountType = type.toLowerCase();
balance = 0.0;
}

void deposit(double amount) {
balance += amount;
System.out.println("Deposited: " + amount + ". Updated balance: " + balance);
}

void display() {
System.out.println("Customer name: " + customerName);
System.out.println("Account number: " + accountNumber);
System.out.println("Type of ACCOUNT: " + (accountType.equals("saving") ? "Savings account" : "Current account"));
System.out.println("Balance = " + balance);
}
}

// Savings Account class
class Sav_acct extends Account {

Sav_acct(String name, int number) {
super(name, number, "saving");
}

void computeInterest() {
double interest = balance * 0.04; // 4% interest rate
balance += interest;
System.out.println("Interest added: " + interest + ". Updated balance: " + balance);
}

void withdraw(double amount) {
if (amount > balance) {
System.out.println("Insufficient balance!");
} else {
balance -= amount;
System.out.println("Withdrawn: " + amount + ". Updated balance: " + balance);
}
}
}

// Current Account class
class Cur_acct extends Account {
final double minBalance = 500;
final double serviceCharge = 50;

Cur_acct(String name, int number) {
super(name, number, "current");
}

void checkBalance() {
if (balance < minBalance) {
balance -= serviceCharge;
System.out.println("Balance below minimum. Service charge of Rs." + serviceCharge + " imposed.");
}
}

void withdraw(double amount) {
if (amount > balance) {
System.out.println("Insufficient balance!");
} else {
balance -= amount;
checkBalance(); // check after withdrawal
System.out.println("Withdrawn: " + amount + ". Updated balance: " + balance);
}
}
}

// Main Bank class
public class Bank {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);

System.out.print("Enter customer name: ");
String name1 = sc.nextLine();
System.out.print("Enter account number: ");
int accNum1 = sc.nextInt();
sc.nextLine();

System.out.print("Enter customer name: ");
String name2 = sc.nextLine();
System.out.print("Enter account number: ");
int accNum2 = sc.nextInt();
sc.nextLine();

Sav_acct sAcc = new Sav_acct(name1, accNum1);
Cur_acct cAcc = new Cur_acct(name2, accNum2);

int choice;
do {
System.out.println("\n-------MENU-------");
System.out.println("1. Deposit");
System.out.println("2. Withdraw");
System.out.println("3. Compute Interest for Savings Account");
System.out.println("4. Display account details");
System.out.println("5. Exit");
System.out.print("Enter your choice: ");
choice = sc.nextInt();
sc.nextLine();

switch (choice) {
case 1:
System.out.print("Enter the type of account (saving/current): ");
String type1 = sc.nextLine().toLowerCase();
System.out.print("Enter the deposit amount: ");
double depAmt = sc.nextDouble();
sc.nextLine();
if (type1.equals("saving"))
sAcc.deposit(depAmt);
else
cAcc.deposit(depAmt);
break;

case 2:
System.out.print("Enter the type of account (saving/current): ");
String type2 = sc.nextLine().toLowerCase();
System.out.print("Enter the withdrawal amount: ");
double withAmt = sc.nextDouble();
sc.nextLine();
if (type2.equals("saving"))
sAcc.withdraw(withAmt);
else
cAcc.withdraw(withAmt);
break;

case 3:
System.out.print("Enter the type of account (saving/current): ");
String type3 = sc.nextLine().toLowerCase();
if (type3.equals("saving"))
sAcc.computeInterest();
else
System.out.println("No interest for current account.");
break;

case 4:
System.out.print("Enter the type of account (saving/current): ");
String type4 = sc.nextLine().toLowerCase();
if (type4.equals("saving"))
sAcc.display();
else
cAcc.display();
break;

case 5:
System.out.println("Exiting...");
break;

default:
System.out.println("Invalid choice!");
}
} while (choice != 5);

sc.close();
}
}
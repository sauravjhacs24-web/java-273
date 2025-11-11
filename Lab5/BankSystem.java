import java.util.Scanner;

class Account {
    String customerName;
    int accountNumber;
    String accountType;
    double balance;

    Account(String name, int accNo, String type) {
        customerName = name;
        accountNumber = accNo;
        accountType = type;
        balance = 0.0;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + ". Updated balance: " + balance);
    }

    void display() {
        System.out.println("Customer name: " + customerName);
        System.out.println("Account number: " + accountNumber);
        System.out.println("Type of Account: " + accountType);
        System.out.println("Account Balance: " + balance);
    }
}

class SavAcct extends Account {
    SavAcct(String name, int accNo, String type) {
        super(name, accNo, type);
    }

    void computeInterest() {
        double rate = 0.04;
        double interest = balance * rate;
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

class CurAcct extends Account {
    final double MIN_BAL = 500.0;
    final double SERVICE_CHARGE = 100.0;

    CurAcct(String name, int accNo, String type) {
        super(name, accNo, type);
    }

    void checkBalance() {
        if (balance < MIN_BAL) {
            balance -= SERVICE_CHARGE;
            System.out.println("Balance below minimum. Service charge imposed: " + SERVICE_CHARGE);
            System.out.println("Updated balance: " + balance);
        }
    }

    void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            checkBalance();
            System.out.println("Withdrawn: " + amount + ". Updated balance: " + balance);
        }
    }
}

public class BankSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account[] accounts = new Account[2];

        for (int i = 0; i < 2; i++) {
            System.out.print("Enter customer name: ");
            String name = sc.nextLine();
            System.out.print("Enter account number: ");
            int accNo = Integer.parseInt(sc.nextLine());
            System.out.print("Enter type of account (saving/current): ");
            String type = sc.nextLine().toLowerCase();

            if (type.equals("saving"))
                accounts[i] = new SavAcct(name, accNo, type);
            else
                accounts[i] = new CurAcct(name, accNo, type);
        }

        int choice;
        do {
            System.out.println("\n-------MENU-------");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Compute Interest for Savings Account");
            System.out.println("4. Display Account Details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the type of account (saving/current): ");
                    String type = sc.next().toLowerCase();
                    System.out.print("Enter the deposit amount: ");
                    double depAmt = sc.nextDouble();
                    for (Account acc : accounts) {
                        if (acc.accountType.equals(type)) {
                            acc.deposit(depAmt);
                           
                            break;
                        }
                    }
                    break;

                case 2:
                    System.out.print("Enter the type of account (saving/current): ");
                    type = sc.next().toLowerCase();
                    System.out.print("Enter the withdrawal amount: ");
                    double wAmt = sc.nextDouble();
                    for (Account acc : accounts) {
                        if (acc.accountType.equals(type)) {
                            if (type.equals("saving"))
                                ((SavAcct) acc).withdraw(wAmt);
                            else
                                ((CurAcct) acc).withdraw(wAmt);
                           
                            break;
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter the type of account (saving/current): ");
                    type = sc.next().toLowerCase();
                    for (Account acc : accounts) {
                        if (acc.accountType.equals("saving") && type.equals("saving")) {
                            ((SavAcct) acc).computeInterest();
                           
                            break;
                        }
                    }
                    break;

                case 4:
                    System.out.print("Enter the type of account (saving/current): ");
                    type = sc.next().toLowerCase();
                    for (Account acc : accounts) {
                        if (acc.accountType.equals(type)) {
                            acc.display();
                            break;
                        }
                    }
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
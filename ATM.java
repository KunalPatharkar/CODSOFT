import java.util.*;
public class ATM {
    static Scanner scanner = new Scanner(System.in);
    static BankAccount account = new BankAccount(1000.0);
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1.Check Balance \n2.Deposit \n3.Withdraw \n4.Exit \nEnter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdraw amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }  }
    static void checkBalance() {
        System.out.println("Current balance: " + account.getBalance());
    }
    static void deposit(double amount) {
        account.setBalance(account.getBalance() + amount);
        System.out.println("Successfully deposited " + amount);
    }
    static void withdraw(double amount) {
        if (amount <= account.getBalance()) {
            account.setBalance(account.getBalance() - amount);
            System.out.println("Successfully withdrew " + amount);
        } else {
            System.out.println("Insufficient balance.");
        }
    }}
class BankAccount {
    private double balance;
    BankAccount(double balance) {
        this.balance = balance;
    }
    double getBalance() {
        return balance;
    }
    void setBalance(double balance) {
        this.balance = balance;
    }
}

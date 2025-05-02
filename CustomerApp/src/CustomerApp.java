import java.util.Scanner;

/**
 * This program demonstrates the creation of a customer object and allows simple operations like checking balance.
 */
public class CustomerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a new customer object with sample data
        Customer customer1 = new Customer(1, "John Doe", 123456, 5000);

        // Display customer information
        System.out.println("Customer ID: " + customer1.getId());
        System.out.println("Customer Name: " + customer1.getName());
        System.out.println("Account Number: " + customer1.getAccountNumber());
        System.out.println("Initial Balance: $" + customer1.getBalance());

        // Example of depositing money
        System.out.print("Enter amount to deposit: ");
        int depositAmount = scanner.nextInt();
        customer1.deposit(depositAmount);
        System.out.println("New Balance after deposit: $" + customer1.getBalance());

        // Example of withdrawing money
        System.out.print("Enter amount to withdraw: ");
        int withdrawAmount = scanner.nextInt();
        customer1.withdraw(withdrawAmount);
        System.out.println("New Balance after withdrawal: $" + customer1.getBalance());

        scanner.close();
    }
}

class Customer {
    private int id;
    private String name;
    private int accountNumber;
    private int balance;

    public Customer(int id, String name, int accountNumber, int balance) {
        this.id = id;
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Getter methods for accessing private attributes
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    // Method to deposit money
    public void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money
    public void withdraw(int amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: $" + amount);
        } else {
            System.out.println("Invalid or insufficient funds for withdrawal.");
        }
    }
}

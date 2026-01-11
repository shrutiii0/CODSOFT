import java.util.Scanner;

// CREATING BANK ACCOUNT CLASS
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    // CREATE GET_BALANCE METHOD
    public double getBalance() {
        return balance;
    }

    // CREATE CHECK_BALANCE METHOD
    public void checkBalance() {
        System.out.println("Current Balance: $" + balance);
    }

    // withdraw method with validation and messages
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. Remaining Balance: $" + balance);
            return true;
        } else if (amount > balance) {
            System.out.println("Insufficient funds. Current Balance: $" + balance);
            return false;
        } else {
            System.out.println("Invalid withdrawal amount.");
            return false;
        }
    }

    // deposit method with messages
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New Balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
}

// ATM Interface Class
public class atmInterface {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.00); // Initial balance
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("Welcome to the ATM!");

        while (!exit) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        account.checkBalance();
                        break;
                    case 2:
                        System.out.print("Enter amount to withdraw: $");
                        if (scanner.hasNextDouble()) {
                            double withdrawAmount = scanner.nextDouble();
                            account.withdraw(withdrawAmount);
                        } else {
                            System.out.println("Invalid input. Please enter a valid number.");
                            scanner.next(); // Consume invalid input
                        }
                        break;
                    case 3:
                        System.out.print("Enter amount to deposit: $");
                        if (scanner.hasNextDouble()) {
                            double depositAmount = scanner.nextDouble();
                            account.deposit(depositAmount);
                        } else {
                            System.out.println("Invalid input. Please enter a valid number.");
                            scanner.next(); // Consume invalid input
                        }
                        break;
                    case 4:
                        exit = true;
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number from the menu.");
                scanner.next(); // Consume invalid input
            }
        }
        scanner.close();
    }
}
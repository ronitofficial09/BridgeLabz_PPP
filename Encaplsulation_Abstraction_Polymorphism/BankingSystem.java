import java.util.ArrayList;
import java.util.List;

// Abstraction & Encapsulation
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    // Abstraction
    public abstract double calculateInterest();

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Concrete methods 
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Deposit successful. New balance: $" + String.format("%.2f", this.balance));
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && this.balance >= amount) {
            this.balance -= amount;
            System.out.println("Withdrawal successful. New balance: $" + String.format("%.2f", this.balance));
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }

    // Encapsulation
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }
}

// Abstraction
interface Loanable {
    double applyForLoan(double loanAmount);
    double calculateLoanEligibility();
}

// Inheritance & Abstraction
class SavingsAccount extends BankAccount {
    private static final double INTEREST_RATE = 0.02;

    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    // Abstraction
    @Override
    public double calculateInterest() {
        return getBalance() * INTEREST_RATE;
    }
}

// Inheritance & Abstraction
class CurrentAccount extends BankAccount implements Loanable {
    private static final double INTEREST_RATE = 0.005; 
    private static final double LOAN_FACTOR = 2.5;

    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    // Abstraction
    @Override
    public double calculateInterest() {
        return getBalance() * INTEREST_RATE;
    }

    // Abstraction
    @Override
    public double applyForLoan(double loanAmount) {
        if (loanAmount <= calculateLoanEligibility()) {
            System.out.println("Loan of $" + String.format("%.2f", loanAmount) + " approved for account " + getAccountNumber());
            return loanAmount;
        } else {
            System.out.println("Loan application denied. Requested amount exceeds eligibility.");
            return 0.0;
        }
    }

    @Override
    public double calculateLoanEligibility() {
        return getBalance() * LOAN_FACTOR;
    }
}

// Main class to demonstrate the banking system
public class BankingSystem {
    public static void main(String[] args) {
        // Polymorphism
        List<BankAccount> accounts = new ArrayList<>();

        // Creating instances of concrete classes
        SavingsAccount savings = new SavingsAccount("S-12345", "Alice", 5000.00);
        CurrentAccount current = new CurrentAccount("C-67890", "Bob", 15000.00);

        // Add accounts to the list
        accounts.add(savings);
        accounts.add(current);

        System.out.println("--- Processing Bank Accounts ---");
        // Polymorphism
        for (BankAccount account : accounts) {
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Holder Name: " + account.getHolderName());
            System.out.println("Current Balance: $" + String.format("%.2f", account.getBalance()));

            double interest = account.calculateInterest();
            System.out.println("Calculated Interest: $" + String.format("%.2f", interest));

            // Polymorphism with the Loanable interface
            if (account instanceof Loanable) {
                Loanable loanableAccount = (Loanable) account;
                System.out.println("Loan Eligibility: $" + String.format("%.2f", loanableAccount.calculateLoanEligibility()));
                loanableAccount.applyForLoan(30000);
            }
            System.out.println("---------------------------------");
        }

        System.out.println("\n--- Demonstrating Concrete Methods ---");
        // Using concrete methods
        savings.deposit(200);
        current.withdraw(1000);
    }
}
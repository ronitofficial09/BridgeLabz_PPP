import java.util.ArrayList;

class Account {
    private String accountNumber;
    private double balance;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}

class Customer {
    private String name;
    private ArrayList<Account> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void viewBalance() {
        System.out.println("Customer: " + name);
        for (Account a : accounts) {
            System.out.println(" - Account " + a.getAccountNumber() + ": $" + a.getBalance());
        }
    }
}

class Bank {
    private String name;
    private ArrayList<Customer> customers;

    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public void openAccount(Customer customer, Account account) {
        customer.addAccount(account);
        if (!customers.contains(customer)) {
            customers.add(customer);
        }
        System.out.println("Bank " + name + " opened account " + account.getAccountNumber() + " for " + customer);
    }
}

public class BankData {
    public static void main(String[] args) {
        Bank bank = new Bank("SBI");

        Customer c1 = new Customer("Alice");
        Customer c2 = new Customer("Bob");

        bank.openAccount(c1, new Account("A101", 5000));
        bank.openAccount(c1, new Account("A102", 3000));
        bank.openAccount(c2, new Account("B201", 7000));

        c1.viewBalance();
        c2.viewBalance();
    }
}

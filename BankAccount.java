public abstract class BankAccount {
    private int accountNumber;
    private String accountHolderName;
    private double balance;
    private static int accountCounter = 1000; // for generating unique account numbers

    // Constructor
    public BankAccount(String accountHolderName, double balance) {
        this.accountNumber = ++accountCounter;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    // Getters and Setters
    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount + ". New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // withdraw method (abstract)
    public abstract void withdraw(double amount);

    // abstract display method
    public abstract void displayDetails();
}

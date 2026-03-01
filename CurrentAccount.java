public class CurrentAccount extends BankAccount {
    private static final double OVERDRAFT_LIMIT = 5000.0;

    public CurrentAccount(String accountHolderName, double balance) {
        super(accountHolderName, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0) {
            double newBalance = getBalance() - amount;
            if (newBalance >= -OVERDRAFT_LIMIT) {
                setBalance(newBalance);
                System.out.println("Withdrawn: " + amount + ". New balance: " + getBalance());
            } else {
                System.out.println("Cannot withdraw. Overdraft limit of " + OVERDRAFT_LIMIT + " exceeded.");
            }
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    @Override
    public void displayDetails() {
        System.out.println("Account Type: Current");
        System.out.println("Account Number: " + getAccountNumber());
        System.out.println("Account Holder: " + getAccountHolderName());
        System.out.println("Balance: " + getBalance());
        System.out.println("Overdraft Limit: " + OVERDRAFT_LIMIT);
    }
}

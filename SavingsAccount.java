public class SavingsAccount extends BankAccount {
    private static final double MINIMUM_BALANCE = 1000.0;

    public SavingsAccount(String accountHolderName, double balance) {
        super(accountHolderName, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0) {
            double newBalance = getBalance() - amount;
            if (newBalance >= MINIMUM_BALANCE) {
                setBalance(newBalance);
                System.out.println("Withdrawn: " + amount + ". New balance: " + getBalance());
            } else {
                System.out.println("Cannot withdraw. Minimum balance of " + MINIMUM_BALANCE + " must be maintained.");
            }
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    @Override
    public void displayDetails() {
        System.out.println("Account Type: Savings");
        System.out.println("Account Number: " + getAccountNumber());
        System.out.println("Account Holder: " + getAccountHolderName());
        System.out.println("Balance: " + getBalance());
        System.out.println("Minimum Balance Required: " + MINIMUM_BALANCE);
    }
}

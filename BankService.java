import java.util.ArrayList;

public class BankService {
    private ArrayList<BankAccount> accounts = new ArrayList<>();

    public void createAccount(String name, double balance, int type) {
        // NEW: Check for negative initial balance
        if (balance < 0) {
            System.out.println("❌ Initial balance cannot be negative!");
            return;
        }
        
        BankAccount account = null;
        if (type == 1) {
            // NEW: Check minimum balance for Savings
            if (balance < 1000) {
                System.out.println("❌ Savings Account requires minimum balance of 1000!");
                return;
            }
            account = new SavingsAccount(name, balance);
        } else if (type == 2) {
            account = new CurrentAccount(name, balance);
        } else {
            System.out.println("❌ Invalid account type.");
            return;
        }
        accounts.add(account);
        System.out.println("✅ Account created successfully!");
        account.displayDetails();
    }

    public void depositMoney(int accNo, double amount) {
        // NEW: Check for negative deposit amount
        if (amount <= 0) {
            System.out.println("❌ Deposit amount must be positive!");
            return;
        }
        
        BankAccount account = findAccount(accNo);
        if (account != null) {
            account.deposit(amount);
        } else {
            System.out.println("❌ Account not found.");
        }
    }

    public void withdrawMoney(int accNo, double amount) {
        // NEW: Check for negative withdrawal amount
        if (amount <= 0) {
            System.out.println("❌ Withdrawal amount must be positive!");
            return;
        }
        
        BankAccount account = findAccount(accNo);
        if (account != null) {
            account.withdraw(amount);
        } else {
            System.out.println("❌ Account not found.");
        }
    }

    public void transferMoney(int fromAcc, int toAcc, double amount) {
        // NEW: Check for negative transfer amount
        if (amount <= 0) {
            System.out.println("❌ Transfer amount must be positive!");
            return;
        }
        
        BankAccount fromAccount = findAccount(fromAcc);
        BankAccount toAccount = findAccount(toAcc);

        if (fromAccount == null) {
            System.out.println("❌ Source account not found.");
            return;
        }
        if (toAccount == null) {
            System.out.println("❌ Destination account not found.");
            return;
        }

        double originalBalance = fromAccount.getBalance();
        fromAccount.withdraw(amount);
        
        if (fromAccount.getBalance() != originalBalance) {
            toAccount.deposit(amount);
            System.out.println("✅ Transfer of ₹" + amount + " completed successfully!");
        } else {
            System.out.println("❌ Transfer failed!");
        }
    }

    public void displayAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("📭 No accounts to display.");
            return;
        }
        System.out.println("\n📋 All Bank Accounts:");
        System.out.println("========================");
        for (BankAccount account : accounts) {
            account.displayDetails();
            System.out.println("------------------------");
        }
    }

    private BankAccount findAccount(int accNo) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accNo) {
                return account;
            }
        }
        return null;
    }
}

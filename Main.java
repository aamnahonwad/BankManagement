import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankService service = new BankService();
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("Welcome to Web Plus Bank");
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. View All Accounts");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Account Holder Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    double balance = scanner.nextDouble();
                    System.out.println("Select Account Type: 1. Savings  2. Current");
                    int type = scanner.nextInt();
                    service.createAccount(name, balance, type);
                    break;
                case 2:
                    System.out.print("Enter Account Number: ");
                    int accNoDeposit = scanner.nextInt();
                    System.out.print("Enter Amount to Deposit: ");
                    double depositAmt = scanner.nextDouble();
                    service.depositMoney(accNoDeposit, depositAmt);
                    break;
                case 3:
                    System.out.print("Enter Account Number: ");
                    int accNoWithdraw = scanner.nextInt();
                    System.out.print("Enter Amount to Withdraw: ");
                    double withdrawAmt = scanner.nextDouble();
                    service.withdrawMoney(accNoWithdraw, withdrawAmt);
                    break;
                case 4:
                    System.out.print("Enter Source Account Number: ");
                    int fromAcc = scanner.nextInt();
                    System.out.print("Enter Destination Account Number: ");
                    int toAcc = scanner.nextInt();
                    System.out.print("Enter Amount to Transfer: ");
                    double transferAmt = scanner.nextDouble();
                    service.transferMoney(fromAcc, toAcc, transferAmt);
                    break;
                case 5:
                    service.displayAllAccounts();
                    break;
                case 6:
                    System.out.println("Thank you for using Web Plus Bank!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Bank bank = new Bank();

        int choice;

        do {

            System.out.println("\n===== BANK ACCOUNT MANAGEMENT SYSTEM =====");
            System.out.println("1. Create Savings Account");
            System.out.println("2. Create Current Account");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Search Account");
            System.out.println("6. Display All Accounts");
            System.out.println("7. Delete Account");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {

                case 1:

                    scanner.nextLine();

                    System.out.print("Enter account number: ");
                    String savingsNumber = scanner.nextLine();

                    System.out.print("Enter account holder name: ");
                    String savingsName = scanner.nextLine();

                    System.out.print("Enter initial balance: ");
                    double savingsBalance = scanner.nextDouble();

                    System.out.print("Enter interest rate: ");
                    double interestRate = scanner.nextDouble();

                    SavingsAccount savingsAccount =
                            new SavingsAccount(
                                    savingsNumber,
                                    savingsName,
                                    savingsBalance,
                                    interestRate
                            );

                    bank.addAccount(savingsAccount);

                    break;

                case 2:

                    scanner.nextLine();

                    System.out.print("Enter account number: ");
                    String currentNumber = scanner.nextLine();

                    System.out.print("Enter account holder name: ");
                    String currentName = scanner.nextLine();

                    System.out.print("Enter initial balance: ");
                    double currentBalance = scanner.nextDouble();

                    System.out.print("Enter overdraft limit: ");
                    double overdraftLimit = scanner.nextDouble();

                    CurrentAccount currentAccount =
                            new CurrentAccount(
                                    currentNumber,
                                    currentName,
                                    currentBalance,
                                    overdraftLimit
                            );

                    bank.addAccount(currentAccount);

                    break;

                case 3:

                    scanner.nextLine();

                    System.out.print("Enter account number: ");
                    String depositAccountNumber = scanner.nextLine();

                    BankAccount depositAccount =
                            bank.searchAccount(depositAccountNumber);

                    if (depositAccount != null) {

                        System.out.print("Enter amount: ");
                        double amount = scanner.nextDouble();

                        depositAccount.deposit(amount);

                    } else {

                        System.out.println("Account not found.");
                    }

                    break;

                case 4:

                    scanner.nextLine();

                    System.out.print("Enter account number: ");
                    String withdrawAccountNumber = scanner.nextLine();

                    BankAccount withdrawAccount =
                            bank.searchAccount(withdrawAccountNumber);

                    if (withdrawAccount != null) {

                        System.out.print("Enter amount: ");
                        double amount = scanner.nextDouble();

                        withdrawAccount.withdraw(amount);

                    } else {

                        System.out.println("Account not found.");
                    }

                    break;

                case 5:

                    scanner.nextLine();

                    System.out.print("Enter account number: ");
                    String searchNumber = scanner.nextLine();

                    BankAccount account =
                            bank.searchAccount(searchNumber);

                    if (account != null) {

                        account.displayAccountDetails();

                    } else {

                        System.out.println("Account not found.");
                    }

                    break;

                case 6:

                    bank.displayAllAccounts();

                    break;

                case 7:

                    scanner.nextLine();

                    System.out.print("Enter account number: ");
                    String deleteNumber = scanner.nextLine();

                    bank.deleteAccount(deleteNumber);

                    break;

                case 8:

                    System.out.println("Thank you for using the system!");

                    break;

                default:

                    System.out.println("Invalid choice.");
            }

        } while (choice != 8);

        scanner.close();
    }
}
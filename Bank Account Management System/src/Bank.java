import java.util.ArrayList;

public class Bank {

    private ArrayList<BankAccount> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    // Add account
    public void addAccount(BankAccount account) {

        accounts.add(account);

        System.out.println("Account created successfully!");
    }

    // Search account
    public BankAccount searchAccount(String accountNumber) {

        for (BankAccount account : accounts) {

            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }

        return null;
    }

    // Display all accounts
    public void displayAllAccounts() {

        if (accounts.isEmpty()) {
            System.out.println("No accounts available.");
            return;
        }

        for (BankAccount account : accounts) {

            account.displayAccountDetails();
        }
    }

    // Delete account
    public void deleteAccount(String accountNumber) {

        BankAccount account = searchAccount(accountNumber);

        if (account != null) {

            accounts.remove(account);

            System.out.println("Account deleted successfully!");

        } else {

            System.out.println("Account not found.");
        }
    }
}

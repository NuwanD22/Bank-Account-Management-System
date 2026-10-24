public class CurrentAccount extends BankAccount {

    private double overdraftLimit;

    public CurrentAccount(String accountNumber,
                          String accountHolderName,
                          double balance,
                          double overdraftLimit) {

        super(accountNumber, accountHolderName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return;
        }

        if (amount <= getBalance() + overdraftLimit) {

            double newBalance = getBalance() - amount;

            // This is just for practice.
            // A real system would handle overdraft differently.
            System.out.println("Withdrawal successful!");
            System.out.println("Remaining balance: Rs. " + newBalance);

        } else {
            System.out.println("Withdrawal exceeds overdraft limit.");
        }
    }

    @Override
    public void displayAccountDetails() {

        System.out.println("----------------------------");
        System.out.println("Current Account");
        System.out.println("Account Number  : " + getAccountNumber());
        System.out.println("Account Holder  : " + getAccountHolderName());
        System.out.println("Balance         : Rs. " + getBalance());
        System.out.println("Overdraft Limit : Rs. " + overdraftLimit);
        System.out.println("----------------------------");
    }
}

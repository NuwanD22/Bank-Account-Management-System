public class SavingsAccount extends BankAccount {

    private double interestRate;

    public SavingsAccount(String accountNumber,
                          String accountHolderName,
                          double balance,
                          double interestRate) {

        super(accountNumber, accountHolderName, balance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    // Calculate interest
    public void calculateInterest() {

        double interest = getBalance() * interestRate / 100;

        System.out.println("Interest: Rs. " + interest);
    }

    // Method overriding
    @Override
    public void displayAccountDetails() {

        System.out.println("----------------------------");
        System.out.println("Savings Account");
        System.out.println("Account Number : " + getAccountNumber());
        System.out.println("Account Holder : " + getAccountHolderName());
        System.out.println("Balance        : Rs. " + getBalance());
        System.out.println("Interest Rate  : " + interestRate + "%");
        System.out.println("----------------------------");
    }
}
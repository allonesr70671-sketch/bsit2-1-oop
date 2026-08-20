package SavingsAccount.java;

public class SavingsAccount extends Account {

    public static final double MAINTAINING_BALANCE = 500.0;

    private final double interestRate;

    public SavingsAccount(String accountNumber, String ownerName,
                          double openingBalance, double interestRate, double interestRate1) {

        super(accountNumber, ownerName, openingBalance);
        this.interestRate = interestRate;
    }

    @Override
    public String getAccountType() {
        return "SAVINGS";
    }

    @Override
    public void withdraw(double amount) throws SavingsAccount.java.InsufficientFundsException {

        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero.");
        }

        if (amount > getBalance()) {
            throw new SavingsAccount.java.InsufficientFundsException("Insufficient funds.");
        }

        if (getBalance() - amount < MAINTAINING_BALANCE) {
            throw new SavingsAccount.java.InsufficientFundsException(
                    "Balance cannot go below " + MAINTAINING_BALANCE
            );
        }

            super.withdraw(amount);
    }

    private double getBalance() {
        return 0;
    }

    public double monthlyInterest() {
        return getBalance() * interestRate / 12;
    }

    public double getInterestRate() {
        return interestRate;
    }
}

package SavingsAccount.java;

public class CheckingAccount extends Account {

    private final double overdraftLimit;

    public CheckingAccount(String accountNumber, String ownerName,
                           double openingBalance, double overdraftLimit) {

        super(accountNumber, ownerName, openingBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public String getAccountType() {
        return "CHECKING";
    }

    @Override
    public void withdraw(double amount) throws SavingsAccount.java.InsufficientFundsException {

        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero.");
        }

        if (amount > getBalance() + overdraftLimit) {
            throw new SavingsAccount.java.InsufficientFundsException("Insufficient funds.");
        }

        super.withdraw(amount);
    }

    private double getBalance() {
        return 0;
    }
}
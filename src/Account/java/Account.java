package Account.java;

public class Account {
    private double balance;

    public double getBalance() {
        return balance;
    }
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0") ;
        }
        balance += amount;;
    }
}

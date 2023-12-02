import exceptions.NegativeAmountException;
import exceptions.InsufficientFundsException;

public class BankAccount {
    private int accountNumber;
    private String accountName;
    private double balance;

    public BankAccount(int accountNumber, String accountName, double balance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = balance;
    }

    public void deposit(double amount) throws NegativeAmountException {
        if (amount < 0){
            throw new NegativeAmountException("Deposit amount can't be negative.");
        }

        balance += amount;
    }

    public void withdraw(double amount) throws NegativeAmountException, InsufficientFundsException {
        if (amount < 0) {
            throw new NegativeAmountException("Withdraw amount can't be negative.");
        }

        if (balance < amount) {
            throw new InsufficientFundsException("There are insufficient funds to carry out the operation.");
        }

        balance -= amount;
    }

    public String getAccountSummary(){
        return "Account name: " + accountName + " (№ " + accountNumber + "), balance: " + balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

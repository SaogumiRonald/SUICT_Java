import java.util.ArrayList;
import java.util.List;
import exceptions.NegativeAmountException;
import exceptions.InsufficientFundsException;
import exceptions.AccountNotFoundException;

public class Bank {
    private final List<BankAccount> accountList;
    private int accountNumberCounter = 0;

    public Bank(List<BankAccount> accounts) {
        this.accountList = accounts;
    }

    public Bank() {
        this.accountList = new ArrayList<>();
    }

    public BankAccount createAccount(String accountName, double balance){
        BankAccount newAccount = new BankAccount(accountNumberCounter++, accountName, balance);
        accountList.add(newAccount);
        return newAccount;
    }

    public BankAccount findAccount(int accountNumber){
        for (BankAccount account : accountList){
            if (account.getAccountNumber() == accountNumber){
                return account;
            }
        }
        return null;
    }

    public void transferMoney(int fromAccountNumber, int toAccountNumber, double amount) throws AccountNotFoundException {
        BankAccount sender = findAccount(fromAccountNumber);
        if (sender == null) {
            throw new AccountNotFoundException("Account with number " + fromAccountNumber + " not found.");
        }

        BankAccount receiver = findAccount(toAccountNumber);
        if (receiver == null) {
            throw new AccountNotFoundException("Account with number " + toAccountNumber + " not found.");
        }

        if (amount < 0) {
            throw new NegativeAmountException("Transfer amount can't be negative.");
        }

        if (sender.getBalance() < amount) {
            throw new InsufficientFundsException("There are insufficient funds to carry out the operation.");
        }

        sender.withdraw(amount);
        receiver.deposit(amount);
    }
}

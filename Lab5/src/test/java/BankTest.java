import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import exceptions.*;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {
    Bank bank;
    BankAccount bankAccount;
    BankAccount secondBankAccount;

    @BeforeEach
    void setUp() {
        bank = new Bank();
        bankAccount = bank.createAccount("First account", 1000);
        secondBankAccount = bank.createAccount("Second account", 1000);
    }

    @Test
    void findAccountThatExisting() {
        int existingAccountNumber = bankAccount.getAccountNumber();
        BankAccount foundAccount = bank.findAccount(existingAccountNumber);

        assertNotNull(foundAccount);
    }

    @Test
    void findAccountThatNotExisting() {
        int notExistingAccountNumber = 1000;
        BankAccount foundAccount = bank.findAccount(notExistingAccountNumber);

        assertNull(foundAccount);
    }

    @Test
    void transferMoney() {
        int senderAccountNumber = bankAccount.getAccountNumber();
        int receiverAccountNumber = secondBankAccount.getAccountNumber();
        double amount = 100;

        double senderAccountBalanceBeforeTransfer = bankAccount.getBalance();
        double receiverBankAccountBalance = secondBankAccount.getBalance();
        bank.transferMoney(senderAccountNumber, receiverAccountNumber, amount);

        assertEquals(secondBankAccount.getBalance(), receiverBankAccountBalance + amount);
        assertEquals(bankAccount.getBalance(), senderAccountBalanceBeforeTransfer - amount);
    }

    @Test
    void transferMoneyWithNegativeAmount() {
        int senderAccountNumber = bankAccount.getAccountNumber();
        int receiverAccountNumber = secondBankAccount.getAccountNumber();
        double negativeAmount = -100;

        assertThrows(NegativeAmountException.class, () -> bank.transferMoney(senderAccountNumber, receiverAccountNumber, negativeAmount));
    }

    @Test
    void transferMoneyWithBiggerThanBalanceAmount() {
        int senderAccountNumber = bankAccount.getAccountNumber();
        int receiverAccountNumber = secondBankAccount.getAccountNumber();
        double biggerThanBalanceAmount = bankAccount.getBalance() + 100;

        assertThrows(InsufficientFundsException.class, () -> bank.transferMoney(senderAccountNumber, receiverAccountNumber, biggerThanBalanceAmount));
    }

    @Test
    void transferMoneyBetweenNotExistingAccount() {
        int notExistingSenderAccountNumber = -1;
        int notExistingReceiverAccountNumber = -2;
        int amount = 1;

        assertThrows(AccountNotFoundException.class, () -> bank.transferMoney(notExistingSenderAccountNumber, notExistingReceiverAccountNumber, amount));
    }
}
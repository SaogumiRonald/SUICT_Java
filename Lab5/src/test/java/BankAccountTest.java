import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import exceptions.*;

class BankAccountTest {
    BankAccount bankAccount;

    @BeforeEach
    void setUp(){
        bankAccount = new BankAccount(1, "Account", 1000);
    }

    @Test
    void depositWithPositiveAmount() {
        double depositAmount = 100;
        double balanceBeforeDeposit = bankAccount.getBalance();

        bankAccount.deposit(depositAmount);

        assertEquals(balanceBeforeDeposit + depositAmount, bankAccount.getBalance());
    }

    @Test
    void depositWithNegativeAmount() {
        double negativeDepositeAmount = -100;

        assertThrows(NegativeAmountException.class, () -> bankAccount.deposit(negativeDepositeAmount));
    }

    @Test
    void withdrawWithPositiveAmount() {
        double withdrawAmount = 100;
        double balanceBeforeWithdraw = bankAccount.getBalance();

        bankAccount.withdraw(withdrawAmount);

        assertEquals(balanceBeforeWithdraw - withdrawAmount, bankAccount.getBalance());
    }

    @Test
    void withdrawWithNegativeAmount() {
        double negativeWithdrawAmount = -100;

        assertThrows(NegativeAmountException.class, () -> bankAccount.withdraw(negativeWithdrawAmount));
    }

    @Test
    void withdrawAmountBiggerThanBalance() {
        double biggerThanBalanceAmount = 1000000;

        assertThrows(InsufficientFundsException.class, () -> bankAccount.withdraw(biggerThanBalanceAmount));
    }
}
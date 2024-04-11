import java.util.List;
import java.util.Map;

public class TransactionReportGenerator {
    public void printBalanceReport(double totalBalance) {
        System.out.println("Загальний баланс: " + totalBalance);
    }

    public void printTransactionsCountByMonth(String monthYear, int count) {
        System.out.println("Кількість транзакцій за " + monthYear + ": " + count);
    }

    public void printTopExpensesReport(List<Transaction> topExpenses) {
        System.out.println("10 найбільших витрат: ");
        for (Transaction expense : topExpenses) {
            System.out.println(expense.getDescription() + ": " + expense.getAmount());
        }
    }

    public void printTopTransactionsInPeriod(List<Transaction> topTransactions) {
        System.out.println("\n3 найбільші транзакції за 20-12-2023 - 30-12-2023: ");
        for (Transaction transaction : topTransactions) {
            System.out.println(transaction);
        }
    }

    public void printLowTransactionsInPeriod(List<Transaction> lowTransactions) {
        System.out.println("\n3 найменші транзакції за 20-12-2023 - 30-12-2023: ");
        for (Transaction transaction : lowTransactions) {
            System.out.println(transaction);
        }
    }
}

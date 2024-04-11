# Самостійна робота №2
## Функціональність програми
У цій самостійній роботі реалізовано консольну програму для читання 
CSV-файлів. Програма читає дані транзакцій з CSV файлу і надає звіти 
за різними параметрами.

## Функціональні вимоги:
1. Читання даних з CSV файлу. 
2. Розрахунок загального балансу. 
3. Підрахунок транзакцій за конкретний місяць. 
4. Визначення 10 найбільших витрат. 
5. Аналіз на що витрачено найбільше грошей. 
6. Визначення найбільших і найменших витрат за вказаний період. 
7. Виведення текстового звіту, що показує сумарні витрати по категоріях та по місяцях у вигляді символів.

## Сутності:
1. `Transaction`: Визначає транзакцію; 
2. `TransactionAnalyzer`: аналізує транзакцію; 
3. `TransactionCSVReader`: читає CSV-файл; 
4. `TransactionReportGenerator`: генерує та виводить звіти по транзакціям;

## Опис роботи
1. Створено клас `Transaction` з полями `date`, `amount`, `description`; 
2. Створено клас `TransactionAnalyzer` з полями `transactions`, `dateFormatter` та методами 
`calculateTotalBalance()`, `countTransactionByMonth()`, `findTopExpenses()`, `getTopTransactionsInPeriod()`, 
`getLowestTransactionsInPeriod()`, `generateSummaryReportByCategory()`, `generateSummaryReportByMonth()`, `printStars()`; 
3. Створено клас `TransactionCSVReader` з методом `readTransaction()`; 
4. Створено клас `TransactionReportGenerator` з методами `printBalanceReport()`, `printTransactionsCountByMonth()`, 
`printTopExpensesReport()`, `printTopTransactionsInPeriod()`, `printLowTransactionsInPeriod()`; 
5. Створено клас `TransactionAnalyzerTest` для тестування функціоналу програми. 
6. Створено клас `Program` для демонстрації роботи програми.

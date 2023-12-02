# Лабораторна робота №5
## Функціональність програми

Програма імітує спрощену банківську систему. 
Це включає створення рахунків, фінансові операції, та функції зведення рахунків.
Також програма має обробляти різні типи помилок.

## Вимоги
1. Реалізуйте клас `BankAccount` з членами класу `accountNumber`, `accountName` і `balance`. 
2. Реалізуйте методи `deposit(double amount)`, `withdraw(double amount)`, `getBalance()` та `getAccountSummary()`. 
3. Створіть спеціалізовані класи винятків:
   - `InsufficientFundsException` 
   - `NegativeAmountException` 
   - `AccountNotFoundException`
4. Реалізуйте клас `Bank`, який зберігає колекцію об'єктів `BankAccount`. 
5. У класі `Bank`, реалізуйте методи:
   - `createAccount(String accountName, double initialDeposit)`
   - `findAccount(int accountNumber)`
   - `transferMoney(int fromAccountNumber, int toAccountNumber, double amount)`
6. Обробляйте винятки відповідно в кожному методі. 
7. Створіть тестові класи, де ви моделюєте різні сценарії для тестування обробки виняткових ситуацій.

## Опис роботи
1. Створено клас `BankAccount` з полями `accountNumber`, `accountName` та `balance`.
2. Реалізовано методи для маніпуляцій з балансом `deposit()`, `withdraw()` та метод `getAccountSummary()` для виводу інформації про аккаунт.
3. Створено клас `Bank` для створення акаунтів, та проведення банківських операцій.
4. Реалізовано методи `createAccount()`, `findAccount()` та `transferMoney()`, для взаємодії з банківськими аккаунтами.
5. Створено помилки що показують, що операція не пройшла успішно:
   - `NegativeAmountException` — операція не підтримує від'ємні значення.
   - `InsufficientFundsException` — на балансі недостатньо коштів для проведення операції.
   - `AccountNotFoundException` — акаунт з вказаним номером не існує.

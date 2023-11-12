# Лабораторна робота №2
## Завдання:

### Система повинна мати можливість:
1. Додавати предмети (книги, DVD) до бібліотеки;
2. Видаляти предмети з бібліотеки;
3. Реєструвати читача;
4. Видавати предмет читачеві;
5. Повертати предмет у бібліотеку;
6. Показувати список доступних предметів;
7. Показувати список взятих предметів та їхніх читачів.

### Покрити тестами функціональність програми.

## Опис класів та інтерфейсів:
1. `Item` (Abstract Class)
   * Attributes:
     - `title`: String;
     - `uniqueID`: String (unique for each item);
     - `isBorrowed`: boolean (default false);
     
   * Methods:
     - Constructors, getters, setters;
     - abstract void `borrowItem()`: Makes the item as borrowed;
     - abstract void `returnItem()`: Marks the item as not borrowed; 

2. `Book` (implements Item)
   * Attributes:
     - `author`: String;
   * Methods:
     - `borrowItem()`: Implements the abstract method from Item;
     - `returnItem()`: Implements the abstract method from Item;
            
3. `DVD` (implements Item)
   * Attributes:
     - `duration`: int (minutes);
   * Methods:
     - `borrowItem()`: Implements the abstract method from Item;
     - `returnItem()`: Implements the abstract method from Item;

4. `Patron`
   * Attributes:
     - `name`: String;
     - `ID`: String (unique for each patron);
     - `borrowedItems`: List<Item>;
   * Methods:
     - `Constructors`, `getters`, `setters`;
     - `borrow(Item)`: Adds an item to the patron's borrowed list;
     - `return(Item)`: Removes an item from the patron's borrowed list;

5. `IManageable` (Interface)
   * Methods:
     - `add(Item)`: Adds an item;
     - `remove(Item)`: Removes an item;
     - `listAvailable()`: Lists all available items;
     - `listBorrowed()`: Lists all borrowed items;

6. `Library` (implements IManageable)
   * Attributes:
     - `items`: List<Item> (to store all items);
     - `patrons`: List<Patron> (to store all registered patrons);
   * Methods:
     - `registerPatron(Patron)`: Registers a new patron;
     - `lendItem(Patron, Item)`: Lends an item to a patron;
     - `returnItem(Patron, Item)`: Returns a borrowed item;

### Функціональність програми:
- Додавання предмета (книги, DVD) до бібліотеки;
- Видалення предмету з бібліотеки;
- Реєстрування читача;
- Видавання предмета читачеві;
- Повернення предмета у бібліотеку;
- Показування списку доступних предметів;
- Показування списку взятих предметів та їх читачів.

### Функціональність програми покрита unit-тестами.

## План розробки програми:
1. Створення абстрактного класу `Item` для роботи з об'єктами;
2. Створення класів конкретних предметів: `Book`, `DVD`;
3. Створення класу бібліотеки `Library`, що керує об'єктами класу Item;
4. Створення класу клієнта бібліотеки `Patron`;
5. Додавання функціоналу керування користувачами до бібліотеки:
   * Додавання поля patrons та методу registerPatron до Library
6. Додавання функціоналу запозичення речі:
   * Додавання поля `isBorrowed` та методів `borrow()`, `return()` до `Item`;
   * Додавання методів `lendItem()` `returnItem()` до `Library`;
   * Додавання поля `borrowedItems()`, `borrowItem()`, `returnItem()` до `Patron`;
7. Створення Unit-тестів:
   * Тестування функціональності керування предметами в бібліотеці;
   * Тестування функціональності керування користувачами бібліотеки;
   * Тестування функціональності запозичення предметів.

## Висновок:
У ході виконання лабораторної роботи я покращив навички розробки ПО за допомогою мови програмування Java, та покращив навички тестування ПО використовуючи JUnit5.








    
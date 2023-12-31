# Лабораторна робота №6
## Функціональність програми
У цій лабораторній роботі студентам необхідно створити програму на Java, 
яка використовує багатовимірні масиви, маніпуляції з масивами та складні алгоритми для вирішення реальної проблеми,
сприяючи глибшому розумінню масивів в Java.

## Вимоги
Уявіть, що вам потрібно створити Java-додаток для кінотеатру. У кінотеатрі п'ять залі, 
кожен з яких має розміщення місць у 10 рядів та 20 місць. Місця представлені 3D масивом, 
де перший вимір представляє зал, другий - ряд, а третій - місце.

1. Ініціалізація Масиву: Створіть 3D масив для представлення кінотеатру. Ініціалізуйте масив нулями, що вказує на те, що всі місця вільні.
2. Бронювання Місць: Напишіть метод bookSeats(int hallNumber, int row, int[] seats), який приймає номер залу, номер ряду, номери місць для бронювання. Метод повинен позначити заброньовані місця, змінивши відповідні нулі на одиниці. Якщо місця заброньовані, система повинна сповістити про це користувача.
3. Скасування Бронювання: Напишіть метод cancelBooking(int hallNumber, int row, int[] seats), який скасовує бронювання, змінюючи відповідні одиниці назад на нулі.
4. Перевірка Наявності: Напишіть метод checkAvailability(int screen, int numSeats), який перевіряє, чи доступна задана кількість послідовних місць в будь-якому ряду зазначеного залу.
5. Друк Схеми Розміщення Місць: Напишіть метод printSeatingArrangement(int hallNumber), який друкує схему розміщення місць для даного залу, вказуючи заброньовані та доступні місця.
6. Реалізуйте метод findBestAvailable(int hallNumber, int numSeats), який знаходить та повертає найкращі доступні послідовні місця для даної кількості місць в зазначеному залі.
7. Реалізуйте метод autoBook(int hallNumber, int numSeats), який автоматично бронює найкращі доступні послідовні місця, знайдені методом findBestAvailable.

## Опис роботи
1. Створюємо клас Cinema для маніпуляції над місцями в кінотеатрі з допомогою методів `bookSeats()`, `cancelBooking()`, та `checkAvailability()`.
2. Реалізовуємо метод `printSeatingArrangement()` для виводу схеми кінотеатру;
3. Створюємо метод `findBestAvailable` який визначає оптимальне розміщення для заданої кількості місць в залі методом `autoBook`.
4. Покриваємо програмний модуль unit-тестами.

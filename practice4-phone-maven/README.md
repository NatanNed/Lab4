# Практична робота №4

## Тема

Класи, масиви, ArrayList + GitHub + Maven.

## Варіант 3

Клас `Phone` + `ArrayList` з 5 об'єктів.

## Опис програми

Програма створює список телефонів за допомогою `ArrayList<Phone>`.
Три об'єкти створюються одразу в коді, ще два телефони вводяться користувачем з клавіатури.

Клас `Phone` містить:

- конструктор з параметрами;
- гетери та сетери для всіх полів;
- метод `toString()`;
- метод `equals()`;
- метод `hashCode()`.

## Поля класу Phone

- `brand` — бренд телефону;
- `model` — модель телефону;
- `memoryGb` — обсяг пам'яті;
- `price` — ціна;
- `has5G` — підтримка 5G.

## Структура Maven-проєкту

```text
src/main/java/org/example/practice4
    Main.java
    Phone.java
pom.xml
.gitignore
README.md
```

## Компіляція проєкту

```bash
mvn clean compile
```

## Приклади комітів

```bash
git add .
git commit -m "Initial Maven project structure"

git add .
git commit -m "Add Phone class"

git add .
git commit -m "Implement toString and equals"

git add .
git commit -m "Add ArrayList driver logic"

git add .
git commit -m "Fix input validation"
```

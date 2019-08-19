## Первый этап
Необходимо создать свою реализацию ArrayList.
В директории collections имеется интерфейс List. Для выполнения задания необходимо
создать класс который имплементирует интерфейс List и следующие методы:

- `void add(long data)`
- `boolean remove(long id)`
- `long find(long value)`
- `long get(long index)`
- `void update(long index, long data)`
- `void long size()`
- `boolean removeAll()`
- `long getMin()`
- `long getMax()`
 
 Не указанные здесь методы можно инициализировать с Exception:
 
 ```java
public void bubbleSort() throws Exception {
        throw new Exception("No realization for this method!");
    }

    public void quickSort() throws Exception {
        throw new Exception("No realization for this method!");
    }
```

``!!ВАЖНО!!`` Такой подход может использоваться только в учебных целях. Категорически
запрещено это делать за пределами данного приложения, это прямое нарушения
принципа подстановки Барбары Лесков. 

## Пятый этап
Для ArrayList необходимо реализовать алгоритм сортировки пузырьком и 
быстрой сортировки.

- `void bubbleSort()`
- `void quickSort()`

[Назад](../readme.md)
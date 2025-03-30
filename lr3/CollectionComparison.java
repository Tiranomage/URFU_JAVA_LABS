package lr3;

import java.util.*;

public class CollectionComparison {
    private static final int VARIANT_NUMBER = 3; // НОМЕР ВАРИАНТА
    private static final int SIZE = VARIANT_NUMBER * 1_000_000; // 3_000_000 элементов
    private static final long INDEX = (long) VARIANT_NUMBER * 1_000_000_000L; // 3_000_000_000 (long)

    public static void main(String[] args) {
        System.out.println("Время выполнения операций (нс):");

        // 1. Добавление в начало
        System.out.println("\n1. Добавление в начало");
        printTime("ArrayList", measureAddFirst(ArrayList::new));
        printTime("ArrayDeque", measureAddFirst(ArrayDeque::new));
        printTime("LinkedHashSet", "N/A");

        // 2. Добавление в конец
        System.out.println("\n2. Добавление в конец");
        printTime("ArrayList", measureAddLast(ArrayList::new));
        printTime("ArrayDeque", measureAddLast(ArrayDeque::new));
        printTime("LinkedHashSet", measureAddLast(LinkedHashSet::new));

        // 3. Добавление в середину
        System.out.println("\n3. Добавление в середину");
        printTime("ArrayList", measureAddMiddle(ArrayList::new));
        printTime("ArrayDeque", "N/A");
        printTime("LinkedHashSet", "N/A");

        // 4. Удаление из начала
        System.out.println("\n4. Удаление из начала");
        printTime("ArrayList", measureRemoveFirst(ArrayList::new));
        printTime("ArrayDeque", measureRemoveFirst(ArrayDeque::new));
        printTime("LinkedHashSet", measureRemoveFirst(LinkedHashSet::new));

        // 5. Удаление из конца
        System.out.println("\n5. Удаление из конца");
        printTime("ArrayList", measureRemoveLast(ArrayList::new));
        printTime("ArrayDeque", measureRemoveLast(ArrayDeque::new));
        printTime("LinkedHashSet", measureRemoveLast(LinkedHashSet::new));

        // 6. Удаление из середины
        System.out.println("\n6. Удаление из середины");
        printTime("ArrayList", measureRemoveMiddle(ArrayList::new));
        printTime("ArrayDeque", "N/A");
        printTime("LinkedHashSet", "N/A");

        // 7. Получение по индексу
        System.out.println("\n7. Получение по индексу");
        printTime("ArrayList", measureGet(ArrayList::new));
        printTime("ArrayDeque", "N/A");
        printTime("LinkedHashSet", "N/A");
    }

    private static void printTime(String name, Object time) {
        System.out.printf("%-12s: %-15s%n", name, time);
    }

    // Методы измерения операций

    // 1. Добавление в начало
    private static long measureAddFirst(CollectionFactory factory) {
        Collection<Integer> collection = factory.create();
        long start = System.nanoTime();
        for (int i = 0; i < SIZE; i++) {
            if (collection instanceof List) {
                ((List<Integer>) collection).add(0, i);
            } else if (collection instanceof Deque) {
                ((Deque<Integer>) collection).addFirst(i);
            }
        }
        return System.nanoTime() - start;
    }

    // 2. Добавление в конец
    private static long measureAddLast(CollectionFactory factory) {
        Collection<Integer> collection = factory.create();
        long start = System.nanoTime();
        for (int i = 0; i < SIZE; i++) {
            collection.add(i);
        }
        return System.nanoTime() - start;
    }

    // 3. Добавление в середину (только для ArrayList)
    private static long measureAddMiddle(CollectionFactory factory) {
        List<Integer> list = (List<Integer>) factory.create();
        for (int i = 0; i < SIZE; i++) {
            list.add(i);
        }
        int midIndex = list.size() / 2; // Середина списка (3_000_000/2 = 1_500_000)
        long start = System.nanoTime();
        list.add(midIndex, 0); 
        return System.nanoTime() - start;
    }

    // 4. Удаление из начала
    private static long measureRemoveFirst(CollectionFactory factory) {
        Collection<Integer> collection = factory.create();
        fillCollection(collection);
        long start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            if (collection instanceof List) {
                ((List<Integer>) collection).remove(0);
            } else if (collection instanceof Deque) {
                ((Deque<Integer>) collection).removeFirst();
            } else if (collection instanceof Set) {
                Iterator<Integer> it = collection.iterator();
                if (it.hasNext()) {
                    it.next();
                    it.remove();
                }
            }
        }
        return System.nanoTime() - start;
    }

    // 5. Удаление из конца
    private static long measureRemoveLast(CollectionFactory factory) {
        Collection<Integer> collection = factory.create();
        fillCollection(collection);
        long start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            if (collection instanceof List) {
                ((List<Integer>) collection).remove(collection.size() - 1);
            } else if (collection instanceof Deque) {
                ((Deque<Integer>) collection).removeLast();
            } else if (collection instanceof Set) {
                Iterator<Integer> it = collection.iterator();
                if (it.hasNext()) {
                    while (it.hasNext()) it.next();
                    it.remove();
                }
            }
        }
        return System.nanoTime() - start;
    }

    // 6. Удаление из середины (только для ArrayList)
    private static long measureRemoveMiddle(CollectionFactory factory) {
        List<Integer> list = (List<Integer>) factory.create();
        fillList(list);
        int midIndex = list.size() / 2; // Середина списка (3_000_000/2 = 1_500_000)
        long start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            list.remove(midIndex);
        }
        return System.nanoTime() - start;
    }

    // 7. Получение по индексу
    private static long measureGet(CollectionFactory factory) {
        List<Integer> list = (List<Integer>) factory.create();
        fillList(list);
        int index = (int) (INDEX % list.size()); // 3_000_000_000 % 3_000_000 = 0
        long start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            list.get(index);
        }
        return System.nanoTime() - start;
    }

    // Вспомогательные методы
    private static void fillCollection(Collection<Integer> collection) {
        for (int i = 0; i < SIZE; i++) {
            collection.add(i);
        }
    }

    private static void fillList(List<Integer> list) {
        for (int i = 0; i < SIZE; i++) {
            list.add(i);
        }
    }

    // Интерфейс для создания коллекций
    @FunctionalInterface
    interface CollectionFactory {
        Collection<Integer> create();
    }
}
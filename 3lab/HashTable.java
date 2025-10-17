import java.util.LinkedList;

public class HashTable<K, V> {
    // Вложенный класс для хранения пар ключ-значение
    private static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() { return key; }
        public V getValue() { return value; }
        public void setValue(V value) { this.value = value; }
    }

    private LinkedList<Entry<K, V>>[] table; // массив цепочек
    private int capacity; // ёмкость таблицы
    private int size; // количество элементов

    // Конструктор
    public HashTable(int capacity) {
        this.capacity = capacity;
        this.table = new LinkedList[capacity];
        this.size = 0;
    }

    // Хэш-функция
    private int hash(K key) {
        return Math.abs(key.hashCode() % capacity);
    }

    // Добавление пары (ключ, значение)
    public void put(K key, V value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }

        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value); // обновление значения
                return;
            }
        }

        table[index].add(new Entry<>(key, value));
        size++;
    }

    // Получение значения по ключу
    public V get(K key) {
        int index = hash(key);
        if (table[index] == null) return null;

        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }

    // Удаление по ключу
    public void remove(K key) {
        int index = hash(key);
        if (table[index] == null) return;

        Entry<K, V> toRemove = null;
        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                toRemove = entry;
                break;
            }
        }

        if (toRemove != null) {
            table[index].remove(toRemove);
            size--;
        }
    }

    // Количество элементов
    public int size() {
        return size;
    }

    // Проверка на пустоту
    public boolean isEmpty() {
        return size == 0;
    }

    // Для удобного вывода таблицы
    public void printTable() {
        for (int i = 0; i < capacity; i++) {
            System.out.print(i + ": ");
            if (table[i] != null) {
                for (Entry<K, V> entry : table[i]) {
                    System.out.print("(" + entry.getKey() + ", " + entry.getValue() + ") ");
                }
            }
            System.out.println();
        }
    }
}

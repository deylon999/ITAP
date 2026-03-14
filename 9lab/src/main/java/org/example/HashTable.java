package org.example;

import java.util.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HashTable<K, V> {
    private static final Logger logger = LoggerFactory.getLogger(HashTable.class);

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

    private LinkedList<Entry<K, V>>[] table;
    private int capacity;
    private int size;

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.table = new LinkedList[capacity];
        this.size = 0;
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % capacity;
    }

    public void put(K key, V value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }

        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }

        table[index].add(new Entry<>(key, value));
        size++;
    }

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

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printTable() {
        StringBuilder sb = new StringBuilder("\n");
        for (int i = 0; i < capacity; i++) {
            sb.append(i).append(": ");
            if (table[i] != null) {
                for (Entry<K, V> entry : table[i]) {
                    sb.append("(").append(entry.getKey()).append(", ")
                      .append(entry.getValue()).append(") ");
                }
            }
            sb.append("\n");
        }
        logger.info(sb.toString());
    }
}
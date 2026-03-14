package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        HashTable<String, Student> students = new HashTable<>(10);
        students.put("BVT24", new Student("Иван", "Иванов", 20, 4.5));
        students.put("BVT23", new Student("Петр", "Петров", 21, 3.9));
        students.put("BVT20", new Student("Анна", "Сидорова", 19, 4.8));

        logger.info("Размер таблицы: {}", students.size());
        students.printTable();

        logger.info("Студент BVT24: {}", students.get("BVT24"));

        students.remove("BVT20");
        logger.info("После удаления. Размер: {}", students.size());
        logger.info("Пуста ли таблица? {}", students.isEmpty());
        students.printTable();

        StudentSerializer serializer = new StudentSerializer();
        Student s = new Student("Иван", "Иванов", 20, 4.5);
        String json = serializer.toJson(s);
        logger.info("JSON: {}", json);
        Student restored = serializer.fromJson(json);
        logger.info("Восстановлен: {}", restored);
    }
}
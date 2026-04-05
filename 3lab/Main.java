public class Main {
    public static void main(String[] args) {
        HashTable<String, Student> students = new HashTable<>(10);

        students.put("BVT24", new Student("Иван", "Иванов", 20, 4.5));
        students.put("BVT23", new Student("Петр", "Петров", 21, 3.9));
        students.put("BVT20", new Student("Анна", "Сидорова", 19, 4.8));

        System.out.println("Размер таблицы: " + students.size());
        students.printTable();

        System.out.println("\n" + students.get("BVT24"));

        students.remove("BVT20");

        System.out.println("\nРазмер таблицы: " + students.size());
        System.out.println("Пуста ли таблица? " + students.isEmpty());

        System.out.println("\n-----------------");
        students.printTable();
    }
}

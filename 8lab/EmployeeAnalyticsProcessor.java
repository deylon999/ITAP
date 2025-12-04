import java.util.List;

public class EmployeeAnalyticsProcessor {
    
    @DataProcessor(description = "Анализ данных о сотрудниках", priority = 7)
    public List<Employee> analyzeEmployees(List<Employee> employees) {
        if (employees.isEmpty()) {
            System.out.println("Нет данных для анализа");
            return employees;
        }

        double avgSalary = employees.parallelStream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);
        
        double totalSalary = employees.parallelStream()
                .mapToDouble(Employee::getSalary)
                .sum();
        
        long developerCount = employees.parallelStream()
                .filter(e -> e.getPosition().toLowerCase().contains("developer"))
                .count();
        
        System.out.println("=== Аналитический отчет ===");
        System.out.println("Средняя зарплата: " + String.format("%.2f", avgSalary));
        System.out.println("Общий фонд зарплат: " + String.format("%.2f", totalSalary));
        System.out.println("Количество разработчиков: " + developerCount);
        System.out.println("Общее количество сотрудников: " + employees.size());
        
        return employees;
    }
}
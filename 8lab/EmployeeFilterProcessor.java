import java.util.List;
import java.util.stream.Collectors;

public class EmployeeFilterProcessor {
    @DataProcessor(description = "Фильтрация по зарплате > 50000", priority = 1)
    public List<Employee> filterBySalary(List<Employee> employees) {
        return employees.parallelStream()
                .filter(e -> e.getSalary() > 50000)
                .collect(Collectors.toList());
    }

    @DataProcessor(description = "Фильтрация по опыту >= 3 года", priority = 2)
    public List<Employee> filterByExperience(List<Employee> employees) {
        return employees.parallelStream()
                .filter(e -> e.getExperience() >= 3)
                .collect(Collectors.toList());
    }

    @DataProcessor(description = "Только разработчики", priority = 3)
    public List<Employee> filterDevelopers(List<Employee> employees) {
        return employees.parallelStream()
                .filter(e -> e.getPosition().toLowerCase().contains("developer"))
                .collect(Collectors.toList());
    }
}
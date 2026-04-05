import java.util.List;
import java.util.stream.Collectors;

public class EmployeeTransformProcessor {
    
    @DataProcessor(description = "Повышение зарплаты на 10%", priority = 4)
    public List<Employee> increaseSalary(List<Employee> employees) {
        return employees.parallelStream()
            .map(e -> new Employee(
                e.getEmployeeId(),
                e.getPosition(),
                e.getSalary() * 1.10,
                e.getExperience()
            ))
            .collect(Collectors.toList());
    }

    @DataProcessor(description = "Смена регистра должностей", priority = 5)
    public List<Employee> transformPositions(List<Employee> employees) {
        return employees.parallelStream()
            .map(e -> new Employee(
                e.getEmployeeId(),
                e.getPosition().toUpperCase(),
                e.getSalary(),
                e.getExperience()
            ))
            .collect(Collectors.toList());
    }

    @DataProcessor(description = "Добавление премии за стаж", priority = 6)
    public List<Employee> addExperienceBonus(List<Employee> employees) {
        return employees.parallelStream()
            .map(e -> new Employee(
                e.getEmployeeId(),
                e.getPosition(),
                e.getSalary() + (e.getExperience() * 5000),
                e.getExperience()
            ))
            .collect(Collectors.toList());
    }
}
import java.io.*;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class DataManager {
    private List<Employee> data = new ArrayList<>();
    private List<Object> processors = new ArrayList<>();

    public void registerDataProcessor(Object processor) {
        processors.add(processor);
    }

    public void loadData(String source) {
        try {
            data = Files.lines(Paths.get(source))
                    .map((line) -> {
                        String[] parts = line.split(",");
                        return new Employee(
                            parts[0].trim(),
                            parts[1].trim(),
                            Double.parseDouble(parts[2].trim()), 
                            Integer.parseInt(parts[3].trim()) 
                        );
                    })
                    .collect(Collectors.toList());
            System.out.println("Загружено сотрудников: " + data.size());
        } catch (IOException e) {
            System.err.println("Ошибка загрузки: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void processData() {
        List<Method> methods = new ArrayList<>();
        for (Object processor : processors) {
            for (Method method : processor.getClass().getDeclaredMethods()) {
                if (method.isAnnotationPresent(DataProcessor.class)) {
                    methods.add(method);
                }
            }
        }

        methods.sort((m1, m2) -> {
            int p1 = m1.getAnnotation(DataProcessor.class).priority();
            int p2 = m2.getAnnotation(DataProcessor.class).priority();
            return Integer.compare(p1, p2);
        });

        for (Method method : methods) {
            try {
                DataProcessor annotation = method.getAnnotation(DataProcessor.class);
                System.out.println("Выполняется: " + annotation.description());

                Object processor = processors.stream()
                    .filter(p -> p.getClass().equals(method.getDeclaringClass()))
                    .findFirst()
                    .orElse(null);
                
                data = (List<Employee>) method.invoke(processor, data);
                System.out.println("Осталось записей: " + data.size());
            } catch (Exception e) {
                System.err.println("Ошибка обработки: " + e.getMessage());
            }
        }
    }

    public void saveData(String destination) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(destination))) {
            data.forEach(e -> writer.println(e.toString()));
            System.out.println("Сохранено записей: " + data.size());
        } catch (IOException e) {
            System.err.println("Ошибка сохранения: " + e.getMessage());
        }
    }
}
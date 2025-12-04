public class Main {
    public static void main(String[] args) {
        DataManager manager = new DataManager();
        
        manager.registerDataProcessor(new EmployeeFilterProcessor());
        manager.registerDataProcessor(new EmployeeTransformProcessor());
        manager.registerDataProcessor(new EmployeeAnalyticsProcessor());
        
        manager.loadData("employees.txt");
        manager.processData();
        manager.saveData("employees_processed.txt");
    }
}
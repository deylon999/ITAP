import java.util.*;

public class SalesTracker {
    public static void main(String[] args) {
        SalesTracker tracker = new SalesTracker();
        tracker.addSale("Молоко", 5);
        tracker.addSale("Хлеб", 3);
        tracker.addSale("Молоко", 2);
        tracker.addSale("Сыр", 4);
        tracker.printSales();
        tracker.printTotal();
        tracker.printMostPopular();
    }

    private Map<String, Integer> sales = new HashMap<>();

    public void addSale(String product, int quantity) {
        sales.put(product, sales.getOrDefault(product, 0) + quantity);
    }

    public void printSales() {
        System.out.println("Список продаж:");
        for (Map.Entry<String, Integer> entry : sales.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public void printTotal() {
        int total = 0;
        for (int quantity : sales.values()) {
            total += quantity;
        }
        System.out.println("Общая сумма продаж: " + total);
    }

    public void printMostPopular() {
        if (sales.isEmpty()) {
            System.out.println("Нет продаж");
            return;
        }
        
        String mostPopular = null;
        int maxQuantity = 0;
        
        for (Map.Entry<String, Integer> entry : sales.entrySet()) {
            if (entry.getValue() > maxQuantity) {
                maxQuantity = entry.getValue();
                mostPopular = entry.getKey();
            }
        }
        
        System.out.println("Самый популярный товар: " + mostPopular);
    }
}

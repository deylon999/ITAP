package third;

import java.util.*;

class Product {
    private final int weight;

    public Product(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
}

class Warehouse {
    private final Queue<Product> products;

    public Warehouse(List<Product> productsList) {
        this.products = new LinkedList<>(productsList);
    }

    public synchronized Product takeProduct() {
        return products.poll();
    }
}

class Loader extends Thread {
    private final Warehouse warehouse;
    private final int maxLoad = 150;
    private int currentLoad = 0;

    public Loader(Warehouse warehouse, String name) {
        super(name);
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        List<Product> carried = new ArrayList<>();
        while (true) {
            Product p = warehouse.takeProduct();
            if (p == null) break;
            if (currentLoad + p.getWeight() > maxLoad) {
                deliverGoods(carried);
                carried.clear();
                currentLoad = 0;
            }
            carried.add(p);
            currentLoad += p.getWeight();
        }
        if (!carried.isEmpty()) {
            deliverGoods(carried);
        }
        System.out.println(getName() + " закончил работу.");
    }

    private void deliverGoods(List<Product> products) {
        System.out.println(getName() + " отправляется с грузом весом " +
                products.stream().mapToInt(Product::getWeight).sum() + " кг.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getName() + " разгрузился.");
    }
}

public class WarehouseTransport {
    public static void main(String[] args) throws InterruptedException {
        List<Product> products = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            products.add(new Product((int)(Math.random()*50)+1));
        }

        Warehouse warehouse = new Warehouse(products);
        Loader loader1 = new Loader(warehouse, "Грузчик-1");
        Loader loader2 = new Loader(warehouse, "Грузчик-2");
        Loader loader3 = new Loader(warehouse, "Грузчик-3");

        loader1.start();
        loader2.start();
        loader3.start();

        loader1.join();
        loader2.join();
        loader3.join();

        System.out.println("Все грузчики закончили работу.");
    }
}

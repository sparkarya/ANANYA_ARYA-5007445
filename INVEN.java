import java.util.ArrayList;
import java.util.List;

class Product {
    int id;
    String name;
    int count;
    double price;

    Product(int id, String name, int count, double price) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.price = price;
    }
}

class Inventory {
    List<Product> items = new ArrayList<>();

    void addItem(Product item) {
        items.add(item);
    }

    void changeItem(int id, Product newItem) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).id == id) {
                items.set(i, newItem);
                break;
            }
        }
    }

    void removeItem(int id) {
        items.removeIf(item -> item.id == id);
    }

    void showAllItems() {
        for (Product item : items) {
            System.out.println("ID: " + item.id + ", Name: " + item.name + ", Count: " + item.count + ", Price: " + item.price+"Rs.");
        }
    }
}

public class INVEN {
    public static void main(String[] args) {
        Inventory store = new Inventory();

        store.addItem(new Product(1, "Product A", 10, 1900.99));
        store.addItem(new Product(2, "Product B", 5, 2009.99));

        store.showAllItems();

        Product updatedItem = new Product(1, "Product A (Updated)", 15, 2082.99);
        store.changeItem(1, updatedItem);

        store.removeItem(2);

        store.showAllItems();
    }
}

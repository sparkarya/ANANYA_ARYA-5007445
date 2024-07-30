import java.util.Arrays;

class ProductItem {
    int productId;
    String productName;
    String category;

    ProductItem(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
}

class Search {
    // Linear search method
    static ProductItem linearSearch(ProductItem[] products, int productId) {
        for (ProductItem product : products) {
            if (product.productId == productId) {
                return product;
            }
        }
        return null;
    }

    static ProductItem binarySearch(ProductItem[] products, int productId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (products[mid].productId == productId) {
                return products[mid];
            }

            if (products[mid].productId < productId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }
}

public class q2 {
    public static void main(String[] args) {

        ProductItem[] products = {
                new ProductItem(3, "Computer", "Electronics"),
                new ProductItem(1, "Shampoo", "Personal Care"),
                new ProductItem(2, "Notebook", "Education")
        };

        ProductItem result1 = Search.linearSearch(products, 2);
        if (result1 != null) {
            System.out.println("Linear Search found: " + result1.productName);
        } else {
            System.out.println("Linear Search did not find the product.");
        }

        Arrays.sort(products, (a, b) -> Integer.compare(a.productId, b.productId));

        ProductItem result2 = Search.binarySearch(products, 2);
        if (result2 != null) {
            System.out.println("Binary Search found: " + result2.productName);
        } else {
            System.out.println("Binary Search did not find the product.");
        }
    }
}

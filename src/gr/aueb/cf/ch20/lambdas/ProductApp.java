package gr.aueb.cf.ch20.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Demo of product filtering with some criteria.
 *
 * @author Thodoris
 */
public class ProductApp {

    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product(1, "Apples", 3.5, 10),
                new Product(2, "Eggs", 2.2, 12),
                new Product(3, "Honey", 10, 2),
                new Product(4, "Milk", 10, 8)
        );

        List<Product> filteredProdsById = getFilteredProducts(products, p -> p.getId() == 1);
        System.out.println(filteredProdsById);

        List<Product> filteredProdsByTitle = getFilteredProducts(products, p -> p.getTitle().matches("[AH].*"));
        System.out.println(filteredProdsByTitle);

        List<Product> filteredProdsByQuantity = getFilteredProducts(products, p -> p.getQuantity() < 10);
        System.out.println(filteredProdsByQuantity);

        List<Product> filteredProdsByPrice = getFilteredProducts(products, p -> p.getPrice() > 3);
        System.out.println(filteredProdsByPrice);
    }

    /**
     * Filters a list of products according to the criteria given.
     *
     * @param products      the list of products to be filtered.
     * @param filter        the predicate (filter) to be applied.
     * @return              a new list of filtered products.
     */
    public static List<Product> getFilteredProducts(List<Product> products, Predicate<Product> filter) {
        List<Product> filteredProducts = new ArrayList<>();
        for (Product product : products) {
            if (filter.test(product)) filteredProducts.add(product);
        }
        return filteredProducts;
    }
}

package online.store.model.wrappers;

import online.store.model.Product;

import java.util.List;

public class Deals {
    private final List<Product> products;

    public Deals(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }
}

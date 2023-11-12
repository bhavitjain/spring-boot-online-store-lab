package online.store.services;

import online.store.model.Product;
import online.store.model.ProductCategory;
import online.store.repositories.ProductCategoryRepository;
import online.store.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Integrates with the database API and handles products and categories business logic
 */
@Service
public class ProductsService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    public List<String> getAllSupportedCategories(){
         List<ProductCategory> categoryList = productCategoryRepository.findAll();
         return categoryList.stream().map(ProductCategory::getCategory).collect(Collectors.toList());
    }

    public List<Product> getAtMostNumberOfProducts(int n){
        Page<Product> products = productRepository.findAll(PageRequest.of(0, n));
        return products.toList();
    }

    public List<Product> getByCategory(String category){
        return productRepository.findByCategory(category);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(long id) {
        return productRepository.findById(id).orElseThrow(
                () -> new IllegalStateException(String.format("Product with id %s doesn't exist", id)));
    }
}

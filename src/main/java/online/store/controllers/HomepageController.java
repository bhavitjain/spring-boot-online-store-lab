package online.store.controllers;

import online.store.model.wrappers.ProductsWrapper;
import online.store.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomepageController {

    @Autowired
    private ProductsService productsService;

    @GetMapping("/categories")
    public String getAllCategories(){
        List<String> categoriesList = productsService.getAllSupportedCategories();
        return String.join(",", categoriesList);
    }

    @GetMapping("/deals_of_the_day/{number_of_products}")
    public ProductsWrapper getDealsOfTheDay(@PathVariable int number_of_products){
        return new ProductsWrapper(productsService.getAtMostNumberOfProducts(number_of_products));
    }

    @GetMapping("/products")
    public ProductsWrapper getProductsByCategory(@RequestParam(name = "category", required = false) String
                                                             category){
        if (category != null && !category.isEmpty()) {

            return new ProductsWrapper(productsService.getByCategory(category));
        }
        return new ProductsWrapper(productsService.getAllProducts());
    }
}

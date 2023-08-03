package online.store.controllers;

import online.store.model.wrappers.Deals;
import online.store.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

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
    public Deals getDealsOfTheDay(@PathVariable int number_of_products){
        return new Deals(productsService.getAtMostNumberOfProducts(number_of_products));
    }
}

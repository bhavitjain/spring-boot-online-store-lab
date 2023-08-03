package online.store.controllers;

import online.store.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
        return categoriesList.stream().collect(Collectors.joining(","));
    }
}

package online.store.model.wrappers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import online.store.model.Product;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductsWrapper {
    private List<Product> products;
}

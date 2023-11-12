package online.store.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents a product stored in a database in the Products table.
 * You do not need to modify this file
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private String imageFileName;
    private float priceUSD;
    private String category;

    public Product(String name, String description, String imageFileName, float priceUSD, String category) {
        this.name = name;
        this.description = description;
        this.imageFileName = imageFileName;
        this.priceUSD = priceUSD;
        this.category = category;
    }

}

package online.store.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Represents an order of a product from our online store, stored in the Orders table.
 * Each order can contain multiple items of the same product
 * You do not need to modify this file
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String shippingAddress;
    private long quantity;
    private String creditCard;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    public Order(String firstName, String lastName, String email, String shippingAddress, long quantity, Product product, String creditCard) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.shippingAddress = shippingAddress;
        this.quantity = quantity;
        this.product = product;
        this.creditCard = creditCard;
    }
}

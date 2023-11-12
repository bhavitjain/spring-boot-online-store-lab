package online.store.repositories;

import online.store.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * This represents an API through which we can perform CRUD operations against the
 * Products table in the database
 * You do not need to modify this file
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    /**
     * Returns all products in the Products table
     */
    List<Product> findAll();

    /**
     * Looks for a product by id in the Products table
     * @return the product that matches the given id or Optional.empty
     */
    Optional<Product> findById(Long productId);

    /**
     * Looks for all the products that match the given category
     */
    List<Product> findByCategory(String productCategory);

    /**
     * Returns at most numberOfProducts from a database
     */
    Page<Product> findAll(Pageable pageable);
}

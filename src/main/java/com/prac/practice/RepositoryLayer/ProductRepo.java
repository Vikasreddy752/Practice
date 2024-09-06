package com.prac.practice.RepositoryLayer;

import com.prac.practice.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
    Product findProductById(int id);
    Product save(Product product);
}

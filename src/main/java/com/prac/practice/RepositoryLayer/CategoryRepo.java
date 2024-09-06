package com.prac.practice.RepositoryLayer;

import com.prac.practice.Model.Category;
import com.prac.practice.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {

    Category findByTittle(String tittle);

    Category save(Category category);
}

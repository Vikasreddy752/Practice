package com.prac.practice.Service;
import com.prac.practice.Model.Category;
import com.prac.practice.RepositoryLayer.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SelfCategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    public Category Creatcategory(String tittle) {

       Category category = new Category();
       category.setTittle(tittle);
       return  categoryRepo.save(category);
    }
}

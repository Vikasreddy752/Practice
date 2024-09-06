package com.prac.practice.Service;

import com.prac.practice.Model.Category;
import com.prac.practice.Model.Product;
import com.prac.practice.RepositoryLayer.CategoryRepo;
import com.prac.practice.RepositoryLayer.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("selfproductservice")
public class SelfProductService implements Productservi {

    @Autowired
    private ProductRepo prorepo;
    private CategoryRepo catrepo;
    private SelfCategoryService svc;

    public SelfProductService(ProductRepo prorepo, CategoryRepo catrepo,SelfCategoryService svc) {
        this.prorepo = prorepo;
        this.catrepo = catrepo;
        this.svc= svc;
    }

    public Product getproductbyid(int id) {

        return null;
    }

    public Product createproduct(String title, String description, String image, String price, String category) {
        Category exsitcategory = catrepo.findByTittle(category);
        if (exsitcategory == null) {
            exsitcategory =svc.Creatcategory(category);
        }
        Product product = new Product();
        product.setTittle(title);
        product.setDescription(description);
        product.setImage(image);
        product.setPrice(Double.valueOf(price));
        product.setCategory(exsitcategory);

        return prorepo.save(product);
    }

    public Product updateproductbyid(int id, String tittle, String description,
                                     String Image, String Price, String category) {
        Product product = prorepo.findProductById(id);
        product.setId(id);
        product.setTittle(tittle);
        product.setDescription(description);
        product.setImage(Image);
        product.setPrice(Double.valueOf(Price));
        product.getCategory().setTittle(tittle);

        return prorepo.save(product);
    }

    public Product deleteproductbyid(int id) {
        return null;
    }

    public List<Product> getallproducts() {
        return null;
    }
}

package com.prac.practice.Service;

import com.prac.practice.Model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Productservi {

    public Product getproductbyid(int id);

    public Product createproduct(String title,
                                 String description,
                                 String image,
                                 String price,
                                 String category);
    public Product updateproductbyid(int id, String tittle, String description,
                                     String Image, String Price, String category);
    public Product deleteproductbyid(int id);
    public List<Product> getallproducts();
}

package com.prac.practice.Service;

import com.prac.practice.Model.products;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Productservi {

    public products getproductbyid(int id);

    public products createproduct(String title,
                              String description,
                              String category);
    public products updateproductbyid(int id,String tittle,String description,
                                      String Image,String Price,String category);
    public products deleteproductbyid(int id);
    public List<products> getallproducts();
}

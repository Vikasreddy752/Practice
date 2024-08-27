package com.prac.practice.Service;

import com.prac.practice.Model.products;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
public interface Productservi {

    public products getproductbyid(int id);

    public products createproduct(String title,
                              String description,
                              String category);
}

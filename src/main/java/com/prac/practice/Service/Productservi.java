package com.prac.practice.Service;

import com.prac.practice.Model.products;
import org.springframework.stereotype.Service;


public interface Productservi {

    public products getproductbyid(int id);
    public void createproduct();
}

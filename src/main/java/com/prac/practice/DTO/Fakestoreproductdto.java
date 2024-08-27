package com.prac.practice.DTO;

import com.prac.practice.Model.Category;
import com.prac.practice.Model.products;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.concurrent.Callable;

@Getter
@Setter
public class Fakestoreproductdto {
    private int id;
    private String title;
    private String description;
    private String category;


   /* public products toproduct(Fakestoreproductdto dto){
        products pr = new products();
        Category cr = new Category();
        cr.setTitle(dto.getCategory());//for category

        pr.setCategory(cr);
        pr.setId(dto.getId());
        pr.setTittle(dto.getTittle());
        pr.setDescription(dto.getDescription());
        pr.setImage(dto.getImage());
        pr.setPrice(Double.valueOf (dto.getPrice()));

        return pr;
    }*/

}

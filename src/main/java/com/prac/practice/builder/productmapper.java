package com.prac.practice.builder;

import com.prac.practice.DTO.Fakestoreproductdto;
import com.prac.practice.DTO.productresponsedto;
import com.prac.practice.Model.products;
import org.springframework.stereotype.Component;

@Component
public class productmapper {
    public  productresponsedto convertproductresponsedto(products pr){
        productresponsedto dto = new productresponsedto();
        dto.setId(pr.getId());
        dto.setTitle(pr.getTittle());
        dto.setDescription(pr.getDescription());
        dto.setCategory(pr.getCategory());


        //dto.setId(pr.getId());


        return dto;
    }
    public products toproduct(Fakestoreproductdto dto){
        products pr = new products();

        pr.setCategory(dto.getCategory());
        pr.setId(dto.getId());
        pr.setTittle(dto.getTitle());
        pr.setDescription(dto.getDescription());

        return pr;
    }
}

package com.prac.practice.builder;

import com.prac.practice.DTO.Fakestoreproductdto;
import com.prac.practice.DTO.ProductResponseDto;
import com.prac.practice.Model.Product;
import org.springframework.stereotype.Component;

@Component
public class productmapper {
    public ProductResponseDto convertproductresponsedto(Product pr){
        ProductResponseDto dto = new ProductResponseDto();
        dto.setId(pr.getId());
        dto.setTitle(pr.getTittle());
        dto.setDescription(pr.getDescription());
        dto.setPrice(pr.getPrice());
        dto.setCategory(pr.getCategory().getTittle());
        dto.setImage(pr.getImage());


        return dto;
    }
    public Product toproduct(Fakestoreproductdto dto){
        Product pr = new Product();

        pr.setId(dto.getId());
        pr.setTittle(dto.getTitle());
        pr.setDescription(dto.getDescription());
        //pr.setCategory(dto.getCategory());
        pr.setImage(dto.getImage());

        return pr;
    }
}

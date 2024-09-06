package com.prac.practice.controller;


import com.prac.practice.DTO.ProductResponseDto;
import com.prac.practice.DTO.CreateProductRequestDto;
import com.prac.practice.Exception.Invalindproductid;
import com.prac.practice.Exception.Productnotfound;
import com.prac.practice.Model.Product;
import com.prac.practice.Service.Productservi;
import com.prac.practice.builder.productmapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//import static com.prac.practice.builder.productmapper.convertproductresponsedto;

@RestController
public class ProductController {


    private Productservi obj;
    private productmapper mapper;
    public ProductController(@Qualifier("selfproductservice")Productservi obj, productmapper mapper) {
        this.obj = obj;
        this.mapper = mapper;
    }
    @GetMapping("/product/{id}")
    public ProductResponseDto getproductbyid(@PathVariable("id") Integer id) throws Invalindproductid,Productnotfound {
        if(id == null){
            throw new Invalindproductid();
        }

       Product pr =  obj.getproductbyid(id);
        if(pr == null){
            throw new Productnotfound();
        }
       ProductResponseDto response =  mapper.convertproductresponsedto(pr);
       return response;
    }

    @PostMapping ("/product")
    public ProductResponseDto createproduct(@RequestBody CreateProductRequestDto dto){

        //1.valdiate request

        //2.call to service
       Product product =  obj.createproduct(dto.getTitle(),
               dto.getDescription(),
               dto.getImage(),
               dto.getPrice(),
               dto.getCategory());

       //3.convert this to dto return;
        ProductResponseDto response = mapper.convertproductresponsedto(product);
        return  response;

       // return productresponsedto;
    }



    @DeleteMapping("/delete/{id}")
    public ProductResponseDto delteproductbyid(@PathVariable("id") int id){

        Product pr = obj.deleteproductbyid(id);

        return mapper.convertproductresponsedto(pr);
    }

    @PatchMapping("/patch/{id}")
    public ProductResponseDto updateproductbyid(@RequestBody CreateProductRequestDto dto, @PathVariable ("id") int id){

       Product pr  =obj.updateproductbyid(id,dto.getTitle(),dto.getDescription(),
                dto.getImage(),dto.getPrice(),dto.getCategory());

       return mapper.convertproductresponsedto(pr);

    }

    @GetMapping("/products")
    public List<ProductResponseDto> getallproducts(){

        //1.calling to servicelayer
        List<Product> productsList =obj.getallproducts();

        //2.creating productresponsedto list to store all mapped products
        List<ProductResponseDto>response = new ArrayList<>();

        //3.by loop mapping all the products
        for (Product pr : productsList) {
            response.add(mapper.convertproductresponsedto(pr));
        }
        return response;
    }

}


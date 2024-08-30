package com.prac.practice.Controller;


import com.prac.practice.DTO.createproductrequestdto;
import com.prac.practice.DTO.productresponsedto;
import com.prac.practice.Model.products;
import com.prac.practice.Service.Productservi;
import com.prac.practice.builder.productmapper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//import static com.prac.practice.builder.productmapper.convertproductresponsedto;

@RestController
public class productcontroller {

    private Productservi obj;
    private productmapper mapper;

    public productcontroller(Productservi obj,productmapper mapper){
        this.obj = obj;
        this.mapper = mapper;
    }


    @GetMapping("/product/{id}")
    public productresponsedto getproductbyid(@PathVariable("id") int id){

       products pr =  obj.getproductbyid(id);
       productresponsedto  response =  mapper.convertproductresponsedto(pr);
       return response;
    }

    @PostMapping ("/product")
    public productresponsedto createproduct(@RequestBody createproductrequestdto dto){

        //1.valdiate request

        //2.call to service
       products product =  obj.createproduct(dto.getTitle(),dto.getDescription(),dto.getCategory());

       //3.convert this to dto return;
        productresponsedto response = mapper.convertproductresponsedto(product);
        return  response;

       // return productresponsedto;
    }



    @DeleteMapping("/delete/{id}")
    public productresponsedto delteproductbyid(@PathVariable("id") int id){

        products pr = obj.deleteproductbyid(id);

        return mapper.convertproductresponsedto(pr);
    }

    @PatchMapping("/patch/{id}")
    public productresponsedto updateproductbyid(@RequestBody createproductrequestdto dto,@PathVariable ("id") int id){

       products pr  =obj.updateproductbyid(id,dto.getTitle(),dto.getDescription(),
                dto.getImage(),dto.getPrice(),dto.getCategory());

       return mapper.convertproductresponsedto(pr);

    }

    @GetMapping("/products")
    public List<productresponsedto> getallproducts(){

        //1.calling to servicelayer
        List<products> productsList =obj.getallproducts();

        //2.creating productresponsedto list to store all mapped products
        List<productresponsedto>response = new ArrayList<>();

        //3.by loop mapping all the products
        for (products pr : productsList) {
            response.add(mapper.convertproductresponsedto(pr));
        }
        return response;
    }
}


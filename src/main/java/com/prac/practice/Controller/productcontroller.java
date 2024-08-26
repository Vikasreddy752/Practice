package com.prac.practice.Controller;


import com.prac.practice.DTO.productresponsedto;
import com.prac.practice.Model.products;
import com.prac.practice.Service.Productservi;
import com.prac.practice.Service.fakestoreservice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class productcontroller {

    private Productservi obj;

    public productcontroller(Productservi obj){
        this.obj = obj;
    }


    @GetMapping("/product/{id}")
    public productresponsedto getproductbyid(@PathVariable("id") int id){

       products pr =  obj.getproductbyid(id);
       productresponsedto  response =  convertproductresponsedto(pr);
       return response;
    }

    private productresponsedto convertproductresponsedto(products pr){
        productresponsedto dto = new productresponsedto();
        dto.setId(pr.getId());
        dto.setTitle(pr.getTittle());
        dto.setDescription(pr.getDescription());
        dto.setCategory(pr.getCategory());

        return dto;
    }

    @PostMapping ("/products")
    public void createproduct(){

    }
}

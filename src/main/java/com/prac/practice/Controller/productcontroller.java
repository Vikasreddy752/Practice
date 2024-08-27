package com.prac.practice.Controller;


import com.prac.practice.DTO.createproductrequestdto;
import com.prac.practice.DTO.productresponsedto;
import com.prac.practice.Model.products;
import com.prac.practice.Service.Productservi;
import com.prac.practice.builder.productmapper;
import org.springframework.web.bind.annotation.*;

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

        if(id<1){
            System.out.println("id not to be null");
            return null;
        }

       products pr =  obj.getproductbyid(id);
       productresponsedto  response =  mapper.convertproductresponsedto(pr);
       return response;
    }

    @PostMapping ("/product")
    public productresponsedto createproduct(@RequestBody createproductrequestdto dto){

        //1.valdiate request

        //2.call to service
       products pr =  obj.createproduct(dto.getTitle(),dto.getDescription(),dto.getCategory());

       //3.convert this to dto return;

        return  mapper.convertproductresponsedto(pr);

       // return productresponsedto;
    }
}

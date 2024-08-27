package com.prac.practice.Service;

import com.prac.practice.DTO.Fakestoreproductdto;
import com.prac.practice.Model.products;
import com.prac.practice.builder.productmapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class fakestoreservice implements  Productservi {

    private final com.prac.practice.builder.productmapper productmapper;
    private RestTemplate restTemplate;

    public fakestoreservice(RestTemplate restTemplate, productmapper productmapper){
        this.restTemplate=restTemplate;
        this.productmapper = productmapper;
    }

    @Override
    public products getproductbyid(int id){

        ResponseEntity<Fakestoreproductdto> response =
                restTemplate.getForEntity("http://fakestoreapi.com/products/"+id , Fakestoreproductdto.class);

        Fakestoreproductdto dto = response.getBody();

        if(response.getBody() == null){
            //throw exception
            System.out.print("product body is null");
        }

        return productmapper.toproduct(dto);

    }

     @Override
    public products createproduct(String title,String description ,String category){
         //1.create fakestoredto object
        Fakestoreproductdto requestbody = new Fakestoreproductdto();
        requestbody.setTitle(title);
        requestbody.setDescription(description);
        requestbody.setCategory(category);

        //2,call fakestore Api
         Fakestoreproductdto response =
                 restTemplate.postForObject("http://fakestoreapi.com/products/",
                         requestbody,Fakestoreproductdto.class);

         products pr = productmapper.toproduct(response);


        return pr;
    }
}

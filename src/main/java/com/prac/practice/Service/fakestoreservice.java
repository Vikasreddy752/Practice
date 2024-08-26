package com.prac.practice.Service;

import com.prac.practice.DTO.Fakestoreproductdto;
import com.prac.practice.Model.products;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class fakestoreservice implements  Productservi {

    private RestTemplate restTemplate;

    public fakestoreservice(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }

    public products getproductbyid(int id){

        ResponseEntity<Fakestoreproductdto> response =
                restTemplate.getForEntity("http://fakestoreapi.com/products/"+id , Fakestoreproductdto.class);

        Fakestoreproductdto dto = response.getBody();
        return dto.toproduct(dto);

    }

    public void createproduct(){

    }
}

package com.prac.practice.Service;

import com.prac.practice.DTO.Fakestoreproductdto;
import com.prac.practice.Model.Product;
import com.prac.practice.builder.productmapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakestoreservice")
public class FakeStoreService implements  Productservi {

    private  productmapper mapper;
    private RestTemplate restTemplate;


    public FakeStoreService(RestTemplate restTemplate, productmapper mapper){
        this.restTemplate=restTemplate;
        this.mapper = mapper;
    }

    @Override
    public Product getproductbyid(int id){

        ResponseEntity<Fakestoreproductdto> response =
                restTemplate.getForEntity("http://fakestoreapi.com/products/"+id , Fakestoreproductdto.class);

        Fakestoreproductdto dto = response.getBody();

        if(response.getBody() == null){
            //throw exception
            System.out.print("product body is null");
            return  null;
        }

        Product pr = mapper.toproduct(dto);
        return pr;

    }

    @Override
    public Product createproduct(String title, String description ,String image,String price, String category){
         //1.create fakestoredto object
        Fakestoreproductdto requestbody = new Fakestoreproductdto();
        requestbody.setTitle(title);
        requestbody.setDescription(description);
        requestbody.setCategory(category);

        //2,call fakestore Api
         Fakestoreproductdto response =
                 restTemplate.postForObject("http://fakestoreapi.com/products/",
                         requestbody,Fakestoreproductdto.class);

         Product product = mapper.toproduct(response);

         return product;
    }

    @Override
    public Product deleteproductbyid(int id){

        ResponseEntity<Fakestoreproductdto> response =
                restTemplate.getForEntity("http://fakestoreapi.com/products/",Fakestoreproductdto.class);

        Fakestoreproductdto dto = response.getBody();

        return mapper.toproduct(dto);
    }

    @Override
    public Product updateproductbyid(int id, String tittle, String description, String Image, String Price, String category){
        Fakestoreproductdto requestbody = new Fakestoreproductdto();
        requestbody.setTitle(tittle);
        requestbody.setDescription(description);
        requestbody.setImage(Image);
        requestbody.setPrice(Price);
        requestbody.setCategory(category);
        HttpHeaders headers = new HttpHeaders();
        //headers.setAccept();
        HttpEntity<Fakestoreproductdto> entity = new HttpEntity<>(requestbody,headers);
        ResponseEntity<Fakestoreproductdto> r =
        restTemplate.exchange("http://fakestoreapi.com/products/"+id, HttpMethod.PUT,entity,Fakestoreproductdto.class);
        Fakestoreproductdto dt = r.getBody();

        Product dto = mapper.toproduct(dt);

        return dto;
    }
    public List<Product> getallproducts(){
        //1.creating list to store all products
        List<Product> produ_s = new ArrayList<>();

        //2.calling to fakestore and storing all products in arraylist Fakestoreproductdto[]
        ResponseEntity<Fakestoreproductdto[]> response =
                restTemplate.getForEntity("http://fakestoreapi.com/products/", Fakestoreproductdto[].class);
       //3.getting body of Fakestoreproductdto[]
        Fakestoreproductdto[] dtos = response.getBody();

        //4.converting all Fakestoreproductdto[] to products
        for (Fakestoreproductdto dto : dtos) {
            Product product = mapper.toproduct(dto);
            produ_s.add(product);
        }
        return produ_s;
    }
}

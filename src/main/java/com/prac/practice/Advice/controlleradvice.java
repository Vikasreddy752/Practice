package com.prac.practice.Advice;

import com.prac.practice.DTO.Errordto;
import com.prac.practice.Exception.Invalindproductid;
import com.prac.practice.Exception.Productnotfound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class controlleradvice {

    @ExceptionHandler(Invalindproductid.class)
    public ResponseEntity<Errordto> handleinvalidproductexception(Invalindproductid e){

        Errordto dto = new Errordto();
        dto.setCode(" error code");
        dto.setMsg("no id");
        return new ResponseEntity<>(dto, HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(Productnotfound.class)
    public ResponseEntity<Errordto> handleiproductnotfoundexception(Productnotfound e){

        Errordto dto = new Errordto();
        dto.setCode(" error code");
        dto.setMsg("product not found ");
        return new ResponseEntity<>(dto, HttpStatus.NO_CONTENT);
    }
}

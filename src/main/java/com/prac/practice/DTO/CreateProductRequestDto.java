package com.prac.practice.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequestDto {
    private String title;
    private String description;
    private String Image;
    private String price;
    private String category;
}

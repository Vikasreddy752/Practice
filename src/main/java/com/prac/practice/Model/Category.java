package com.prac.practice.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Category extends BaseModel  {

    private String tittle;

    @OneToMany(mappedBy = "category",cascade = CascadeType.PERSIST)
    List<Product> products;
}

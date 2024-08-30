package com.prac.practice.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Errordto {
    private String msg;
    private String code;

    public Errordto(  ) {
    }
}

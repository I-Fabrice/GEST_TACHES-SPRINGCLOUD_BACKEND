package com.mycompany.tacheApplication.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class DelaiRequestDTO {
    private Long ref ;
    private Date delai;
}

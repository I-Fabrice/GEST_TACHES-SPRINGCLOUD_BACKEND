package com.mycompany.tacheApplication.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

@Getter @Setter
public class TacheRequestDTO {
    private Long   ref;
    private String description;
    private Date delai;
    private boolean isPriority;
}

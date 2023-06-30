package com.mycompany.tacheApplication.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;
import java.util.List;

@Getter @Setter
public class TacheRequestDTO {
    private Long   ref;
    private String description;
    private Date delai;
    private boolean isPriority;
    private List<CompteId> compteId;

    @Getter @Setter
    public static class CompteId{
        private Long compteId;
    }
}



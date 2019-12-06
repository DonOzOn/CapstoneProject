package com.realestatebrokerage.service.dto;

import com.realestatebrokerage.domain.ParWoman;


public class ParWomanDTO {
    private Long id;
    private String namePar;

    public ParWomanDTO() {
    }

    public ParWomanDTO(ParWoman parWoman) {
        this.id = parWoman.getId();
        this.namePar = parWoman.getNamePar();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamePar() {
        return namePar;
    }

    public void setNamePar(String namePar) {
        this.namePar = namePar;
    }
}

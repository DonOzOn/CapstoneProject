package com.realestatebrokerage.service.dto;


import com.realestatebrokerage.domain.ParMan;

public class ParManDTO {
    private Long id;
    private String namePar;

    public ParManDTO() {
    }

    public ParManDTO(ParMan parMan) {
        this.id = parMan.getId();
        this.namePar = parMan.getNamePar();
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

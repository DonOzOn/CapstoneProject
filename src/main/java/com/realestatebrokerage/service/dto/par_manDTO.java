package com.realestatebrokerage.service.dto;


import com.realestatebrokerage.domain.ParMan;

public class par_manDTO {
    private Long id;
    private String name_par;

    public par_manDTO() {
    }

    public par_manDTO(ParMan par_man) {
        this.id = par_man.getId();
        this.name_par = par_man.getNamePar();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName_par() {
        return name_par;
    }

    public void setName_par(String name_par) {
        this.name_par = name_par;
    }
}

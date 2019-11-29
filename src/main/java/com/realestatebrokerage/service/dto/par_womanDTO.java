package com.realestatebrokerage.service.dto;

import com.realestatebrokerage.domain.par_man;
import com.realestatebrokerage.domain.par_woman;

public class par_womanDTO {
    private Long id;
    private String name_par;

    public par_womanDTO() {
    }

    public par_womanDTO(par_woman par_woman) {
        this.id = par_woman.getId();
        this.name_par = par_woman.getName_par();
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

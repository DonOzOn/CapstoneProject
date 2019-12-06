package com.realestatebrokerage.service.dto;


import com.realestatebrokerage.domain.DirectionHouse;
import com.realestatebrokerage.domain.ParMan;

import javax.persistence.Column;
import javax.validation.constraints.Size;

public class DirectionHouseDTO {
    private Long id;
    private String name_par;
    private String sinhkhi;
    private String thieny;
    private String diennien;
    private String phucvi;
    private String tuyetmenh;
    private String nguquy;
    private String lucsat;
    private String hoahai;

    public DirectionHouseDTO() {
    }
    public DirectionHouseDTO(DirectionHouse directionHouse) {
        this.id = directionHouse.getId();
        this.name_par = directionHouse.getName_par();
        this.sinhkhi = directionHouse.getSinhkhi();
        this.thieny = directionHouse.getThieny();
        this.diennien = directionHouse.getDiennien();
        this.phucvi = directionHouse.getPhucvi();
        this.tuyetmenh = directionHouse.getTuyetmenh();
        this.nguquy = directionHouse.getNguquy();
        this.lucsat = directionHouse.getLucsat();
        this.hoahai = directionHouse.getHoahai();
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

    public String getSinhkhi() {
        return sinhkhi;
    }

    public void setSinhkhi(String sinhkhi) {
        this.sinhkhi = sinhkhi;
    }

    public String getThieny() {
        return thieny;
    }

    public void setThieny(String thieny) {
        this.thieny = thieny;
    }

    public String getDiennien() {
        return diennien;
    }

    public void setDiennien(String diennien) {
        this.diennien = diennien;
    }

    public String getPhucvi() {
        return phucvi;
    }

    public void setPhucvi(String phucvi) {
        this.phucvi = phucvi;
    }

    public String getTuyetmenh() {
        return tuyetmenh;
    }

    public void setTuyetmenh(String tuyetmenh) {
        this.tuyetmenh = tuyetmenh;
    }

    public String getNguquy() {
        return nguquy;
    }

    public void setNguquy(String nguquy) {
        this.nguquy = nguquy;
    }

    public String getLucsat() {
        return lucsat;
    }

    public void setLucsat(String lucsat) {
        this.lucsat = lucsat;
    }

    public String getHoahai() {
        return hoahai;
    }

    public void setHoahai(String hoahai) {
        this.hoahai = hoahai;
    }
}

package com.realestatebrokerage.service.dto;


import com.realestatebrokerage.domain.DirectionHouse;

public class direction_houseDTO {
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

    public direction_houseDTO() {
    }

    public direction_houseDTO(DirectionHouse direction_house) {
        this.id = direction_house.getId();
        this.name_par = direction_house.getName_par();
        this.sinhkhi = direction_house.getSinhkhi();
        this.thieny = direction_house.getThieny();
        this.diennien = direction_house.getDiennien();
        this.phucvi = direction_house.getPhucvi();
        this.tuyetmenh = direction_house.getTuyetmenh();
        this.nguquy = direction_house.getNguquy();
        this.lucsat = direction_house.getLucsat();
        this.hoahai = direction_house.getHoahai();
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

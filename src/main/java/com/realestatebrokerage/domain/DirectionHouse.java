package com.realestatebrokerage.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "direction_house")
public class DirectionHouse {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50)
    @Column(name = "name_par", length = 50)
    private String name_par;
    @Size(max = 50)
    @Column(name = "sinhkhi", length = 50)
    private String sinhkhi;
    @Size(max = 50)
    @Column(name = "thieny", length = 50)
    private String thieny;
    @Size(max = 50)
    @Column(name = "diennien", length = 50)
    private String diennien;
    @Size(max = 50)
    @Column(name = "phucvi", length = 50)
    private String phucvi;
    @Size(max = 50)
    @Column(name = "tuyetmenh", length = 50)
    private String tuyetmenh;
    @Size(max = 50)
    @Column(name = "nguquy", length = 50)
    private String nguquy;
    @Size(max = 50)
    @Column(name = "lucsat", length = 50)
    private String lucsat;
    @Size(max = 50)
    @Column(name = "hoahai", length = 50)
    private String hoahai;

    public DirectionHouse() {
    }

    public DirectionHouse(@Size(max = 50) String name_par, @Size(max = 50) String sinhkhi, @Size(max = 50) String thieny, @Size(max = 50) String diennien, @Size(max = 50) String phucvi, @Size(max = 50) String tuyetmenh, @Size(max = 50) String nguquy, @Size(max = 50) String lucsat, @Size(max = 50) String hoahai) {
        this.name_par = name_par;
        this.sinhkhi = sinhkhi;
        this.thieny = thieny;
        this.diennien = diennien;
        this.phucvi = phucvi;
        this.tuyetmenh = tuyetmenh;
        this.nguquy = nguquy;
        this.lucsat = lucsat;
        this.hoahai = hoahai;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    @Override
    public String toString() {
        return "DirectionHouse{" +
            "id=" + id +
            ", name_par='" + name_par + '\'' +
            ", sinhkhi='" + sinhkhi + '\'' +
            ", thieny='" + thieny + '\'' +
            ", diennien='" + diennien + '\'' +
            ", phucvi='" + phucvi + '\'' +
            ", tuyetmenh='" + tuyetmenh + '\'' +
            ", nguquy='" + nguquy + '\'' +
            ", lucsat='" + lucsat + '\'' +
            ", hoahai='" + hoahai + '\'' +
            '}';
    }
}

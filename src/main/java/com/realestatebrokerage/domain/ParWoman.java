package com.realestatebrokerage.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "par_woman")
public class ParWoman {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50)
    @Column(name = "name_par", length = 50)
    private String name_par;

    public ParWoman() {
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
}

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
    private String namePar;

    public ParWoman() {
    }

    public ParWoman(@Size(max = 50) String namePar) {
        this.namePar = namePar;
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

    public String getNamePar() {
        return namePar;
    }

    public void setNamePar(String namePar) {
        this.namePar = namePar;
    }
}

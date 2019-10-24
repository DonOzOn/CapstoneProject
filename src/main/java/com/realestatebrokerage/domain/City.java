package com.realestatebrokerage.domain;


import com.realestatebrokerage.config.Constants;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "city")
public class City extends AbstractAuditingEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, name = "city_name")
    private String cityName;

    @Column(name = "type", length = 60)
    private String type;


    public City() {
    }

    public City(City city){
        this.id = city.getId();
        this.cityName = city.getCityName();
        this.type = city.getType();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}

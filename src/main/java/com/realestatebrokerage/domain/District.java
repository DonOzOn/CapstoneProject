package com.realestatebrokerage.domain;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "district")
public class District extends AbstractAuditingEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "city_id")
    private City city;

    @Column(length = 50, name = "district_name")
    private String districtName;

    @Column(name = "type", length = 60)
    private String type;


    public District() {
    }

    public District(District district){
        this.id = district.getId();
        this.districtName = district.getDistrictName();
        if (district.getCity() != null) {
            this.city = district.getCity();
        }
        this.type = district.getType();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

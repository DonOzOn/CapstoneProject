package com.realestatebrokerage.domain;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "address")
public class Address extends AbstractAuditingEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(referencedColumnName = "id", name = "district_id")
    private District district;

    @OneToOne
    @JoinColumn(referencedColumnName = "id", name = "ward_id")
    private Ward ward;

    @OneToOne
    @JoinColumn(referencedColumnName = "id", name = "city_id")
    private City city;


    public Address() {
    }

    public Address(Address address){
        this.id = address.getId();
        if (address.getDistrict() != null) {
            this.district = address.getDistrict();
        }
        if (address.getWard() != null) {
            this.ward = address.getWard();
        }
        if (address.getCity() != null) {
            this.city = address.getCity();
        }

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public Ward getWard() {
        return ward;
    }

    public void setWard(Ward ward) {
        this.ward = ward;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}

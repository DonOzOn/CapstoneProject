package com.realestatebrokerage.domain;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ward")
public class Ward extends AbstractAuditingEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "district_id")
    private District district;

    @Column(length = 50, name = "ward_name")
    private String wardName;

    @Column(name = "type", length = 60)
    private String type;


    public Ward() {
    }

    public Ward(Ward ward){
        this.id = ward.getId();
        this.wardName = ward.getWardName();
        if (ward.getDistrict() != null) {
            this.district = ward.getDistrict();
        }
        this.type = district.getType();

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

    public String getWardName() {
        return wardName;
    }

    public void setWardName(String wardName) {
        this.wardName = wardName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

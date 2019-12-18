package com.realestatebrokerage.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.search.annotations.ContainedIn;
import org.hibernate.search.annotations.Field;

import javax.persistence.*;

@Entity
@Table(name = "ward")
public class Ward {
    @Id
    private String code;

    @ContainedIn
    @Field
    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "district_code", referencedColumnName = "code")
    private District district;

    public Ward(String code, String name, String type, District district) {
        this.code = code;
        this.name = name;
        this.type = type;
        this.district = district;
    }

    public Ward() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Ward{" +
            "code='" + code + '\'' +
            ", name='" + name + '\'' +
            ", type='" + type + '\'' +
            ", district=" + district +
            '}';
    }
}

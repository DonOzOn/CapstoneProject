package com.realestatebrokerage.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.search.annotations.ContainedIn;
import org.hibernate.search.annotations.Field;

import javax.persistence.*;

@Entity
@Table(name = "district")
public class District {
    public District(){}
    @Id
    private String code;

    @Field
    @Column(name = "name")
    private String name;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "province_code", referencedColumnName = "code")
    private Province province;

    @Column(name = "type")
    private String type;

    public District(String code, String name, Province province, String type) {
        this.code = code;
        this.name = name;
        this.province = province;
        this.type = type;
    }

    public District() {
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

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "District{" +
            "code='" + code + '\'' +
            ", name='" + name + '\'' +
            ", province=" + province +
            ", type='" + type + '\'' +
            '}';
    }
}

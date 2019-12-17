package com.realestatebrokerage.domain;

import org.hibernate.search.annotations.ContainedIn;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "province")
public class Province {
    @Id
    private String code;

    @Field
    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    public Province(String code, String name, String type) {
        this.code = code;
        this.name = name;
        this.type = type;
    }

    public Province() {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Province{" +
            "code='" + code + '\'' +
            ", name='" + name + '\'' +
            ", type='" + type + '\'' +
            '}';
    }
}

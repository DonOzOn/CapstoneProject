package com.realestatebrokerage.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A utilities.
 */
@Entity
@Table(name = "utilities")
public class Utilities{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50)
    @Column(name = "utilities_name", length = 50)
    private String utilitiesName;

    public Utilities() {
    }

    public Utilities(@Size(max = 50) String utilitiesName) {
        this.utilitiesName = utilitiesName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUtilitiesName() {
        return utilitiesName;
    }

    public void setUtilitiesName(String utilitiesName) {
        this.utilitiesName = utilitiesName;
    }
}

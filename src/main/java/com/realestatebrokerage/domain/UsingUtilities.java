package com.realestatebrokerage.domain;

import com.realestatebrokerage.config.Constants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;
import java.util.Collection;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/**
 * A using_utilities.
 */
@Entity
@Table(name = "using_utilities")
public class UsingUtilities extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(referencedColumnName = "id", name = "product_id")
    private Product product;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "utilities_id")
    private Utilities utilities;

    @NotNull
    @Column(name = "status", nullable = false)
    private boolean status = false;

    public UsingUtilities(UsingUtilities usingUtilities) {
        this.id= usingUtilities.getId();
        if(usingUtilities.getProduct() !=null){
            this.product=usingUtilities.getProduct();
        }
        if(usingUtilities.getUtilities() !=null){
            this.utilities=usingUtilities.getUtilities();
        }
        this.status= usingUtilities.getStatus();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Utilities getUtilities() {
        return utilities;
    }

    public void setUtilities(Utilities utilities) {
        this.utilities = utilities;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}

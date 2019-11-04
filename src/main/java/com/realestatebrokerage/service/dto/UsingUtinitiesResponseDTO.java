package com.realestatebrokerage.service.dto;

import com.realestatebrokerage.domain.Product;
import com.realestatebrokerage.domain.UsingUtilities;
import com.realestatebrokerage.domain.Utilities;

import java.time.Instant;
import java.time.LocalDateTime;

public class UsingUtinitiesResponseDTO {
    private Long id;
    private Product product;
    private Utilities utilities;
    private boolean status;
    private String createdBy;
    private Instant createdDate;
    private String lastModifiedBy;
    private Instant lastModifiedDate;

    public UsingUtinitiesResponseDTO() {
    }

    public UsingUtinitiesResponseDTO(UsingUtilities usingUtilities) {
        this.id = usingUtilities.getId();
        if(usingUtilities.getProduct()!= null){
            this.product = usingUtilities.getProduct();
        }
        if(usingUtilities.getUtilities()!= null){
            this.utilities = usingUtilities.getUtilities();
        }
        this.status = usingUtilities.getStatus();
        if (usingUtilities.getCreatedBy() != null) {
            this.createdBy = usingUtilities.getCreatedBy();
        }
        if (usingUtilities.getLastModifiedBy() != null) {
            this.lastModifiedBy = usingUtilities.getLastModifiedBy();
        }
        if (usingUtilities.getCreatedDate() != null) {
            this.createdDate = usingUtilities.getCreatedDate();
        }
        this.lastModifiedDate = usingUtilities.getLastModifiedDate();

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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Instant getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Instant lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}

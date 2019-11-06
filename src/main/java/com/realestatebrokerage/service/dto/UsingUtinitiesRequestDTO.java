package com.realestatebrokerage.service.dto;
import com.realestatebrokerage.domain.UsingUtilities;

import java.time.LocalDateTime;
import java.util.Date;

public class UsingUtinitiesRequestDTO {
    private Long id;
    private Long product;
    private Long utilities;
    private boolean status;

    public UsingUtinitiesRequestDTO() {
    }

    public UsingUtinitiesRequestDTO(UsingUtilities usingUtilities) {
        this.id = usingUtilities.getId();
        if(usingUtilities.getProduct()!= null){
            this.product = usingUtilities.getProduct().getId();
        }
        if(usingUtilities.getUtilities()!= null){
            this.utilities = usingUtilities.getUtilities().getId();
        }
        this.status = usingUtilities.getStatus();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProduct() {
        return product;
    }

    public void setProduct(Long product) {
        this.product = product;
    }

    public Long getUtilities() {
        return utilities;
    }

    public void setUtilities(Long utilities) {
        this.utilities = utilities;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UsingUtinitiesRequestDTO{" +
            "id=" + id +
            ", product=" + product +
            ", utilities=" + utilities +
            ", status=" + status +
            '}';
    }
}

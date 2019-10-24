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
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/**
 * A legal_status.
 */
@Entity
@Table(name = "legal_status")
public class LegalStatus extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50)
    @Column(name = "legal_status_name", length = 50)
    private String legalStatusName;

    @NotNull
    @Column(name = "status", nullable = false)
    private boolean status = false;

    public LegalStatus(LegalStatus legalStatus) {
        this.id= legalStatus.getId();
        this.legalStatusName= legalStatus.getLegalStatusName();
        this.status= legalStatus.getStatus();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLegalStatusName() {
        return legalStatusName;
    }

    public void setLegalStatusName(String legalStatusName) {
        this.legalStatusName = legalStatusName;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}

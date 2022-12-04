package com.aeon.models.entities;

import java.util.Date;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
    value = {"created_date", "updated_date", "deleted_date"},
    allowGetters = true
)

public abstract class AbstractDate{
    
    @CreatedDate
    @Column(name = "created_date", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_date;
    
    @LastModifiedDate
    @Column(name = "updated_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_date;
    
    @Column(name = "deleted_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deleted_date;
}

package com.example.samples.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "M_SHOUHINBUNRUI")
public class Shouhinbunrui implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private BigDecimal shouhinbunruiId;
    
    @Column(name = "SHOUHINBUNRUI")
    private String name;

    public BigDecimal getShouhinbunruiId() {
        return shouhinbunruiId;
    }

    public void setShouhinbunruiId(BigDecimal shouhinbunruiId) {
        this.shouhinbunruiId = shouhinbunruiId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

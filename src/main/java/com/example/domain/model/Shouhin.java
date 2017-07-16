package com.example.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "M_SHOUHIN")
public class Shouhin implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String shouhinId;
    private BigDecimal shouhinVer;
    private String shouhin;
    private BigDecimal shouhinbunruiId;
    private String urine;
    private String seisanchi;

    public String getShouhinId() {
        return shouhinId;
    }
    public void setShouhinId(String shouhinId) {
        this.shouhinId = shouhinId;
    }
    public BigDecimal getShouhinVer() {
        return shouhinVer;
    }
    public void setShouhinVer(BigDecimal shouhinVer) {
        this.shouhinVer = shouhinVer;
    }
    public String getShouhin() {
        return shouhin;
    }
    public void setShouhin(String shouhin) {
        this.shouhin = shouhin;
    }
    public BigDecimal getShouhinbunruiId() {
        return shouhinbunruiId;
    }
    public void setShouhinbunruiId(BigDecimal shouhinbunruiId) {
        this.shouhinbunruiId = shouhinbunruiId;
    }
    public String getUrine() {
        return urine;
    }
    public void setUrine(String urine) {
        this.urine = urine;
    }
    public String getSeisanchi() {
        return seisanchi;
    }
    public void setSeisanchi(String seisanchi) {
        this.seisanchi = seisanchi;
    }
}

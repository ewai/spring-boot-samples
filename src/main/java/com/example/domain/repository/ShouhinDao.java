package com.example.domain.repository;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.example.domain.model.Shouhin;
import com.example.domain.model.Shouhinbunrui;

public interface ShouhinDao <T> extends Serializable {

    public List<Shouhin> getShouhinList(BigDecimal shouhinVer);
    public List<Shouhinbunrui> getDistinctShouhinbunruiList(BigDecimal shouhinVer);

}

package com.example.samples.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public interface ShouhinDao <T> extends Serializable {

    public List<Shouhin> getShouhinList(BigDecimal shouhinVer);
    public List<Shouhinbunrui> getDistinctShouhinbunruiList(BigDecimal shouhinVer);

}

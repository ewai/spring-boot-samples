package com.example.samples.domain;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface  RestShouhinRepository extends PagingAndSortingRepository<Shouhin, Long> {
    public Shouhin findByShouhinId(@Param("shouhinId") String shouhinId);
    public Shouhin findByShouhinIdAndShouhinVer(@Param("shouhinId") String shouhinId, @Param("shouhinVer") BigDecimal shouhinVer);
    public List<Shouhin> findByShouhinVer(@Param("shouhinVer") BigDecimal shouhinVer);
    public List<Shouhin> findByShouhinVerAndShouhinbunruiId(@Param("shouhinVer") BigDecimal shouhinVer, @Param("shouhinbunruiId") BigDecimal shouhinbunruiId);
}

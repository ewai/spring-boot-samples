package com.example.samples.domain;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShouhinRepository extends JpaRepository<Shouhin, String> {
    public Shouhin findByShouhinIdAndShouhinVer(String shouhinId, BigDecimal shouhinVer);
    public List<Shouhin> findByShouhinVer(BigDecimal shouhinVer);
    public List<Shouhin> findByShouhinVerAndShouhinbunruiId(BigDecimal shouhinVer, BigDecimal shouhinbunruiId);
}

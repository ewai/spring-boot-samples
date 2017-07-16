package com.example.domain.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.model.Shouhin;

@Repository
public interface ShouhinRepository extends JpaRepository<Shouhin, String> {
    public Shouhin findByShouhinId(String shouhinId);
    public Shouhin findByShouhinIdAndShouhinVer(String shouhinId, BigDecimal shouhinVer);
    public List<Shouhin> findByShouhinVer(BigDecimal shouhinVer);
    public List<Shouhin> findByShouhinVerAndShouhinbunruiId(BigDecimal shouhinVer, BigDecimal shouhinbunruiId);
}

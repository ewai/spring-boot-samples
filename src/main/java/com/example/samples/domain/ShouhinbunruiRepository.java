package com.example.samples.domain;


import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShouhinbunruiRepository extends JpaRepository<Shouhinbunrui, String> {
    public Shouhinbunrui findByShouhinbunruiId(BigDecimal shouhinbunruiId);
}

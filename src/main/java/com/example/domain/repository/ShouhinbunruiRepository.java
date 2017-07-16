package com.example.domain.repository;


import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.model.Shouhinbunrui;

@Repository
public interface ShouhinbunruiRepository extends JpaRepository<Shouhinbunrui, String> {
    public Shouhinbunrui findByShouhinbunruiId(BigDecimal shouhinbunruiId);
}

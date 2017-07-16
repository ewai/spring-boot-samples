package com.example.domain.service;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.model.Shouhin;
import com.example.domain.model.Shouhinbunrui;
import com.example.domain.repository.ShouhinDaoImpl;
import com.example.domain.repository.ShouhinRepository;
import com.example.domain.repository.ShouhinbunruiRepository;

@Service
public class ShouhinService {

    @Autowired
    ShouhinRepository shouhinRepository;

    @PersistenceContext
    EntityManager entityManager;

    ShouhinDaoImpl shouhinDao;

    @Autowired
    ShouhinbunruiRepository shouhinbunruiRepository;

    public Shouhin findByShouhinId(String shouhinId) {
        return this.shouhinRepository.findByShouhinId(shouhinId);
    }

    public Shouhin findByShouhinIdAndShouhinVer(String shouhinId, BigDecimal shouhinVer) {
        return this.shouhinRepository.findByShouhinIdAndShouhinVer(shouhinId, shouhinVer);
    }

    public List<Shouhin> findByShouhinVerAndShouhinbunruiId(BigDecimal shouhinVer, BigDecimal shouhinbunruiId) {
        return this.shouhinRepository.findByShouhinVerAndShouhinbunruiId(shouhinVer, shouhinbunruiId);
    }

    public List<Shouhinbunrui> getShouhinbunruilist() {
        this.shouhinDao = new ShouhinDaoImpl(this.entityManager);
        return this.shouhinDao.getDistinctShouhinbunruiList(new BigDecimal(1729));
    }
}

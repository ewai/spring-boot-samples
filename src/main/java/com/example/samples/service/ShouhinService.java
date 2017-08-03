package com.example.samples.service;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.samples.domain.Shouhin;
import com.example.samples.domain.ShouhinDaoImpl;
import com.example.samples.domain.ShouhinRepository;
import com.example.samples.domain.Shouhinbunrui;
import com.example.samples.domain.ShouhinbunruiRepository;

@Service
public class ShouhinService {

    @Autowired
    ShouhinRepository shouhinRepository;

    @PersistenceContext
    EntityManager entityManager;

    ShouhinDaoImpl shouhinDao;

    @Autowired
    ShouhinbunruiRepository shouhinbunruiRepository;

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

    public Shouhin save(Shouhin shouhin) {
        return this.shouhinRepository.saveAndFlush(shouhin);
    }
}

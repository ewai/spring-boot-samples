package com.example.samples.domain;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ShouhinDaoImpl implements ShouhinDao<Shouhin> {

    private static final long serialVersionUID = 1L;

    private EntityManager entityManager;

    public ShouhinDaoImpl() {
        super();
    }

    public ShouhinDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Shouhin> getShouhinList(BigDecimal shouhinVer) {
        Query query = this.entityManager.createQuery("from Shouhin where shouhinVer = :shouhinVer");
        query.setParameter("shouhinVer", shouhinVer);

        List<Shouhin> shouhinList = query.getResultList();
        entityManager.close();
        return shouhinList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Shouhinbunrui> getDistinctShouhinbunruiList(BigDecimal shouhinVer) {
        Query query = this.entityManager.createNativeQuery(
                "select distinct t2.shouhinbunrui_id, t2.shouhinbunrui from m_shouhin t1, m_shouhinbunrui t2 where t1.shouhinbunrui_id = t2.shouhinbunrui_id and t1.shouhin_ver = :shouhinVer",
                Shouhinbunrui.class);
        query.setParameter("shouhinVer", shouhinVer);

        List<Shouhinbunrui> shouhinbunruiList = query.getResultList();
        entityManager.close();
        return shouhinbunruiList;
    }
}

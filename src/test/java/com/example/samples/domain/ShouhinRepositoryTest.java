package com.example.samples.domain;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

@RunWith(SpringRunner.class)
@DataJpaTest
//@AutoConfigureTestDatabase(replace=Replace.NONE)
public class ShouhinRepositoryTest {

//    @Autowired
//  private TestEntityManager entityManager;
//    private EntityManager entityManager;

    @Autowired
    private ShouhinRepository repository;

    @Test
    public void testExample() throws Exception {
/*
        Shouhin testdata = new Shouhin();
        testdata.setShouhinId("test1");
        testdata.setShouhin("test2");
        testdata.setShouhinVer(new BigDecimal(1729));
        this.entityManager.persist(testdata);
*/
        Shouhin shouhin = this.repository.findByShouhinIdAndShouhinVer("test1", new BigDecimal(1729));
        assertThat("qqq").isEqualTo(shouhin.getShouhinId());
        //assertThat(testdata.getShouhinId()).isEqualTo(shouhin.getShouhinId());
    }
}

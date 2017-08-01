package com.example.samples.domain;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class ShouhinRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ShouhinRepository repository;

    @Test
    public void testExample() throws Exception {

        Shouhin testdata = new Shouhin();
        testdata.setShouhinId("00014939");
        testdata.setShouhin("item name");
        testdata.setShouhinVer(new BigDecimal(9999));
        this.entityManager.persist(testdata);

        Shouhin shouhin = this.repository.findByShouhinIdAndShouhinVer("00014939", new BigDecimal(9999));
        assertThat(testdata.getShouhinId()).isEqualTo(shouhin.getShouhinId());
    }
}

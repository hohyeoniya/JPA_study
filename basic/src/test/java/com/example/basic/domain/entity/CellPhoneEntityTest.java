package com.example.basic.domain.entity;

import com.example.basic.type.CellPhoneBrand;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(false)
public class CellPhoneEntityTest {
    @PersistenceContext
    EntityManager entityManager;

    @Test
    public void persistTest(){
        LocalDateTime cellPhoneReleaseDate = LocalDateTime.now();
//        LocalDateTime cellPhoneReleaseDate2 = LocalDateTime.of(1996,06,01,02,22);
        CellPhone cellPhone = new CellPhone();
        cellPhone.setCellPhoneBrand(CellPhoneBrand.GALAXY);
        cellPhone.setCellPhonePrice(500);
        cellPhone.setCellPhoneVersion("S22");
        cellPhone.setCellPhoneReleaseDate(cellPhoneReleaseDate);
        entityManager.persist(cellPhone);

        entityManager.find(CellPhone.class,1l);
        entityManager.remove( entityManager.find(CellPhone.class,1l));
    }

}

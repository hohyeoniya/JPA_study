package com.example.basic.domain.entity;

import com.example.basic.repository.CellPhoneDAO;
import com.example.basic.type.CellPhoneBrand;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(false)
public class CellPhoneTest {
    @Autowired
    private CellPhoneDAO cellPhoneDAO;

    @Test
    public void saveTest(){
        LocalDateTime localDateTime = LocalDateTime.of(2015,06,25,15,32);
        CellPhone cellPhone = new CellPhone();
        cellPhone.setCellPhoneBrand(CellPhoneBrand.IPHONE);
        cellPhone.setCellPhoneVersion("8 mini");
        cellPhone.setCellPhonePrice(0);
        cellPhone.setCellPhoneReleaseDate(localDateTime);

        cellPhoneDAO.save(cellPhone);

    }

    @Test
    public void findTest(){
        assertThat(cellPhoneDAO.findById(1l).getCellPhoneVersion()).isEqualTo("S22");
    }

    @Test
    public void updateTest(){
        cellPhoneDAO.findById(2l).setCellPhonePrice(10);
    }

    @Test
    public void deleteTest(){
        cellPhoneDAO.delete(cellPhoneDAO.findById(3l));
    }

    @Test
    public void findAllTest(){
        assertThat(cellPhoneDAO.findAll().get(1).getCellPhoneBrand()).isEqualTo(CellPhoneBrand.IPHONE);
        assertThat(cellPhoneDAO.findAll().size()).isEqualTo(2);
    }

    @Test
    public void findByVersion(){
        String version = "8 mini";
        assertThat(cellPhoneDAO.findByVersion(version).getCellPhonePrice()).isEqualTo(10);
    }

    @Test
    public void findByBrand(){
        CellPhoneBrand cellPhoneBrand = CellPhoneBrand.GALAXY;

        LocalDateTime date = LocalDateTime.of(2022,11,15,21,8,12);


        assertThat(cellPhoneDAO.findByBrand(cellPhoneBrand).getCellPhoneReleaseDate()).isEqualTo(date);
    }

    @Test
    public void findByreleaseDateTest(){
        String releaseDate = "20221115";
        assertThat(cellPhoneDAO.findByLocalDateTime(releaseDate).get(0).getCellPhoneBrand()).isEqualTo(CellPhoneBrand.GALAXY);
    }

}

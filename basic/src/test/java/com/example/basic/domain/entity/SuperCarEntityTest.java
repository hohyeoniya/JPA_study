package com.example.basic.domain.entity;

import com.example.basic.type.SuperCarBrand;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.implementation.bind.annotation.Super;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(false)
public class SuperCarEntityTest {
    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void SuperCarTest(){
        SuperCar superCarA = new SuperCar();
        superCarA.setSuperCarName("우르스");
        superCarA.setSuperCarBrand(SuperCarBrand.LAMBORGHINI);
        superCarA.setSuperCarColor("블랙");
        superCarA.setSuperCarPrice(26500l);

        entityManager.persist(superCarA);

       SuperCar superCar1 = entityManager.find(SuperCar.class, 1l);
       superCar1.setSuperCarPrice(26000l);

        if(Optional.ofNullable(superCar1).isPresent()){
            assertThat(superCar1.getSuperCarName()).isEqualTo("우르스");
        };

        entityManager.remove(superCar1);
    }
}

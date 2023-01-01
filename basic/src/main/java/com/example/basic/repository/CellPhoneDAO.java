package com.example.basic.repository;


import com.example.basic.domain.entity.CellPhone;
import com.example.basic.type.CellPhoneBrand;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class CellPhoneDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public CellPhone save(CellPhone cellPhone){
        entityManager.persist(cellPhone);
        return cellPhone;
    }

    public CellPhone findById(Long cellPhoneId){
        return entityManager.find(CellPhone.class,cellPhoneId);
    }

    public void delete(CellPhone cellPhone){
        entityManager.remove(cellPhone);
    }

    public List<CellPhone> findAll(){
        return entityManager.createQuery("select d from CellPhone d").getResultList();
    }

    public CellPhone findByVersion(String version){
        return entityManager.createQuery("select d from CellPhone d where d.cellPhoneVersion = :asdfasdfd",CellPhone.class)
                .setParameter("asdfasdfd",version).getSingleResult();
    }

    public CellPhone findByBrand(CellPhoneBrand cellPhoneBrand){
        return entityManager.createQuery("select d from CellPhone d where d.cellPhoneBrand = :brand",CellPhone.class)
                .setParameter("brand",cellPhoneBrand).getSingleResult();
    }

    public List<CellPhone> findByLocalDateTime(String date){
     return  entityManager.createQuery("select d from CellPhone d where function('to_char',d.cellPhoneReleaseDate,'yyyyMMdd')  = : date")
                .setParameter("date",date).getResultList();
    }




}

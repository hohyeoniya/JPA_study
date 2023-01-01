package com.example.basic.domain.entity;


import com.example.basic.type.CellPhoneBrand;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TBL_CELLPHONE")
@Getter
@Setter
@ToString
public class CellPhone {

    @Id @GeneratedValue
    @Column(name="CELLPHONE_ID")
    private Long cellPhoneId;
    @Enumerated(EnumType.STRING)
    @Column(name="CELLPHONE_BRAND")
    private CellPhoneBrand cellPhoneBrand;
    @Column(name="CELLPHONE_PRICE")
    private Integer cellPhonePrice;
    @Column(name="CELLPHONE_VERSION")
    private String cellPhoneVersion;
    @Column(name="CELLPHONE_RELEASE_DATE")
    private LocalDateTime cellPhoneReleaseDate;
}

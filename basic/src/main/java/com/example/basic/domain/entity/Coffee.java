package com.example.basic.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="TBL_COFFEE")
@Getter @Setter
@ToString
@NoArgsConstructor
public class Coffee {
    @Id @GeneratedValue
    @Column(name="COFFEE_NUMBER")
    private Long coffeeNumber;

    @Column(name="COFFEE_NAME")
    private String coffeeName;
    @Column(name="COFFEE_PRICE")
    private Long coffeePrice;
    @Column(name="COFFEE_RELEASE_DATE")
    private LocalDateTime coffeeReleaseDate;
    @Column(name="COFFEE_UPDATE_DATE")
    private LocalDateTime coffeeUpdateDate;

}

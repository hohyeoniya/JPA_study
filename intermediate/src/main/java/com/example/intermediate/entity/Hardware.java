package com.example.intermediate.entity;

import javax.persistence.Embeddable;




// 상속 관계가 아니다
// 각 필드만 개별적으로 사용되지 않고, 묶어서 한 번에 사용될 때 Embedded 방식을 사용한다.
// 만약 Embeddable에 선언된 필드를 통채로 자주 사용할 경우 Embedded방식으로 설계한다.
@Embeddable //모듈화
public class Hardware {
    private String computerRam;
    private String computerSSD;
    private String computerGPU;
    private String computerProcessor;

    public void create(String computerRam, String computerSSD, String computerGPU, String computerProcessor) {
        this.computerRam = computerRam;
        this.computerSSD = computerSSD;
        this.computerGPU = computerGPU;
        this.computerProcessor = computerProcessor;
    }
}

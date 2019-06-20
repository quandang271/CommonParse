package com.tima.model.insurance;

import lombok.Getter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@ToString
public class InsuranceHealthModel {
    private String birthDate;
    private String expiredDate;
    private String insuranceCode;
    private Timestamp lastUpdate;
    private String name;
    private String startDate;

    public InsuranceHealthModel(String jsonObject){

    }
}

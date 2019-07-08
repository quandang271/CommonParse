package com.tima.model.insurance;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@ToString
@AllArgsConstructor()
public class InsuranceHealthModel {
    private long birthDate;
    private String expiredDate;
    private String insuranceCode;
    private String lastUpdate;
    private String name;
    private String startDate;
}

package com.tima.model.insurance;

import lombok.Getter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@ToString
public class InsuranceSocialModel {
    private String insuranceCode;
    private String personalCode;
    private String name;

    private String gender;
    private String dateOfBirth;
    private String familyCode;
    private String address;
    private Timestamp lastUpdate;
}

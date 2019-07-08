package com.tima.model.insurance;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Getter
@ToString
@AllArgsConstructor()
public class InsuranceSocialModel {
    private String insuranceCode;
    private String personalCode;
    private String name;

    private String gender;
    private long dateOfBirth;
    private String familyCode;
    private String address;
    private String lastUpdate;

}

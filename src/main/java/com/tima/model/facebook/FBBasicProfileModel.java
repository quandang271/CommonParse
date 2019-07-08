package com.tima.model.facebook;

import com.tima.model.TimaBasicEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor()
public class FBBasicProfileModel {
    private Long birthdayDate;
    private String about;
    private String currentLocationCity;
    private String currentLocationCountry;
    private String currentLocationLatitude;
    private String currentLocationLocationId;
    private String currentLocationLongitude;
    private String currentLocationName;
    private String currentLocationState;
    private String currentLocationZip;
    private int friendCount;
    private String interests;
    private String name;
    private int notesCount;
    private String profileUpdateTime;
    private String relationshipStatus;
    private String sex;
    private String subscriberCount;
    private String thirdPartyId;
    private String timestamp;
    private long uid;
    private String username;
}

package com.tima.model.facebook;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class FBWorksModel {
    private long employerId;
    private String employerName;
    private long positionId;
    private String positionName;
    private Object startDate;
    private String timestamp;
    private long uid;

}

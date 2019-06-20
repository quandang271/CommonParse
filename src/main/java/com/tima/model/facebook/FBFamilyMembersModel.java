package com.tima.model.facebook;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class FBFamilyMembersModel {
    private long memberId;
    private String relationship;
    private String timestamp;
    private long uid;
}

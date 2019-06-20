package com.tima.model.facebook;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.tima.parse.TimaFacebookParseTool;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
public  class FBDetailsModel {
    public FBDetailsModel(){};

    @Getter(AccessLevel.NONE)
    protected TimaFacebookParseTool objectParseTool = TimaFacebookParseTool.getInstance();

    private FBBasicProfileModel basicProfile ;

    private List<FBWorksModel> works = new ArrayList<FBWorksModel>();

    private List<FBFamilyMembersModel> familyMembers = new ArrayList<FBFamilyMembersModel>();

    private List<FBEducationModel> education= new ArrayList<FBEducationModel>();

    private List<FBFriendsModel> friends = new ArrayList<FBFriendsModel>();

    private List<FBGroupsModel> groups= new ArrayList<FBGroupsModel>();

    private FBFeedBasicModel feedBasic;

    public FBDetailsModel(String jsonObject){
        loadModel(new JsonParser().parse(jsonObject).getAsJsonObject());
    }

    public FBDetailsModel(JsonObject jsonObject){
        loadModel(jsonObject);
    }

    private void loadModel(JsonObject jsonObject){
        if(jsonObject.has("basicProfile") && !jsonObject.get("basicProfile").isJsonNull())
            basicProfile = objectParseTool.parseBasicProfile(jsonObject.getAsJsonObject("basicProfile"));

        if(jsonObject.has("works") && !jsonObject.get("works").isJsonNull())
            works= objectParseTool.parseWorks(jsonObject.getAsJsonArray("works"));

        if(jsonObject.has("groups") && !jsonObject.get("groups").isJsonNull())
            groups = objectParseTool.parseGroups(jsonObject.getAsJsonArray("groups"));

        if(jsonObject.has("friends") && !jsonObject.get("friends").isJsonNull())
            friends = objectParseTool.parseFriends(jsonObject.getAsJsonArray("friends"));

        if(jsonObject.has("feedBasic") && !jsonObject.get("feedBasic").isJsonNull())
            feedBasic = objectParseTool.parseFeedBasic(jsonObject.getAsJsonObject("feedBasic"));

        if(jsonObject.has("familyMembers") && !jsonObject.get("familyMembers").isJsonNull())
            familyMembers = objectParseTool.parseFamilyMembers(jsonObject.getAsJsonArray("familyMembers"));

        if(jsonObject.has("education") && !jsonObject.get("education").isJsonNull())
            education = objectParseTool.parseEducations(jsonObject.getAsJsonArray("education"));

    }
}

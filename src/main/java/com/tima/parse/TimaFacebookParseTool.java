package com.tima.parse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.tima.config.Config;
import com.tima.model.TimaBasicEntity;
import com.tima.model.facebook.*;
import com.tima.model.insurance.InsuranceHealthResultModel;
import connection.Connect;
import jdk.nashorn.internal.runtime.ParserException;

import java.util.ArrayList;
import java.util.List;

public class TimaFacebookParseTool {

    private static TimaFacebookParseTool timaObjectParseTool;
    private static final List<FBGroupsModel> emptyListGroups= new ArrayList<FBGroupsModel>();

    public static TimaFacebookParseTool getInstance(){
        if(timaObjectParseTool==null)
            timaObjectParseTool = new TimaFacebookParseTool();
        return timaObjectParseTool;
    }

    private Gson gson = new Gson();


    // Basic Profile
    public FBBasicProfileModel parseBasicProfile(String jsonObject){
        return gson.fromJson(jsonObject, FBBasicProfileModel.class);
    }

    public FBBasicProfileModel parseBasicProfile(JsonObject jsonObject){
        return gson.fromJson(jsonObject, FBBasicProfileModel.class);
    }

    // Education
    public FBEducationModel parseEducation(String jsonObject){
        return gson.fromJson(jsonObject, FBEducationModel.class);
    }

    public FBEducationModel parseEducation(JsonObject jsonObject){
        return gson.fromJson(jsonObject, FBEducationModel.class);
    }

    public List<FBEducationModel> parseEducations(JsonArray arrEdus){
        return gson.fromJson(arrEdus,new TypeToken<ArrayList<FBEducationModel>>(){}.getType());
    }

    // FamilyMember
    public FBFamilyMembersModel parseFamilyMember(String jsonObject){
        return gson.fromJson(jsonObject, FBFamilyMembersModel.class);
    }

    public FBFamilyMembersModel parseFamilyMember(JsonObject jsonObject){
        return gson.fromJson(jsonObject, FBFamilyMembersModel.class);
    }

    public List<FBFamilyMembersModel> parseFamilyMembers(JsonArray arrMembers){
        return gson.fromJson(arrMembers,new TypeToken<ArrayList<FBFamilyMembersModel>>(){}.getType());
    }

    // FeedBasic
    public FBFeedBasicModel parseFeedBasic(String jsonObject){
        return gson.fromJson(jsonObject, FBFeedBasicModel.class);
    }

    public FBFeedBasicModel parseFeedBasic(JsonObject jsonObject){
        return gson.fromJson(jsonObject, FBFeedBasicModel.class);
    }

    // Friends
    public FBFriendsModel parseFriend(String jsonObject){
        return gson.fromJson(jsonObject, FBFriendsModel.class);
    }

    public FBFriendsModel parseFriend(JsonObject jsonObject){
        return gson.fromJson(jsonObject, FBFriendsModel.class);
    }

    public List<FBFriendsModel> parseFriends(JsonArray arrayFriends){
        return gson.fromJson(arrayFriends,new TypeToken<ArrayList<FBFriendsModel>>(){}.getType());
    }

    // Groups
    public FBGroupsModel parseGroups(String jsonObject){
        return gson.fromJson(jsonObject, FBGroupsModel.class);
    }

    public FBGroupsModel parseGroups(JsonObject jsonObject){
        return gson.fromJson(jsonObject, FBGroupsModel.class);
    }

    public List<FBGroupsModel> parseGroups(JsonArray arrayGroups){
        return (!arrayGroups.isJsonNull()) ? (List<FBGroupsModel>) gson.fromJson(arrayGroups, new TypeToken<ArrayList<FBGroupsModel>>() {}.getType()): emptyListGroups;
    }

    // Works
    public FBWorksModel parseWork(String jsonObject){
        return gson.fromJson(jsonObject, FBWorksModel.class);
    }

    public FBWorksModel parseWork(JsonObject jsonObject){
        return gson.fromJson(jsonObject, FBWorksModel.class);
    }

    public List<FBWorksModel> parseWorks(JsonArray arrayWorks){
        return gson.fromJson(arrayWorks, new TypeToken<ArrayList<FBWorksModel>>(){}.getType());
    }

    // Details
    public FBDetailsModel parseFacebookDetailsModel(String jsonObject){
        return new FBDetailsModel(jsonObject);
    }

    public FBDetailsModel parseFacebookDetailsModel(JsonObject jsonObject){
        return new FBDetailsModel(jsonObject);
    }

    // Result

    public FBResultModel parseFacebookResultModel(String jsonObject){
        return new FBResultModel(jsonObject);
    }

    public FBResultModel parseFacebookResultModel(JsonObject jsonObject) throws ParserException{
        try{
            if(jsonObject.get("responseCode").getAsInt()==0 && jsonObject.has("result") && !jsonObject.get("result").isJsonNull()){
                return new FBResultModel(jsonObject.getAsJsonObject("result"));
            }
        } catch (Exception e){
            throw new ParserException("Object format may be wrong. Cause: " + e.getMessage());
        }
        throw new ParserException("Object has reponse not success !");
    }

    public static void main(String[] args) {
        Connect connect = new Connect();
        String uid = "5208983341772692219";
        String token = Config.getInstance().getTokenFacebook();
        // uid = 100005568973407
        FBResultModel fb = connect.getFacebookModelInfo(uid,token);


        System.out.println(fb);

    }

}

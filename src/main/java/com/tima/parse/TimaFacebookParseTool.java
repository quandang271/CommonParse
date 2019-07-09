package com.tima.parse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
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
      //  return gson.fromJson(jsonObject, FBBasicProfileModel.class);
        JsonParser jsonParser= new JsonParser();
        return ObjectParseTool.getInstance().parseJsonObjectToFBBasicProfileModel((JsonObject) jsonParser.parse(jsonObject));
    }

    public FBBasicProfileModel parseBasicProfile(JsonObject jsonObject){
       // return gson.fromJson(jsonObject, FBBasicProfileModel.class);
        return ObjectParseTool.getInstance().parseJsonObjectToFBBasicProfileModel(jsonObject);
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

    public FBResultModel parseFacebookResultModel(String jsonObject) throws ParserException{
       // return parseFacebookResultModel(new JsonParser().parse(jsonObject).getAsJsonObject());
        return new FBResultModel(jsonObject);
    }

    public FBResultModel parseFacebookResultModel(JsonObject jsonObject) throws ParserException{
        new FBResultModel(jsonObject.getAsJsonObject("result"));
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
        String str = "{\n" +
                "  \"responseCode\": 0,\n" +
                "  \"mess\": \"Thành công\",\n" +
                "  \"result\": {\n" +
                "    \"uid\": \"100000916008785\",\n" +
                "    \"status\": \"DONE\",\n" +
                "    \"statusDes\": \"Thành công\",\n" +
                "    \"detail\": {\n" +
                "      \"basicProfile\": {\n" +
                "        \"about\": null,\n" +
                "        \"currentLocationCity\": null,\n" +
                "        \"currentLocationCountry\": null,\n" +
                "        \"currentLocationLatitude\": null,\n" +
                "        \"currentLocationLocationId\": null,\n" +
                "        \"currentLocationLongitude\": null,\n" +
                "        \"currentLocationName\": null,\n" +
                "        \"currentLocationState\": null,\n" +
                "        \"currentLocationZip\": null,\n" +
                "        \"friendCount\": 557,\n" +
                "        \"interests\": \"\",\n" +
                "        \"name\": \"�����t Luy���n\",\n" +
                "        \"notesCount\": 0,\n" +
                "        \"profileUpdateTime\": \"1552567206\",\n" +
                "        \"relationshipStatus\": \"\",\n" +
                "        \"sex\": \"male\",\n" +
                "        \"subscriberCount\": \"0\",\n" +
                "        \"thirdPartyId\": \"bbofFeJfsgC0xiRWUhWzGO43GFs\",\n" +
                "        \"timestamp\": \"1554516980370\",\n" +
                "        \"uid\": 100000916008785,\n" +
                "        \"username\": \"luthada\"\n" +
                "      },\n" +
                "      \"works\": null,\n" +
                "      \"familyMembers\": null,\n" +
                "      \"education\": null,\n" +
                "      \"friends\": null,\n" +
                "      \"groups\": null,\n" +
                "      \"feedBasic\": null\n" +
                "    }\n" +
                "  }\n" +
                "}";
//        Connect connect = new Connect();
//        String uid = "100000916008785";
//        String token = Config.getInstance().getTokenFacebook();
        // uid = 100005568973407
//        JsonObject jsonObject = connect.getFacebookJsonObjectInfo(uid,Config.getInstance().getTokenFacebook());
        FBResultModel fbResultModel = TimaFacebookParseTool.getInstance().parseFacebookResultModel(str);
        System.out.println(fbResultModel);
//        System.out.println(jsonObject.get("result"));
    }

}

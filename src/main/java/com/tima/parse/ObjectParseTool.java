package com.tima.parse;

import com.google.gson.*;
import com.tima.model.facebook.FBBasicProfileModel;
import com.tima.model.insurance.InsuranceHealthModel;
import com.tima.model.insurance.InsuranceSocialModel;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

public class ObjectParseTool {
    private static ObjectParseTool insuranceObjectParse;
    public static ObjectParseTool getInstance(){
        if(insuranceObjectParse == null)
            insuranceObjectParse = new ObjectParseTool();
        return insuranceObjectParse;
    }

    // Facebook -------------------
    public long covertStringDateFB(String strDate){
        Pattern patternMDY = Pattern.compile("\\d{1,2}[-|/]\\d{1,2}[-|/]\\d{4}");
        Pattern patternMD = Pattern.compile("\\d{1,2}[-|/]\\d{1,2}");

        try{
            if(patternMDY.matcher(strDate).matches() || patternMD.matcher(strDate).matches() && !strDate.toLowerCase().equals("null")) {

                DateFormat formatter ;
                if(patternMDY.matcher(strDate).matches()) {
                    formatter = new SimpleDateFormat("MM/dd/yyyy");
                }
                else
                {
                    formatter = new SimpleDateFormat("MM/dd");
                }

                Date date = formatter.parse(strDate);
                return date.getTime();

            }
            else{
                return new Long(0);
            }
        }
        catch (ParseException e){
            e.printStackTrace();
            return new Long(0);
        }
    }

    public FBBasicProfileModel parseJsonObjectToFBBasicProfileModel(JsonObject jsonObject){
        GsonBuilder gsonBuilder = new GsonBuilder();

// change serialization for specific types
        JsonDeserializer<FBBasicProfileModel> deserializer = new JsonDeserializer<FBBasicProfileModel>() {
            @Override
            public FBBasicProfileModel deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                //JsonObject jsonObject = json.getAsJsonObject();

                Long birthdayDate = (jsonObject.has("birthdayDate") && !jsonObject.get("birthdayDate").isJsonNull())
                        ? covertStringDateFB(jsonObject.get("birthdayDate").toString())
                        : 0;


                return new FBBasicProfileModel(
                        birthdayDate,
                        (jsonObject.has("about") && !jsonObject.get("about").isJsonNull()) ? jsonObject.get("about").toString():null,
                        (jsonObject.has("currentLocationCity") && !jsonObject.get("currentLocationCity").isJsonNull())?jsonObject.get("currentLocationCity").toString():null,
                        (jsonObject.has("currentLocationCountry") && !jsonObject.get("currentLocationCountry").isJsonNull())?jsonObject.get("currentLocationCountry").toString():null,
                        (jsonObject.has("currentLocationLatitude") && !jsonObject.get("currentLocationLatitude").isJsonNull())?jsonObject.get("currentLocationLatitude").toString():null,
                        (jsonObject.has("currentLocationLocationId") && !jsonObject.get("currentLocationLocationId").isJsonNull())?jsonObject.get("currentLocationLocationId").toString():null,
                        (jsonObject.has("currentLocationLongitude") && !jsonObject.get("currentLocationLongitude").isJsonNull())?jsonObject.get("currentLocationLongitude").toString():null,
                        (jsonObject.has("currentLocationName") && !jsonObject.get("currentLocationName").isJsonNull())?jsonObject.get("currentLocationName").toString():null,
                        (jsonObject.has("currentLocationState") && !jsonObject.get("currentLocationState").isJsonNull())?jsonObject.get("currentLocationState").toString():null,
                        (jsonObject.has("currentLocationZip") && !jsonObject.get("currentLocationZip").isJsonNull())?jsonObject.get("currentLocationZip").toString():null,
                        (jsonObject.has("friendCount") && !jsonObject.get("friendCount").isJsonNull())?jsonObject.get("friendCount").getAsInt():null,

                        (jsonObject.has("interests") && !jsonObject.get("interests").isJsonNull())?jsonObject.get("interests").toString():null,
                        (jsonObject.has("name") && !jsonObject.get("name").isJsonNull())?jsonObject.get("name").toString():null,
                        (jsonObject.has("notesCount") && !jsonObject.get("notesCount").isJsonNull())?jsonObject.get("notesCount").getAsInt():null,
                        (jsonObject.has("profileUpdateTime") && !jsonObject.get("profileUpdateTime").isJsonNull())?jsonObject.get("profileUpdateTime").toString():null,

                        (jsonObject.has("relationshipStatus") && !jsonObject.get("relationshipStatus").isJsonNull())?jsonObject.get("relationshipStatus").toString():null,
                        (jsonObject.has("sex") && !jsonObject.get("sex").isJsonNull())?jsonObject.get("sex").toString():null,
                        (jsonObject.has("subscriberCount") && !jsonObject.get("subscriberCount").isJsonNull())?jsonObject.get("subscriberCount").toString():null,
                        (jsonObject.has("thirdPartyId") && !jsonObject.get("thirdPartyId").isJsonNull())?jsonObject.get("thirdPartyId").toString():null,
                        (jsonObject.has("timestamp") && !jsonObject.get("timestamp").isJsonNull())?jsonObject.get("timestamp").toString():null,
                        (jsonObject.has("uid") && !jsonObject.get("uid").isJsonNull())?jsonObject.get("uid").getAsLong():null,
                        (jsonObject.has("username") && !jsonObject.get("username").isJsonNull())?jsonObject.get("username").toString():null
                );
            }
        };

        gsonBuilder.registerTypeAdapter(FBBasicProfileModel.class, deserializer);
        Gson customGson = gsonBuilder.create();
        return customGson.fromJson(jsonObject, FBBasicProfileModel.class);
    }


    // Insurance ----------------------
    private long covertStringDateInsurance(String strDate){
        try{
            if(!strDate.toLowerCase().equals("null")) {
                DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date date = formatter.parse(strDate);
            return date.getTime();
            }
            else{
                return new Long(0);
            }
        }
        catch (ParseException e){
            e.printStackTrace();
            return new Long(0);
        }
    }


    // Health
    public InsuranceHealthModel parseJsonObjectToInsuranceHealthModel(JsonObject jsonObject){
        GsonBuilder gsonBuilder = new GsonBuilder();

// change serialization for specific types
        JsonDeserializer<InsuranceHealthModel> deserializer = new JsonDeserializer<InsuranceHealthModel>() {
            @Override
            public InsuranceHealthModel deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
           //     JsonObject jsonObject = json.getAsJsonObject();

                Long birthDate = (jsonObject.has("about") && !jsonObject.get("about").isJsonNull()) ?covertStringDateInsurance(jsonObject.get("birthDate").getAsString()):0;


                return new InsuranceHealthModel(
                        birthDate,
                        jsonObject.get("expiredDate").toString(),
                        jsonObject.get("insuranceCode").toString(),
                        jsonObject.get("lastUpdate").toString(),
                        jsonObject.get("name").toString(),
                        jsonObject.get("startDate").toString()
                );
            }
        };

        gsonBuilder.registerTypeAdapter(InsuranceHealthModel.class, deserializer);
        Gson customGson = gsonBuilder.create();
        return customGson.fromJson(jsonObject, InsuranceHealthModel.class);
    }

    public List<InsuranceHealthModel> parseJsonArrayToInsuranceHealthModelArray(JsonArray jsonArray){
        List<InsuranceHealthModel> results = new ArrayList<InsuranceHealthModel>();
        for(JsonElement jsonElement:jsonArray){
            results.add(parseJsonObjectToInsuranceHealthModel(jsonElement.getAsJsonObject()));
        }
        return results;
    }

    // Social
    public InsuranceSocialModel parseJsonObjectToInsuranceSocialModel(JsonObject jsonObject){
        GsonBuilder gsonBuilder = new GsonBuilder();

// change serialization for specific types
        JsonDeserializer<InsuranceSocialModel> deserializer = new JsonDeserializer<InsuranceSocialModel>() {
            @Override
            public InsuranceSocialModel deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
               // JsonObject jsonObject = json.getAsJsonObject();

                Long dateOfBirth = new Long(
                        covertStringDateInsurance(jsonObject.get("dateOfBirth").getAsString())
                );


                return new InsuranceSocialModel(
                        jsonObject.get("insuranceCode").toString(),
                        jsonObject.get("personalCode").toString(),
                        jsonObject.get("name").toString(),
                        jsonObject.get("gender").toString(),
                        dateOfBirth,
                        jsonObject.get("familyCode").toString(),
                        jsonObject.get("address").toString(),
                        jsonObject.get("lastUpdate").toString()

                );
            }
        };

        gsonBuilder.registerTypeAdapter(InsuranceSocialModel.class, deserializer);
        Gson customGson = gsonBuilder.create();
        return customGson.fromJson(jsonObject, InsuranceSocialModel.class);
    }

    public List<InsuranceSocialModel> parseJsonArrayToInsuranceSocialModelArray(JsonArray jsonArray){
        List<InsuranceSocialModel> results = new ArrayList<InsuranceSocialModel>();
        for(JsonElement jsonElement:jsonArray){
            results.add(parseJsonObjectToInsuranceSocialModel(jsonElement.getAsJsonObject()));
        }
        return results;
    }
}

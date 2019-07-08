package com.tima.parse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.tima.model.insurance.*;
import connection.Connect;
import jdk.nashorn.internal.runtime.ParserException;

import java.util.List;

public class TimaInsuranceParseTool {

    private static TimaInsuranceParseTool timaInsuranceParseTool;
    public static TimaInsuranceParseTool getInstance(){
        if(timaInsuranceParseTool == null){
            timaInsuranceParseTool = new TimaInsuranceParseTool();
        }
        return timaInsuranceParseTool;
    }

    private Gson gson = new Gson();

    // Health
    public List<InsuranceHealthModel> parseListHealthModel(JsonArray jsonArray){
      //  return gson.fromJson(jsonArray,new TypeToken<ArrayList<InsuranceHealthModel>>(){}.getType());
        return ObjectParseTool.getInstance().parseJsonArrayToInsuranceHealthModelArray(jsonArray);
    }

    public InsuranceHealthResultModel parseHealthInsuranceResultFromRootObject(JsonObject jsonObject) throws ParserException{
        try
        {
            if(jsonObject.get("responseCode").getAsInt()==0 && jsonObject.has("result") && !jsonObject.get("result").isJsonNull()){
                jsonObject = jsonObject.getAsJsonObject("result");
                return new InsuranceHealthResultModel(jsonObject);
            }
        } catch (Exception e){
            throw new ParserException("Object format may be wrong. Cause: " + e.getMessage());
        }
        throw new ParserException("Object has reponse not success !");
    }

    // Social
    public List<InsuranceSocialModel> parseListSocialModel(JsonArray jsonArray){
     //   return gson.fromJson(jsonArray,new TypeToken<ArrayList<InsuranceSocialModel>>(){}.getType());
        return ObjectParseTool.getInstance().parseJsonArrayToInsuranceSocialModelArray(jsonArray);
    }


    public InsuranceSocialResultModel parseSocialInsuranceResultFromRootObject(JsonObject jsonObject) throws ParserException{
        try
        {
            if(jsonObject.get("responseCode").getAsInt()==0 && jsonObject.has("result") && !jsonObject.get("result").isJsonNull()){
            jsonObject = jsonObject.getAsJsonObject("result");
            return new InsuranceSocialResultModel(jsonObject);
        }
        } catch (Exception e){
            throw new ParserException("Object format may be wrong. Cause: " + e.getMessage());
        }
        throw new ParserException("Object has reponse not success !");
    }


    public static void main(String[] args) {
        Connect connect = new Connect();
//        JsonObject jsonObject = connect.getHealthInsuranceJsonObjectInfo("6372460565776449889");
//        InsuranceHealthResultModel insur = TimaInsuranceParseTool.getInstance().parseHealthInsuranceResultFromRootObject(jsonObject);
//        System.out.println(insur.getDetails().get(0));
        JsonObject jsonObject1 = connect.getSocialInsuranceJsonObjectInfo("5208983341772692219");
        InsuranceSocialResultModel insur1 = TimaInsuranceParseTool.getInstance().parseSocialInsuranceResultFromRootObject(jsonObject1);
        System.out.println(insur1.getDetails());
//        JsonArray jsonArray = jsonObject.get("result").getAsJsonObject().getAsJsonArray("details");
//        System.out.println(TimaInsuranceParseTool.getInstance().parseListSocialModel(jsonArray));

        // health 6372460565776449889
        JsonObject jsonObject2 = connect.getHealthInsuranceJsonObjectInfo("6372460565776449889");
        InsuranceHealthResultModel insur2 = TimaInsuranceParseTool.getInstance().parseHealthInsuranceResultFromRootObject(jsonObject2);
        System.out.println(insur2.getDetails());

    }
}

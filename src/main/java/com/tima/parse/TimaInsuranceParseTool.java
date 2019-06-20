package com.tima.parse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.tima.model.insurance.InsuranceHealthDetailModel;
import com.tima.model.insurance.InsuranceHealthModel;
import com.tima.model.insurance.InsuranceSocialDetailModel;
import com.tima.model.insurance.InsuranceSocialModel;
import connection.Connect;

import java.util.ArrayList;
import java.util.Comparator;
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
//    public InsuranceHealthModel parseHealthInsuranceModel(String jsonObject){
//        return gson.fromJson(jsonObject,InsuranceHealthModel.class);
//    }
//    public InsuranceHealthModel parseHealthInsuranceModel(JsonObject jsonObject){
//        return gson.fromJson(jsonObject,InsuranceHealthModel.class);
//    }
    public ArrayList<InsuranceHealthModel> parseHealthInsuranceModel(JsonArray jsonArray){
        return gson.fromJson(jsonArray,new TypeToken<ArrayList<InsuranceHealthModel>>(){}.getType());
    }


    public ArrayList<InsuranceSocialModel> parseSocialInsuranceModel(JsonArray jsonArray){
        return gson.fromJson(jsonArray,new TypeToken<ArrayList<InsuranceSocialModel>>(){}.getType());
    }

    public InsuranceHealthDetailModel parseHealthDetailInsuranceModel(JsonArray jsonArray){
        return new InsuranceHealthDetailModel(jsonArray);
    }

    public InsuranceSocialDetailModel parseSocialDetailInsuranceModel(JsonArray jsonArray){
        return new InsuranceSocialDetailModel(jsonArray);
    }




    public static void main(String[] args) {
        Connect connect = new Connect();

//        JsonArray jsonArray = connect.getHealthInsuranceJsonObjectInfo("").getAsJsonObject("result").getAsJsonArray("details");
//        InsuranceHealthDetailModel insur = TimaInsuranceParseTool.getInstance().parseHealthDetailInsuranceModel(jsonArray);
//        System.out.println(insur);
        JsonArray jsonArray = connect.getSocialInsuranceJsonOnjectInfo("").getAsJsonObject("result").getAsJsonArray("details");
        InsuranceSocialDetailModel insur = TimaInsuranceParseTool.getInstance().parseSocialDetailInsuranceModel(jsonArray);
        System.out.println(insur);

    }
}

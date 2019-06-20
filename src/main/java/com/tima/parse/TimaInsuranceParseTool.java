package com.tima.parse;

import com.google.gson.JsonArray;
import com.tima.model.insurance.InsuranceHealthDetails;
import com.tima.model.insurance.InsuranceHealthModel;
import com.tima.model.insurance.InsuranceSocialDetails;
import connection.Connect;

public class TimaInsuranceParseTool {
    private static TimaInsuranceParseTool timaInsuranceParseTool;
    public static TimaInsuranceParseTool getInstance(){
        if(timaInsuranceParseTool == null){
            timaInsuranceParseTool = new TimaInsuranceParseTool();
        }
        return timaInsuranceParseTool;
    }

    public InsuranceHealthDetails parseHealthInsuranceDetails(JsonArray jsonArray){
        return new InsuranceHealthDetails(jsonArray);
    }

    public InsuranceSocialDetails parseSocialInsuranceDetails(JsonArray jsonArray){
        return new InsuranceSocialDetails(jsonArray);
    }




    public static void main(String[] args) {
        Connect connect = new Connect();
        JsonArray jsonArray = connect.getHealthInsuranceJsonObjectInfo("").getAsJsonObject("result").getAsJsonArray("details");
        InsuranceHealthDetails insur = TimaInsuranceParseTool.getInstance().parseHealthInsuranceDetails(jsonArray);
        System.out.println(insur);

    }
}

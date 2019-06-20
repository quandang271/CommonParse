package com.tima.model.insurance;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.tima.parse.TimaInsuranceParseTool;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;

@ToString
@Getter
public class InsuranceHealthDetailModel {
    private ArrayList<InsuranceHealthModel> insuranceHealthDetails = new ArrayList<InsuranceHealthModel>();

    public InsuranceHealthDetailModel(JsonArray jsonArray){
        insuranceHealthDetails = TimaInsuranceParseTool.getInstance().parseHealthInsuranceModel(jsonArray);
    }
}

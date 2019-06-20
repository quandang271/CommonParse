package com.tima.model.insurance;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import com.tima.parse.TimaInsuranceParseTool;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;

@ToString
@Getter
public class InsuranceSocialDetails {
    private ArrayList<InsuranceSocialModel> insuranceSocialDetails = new ArrayList<InsuranceSocialModel>();

    public InsuranceSocialDetails(JsonArray jsonArray){
        Gson gson = new Gson();
        insuranceSocialDetails = gson.fromJson(jsonArray,new TypeToken<ArrayList<InsuranceSocialModel>>(){}.getType());
    }
}

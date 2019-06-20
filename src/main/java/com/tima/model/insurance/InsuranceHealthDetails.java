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
public class InsuranceHealthDetails {
    private ArrayList<InsuranceHealthModel> insuranceHealthDetails = new ArrayList<InsuranceHealthModel>();

    public InsuranceHealthDetails(JsonArray jsonArray){
        Gson gson = new Gson();
        insuranceHealthDetails = gson.fromJson(jsonArray,new TypeToken<ArrayList<InsuranceHealthModel>>(){}.getType());
    }
}

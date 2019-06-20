package com.tima.model.insurance;

import com.google.gson.JsonArray;
import com.tima.parse.TimaInsuranceParseTool;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;

@ToString
@Getter
public class InsuranceSocialDetailModel {
    private ArrayList<InsuranceSocialModel> insuranceSocialDetails = new ArrayList<InsuranceSocialModel>();

    public InsuranceSocialDetailModel(JsonArray jsonArray){
        insuranceSocialDetails = TimaInsuranceParseTool.getInstance().parseSocialInsuranceModel(jsonArray);
    }
}

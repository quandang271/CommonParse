package com.tima.model.insurance;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.tima.parse.TimaInsuranceParseTool;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class InsuranceSocialResultModel {
    private List<InsuranceSocialModel> details;
    private String referenceCode ="";
    private String status = "";
    private String statusDes = "";

    public InsuranceSocialResultModel(JsonObject jsonObject) {
        loadModel(jsonObject);
    }

    @Getter(AccessLevel.NONE)
    private TimaInsuranceParseTool parseTool = TimaInsuranceParseTool.getInstance();


    private void loadModel(JsonObject jsonObject){
        if(jsonObject.has("details") && !(jsonObject.get("details").isJsonNull())){
            details = parseTool.parseListSocialModel(jsonObject.getAsJsonArray("details"));
        }

        if(jsonObject.has("referenceCode") && !(jsonObject.get("referenceCode").isJsonNull())){
            referenceCode = jsonObject.get("referenceCode").getAsString();
        }

        if(jsonObject.has("status") && !(jsonObject.get("status").isJsonNull())){
            status = jsonObject.get("status").getAsString();
        }
        if(jsonObject.has("statusDes") && !(jsonObject.get("statusDes").isJsonNull())){
            statusDes = jsonObject.get("statusDes").getAsString();
        }
    }
}

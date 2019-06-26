package com.tima.model.insurance;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.tima.model.TimaBasicEntity;
import com.tima.parse.TimaInsuranceParseTool;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class InsuranceHealthResultModel extends TimaBasicEntity {
    private List<InsuranceHealthModel> details;
    private String referenceCode ="";
    private String status = "";
    private String statusDes = "";

    public InsuranceHealthResultModel(JsonObject jsonObject) {
        loadModel(jsonObject);
    }

    @Getter(AccessLevel.NONE)
    private TimaInsuranceParseTool parseTool = TimaInsuranceParseTool.getInstance();

    private void loadModel(JsonObject jsonObject){
        if(jsonObject.has("details") && !(jsonObject.get("details").isJsonNull())){
            details = parseTool.parseListHealthModel(jsonObject.getAsJsonArray("details"));
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

    public  boolean isDone(){
        return "DONE".equals(status);
    }
}

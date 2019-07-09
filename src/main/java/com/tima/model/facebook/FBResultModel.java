package com.tima.model.facebook;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.tima.model.TimaBasicEntity;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class FBResultModel extends TimaBasicEntity {
    private String uid = "";
    private String status = "";
    private String statusDes = "";
    FBDetailsModel fbDetailsModel;

    public FBResultModel(String jsonObject){
      //  loadModel(new JsonParser().parse(jsonObject).getAsJsonObject());
        loadModel(new JsonParser().parse(jsonObject).getAsJsonObject());
    }

    public FBResultModel(JsonObject jsonObject){
        loadModel(jsonObject);
    }

    private void loadModel(JsonObject jsonObject){

        if(jsonObject.has("detail") && !(jsonObject.get("detail").isJsonNull())) {
            fbDetailsModel = new FBDetailsModel(jsonObject.getAsJsonObject("detail"));
        }

        if (jsonObject.has("uid") && !(jsonObject.get("uid").isJsonNull())) {
            uid =  jsonObject.get("uid").getAsString();
        }
        if (jsonObject.has("status") && !(jsonObject.get("status").isJsonNull())) {
            status =  jsonObject.get("status").getAsString();
        }
        if (jsonObject.has("statusDes") && !(jsonObject.get("statusDes").isJsonNull())) {
            statusDes =  jsonObject.get("statusDes").getAsString();
        }

    }
    public  boolean isDone(){
        return "DONE".equals(status);
    }
}

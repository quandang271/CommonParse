package connection;


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.tima.config.Config;
import com.tima.model.facebook.FBResultModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Connect {
    public String getFacebookInfo(String uid,String token) {
        try {
            URL url = new URL(Config.getInstance().getURLFacebook(uid));
            System.out.println(url);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Authorization", token);
            return getContent(con);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public String getFacebookInfo(String uid){
        //read token from config
        return getFacebookInfo(uid, Config.getInstance().getTokenFacebook());
    }

    public JsonObject getFacebookJsonObjectInfo(String uid,String token){
        return new JsonParser().parse(getFacebookInfo(uid,token)).getAsJsonObject();
    }
    public FBResultModel getFacebookModelInfo(String uid, String token){
        return new FBResultModel(new JsonParser().parse(getFacebookInfo(uid,token)).getAsJsonObject()) ;
    }

    public String getHealthInsuranceInfo(String uid){
        try {
            URL url = new URL(Config.getInstance().getURLHealthInsurance(uid));
            System.out.println(url);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");
            return getContent(con);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public JsonObject getHealthInsuranceJsonObjectInfo(String uid){
        return new JsonParser().parse(getHealthInsuranceInfo(uid)).getAsJsonObject();
    }

    public String getSocialInsuranceInfo(String uid){
        try {
            URL url = new URL(Config.getInstance().getURLSocialInsurance(uid));
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");
            return getContent(con);

        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public JsonObject getSocialInsuranceJsonOnjectInfo(String uid){
        return new JsonParser().parse(getSocialInsuranceInfo(uid)).getAsJsonObject();
    }

    private String getContent(HttpURLConnection con) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        con.disconnect();
        return content.toString();
    }

    public static void main(String[] args) {
        Connect c = new Connect();
        System.out.println(c.getSocialInsuranceJsonOnjectInfo("").getAsJsonObject("result").getAsJsonArray("details"));
        System.out.println(c.getFacebookInfo("5208983341772692219",Config.getInstance().getTokenFacebook()));
     }
}

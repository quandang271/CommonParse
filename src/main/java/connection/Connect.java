package connection;


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Iterator;

public class Connect {
    public String getFacebookInfo(String uid) {
        try {
            URL url = new URL("http://172.16.10.111:8082/facebook-information/"+uid+"?fields=basic_profile,posts,works,family,friends");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtZWNhc2giLCJhdXRob3JpdGllcyI6WyJST0xFX0ZBQ0VCT09LX0lORk8iXSwiaWF0IjoxNTYwMzIzODMyLCJleHAiOjE1NjI5MTU4MzJ9.WSSv2CXL27CbqLtPy6xnyo39M8zsQaluIcE4NRaIHQCtXxClVJxY_nIc1iEyc3iCj-vURCipF4iETzKED95xjQ");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            con.disconnect();
            return content.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
    public JsonObject getFacebookJsonObjectInfo(String uid){
        return new JsonParser().parse(getFacebookInfo(uid)).getAsJsonObject();
    }

    public String getHealthInsuranceInfo(String uid){
        try {
            URL url = new URL("http://103.9.79.172:9091/health-insurance/6372460565776449889\n");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");
           // con.setRequestProperty("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtZWNhc2giLCJhdXRob3JpdGllcyI6WyJST0xFX0ZBQ0VCT09LX0lORk8iXSwiaWF0IjoxNTYwMzIzODMyLCJleHAiOjE1NjI5MTU4MzJ9.WSSv2CXL27CbqLtPy6xnyo39M8zsQaluIcE4NRaIHQCtXxClVJxY_nIc1iEyc3iCj-vURCipF4iETzKED95xjQ");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            con.disconnect();
            return content.toString();

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
            URL url = new URL("http://103.9.79.172:9091/social-insurance/5208983341772692219\n");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");
            // con.setRequestProperty("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtZWNhc2giLCJhdXRob3JpdGllcyI6WyJST0xFX0ZBQ0VCT09LX0lORk8iXSwiaWF0IjoxNTYwMzIzODMyLCJleHAiOjE1NjI5MTU4MzJ9.WSSv2CXL27CbqLtPy6xnyo39M8zsQaluIcE4NRaIHQCtXxClVJxY_nIc1iEyc3iCj-vURCipF4iETzKED95xjQ");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            con.disconnect();
            return content.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public JsonObject getSocialInsuranceJsonOnjectInfo(String uid){
        return new JsonParser().parse(getSocialInsuranceInfo(uid)).getAsJsonObject();
    }

    public static void main(String[] args) {
        Connect c = new Connect();
        System.out.println(c.getSocialInsuranceJsonOnjectInfo("").getAsJsonObject("result").getAsJsonArray("details"));
    }
}

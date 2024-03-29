package com.tima.config;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Config {
    private static Config config;

    private static String pathFileConfig = "common-model-config.properties";

    public static void setPathFileConfig(String pathFileConfig){
        Config.pathFileConfig = pathFileConfig;
    }

    public static Config getInstance(){
        if(config == null){
            config = new Config(pathFileConfig);
        }
        return config;
    }

    public Config(String pathFileConfig){
        try {
            properties.load(new FileReader(pathFileConfig));
            if(properties.containsKey("com.tima.common.facebook-crawl.url"))
                urlFacebook=properties.getProperty("com.tima.common.facebook-crawl.url");
            if(properties.containsKey("com.tima.common.healthinsurance-crawl.url"))
                urlHealthInsurance=properties.getProperty("com.tima.common.healthinsurance-crawl.url");
            if(properties.containsKey("com.tima.common.socialinsurance-crawl.url"))
                urlSocialInsurance=properties.getProperty("com.tima.common.socialinsurance-crawl.url");
            if(properties.containsKey("com.tima.common.facebook-crawl.token"))
                tokenFacebook=properties.getProperty("com.tima.common.facebook-crawl.token");
            if(properties.containsKey("com.tima.common.healthinsurance-crawl.token"))
                tokenHealthInsurance=properties.getProperty("com.tima.common.healthinsurance-crawl.token");
            if(properties.containsKey("com.tima.common.socialinsurance-crawl.token"))
                tokenSocialInsurance=properties.getProperty("com.tima.common.socialinsurance-crawl.token");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Properties properties = new Properties();
    private String urlFacebook="http://172.16.10.111:8082/facebook-information/";
    private String urlHealthInsurance;
    private String urlSocialInsurance;
    private String tokenFacebook;
    private String tokenHealthInsurance;
    private String tokenSocialInsurance;


    //  public String getURLFacebook(String uid, String[] listData){
    public String getURLFacebook(String uid, String params){

        return urlFacebook+uid+"?fields="+params;
    }

    public String getURLFacebook(String uid){
        return getURLFacebook(uid, "basic_profile,posts,works,family,friends");
    }

    public String getTokenFacebook(){
        return tokenFacebook;
    }




    public String getURLHealthInsurance(String uid){
        // 6372460565776449889
        return urlHealthInsurance+uid+"\n";
    }

    public String getURLSocialInsurance(String uid){
        // 5208983341772692219
        return urlSocialInsurance+uid+"\n";
    }

    public void setpathFileConfig(String url){
        this.pathFileConfig = url;
    }

    //token "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtZWNhc2giLCJhdXRob3JpdGllcyI6WyJST0xFX0ZBQ0VCT09LX0lORk8iXSwiaWF0IjoxNTYwMzIzODMyLCJleHAiOjE1NjI5MTU4MzJ9.WSSv2CXL27CbqLtPy6xnyo39M8zsQaluIcE4NRaIHQCtXxClVJxY_nIc1iEyc3iCj-vURCipF4iETzKED95xjQ"

    public static void main(String[] args) {
        Config config = Config.getInstance();
        System.out.println(config.getURLFacebook("4927346249"));
    }
}

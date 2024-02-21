package be.helmo.reseau.analyzer;

import be.helmo.reseau.interfaces.IBuilder;

import java.util.Set;

import static be.helmo.reseau.analyzer.Analyzer.*;

public class Builder implements IBuilder {

    public final static String space = " ";
    //public final static String newmon = "NEWMON" +;

    //public final static String Lis


    public String NewmonCreation(String augmentedUrl){
        return "Newmon" + space + augmentedUrl + CRLF_REGEX;
    }
    private String augmentedUrlCreation(String id, String url, String min, String max){
        return id + "!" + url + "!" + min + "!" + max;
    }

    public String newmon_respCreation(String message, boolean ajoutOk){
        if(ajoutOk == true){
            return "+OK" + space + message;
        }
        else{
            return "-ERR" + space + message;
        }
    }
    public String listmonCreation(){
        return "LISTMON" + CRLF_REGEX;
    }
    public String monCreation(Set<String> idList){
        String allId = "";
        for (String id : idList){
            allId += id + space;
        }
        return "MON" + space + allId + CRLF_REGEX;
    }
}

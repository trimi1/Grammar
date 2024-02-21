package be.helmo.reseau.analyzer;

import be.helmo.reseau.interfaces.IBuilder;

import java.util.Set;
import java.util.regex.Pattern;

import static be.helmo.reseau.analyzer.Analyzer.*;

public class Builder implements IBuilder {

    public final static String space = " ";
    public final static String newmon = "NEWMON <AugmentedUrl> \\n";
    public final static String newmon_resp = "<etat> \\n <message> \\n";
    public final static String listmon = "LISTMON \\n";
    public final static String mon = "MON <id> \\n";
    public final static String request = "REQUEST <id> \\n";
    public final static String respond = "RESPOND <id> <url> <state> \\n";

    public String NewmonCreation(String id, String url, String min, String max){
        newmon.replace("<AugmentedUrl>", augmentedUrlCreation(id, url, min, max);
        return newmon;
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

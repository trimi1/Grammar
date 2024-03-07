package be.helmo.reseau.builder;

import be.helmo.reseau.interfaces.IBuilder;

import java.util.List;

public class Builder implements IBuilder {
    /*
    For monitor to probe
     */
    public final static String SETUP = "SETUP <frequency>\n\n";
    public final static String STATUSOF = "STATUSOF <id>\n\n";
    public final static String STATUS = "STATUS <id> <state>\n\n";

    /*
    For probe to monitor
     */
    public final static String PROBE = "PROBE <protocol> <port>\n\n";
    public final static String DATA = "DATA <protocol> <port>\n\n";

    /*
    For Client to Monitor
     */
    public final static String NEWMON = "NEWMON <augmented_url>\n\n";
    public final static String NEWMON_RESPOK = "+OK <message>\n\n";
    public final static String NEWMON_RESPERR = "-ERR <message>\n\n";
    public final static String LISTMON = "LISTMON\n\n";
    public final static String MON = "MON <id>\n\n";
    public final static String REQUEST = "REQUEST <id>\n\n";
    public final static String RESPOND = "RESPOND <id> <url> <state>\n\n";



    /*
    Utils
     */
    private String replacePlaceholder(String template, String placeholder, String value) {
        return template.replace("<" + placeholder + ">", value);
    }

    /*
    From monitor to probe
     */
    public String buildSetup(int frequency, List<String> augmentedUrl) {
        StringBuilder s = new StringBuilder(this.replacePlaceholder(SETUP, "frequency", String.valueOf(frequency)));
        for (String a : augmentedUrl) {
            s.append(" ").append(a);
        }
        return s.toString();
    }

    public String buildStatusOf(int id) {
        return this.replacePlaceholder(STATUSOF, "id", String.valueOf(id));
    }

    public String buildStatus(int id, String state) {
        return this.replacePlaceholder(this.replacePlaceholder(STATUS, "id", String.valueOf(id)), "state", state);
    }

    /*
    From probe to monitor
     */
    public String buildProbe(String protocol, int port) {
        return this.replacePlaceholder(this.replacePlaceholder(PROBE, "protocol", protocol), "port", String.valueOf(port));
    }

    public String buildData(String protocol, int port) {
        return this.replacePlaceholder(this.replacePlaceholder(DATA, "protocol", protocol), "port", String.valueOf(port));
    }

    public String buildNewmon(String augmentedUrl){
        return this.replacePlaceholder(NEWMON,"augmented_url",augmentedUrl);
    }
    public String buildNewmonRespOk(String message){
        return this.replacePlaceholder(NEWMON_RESPOK,"message",message);
    }
 public String buildNewmonRespErr(String message){
        return this.replacePlaceholder(NEWMON_RESPERR,"message",message);
    }
public String buildNewmonListmon(String message){
        return LISTMON;
    }
public String buildMon(List<Integer> id){
    return this.replacePlaceholder(MON,"id",id);


    }

}

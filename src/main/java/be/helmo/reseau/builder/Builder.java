package be.helmo.reseau.builder;

import java.util.List;

public class Builder {
    /*
    For monitor to probe
     */
    public final static String SETUP = "SETUP <frequency>\n\n";
    public final static String STATUSOF = "STATUSOF <id>\n\n";

    /*
    For probe to monitor
     */
    public final static String PROBE = "PROBE <protocol> <port>\n\n";
    public final static String DATA = "DATA <protocol> <port>\n\n";
    public final static String STATUS = "STATUS <id> <state>\n\n";

    /*
    For Client to Monitor
     */
    public final static String NEWMON = "NEWMON <augmented_url>\n\n";

    public final static String LISTMON = "LISTMON\n\n";
    public final static String REQUEST = "REQUEST <id>\n\n";

    /*
    For Monitor to Client
     */
    public final static String NEWMON_RESPOK = "+OK <message>\n\n";
    public final static String NEWMON_RESPERR = "-ERR <message>\n\n";
    public final static String MON = "MON <id>\n\n";
    public final static String RESPOND = "RESPOND <id> <url> <state>\n\n";

    /*
  Utils
   */
    private static String replacePlaceholder(String template, String placeholder, String value) {
        return template.replace("<" + placeholder + ">", value);
    }

    /*
    For Monitor to Client
     */

    public static String buildNewMonRespOk(String message) {
        return replacePlaceholder(NEWMON_RESPOK, "message", message);

    }

    public static String buildNewMonRespErr(String message) {
        return replacePlaceholder(NEWMON_RESPERR, "message", message);
    }

    public static String buildMon(String id) {
        return replacePlaceholder(MON, "id", id);
    }

    public static String buildRespond(String id, String url, String state) {
        return replacePlaceholder(replacePlaceholder(replacePlaceholder(RESPOND, "id", id), "url", url), "state", state);
    }

    /*
    From monitor to probe
     */
    public static String buildSetup(int frequency, List<String> augmentedUrl) {
        StringBuilder s = new StringBuilder(replacePlaceholder(SETUP, "frequency", String.valueOf(frequency)));
        for (String a : augmentedUrl) {
            s.append(" ").append(a);
        }
        return s.toString();
    }

    public static String buildStatusOf(String id) {
        return replacePlaceholder(STATUSOF, "id", id);
    }

    /*
    From probe to monitor
     */
    public static String buildProbe(String protocol, int port) {
        return replacePlaceholder(replacePlaceholder(PROBE, "protocol ", protocol), "port", String.valueOf(port));
    }

    public static String buildData(String protocol, int port) {
        return replacePlaceholder(replacePlaceholder(DATA, "protocol ", protocol), "port", String.valueOf(port));
    }

    public static String buildStatus(String id, String state) {
        return replacePlaceholder(replacePlaceholder(STATUS, "id", id), "state", state);
    }
}

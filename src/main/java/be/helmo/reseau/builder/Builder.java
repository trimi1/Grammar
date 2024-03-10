package be.helmo.reseau.builder;

import java.util.List;

public class Builder {
    /*
    For monitor to probe
     */
    private final static String SETUP = "SETUP <frequency>";
    public final static String STATUSOF = "STATUSOF <id>\r\n";

    /*
    For probe to monitor
     */
    private final static String PROBE = "PROBE <protocol> <port>\r\n";
    private final static String DATA = "DATA <protocol> <port>\r\n";
    private final static String STATUS = "STATUS <id> <state>\r\n";

    /*
    For Client to Monitor
     */
    private final static String NEWMON = "NEWMON <augmented_url>\r\n";
    private final static String LISTMON = "LISTMON\r\n";
    private final static String REQUEST = "REQUEST <id>\r\n";

    /*
    For Monitor to Client
     */
    private final static String NEWMON_RESPOK = "+OK <message>\r\n";
    private final static String NEWMON_RESPERR = "-ERR <message>\r\n";
    private final static String MON = "MON";
    private final static String RESPOND = "RESPOND <id> <url> <state>\r\n";

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

    public static String buildMon(List<String> ids) {
        StringBuilder s = new StringBuilder(MON);
        for (String id : ids) {
            s.append(" ").append(id);
        }
        s.append("\r\n");
        return s.toString();
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
            if (!a.isEmpty()) {
                s.append(" ").append(a);
            }
        }
        s.append("\r\n");
        return s.toString();
    }

    public static String buildStatusOf(String id) {
        return replacePlaceholder(STATUSOF, "id", id);
    }

    /*
    From probe to monitor
     */
    public static String buildProbe(String protocol, int port) {
        return replacePlaceholder(replacePlaceholder(PROBE, "protocol", protocol), "port", String.valueOf(port));
    }

    public static String buildData(String protocol, int port) {
        return replacePlaceholder(replacePlaceholder(DATA, "protocol", protocol), "port", String.valueOf(port));
    }

    public static String buildStatus(String id, String state) {
        return replacePlaceholder(replacePlaceholder(STATUS, "id", id), "state", state);
    }
}

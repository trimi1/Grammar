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
    Utils
     */
    private static String replacePlaceholder(String template, String placeholder, String value) {
        return template.replace("<" + placeholder + ">", value);
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

    public static String buildStatus(String id, String state) {
        return replacePlaceholder(replacePlaceholder(STATUS, "id", id), "state", state);
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
}

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

<<<<<<< HEAD
    public String buildStatusOf(String id) {
        return this.replacePlaceholder(STATUSOF, "id", String.valueOf(id));
    }

    public String buildStatus(String id, String state) {
        return this.replacePlaceholder(this.replacePlaceholder(STATUS, "id", id), "state", state);
    }
=======
    public static String buildStatusOf(int id) {
        return replacePlaceholder(STATUSOF, "id", String.valueOf(id));
    }

>>>>>>> 2775c4a4f94be4d82b57687650f1854abad3e1e9

    /*
    From probe to monitor
     */
<<<<<<< HEAD
    public String buildProbe(String protocol, int port) {
        return this.replacePlaceholder(this.replacePlaceholder(PROBE, "protocol", protocol), "port", String.valueOf(port));
    }

    public String buildData(String protocol, int port) {
        return this.replacePlaceholder(this.replacePlaceholder(DATA, "protocol", protocol), "port", String.valueOf(port));
=======
    public static String buildProbe(String protocol, int port) {
        return replacePlaceholder(replacePlaceholder(PROBE, "protocol ", protocol), "port", String.valueOf(port));
    }

    public static String buildData(String protocol, int port) {
        return replacePlaceholder(replacePlaceholder(DATA, "protocol ", protocol), "port", String.valueOf(port));
>>>>>>> 2775c4a4f94be4d82b57687650f1854abad3e1e9
    }
}

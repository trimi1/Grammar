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

    public String buildStatusOf(String id) {
        return this.replacePlaceholder(STATUSOF, "id", String.valueOf(id));
    }

    public String buildStatus(String id, String state) {
        return this.replacePlaceholder(this.replacePlaceholder(STATUS, "id", id), "state", state);
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
}

package be.helmo.reseau.interfaces;

import java.util.List;

public interface IBuilder {
    String buildSetup(int frequency, List<String> augmentedUrl);
    String buildStatusOf(int id);
    String buildProbe(String protocol, int port);
    String buildData(String protocol, int port);
}

package be.helmo.reseau.interfaces;

import java.util.List;

public interface IBuilder {
    String buildSetup(int frequency, List<String> augmentedUrl);
<<<<<<< HEAD
    String buildStatusOf(String id);
    String buildStatus(String id, String state);
=======
    String buildStatusOf(int id);
>>>>>>> 2775c4a4f94be4d82b57687650f1854abad3e1e9
    String buildProbe(String protocol, int port);
    String buildData(String protocol, int port);
}

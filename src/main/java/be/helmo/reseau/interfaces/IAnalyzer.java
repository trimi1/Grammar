package be.helmo.reseau.interfaces;

import java.util.Map;
import java.util.Optional;

public interface IAnalyzer {
    Map<String, String> getGroups(String receivedMessage);
}
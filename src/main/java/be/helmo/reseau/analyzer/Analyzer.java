package be.helmo.reseau.analyzer;

import be.helmo.reseau.interfaces.IAnalyzer;

public class Analyzer implements IAnalyzer {
    public static String LETTER_REGEX = "[A-Za-z]";
    public static String DIGIT_REGEX = "[0-9]";
    public static String LETTER_DIGIT_REGEX = LETTER_REGEX + "|" + DIGIT_REGEX;
    public static String CRLF_REGEX = "\r\n";
    public static String PORT_REGEX = "\\d{1,5}";
    public static String HOST_REGEX = "(?:(?:\\w{3,50}|\\.|-|)+)";
    public static String PATH_REGEX = "/[\\w./_-]{0,100}";

}

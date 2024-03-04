package be.helmo.reseau.analyzer;

import be.helmo.reseau.interfaces.IAnalyzer;

import java.util.List;

public class Analyzer implements IAnalyzer {
    /*
    Standard definitions
     */
    private static final String LETTER_REGEX = "[A-Za-z]";
    private static final String DIGIT_REGEX = "[0-9]";
    private static final String LETTER_DIGIT_REGEX = "(" + LETTER_REGEX + "|" + DIGIT_REGEX + ")";
    private static final String CRLF_REGEX = "\r\n";
    private static final String PORT_REGEX = DIGIT_REGEX + "{1,5}";
    private static final String CHARACTER_REGEX = "[\\x20-\\xFF]";
    private static final String CHARACTER_SPEC_REGEX = "[-_=./+*$°()\\[\\]{}^]";
    private static final String CHARACTER_PASS_REGEX = "(" + LETTER_DIGIT_REGEX + "|" + CHARACTER_SPEC_REGEX + ")";
    private static final String SP_REGEX = "\\x20";
    private static final String ID_REGEX = LETTER_DIGIT_REGEX + "{5,10}";
    private static final String PROTOCOL_REGEX = LETTER_DIGIT_REGEX + "{3,15}";
    private static final String USERNAME_REGEX = LETTER_DIGIT_REGEX + "{3,50}";
    private static final String PASSWORD_REGEX = CHARACTER_PASS_REGEX + "{3,50}";
    private static final String AUTHENTICATION_REGEX = CHARACTER_PASS_REGEX + "{3,50}";
    private static final String PASSWORD_AUTH_REGEX = PASSWORD_REGEX + "(#" + AUTHENTICATION_REGEX + ")?";
    private static final String HOST_REGEX = "(" + LETTER_DIGIT_REGEX + "|" + "\\." + "|" + "_" + "|" + "-" + ")" + "{3,50}";
    private static final String PATH_REGEX = "/(" + LETTER_DIGIT_REGEX + "|[.\\-_]){0,100}";
    private static final String URL_REGEX = PROTOCOL_REGEX + "://(" + USERNAME_REGEX + "(:"
            + PASSWORD_AUTH_REGEX + ")?@)?" + HOST_REGEX + "(" + PORT_REGEX + ")?" + PATH_REGEX;
    private static final String MIN_REGEX = DIGIT_REGEX + "{1,8}";
    private static final String MAX_REGEX = DIGIT_REGEX + "{1,8}";
    private static final String FREQUENCY_REGEX = DIGIT_REGEX + "{1,8}";
    private static final String AUGMENTED_URL_REGEX = ID_REGEX + "!" + URL_REGEX + "!" + MIN_REGEX + "!" + MAX_REGEX;
    private static final String STATE_REGEX = "OK|ALARM|DOWN|UNKNOWN";
    private static final String MESSAGE_REGEX = CHARACTER_REGEX + "{1,200}";

    /*
    Protocol between client and monitor
     */
    public static String NEWMON_REGEX = "NEWMON" + SP_REGEX + AUGMENTED_URL_REGEX + CRLF_REGEX;
    public static String NEWMON_RESP_REGEX = "(\\+OK" + SP_REGEX + MESSAGE_REGEX + ")?|(-ERR" + SP_REGEX + MESSAGE_REGEX + ")?";
    public static String LISTMON_REGEX = "LISTMON" + CRLF_REGEX;
    public static String MON_REGEX = "MON" + "((" + SP_REGEX + ID_REGEX + "){0,100})" + CRLF_REGEX;
    public static String REQUEST_REGEX = "REQUEST" + SP_REGEX + ID_REGEX + CRLF_REGEX;
    public static String RESPOND_REGEX = "RESPOND" + SP_REGEX + ID_REGEX + SP_REGEX + URL_REGEX + SP_REGEX + STATE_REGEX + CRLF_REGEX;

    /*
    Protocol between monitor and probe
     */
    public static String SETUP_REGEX = "SETUP" + SP_REGEX + FREQUENCY_REGEX + "((" + SP_REGEX + AUGMENTED_URL_REGEX + "){0,100})" + CRLF_REGEX;
    public static String STATUSOF_REGEX = "STATUSOF" + SP_REGEX + "(" + ID_REGEX + ")" + CRLF_REGEX;
    public static String STATUS_REGEX = "STATUS" + SP_REGEX + "(" + ID_REGEX + ")" + SP_REGEX + "(" + STATE_REGEX + ")" + CRLF_REGEX;

    /*
    Multicast
     */
    public static String PROBE_REGEX = "PROBE" + SP_REGEX + PROTOCOL_REGEX + SP_REGEX + PORT_REGEX + CRLF_REGEX;
    public static String DATA_REGEX = "DATA" + SP_REGEX + PROTOCOL_REGEX + SP_REGEX + PORT_REGEX + CRLF_REGEX;

    private final List<String> regexList = List.of(
            NEWMON_REGEX, NEWMON_RESP_REGEX, LISTMON_REGEX, LISTMON_REGEX, MON_REGEX, REQUEST_REGEX, RESPOND_REGEX, SETUP_REGEX, STATUSOF_REGEX, STATUS_REGEX, PROBE_REGEX, DATA_REGEX
    );


    public int analyze(String toAnalyze) {
        for (String r : regexList) {
            if (r.matches(toAnalyze)) {
                return regexList.indexOf(r);
            }
        }

        return -1;
    }

    public String giveMessageConstruction(String toAnalyze) {
        int pos = analyze(toAnalyze);
        return regexList.get(pos);
    }
}

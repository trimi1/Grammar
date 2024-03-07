package be.helmo.reseau.analyzer;

import be.helmo.reseau.interfaces.IAnalyzer;

import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;

public class Analyzer implements IAnalyzer {
    /*
    Standard definitions
     */
    public static String LETTER_REGEX = "[A-Za-z]";
    public static String DIGIT_REGEX = "[0-9]";
    public static String LETTER_DIGIT_REGEX = "(" + LETTER_REGEX + "|" + DIGIT_REGEX + ")";
    public static String CRLF_REGEX = "\r\n";
    public static String PORT_REGEX = DIGIT_REGEX + "{1,5}";
    public static String CHARACTER_REGEX = "[\\x20-\\xFF]";
    public static String CHARACTER_SPEC_REGEX = "[-_=./+*$°()\\[\\]{}^]";
    public static String CHARACTER_PASS_REGEX = "(" + LETTER_DIGIT_REGEX + "|" + CHARACTER_SPEC_REGEX + ")";
    public static String SP_REGEX = "\\x20";
    public static String ID_REGEX = LETTER_DIGIT_REGEX + "{5,10}";
    public static String PROTOCOL_REGEX = LETTER_DIGIT_REGEX + "{3,15}";
    public static String USERNAME_REGEX = LETTER_DIGIT_REGEX + "{3,50}";
    public static String PASSWORD_REGEX = CHARACTER_PASS_REGEX + "{3,50}";
    public static String AUTHENTICATION_REGEX = CHARACTER_PASS_REGEX + "{3,50}";
    public static String PASSWORD_AUTH_REGEX = PASSWORD_REGEX + "(#" + AUTHENTICATION_REGEX + ")?";
    public static String HOST_REGEX = "(" + LETTER_DIGIT_REGEX + "|" + "\\." + "|" + "_" + "|" + "-" + ")" + "{3,50}";
    public static String PATH_REGEX = "/(" + LETTER_DIGIT_REGEX + "|[.\\-_]){0,100}";
    public static String URL_REGEX = PROTOCOL_REGEX + "://(" + USERNAME_REGEX + "(:"
            + PASSWORD_AUTH_REGEX + ")?@)?" + HOST_REGEX + "(" + PORT_REGEX + ")?" + PATH_REGEX;
    public static String MIN_REGEX = DIGIT_REGEX + "{1,8}";
    public static String MAX_REGEX = DIGIT_REGEX + "{1,8}";
    public static String FREQUENCY_REGEX = DIGIT_REGEX + "{1,8}";
    public static String AUGMENTED_URL_REGEX = ID_REGEX + "!" + URL_REGEX + "!" + MIN_REGEX + "!" + MAX_REGEX;
    public static String STATE_REGEX = "OK|ALARM|DOWN|UNKNOWN";
    public static String MESSAGE_REGEX = CHARACTER_REGEX + "{1,200}";

    /*
    Protocol between client and monitor
     */
    public static String NEWMON_REGEX = "NEWMON" + SP_REGEX + AUGMENTED_URL_REGEX + CRLF_REGEX;
    public static String NEWMON_RESP_REGEX = "(\\+OK" + SP_REGEX + MESSAGE_REGEX + ")?|(-ERR" + SP_REGEX + MESSAGE_REGEX + ")?";
    public static String LISTMON_REGEX = "LISTMON" + CRLF_REGEX;
    public static String MON_REGEX = "MON" + "((" + SP_REGEX + ID_REGEX + "){0,100})" + CRLF_REGEX;
    public static String REQUEST_REGEX = "REQUEST" + SP_REGEX + ID_REGEX + CRLF_REGEX;
    public static String RESPOND_REGEX = "RESPOND" + SP_REGEX + ID_REGEX + SP_REGEX + URL_REGEX + SP_REGEX + STATE_REGEX + CRLF_REGEX;
    public static String CLIENT_PROTOCOL_REGEX = NEWMON_REGEX + NEWMON_RESP_REGEX + LISTMON_REGEX + MON_REGEX + REQUEST_REGEX + RESPOND_REGEX;

    /*
    Protocol between monitor and server
     */
    public static String SETUP_REGEX = "SETUP" + SP_REGEX + FREQUENCY_REGEX + "((" + SP_REGEX + AUGMENTED_URL_REGEX + "){0,100})" + CRLF_REGEX;
    public static String STATUSOF_REGEX = "STATUSOF" + SP_REGEX + ID_REGEX + CRLF_REGEX;
    public static String STATUS_REGEX = "STATUS" + SP_REGEX + ID_REGEX + SP_REGEX + STATE_REGEX + CRLF_REGEX;
    public static String MONITOR_PROTOCOL_REGEX = SETUP_REGEX + STATUSOF_REGEX + STATUS_REGEX;

    /*
    Multicast
     */
    public static String PROBE_REGEX = "PROBE" + SP_REGEX + PROTOCOL_REGEX + SP_REGEX + PORT_REGEX + CRLF_REGEX;
    public static String DATA_REGEX = "DATA" + SP_REGEX + PROTOCOL_REGEX + SP_REGEX + PORT_REGEX + CRLF_REGEX;

    private final List<String> regexList = List.of(
            LETTER_REGEX,
            DIGIT_REGEX,
            LETTER_DIGIT_REGEX,
            CRLF_REGEX,
            PORT_REGEX,
            CHARACTER_REGEX,
            CHARACTER_SPEC_REGEX,
            CHARACTER_PASS_REGEX,
            SP_REGEX,
            ID_REGEX,
            PROTOCOL_REGEX,
            USERNAME_REGEX,
            PASSWORD_REGEX,
            AUTHENTICATION_REGEX,
            PASSWORD_AUTH_REGEX,
            HOST_REGEX,
            PATH_REGEX,
            URL_REGEX,
            MIN_REGEX,
            MAX_REGEX,
            FREQUENCY_REGEX,
            AUGMENTED_URL_REGEX,
            STATE_REGEX,
            MESSAGE_REGEX,
            NEWMON_REGEX,
            NEWMON_RESP_REGEX,
            LISTMON_REGEX,
            MON_REGEX,
            REQUEST_REGEX,
            RESPOND_REGEX,
            CLIENT_PROTOCOL_REGEX,
            SETUP_REGEX,
            STATUSOF_REGEX,
            STATUS_REGEX,
            MONITOR_PROTOCOL_REGEX,
            PROBE_REGEX,
            DATA_REGEX
    );


    public int analyze(String toAnalyze) {
        for (String r : regexList) {
            if (r.matches(toAnalyze)) {
                return regexList.indexOf(r);
            }
        }
        return -1;
    }
}

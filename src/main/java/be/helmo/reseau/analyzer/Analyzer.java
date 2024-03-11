package be.helmo.reseau.analyzer;

import be.helmo.reseau.interfaces.IAnalyzer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Analyzer implements IAnalyzer {
    private static Analyzer instance;

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
    private static final String PASSWORD_AUTH_REGEX = "(?<Password>" + PASSWORD_REGEX + ")(#(?<Auth>" + AUTHENTICATION_REGEX + "))?";
    private static final String HOST_REGEX = "(?<Host>(" + LETTER_DIGIT_REGEX + "|\\.|_|-)" + "{3,50})";
    private static final String PATH_REGEX = "/(?<Oid>(" + LETTER_DIGIT_REGEX + "|[.\\-_])" + "{0,100})";
    public static final String URL_REGEX = "(?<Protocol>" + PROTOCOL_REGEX + ")://((?<Username>" + USERNAME_REGEX + ")(:("
            + PASSWORD_AUTH_REGEX + "))?@)?" + HOST_REGEX + "(:(?<Port>" + PORT_REGEX + "))?" + PATH_REGEX;
    private static final String MIN_REGEX = DIGIT_REGEX + "{1,8}";
    private static final String MAX_REGEX = DIGIT_REGEX + "{1,8}";
    private static final String FREQUENCY_REGEX = DIGIT_REGEX + "{1,8}";
    private static final String STATE_REGEX = "OK|ALARM|DOWN|UNKNOWN";
    private static final String MESSAGE_REGEX = CHARACTER_REGEX + "{1,200}";
    public static final String AUGMENTED_URL_REGEX = "((?<Id>" + ID_REGEX + ")!(?<Url>" + URL_REGEX + ")!(?<Min>" + MIN_REGEX + ")!(?<Max>" + MAX_REGEX + "))";
    public static final String NEWMON_REGEX = "(?<Type>NEWMON)" + SP_REGEX + "(?<Aurl>" + AUGMENTED_URL_REGEX + ")" + CRLF_REGEX;
    public static final String NEWMON_RESP_REGEX = "(\\+OK" + SP_REGEX + MESSAGE_REGEX + ")?|(-ERR" + SP_REGEX + MESSAGE_REGEX + ")?" + CRLF_REGEX;
    public static final String LISTMON_REGEX = "(?<Type>LISTMON)" + CRLF_REGEX;
    public static final String MON_REGEX = "(?<Type>MON)" + "((" + SP_REGEX + ID_REGEX + "){0,100})" + CRLF_REGEX;
    public static final String REQUEST_REGEX = "(?<Type>REQUEST)" + SP_REGEX + ID_REGEX + CRLF_REGEX;
    public static final String RESPOND_REGEX = "(?<Type>RESPOND)" + SP_REGEX + ID_REGEX + SP_REGEX + URL_REGEX + SP_REGEX + STATE_REGEX + CRLF_REGEX;
    public static final String SETUP_REGEX = "(?<Type>SETUP)" + SP_REGEX + "(?<Frequency>" + FREQUENCY_REGEX + ")(?<Aurls>(" + SP_REGEX + AUGMENTED_URL_REGEX + "){0,100})"  + CRLF_REGEX;
    public static final String STATUSOF_REGEX = "(?<Type>STATUSOF)" + SP_REGEX + "(?<Id>" + ID_REGEX + ")" + CRLF_REGEX;
    public static final String STATUS_REGEX = "(?<Type>STATUS)" + SP_REGEX + "(?<Id>" + ID_REGEX + ")" + SP_REGEX + "(?<State>" + STATE_REGEX + ")" + CRLF_REGEX;
    public static final String PROBE_REGEX = "(?<Type>PROBE)" + SP_REGEX + "(?<Protocol>" + PROTOCOL_REGEX + ")" + SP_REGEX + "(?<Port>" + PORT_REGEX + ")" + CRLF_REGEX;
    public static final String DATA_REGEX = "(?<Type>DATA)" + SP_REGEX + "(?<Protocol>" + PROTOCOL_REGEX + ")" + SP_REGEX + "(?<Port>" + PORT_REGEX + ")" + CRLF_REGEX;

    private final List<String> regexList = List.of(
            URL_REGEX, NEWMON_REGEX, NEWMON_RESP_REGEX, LISTMON_REGEX, MON_REGEX, REQUEST_REGEX, RESPOND_REGEX, SETUP_REGEX, STATUSOF_REGEX, STATUS_REGEX, PROBE_REGEX, DATA_REGEX, AUGMENTED_URL_REGEX
    );

    private Analyzer() {
    }

    public static Analyzer getInstance() {
        if (instance == null) {
            instance = new Analyzer();
        }

        return instance;
    }

    public Optional<String> getRegex(String toAnalyze) {
        for (String regex : this.regexList) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(toAnalyze);

            if (matcher.matches()) {
                return Optional.of(regex);
            }
        }
        return Optional.empty();
    }

    public Map<String, String> getGroups(String receivedMessage) {
        Map<String, String> groups = new HashMap<>();
        for (String regex : this.regexList) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(receivedMessage);

            if (matcher.find()) {
                for (String groupName : pattern.namedGroups().keySet()) {
                    String groupValue = matcher.group(groupName);
                    groups.put(groupName, groupValue);
                }
                break;
            }
        }
        return groups;
    }
}
package be.helmo.reseau.analyzer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnalyzerTest {
    //testes suivant implémenté par Leutrim
    /*
    public static String USERNAME_REGEX = "[" + LETTER_DIGIT_REGEX + "]{3,50}";
    public static String PASSWORD_REGEX = "[\\x21-\\x7E]{3,50}";
    public static String AUTHENTICATION_REGEX = "[\\x21-\\x7E]{3,50}";
    public static String PASSWORD_AUTH_REGEX = PASSWORD_REGEX + "(#" + AUTHENTICATION_REGEX + ")?";
    public static String URL_REGEX = PROTOCOL_REGEX + "://(" + USERNAME_REGEX + "(:"
            + PASSWORD_AUTH_REGEX + "@)?" + HOST_REGEX + "(:"
            + PORT_REGEX + ")?" + PATH_REGEX + ")?";
    public static String MIN_REGEX = "[" + DIGIT_REGEX + "]{1,8}";
    public static String MAX_REGEX = "[" + DIGIT_REGEX + "]{1,8}";
    public static String FREQUENCY_REGEX = "[" + DIGIT_REGEX + "]{1,8}";
    public static String AUGMENTED_URL_REGEX = "[" + DIGIT_REGEX + "]{1,8}!" + URL_REGEX + "!" + MIN_REGEX + "!" + MAX_REGEX;
    public static String STATE_REGEX = "OK|ALARM|DOWN|UNKNOWN";
    public static String MESSAGE_REGEX = "[\\x21-\\x7E]{1,200}";
    */

    @Test
    public void testUsernameRegex() {
        String USERNAME_REGEX = "[" + Analyzer.LETTER_DIGIT_REGEX + "]{3,50}";
        assertTrue("abc123".matches(USERNAME_REGEX));
        assertTrue("abc123abc123abc123abc123abc123abc123abc123abc123abc123abc123".matches(USERNAME_REGEX));
        assertFalse("abc123abc123abc123abc123abc123abc123abc123abc123abc123abc1234".matches(USERNAME_REGEX));
        assertFalse("abc123abc123abc123abc123abc123abc123abc123abc123abc123abc1234a".matches(USERNAME_REGEX));
    }
}

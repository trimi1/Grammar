package be.helmo.reseau.analyzer;

<<<<<<< HEAD
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AnalyzerTest {

    @Test
    public void letterRegexTest() {
        assertTrue("a".matches(Analyzer.LETTER_REGEX));
        assertTrue("Z".matches(Analyzer.LETTER_REGEX));
        assertTrue("r".matches(Analyzer.LETTER_REGEX));
        assertTrue("b".matches(Analyzer.LETTER_REGEX));
        assertTrue("Q".matches(Analyzer.LETTER_REGEX));
    }

    @Test
    public void DigitTest() {
        assertTrue("1".matches(Analyzer.DIGIT_REGEX));
        assertTrue("2".matches(Analyzer.DIGIT_REGEX));
        assertTrue("3".matches(Analyzer.DIGIT_REGEX));
        assertTrue("4".matches(Analyzer.DIGIT_REGEX));
        assertTrue("5".matches(Analyzer.DIGIT_REGEX));
        assertTrue("6".matches(Analyzer.DIGIT_REGEX));
        assertTrue("7".matches(Analyzer.DIGIT_REGEX));
        assertTrue("8".matches(Analyzer.DIGIT_REGEX));
        assertTrue("9".matches(Analyzer.DIGIT_REGEX));
    }

    @Test
    public void LetterDigitTest() {
        assertTrue("2".matches(Analyzer.LETTER_DIGIT_REGEX));
        assertTrue("a".matches(Analyzer.LETTER_DIGIT_REGEX));
        assertTrue("R".matches(Analyzer.LETTER_DIGIT_REGEX));
        assertTrue("b".matches(Analyzer.LETTER_DIGIT_REGEX));
    }

    @Test
    public void CRLFTest() {
        assertTrue(" ".matches(Analyzer.CRLF_REGEX));
    }

    @Test
    public void portRegexTest() {
        assertTrue("2323".matches(Analyzer.PORT_REGEX));
        assertTrue("1".matches(Analyzer.PORT_REGEX));
        assertTrue("34".matches(Analyzer.PORT_REGEX));
        assertTrue("23233".matches(Analyzer.PORT_REGEX));
        assertFalse("232232".matches(Analyzer.PORT_REGEX));
        assertFalse("".matches(Analyzer.PORT_REGEX));
    }

    @Test
    public void hostRegexTest() {
        assertTrue("2131231213".matches(Analyzer.HOST_REGEX));
        assertFalse("2".matches(Analyzer.HOST_REGEX));
        assertFalse("22".matches(Analyzer.HOST_REGEX));
        assertTrue("223".matches(Analyzer.HOST_REGEX));
        assertTrue("223.231".matches(Analyzer.HOST_REGEX));
        assertTrue("223-".matches(Analyzer.HOST_REGEX));
        assertTrue("223_".matches(Analyzer.HOST_REGEX));
        assertTrue("223_.-".matches(Analyzer.HOST_REGEX));
        assertTrue("1233212_511.411".matches(Analyzer.HOST_REGEX));
    }

    @Test
    public void pathRegexTest() {
        assertTrue("/2334".matches(Analyzer.PATH_REGEX));
        assertTrue("/2334.2321".matches(Analyzer.PATH_REGEX));
        assertTrue("/-".matches(Analyzer.PATH_REGEX));
        assertTrue("/_".matches(Analyzer.PATH_REGEX));
        assertTrue("/.".matches(Analyzer.PATH_REGEX));
        assertTrue("/".matches(Analyzer.PATH_REGEX));
    }

=======
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
>>>>>>> dc96cc95ad90a9c1584d416b9d5d144c4f7e8480
}

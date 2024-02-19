package be.helmo.reseau.analyzer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnalyzerTest {
    // Branch Leutrim
    //Branch Matteo
    @Test
    public void letterRegexTest() {
        assertTrue("a".matches(Analyzer.LETTER_REGEX));
        assertTrue("Z".matches(Analyzer.LETTER_REGEX));
        assertTrue("r".matches(Analyzer.LETTER_REGEX));
        assertTrue("b".matches(Analyzer.LETTER_REGEX));
        assertTrue("Q".matches(Analyzer.LETTER_REGEX));
        assertFalse("1".matches(Analyzer.LETTER_REGEX));
        assertFalse("aa".matches(Analyzer.LETTER_REGEX));
        assertTrue("A".matches(Analyzer.LETTER_REGEX));
        assertTrue("z".matches(Analyzer.LETTER_REGEX));
        assertTrue("C".matches(Analyzer.LETTER_REGEX));
        assertFalse("123".matches(Analyzer.LETTER_REGEX));
        assertFalse("_".matches(Analyzer.LETTER_REGEX));
    }

    @Test
    public void DigitTest() {
        assertTrue("0".matches(Analyzer.DIGIT_REGEX));
        assertTrue("5".matches(Analyzer.DIGIT_REGEX));
        assertTrue("9".matches(Analyzer.DIGIT_REGEX));
        assertFalse("A".matches(Analyzer.DIGIT_REGEX));
        assertFalse("_".matches(Analyzer.DIGIT_REGEX));
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
        assertTrue("A".matches(Analyzer.LETTER_DIGIT_REGEX));
        assertTrue("z".matches(Analyzer.LETTER_DIGIT_REGEX));
        assertTrue("C".matches(Analyzer.LETTER_DIGIT_REGEX));
        assertTrue("5".matches(Analyzer.LETTER_DIGIT_REGEX));
        assertFalse("123".matches(Analyzer.LETTER_DIGIT_REGEX));
        assertFalse("_".matches(Analyzer.LETTER_DIGIT_REGEX));
    }

    @Test
    public void CRLFTest() {
        assertTrue("\r\n".matches(Analyzer.CRLF_REGEX));
        assertFalse("\n".matches(Analyzer.CRLF_REGEX));
        assertFalse("\r".matches(Analyzer.CRLF_REGEX));
        assertFalse("\r\n\r\n".matches(Analyzer.CRLF_REGEX));
        assertFalse("A".matches(Analyzer.CRLF_REGEX));
    }

    @Test
    public void portRegexTest() {
        assertTrue("2323".matches(Analyzer.PORT_REGEX));
        assertTrue("1".matches(Analyzer.PORT_REGEX));
        assertTrue("34".matches(Analyzer.PORT_REGEX));
        assertTrue("23233".matches(Analyzer.PORT_REGEX));
        assertFalse("232232".matches(Analyzer.PORT_REGEX));
        assertFalse("".matches(Analyzer.PORT_REGEX));
        assertTrue("1".matches(Analyzer.PORT_REGEX));
        assertTrue("12345".matches(Analyzer.PORT_REGEX));
        assertTrue("0".matches(Analyzer.PORT_REGEX));
        assertFalse("123456".matches(Analyzer.PORT_REGEX));
        assertFalse("abc".matches(Analyzer.PORT_REGEX));
    }

    @Test
    public void characterRegexTest() {
        assertTrue(" ".matches(Analyzer.CHARACTER_REGEX));
        assertTrue("a".matches(Analyzer.CHARACTER_REGEX));
        assertTrue("R".matches(Analyzer.CHARACTER_REGEX));
        assertTrue("b".matches(Analyzer.CHARACTER_REGEX));
        assertTrue("2".matches(Analyzer.CHARACTER_REGEX));
        assertTrue("3".matches(Analyzer.CHARACTER_REGEX));
        assertTrue("4".matches(Analyzer.CHARACTER_REGEX));
        assertTrue("5".matches(Analyzer.CHARACTER_REGEX));
        assertTrue("6".matches(Analyzer.CHARACTER_REGEX));
        assertTrue("7".matches(Analyzer.CHARACTER_REGEX));
        assertTrue("8".matches(Analyzer.CHARACTER_REGEX));
        assertTrue("9".matches(Analyzer.CHARACTER_REGEX));
        assertTrue("0".matches(Analyzer.CHARACTER_REGEX));
        assertTrue("A".matches(Analyzer.CHARACTER_REGEX));
        assertTrue("z".matches(Analyzer.CHARACTER_REGEX));
        assertTrue("5".matches(Analyzer.CHARACTER_REGEX));
        assertTrue("!".matches(Analyzer.CHARACTER_REGEX));
        assertFalse("\n".matches(Analyzer.CHARACTER_REGEX));
        assertFalse("\r".matches(Analyzer.CHARACTER_REGEX));
    }

    @Test
    public void characterPassRegexTest() {
        assertTrue("a".matches(Analyzer.CHARACTER_PASS_REGEX));
        assertTrue("R".matches(Analyzer.CHARACTER_PASS_REGEX));
        assertTrue("b".matches(Analyzer.CHARACTER_PASS_REGEX));
        assertTrue("2".matches(Analyzer.CHARACTER_PASS_REGEX));
        assertTrue("-".matches(Analyzer.CHARACTER_PASS_REGEX));
        assertTrue(".".matches(Analyzer.CHARACTER_PASS_REGEX));
        assertTrue("/".matches(Analyzer.CHARACTER_PASS_REGEX));
        assertTrue("=".matches(Analyzer.CHARACTER_PASS_REGEX));
        assertTrue("+".matches(Analyzer.CHARACTER_PASS_REGEX));
        assertTrue("*".matches(Analyzer.CHARACTER_PASS_REGEX));
        assertTrue("$".matches(Analyzer.CHARACTER_PASS_REGEX));
        assertTrue("°".matches(Analyzer.CHARACTER_PASS_REGEX));
        assertTrue("(".matches(Analyzer.CHARACTER_PASS_REGEX));
        assertTrue(")".matches(Analyzer.CHARACTER_PASS_REGEX));
        assertTrue("[".matches(Analyzer.CHARACTER_PASS_REGEX));
        assertTrue("]".matches(Analyzer.CHARACTER_PASS_REGEX));
        assertTrue("{".matches(Analyzer.CHARACTER_PASS_REGEX));
        assertTrue("}".matches(Analyzer.CHARACTER_PASS_REGEX));
        assertTrue("^".matches(Analyzer.CHARACTER_PASS_REGEX));

        assertTrue("A".matches(Analyzer.CHARACTER_PASS_REGEX));
        assertTrue("z".matches(Analyzer.CHARACTER_PASS_REGEX));
        assertTrue("5".matches(Analyzer.CHARACTER_PASS_REGEX));
        assertFalse("!".matches(Analyzer.CHARACTER_PASS_REGEX));
        assertTrue("-".matches(Analyzer.CHARACTER_PASS_REGEX));
        assertFalse("\n".matches(Analyzer.CHARACTER_PASS_REGEX));
        assertFalse("\r".matches(Analyzer.CHARACTER_PASS_REGEX));
    }

    @Test
    public void spRegexTest() {
        assertTrue(" ".matches(Analyzer.SP_REGEX));
        assertFalse("A".matches(Analyzer.SP_REGEX));
        assertFalse("123".matches(Analyzer.SP_REGEX));
        assertFalse("\n".matches(Analyzer.SP_REGEX));
        assertFalse("\r".matches(Analyzer.SP_REGEX));
    }

    @Test
    public void idRegexTest() {
        assertFalse("1234".matches(Analyzer.ID_REGEX));
        assertTrue("12345".matches(Analyzer.ID_REGEX));
        assertTrue("123456".matches(Analyzer.ID_REGEX));
        assertTrue("1234567".matches(Analyzer.ID_REGEX));
        assertTrue("12345678".matches(Analyzer.ID_REGEX));
        assertTrue("123456789".matches(Analyzer.ID_REGEX));
        assertTrue("1234567890".matches(Analyzer.ID_REGEX));
        assertFalse("12345678901".matches(Analyzer.ID_REGEX));
        assertTrue("abc123".matches(Analyzer.ID_REGEX));
        assertTrue("xyz987654".matches(Analyzer.ID_REGEX));
        assertFalse("1".matches(Analyzer.ID_REGEX));
        assertFalse("abcdefghijw".matches(Analyzer.ID_REGEX));
        assertFalse("abc_123".matches(Analyzer.ID_REGEX));
    }

    @Test
    public void protocolRegexTest() {
        // Test with valid inputs
        assertTrue("abc".matches(Analyzer.PROTOCOL_REGEX));
        assertTrue("123".matches(Analyzer.PROTOCOL_REGEX));
        assertTrue("abc123".matches(Analyzer.PROTOCOL_REGEX));
        assertTrue("123abc".matches(Analyzer.PROTOCOL_REGEX));
        assertTrue("a1b2c3".matches(Analyzer.PROTOCOL_REGEX));
        assertTrue("1a2b3c".matches(Analyzer.PROTOCOL_REGEX));
        assertTrue("abc123def456".matches(Analyzer.PROTOCOL_REGEX));
        assertTrue("123abc456def".matches(Analyzer.PROTOCOL_REGEX));
        assertTrue("a1b2c3d4e5f6".matches(Analyzer.PROTOCOL_REGEX));
        assertTrue("1a2b3c4d5e6f".matches(Analyzer.PROTOCOL_REGEX));
        assertTrue("http".matches(Analyzer.PROTOCOL_REGEX));
        assertTrue("ftp".matches(Analyzer.PROTOCOL_REGEX));
        assertTrue("123".matches(Analyzer.PROTOCOL_REGEX));

        // Test with invalid inputs
        assertFalse("ab".matches(Analyzer.PROTOCOL_REGEX)); // less than 3 characters
        assertFalse("1234567890123456".matches(Analyzer.PROTOCOL_REGEX)); // more than 15 characters
        assertFalse("abc@123".matches(Analyzer.PROTOCOL_REGEX)); // contains invalid character
        assertFalse("123_abc".matches(Analyzer.PROTOCOL_REGEX)); // contains invalid character
        assertFalse("a1b2c3!".matches(Analyzer.PROTOCOL_REGEX)); // contains invalid character
        assertFalse("1a2b3c$".matches(Analyzer.PROTOCOL_REGEX)); // contains invalid character
        assertFalse("ftp_abc".matches(Analyzer.PROTOCOL_REGEX));
    }

    @Test
    public void usernameRegexTest() {
        // Test with valid inputs
        assertTrue("abc".matches(Analyzer.USERNAME_REGEX));
        assertTrue("123".matches(Analyzer.USERNAME_REGEX));
        assertTrue("abc123".matches(Analyzer.USERNAME_REGEX));
        assertTrue("123abc".matches(Analyzer.USERNAME_REGEX));
        assertTrue("a1b2c3".matches(Analyzer.USERNAME_REGEX));
        assertTrue("1a2b3c".matches(Analyzer.USERNAME_REGEX));
        assertTrue("abc123def456".matches(Analyzer.USERNAME_REGEX));
        assertTrue("123abc456def".matches(Analyzer.USERNAME_REGEX));
        assertTrue("a1b2c3d4e5f6".matches(Analyzer.USERNAME_REGEX));
        assertTrue("1a2b3c4d5e6f".matches(Analyzer.USERNAME_REGEX));
        assertTrue("a".repeat(50).matches(Analyzer.USERNAME_REGEX)); // exactly 50 characters
        assertTrue("user123".matches(Analyzer.USERNAME_REGEX));

        // Test with invalid inputs
        assertFalse("ab".matches(Analyzer.USERNAME_REGEX)); // less than 3 characters
        assertFalse("a".repeat(51).matches(Analyzer.USERNAME_REGEX)); // more than 50 characters
        assertFalse("abc@123".matches(Analyzer.USERNAME_REGEX)); // contains invalid character
        assertFalse("123_abc".matches(Analyzer.USERNAME_REGEX)); // contains invalid character
        assertFalse("a1b2c3!".matches(Analyzer.USERNAME_REGEX)); // contains invalid character
        assertFalse("1a2b3c$".matches(Analyzer.USERNAME_REGEX)); // contains invalid character
        assertFalse("1".matches(Analyzer.USERNAME_REGEX));
        assertFalse("user@name".matches(Analyzer.USERNAME_REGEX));
        assertFalse("user#name".matches(Analyzer.USERNAME_REGEX));
    }

    @Test
    public void passwordRegexTest() {
        // Test with valid inputs
        assertTrue("abc".matches(Analyzer.PASSWORD_REGEX));
        assertTrue("123".matches(Analyzer.PASSWORD_REGEX));
        assertTrue("abc123".matches(Analyzer.PASSWORD_REGEX));
        assertTrue("123abc".matches(Analyzer.PASSWORD_REGEX));
        assertTrue("a1b2c3".matches(Analyzer.PASSWORD_REGEX));
        assertTrue("1a2b3c".matches(Analyzer.PASSWORD_REGEX));
        assertTrue("abc123def456".matches(Analyzer.PASSWORD_REGEX));
        assertTrue("123abc456def".matches(Analyzer.PASSWORD_REGEX));
        assertTrue("a1b2c3d4e5f6".matches(Analyzer.PASSWORD_REGEX));
        assertTrue("1a2b3c4d5e6f".matches(Analyzer.PASSWORD_REGEX));
        assertTrue("a".repeat(50).matches(Analyzer.PASSWORD_REGEX)); // exactly 50 characters
        assertTrue("Pass123".matches(Analyzer.PASSWORD_REGEX));
        assertTrue("SecurePwd".matches(Analyzer.PASSWORD_REGEX));
        assertTrue("password".matches(Analyzer.PASSWORD_REGEX));
        assertTrue("*$°(54879".matches(Analyzer.PASSWORD_REGEX));
        assertTrue("54879*$°(".matches(Analyzer.PASSWORD_REGEX));
        assertTrue("A5°4+8-)Bdg7(d9*$(".matches(Analyzer.PASSWORD_REGEX));
        // Test with invalid inputs
        assertFalse("ab".matches(Analyzer.PASSWORD_REGEX)); // less than 3 characters
        assertFalse("a".repeat(51).matches(Analyzer.PASSWORD_REGEX)); // more than 50 characters
        assertFalse("pass@word".matches(Analyzer.PASSWORD_REGEX));
    }

    @Test
    public void authenticationRegexTest() {
        // Test with valid inputs
        assertTrue("abc".matches(Analyzer.AUTHENTICATION_REGEX));
        assertTrue("123".matches(Analyzer.AUTHENTICATION_REGEX));
        assertTrue("abc123".matches(Analyzer.AUTHENTICATION_REGEX));
        assertTrue("123abc".matches(Analyzer.AUTHENTICATION_REGEX));
        assertTrue("a1b2c3".matches(Analyzer.AUTHENTICATION_REGEX));
        assertTrue("1a2b3c".matches(Analyzer.AUTHENTICATION_REGEX));
        assertTrue("abc123def456".matches(Analyzer.AUTHENTICATION_REGEX));
        assertTrue("123abc456def".matches(Analyzer.AUTHENTICATION_REGEX));
        assertTrue("a1b2c3d4e5f6".matches(Analyzer.AUTHENTICATION_REGEX));
        assertTrue("1a2b3c4d5e6f".matches(Analyzer.AUTHENTICATION_REGEX));
        assertTrue("a".repeat(50).matches(Analyzer.AUTHENTICATION_REGEX)); // exactly 50 characters
        assertTrue("Auth123".matches(Analyzer.AUTHENTICATION_REGEX));
        assertTrue("SecureAuth".matches(Analyzer.AUTHENTICATION_REGEX));
        assertTrue("abc123".matches(Analyzer.AUTHENTICATION_REGEX));
        assertTrue("123abc".matches(Analyzer.AUTHENTICATION_REGEX));
        assertTrue("a1b2c3".matches(Analyzer.AUTHENTICATION_REGEX));
        assertTrue("Pass123*".matches(Analyzer.AUTHENTICATION_REGEX));
        // Test with invalid inputs
        assertFalse("ab".matches(Analyzer.AUTHENTICATION_REGEX)); // less than 3 characters
        assertFalse("a".repeat(51).matches(Analyzer.AUTHENTICATION_REGEX)); // more than 50 characters
        assertFalse("auth@123".matches(Analyzer.AUTHENTICATION_REGEX));
        assertFalse("ab".matches(Analyzer.AUTHENTICATION_REGEX)); // less than 3 characters
        assertFalse("a".repeat(51).matches(Analyzer.AUTHENTICATION_REGEX)); // more than 50 characters
        assertFalse("pass@word".matches(Analyzer.AUTHENTICATION_REGEX));
    }

    @Test
    public void passwordAuthRegexTest() {
        // Test with valid inputs
        assertTrue("abc".matches(Analyzer.PASSWORD_AUTH_REGEX)); // password only
        assertTrue("123".matches(Analyzer.PASSWORD_AUTH_REGEX)); // password only
        assertTrue("abc123".matches(Analyzer.PASSWORD_AUTH_REGEX)); // password only
        assertTrue("abc#123".matches(Analyzer.PASSWORD_AUTH_REGEX)); // password with authentication
        assertTrue("123#abc".matches(Analyzer.PASSWORD_AUTH_REGEX)); // password with authentication
        assertTrue("a1b2c3#d4e5f6".matches(Analyzer.PASSWORD_AUTH_REGEX)); // password with authentication
        assertTrue("1a2b3c#4d5e6f".matches(Analyzer.PASSWORD_AUTH_REGEX)); // password with authentication
        String exactlyFiftyCharacters = "a".repeat(25) + "#" + "a".repeat(24);
        assertTrue(exactlyFiftyCharacters.matches(Analyzer.PASSWORD_AUTH_REGEX));  // exactly 50 characters for password and authentication

        // Test with invalid inputs
        assertFalse("ab".matches(Analyzer.PASSWORD_AUTH_REGEX)); // less than 3 characters for password
        assertFalse("a".repeat(51).matches(Analyzer.PASSWORD_AUTH_REGEX)); // more than 50 characters for password
        String moreFiftyCharacters = "abc#" + "a".repeat(51);
        assertFalse(moreFiftyCharacters.matches(Analyzer.PASSWORD_AUTH_REGEX)); // more than 50 characters for authentication
    }

    @Test
    public void testHostRegex() {
        // Cas valides
        assertTrue("www.example.com".matches(Analyzer.HOST_REGEX));
        assertTrue("example-domain.com".matches(Analyzer.HOST_REGEX));
        assertTrue("example".matches(Analyzer.HOST_REGEX));
        assertTrue("example.com".matches(Analyzer.HOST_REGEX));
        assertTrue("sub_domain_123.example.co.uk".matches(Analyzer.HOST_REGEX));
        assertTrue("127.0.0.1".matches(Analyzer.HOST_REGEX));
        assertTrue("www..com".matches(Analyzer.HOST_REGEX));
        assertTrue("..www.example..com".matches(Analyzer.HOST_REGEX));

        // Cas invalides
        assertFalse(")example..com".matches(Analyzer.HOST_REGEX));
        assertFalse("%invalid-host@name".matches(Analyzer.HOST_REGEX));
        assertFalse("host_123!".matches(Analyzer.HOST_REGEX));
    }

    @Test
    public void testPathRegex() {
        // Cas valides
        assertTrue("/abc123".matches(Analyzer.PATH_REGEX));
        assertTrue("/123abc".matches(Analyzer.PATH_REGEX));
        assertTrue("/a1b2c3".matches(Analyzer.PATH_REGEX));
        assertTrue("/path_name".matches(Analyzer.PATH_REGEX));
        assertTrue("/path-123".matches(Analyzer.PATH_REGEX));
        assertTrue("/path_abc".matches(Analyzer.PATH_REGEX));
        assertTrue("/path.123".matches(Analyzer.PATH_REGEX));

        // Cas invalides
        assertFalse(" /ab".matches(Analyzer.PATH_REGEX)); // less than 3 characters
        assertFalse("../a".repeat(101).matches(Analyzer.PATH_REGEX)); // more than 100 characters
        assertFalse("o/path@name".matches(Analyzer.PATH_REGEX));
    }

    @Test
    public void characterSpecRegexTest() {
        assertTrue("-".matches(Analyzer.CHARACTER_SPEC_REGEX));
        assertTrue(".".matches(Analyzer.CHARACTER_SPEC_REGEX));
        assertTrue("/".matches(Analyzer.CHARACTER_SPEC_REGEX));
        assertTrue("=".matches(Analyzer.CHARACTER_SPEC_REGEX));
        assertTrue("+".matches(Analyzer.CHARACTER_SPEC_REGEX));
        assertTrue("*".matches(Analyzer.CHARACTER_SPEC_REGEX));
        assertTrue("$".matches(Analyzer.CHARACTER_SPEC_REGEX));
        assertTrue("°".matches(Analyzer.CHARACTER_SPEC_REGEX));
        //assertEquals("°", Analyzer.CHARACTER_SPEC_REGEX);
        assertTrue("(".matches(Analyzer.CHARACTER_SPEC_REGEX));
        assertTrue(")".matches(Analyzer.CHARACTER_SPEC_REGEX));
        assertTrue("[".matches(Analyzer.CHARACTER_SPEC_REGEX));
        assertTrue("]".matches(Analyzer.CHARACTER_SPEC_REGEX));
        assertTrue("{".matches(Analyzer.CHARACTER_SPEC_REGEX));
        assertTrue("}".matches(Analyzer.CHARACTER_SPEC_REGEX));
        assertTrue("^".matches(Analyzer.CHARACTER_SPEC_REGEX));
    }
}

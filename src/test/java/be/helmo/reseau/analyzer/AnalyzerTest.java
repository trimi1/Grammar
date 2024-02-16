package be.helmo.reseau.analyzer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnalyzerTest {

    @Test
    public void letterRegexTest(){
        assertTrue("a".matches(Analyzer.LETTER_REGEX));
        assertTrue("Z".matches(Analyzer.LETTER_REGEX));
        assertTrue("r".matches(Analyzer.LETTER_REGEX));
        assertTrue("b".matches(Analyzer.LETTER_REGEX));
        assertTrue("Q".matches(Analyzer.LETTER_REGEX));
    }

    @Test
    public void DigitTest(){
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
    public void LetterDigitTest(){
        assertTrue("2".matches(Analyzer.LETTER_DIGIT_REGEX));
        assertTrue("a".matches(Analyzer.LETTER_DIGIT_REGEX));
        assertTrue("R".matches(Analyzer.LETTER_DIGIT_REGEX));
        assertTrue("b".matches(Analyzer.LETTER_DIGIT_REGEX));
    }
    @Test
    public void CRLFTest(){
        assertTrue("\n".matches(Analyzer.CRLF_REGEX));
    }
}

package com.unit.stream;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ChangeWordInTextTest {

    static String TEXT = "test_word";
    static String TEXT_EXAMPLE = "test word";
    static String EXP_RESULT = "test_word test_word";

    @Test
    void changeWordInText() {
        ChangeWordInText cw = new ChangeWordInText();
        assertTrue(EXP_RESULT.equals(cw.changeWord(TEXT_EXAMPLE, TEXT, 4L)));
        assertEquals(EXP_RESULT, cw.changeWord(TEXT_EXAMPLE, TEXT, 4L));
    }

    @Test
    void changeWordInTextNothing() {
        ChangeWordInText cw = new ChangeWordInText();
        assertTrue(TEXT_EXAMPLE.equals(cw.changeWord(TEXT_EXAMPLE, TEXT, 5L)));
        assertEquals(TEXT_EXAMPLE, cw.changeWord(TEXT_EXAMPLE, TEXT, 5L));
    }
}

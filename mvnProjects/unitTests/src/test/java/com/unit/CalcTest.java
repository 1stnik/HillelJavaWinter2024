package com.unit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CalcTest {

    @Test
    @Tag("calc")
    @DisplayName("додавання")
    void add() {
        assertEquals(4, new Calc().add(2, 2));
    }

    @Test
    @Tag("calc")
    @DisplayName("ділення")
    void div() {
        assertEquals(1, new Calc().div(2, 2));
    }

    @Test
    @Tag("div")
    @DisplayName("ділення на 0")
    @Disabled
    void divByZero() {
        assertThrows(ArithmeticException.class, () -> new Calc().div(2, 0));
    }

    @Test
    @Tag("calc")
    @DisplayName("вичитання")
    void sub() {
        assertEquals(0, new Calc().sub(2, 2));
    }
}

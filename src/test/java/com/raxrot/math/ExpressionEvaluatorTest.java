package com.raxrot.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExpressionEvaluatorTest {
    @Test
    void testBasicMath() {
        assertEquals(14.0, ExpressionEvaluator.evaluate("2 + 3 * 4"));
        assertEquals(5.0, ExpressionEvaluator.evaluate("(10 + 5) / 3"));
        assertEquals(13.0, ExpressionEvaluator.evaluate("2 * (3 + 4) - 1"));
    }

    @Test
    void testNegativeNumbers() {
        assertEquals(-2.0, ExpressionEvaluator.evaluate("-5 + 3"));
    }

    @Test
    void testDecimalMath() {
        assertEquals(5.0, ExpressionEvaluator.evaluate("3.5 + 1.5"));
    }
}
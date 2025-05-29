package com.raxrot.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExpressionEvaluatorTest {
    @Test
    void testMath() {
        assertEquals(1, ExpressionEvaluator.evaluate("-24+5*5"));
        assertEquals(2, ExpressionEvaluator.evaluate("(5+20)-23"));
        assertEquals(3, ExpressionEvaluator.evaluate("5*6-30+3"));
    }
}
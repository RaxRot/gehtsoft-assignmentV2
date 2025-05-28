package com.raxrot.math;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

/**
 * A simple expression evaluator that calculates the result
 * of a mathematical expression provided as a string.
 * <p>
 * This class uses the exp4j library to parse and evaluate expressions.
 * Supported operations include +, -, *, /, parentheses, decimals,
 * and negative numbers.
 */
public class ExpressionEvaluator {

    /**
     * Evaluates a given arithmetic expression as a string.
     *
     * @param expression the expression to evaluate (e.g. "2 + 3 * (4 - 1)")
     * @return the result of the expression as a double
     * @throws IllegalArgumentException if the expression is invalid
     */
    public static double evaluate(String expression) {
        Expression exp = new ExpressionBuilder(expression).build();
        return exp.evaluate();
    }
}
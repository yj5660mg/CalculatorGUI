package com.Lucky.lucky.Calculator;

import java.util.function.DoubleBinaryOperator;
//Creating enum Operation for handling different calculator operations such as
// addition, subtraction, division, multiplication and percentages.
public enum Operation {
    ADDITION((x, y) -> x+y),
    SUBTRACTION((x, y) -> x-y),
    DIVISION((x, y) -> x/y),
    MULTIPLICATION((x, y) -> x*y),
    PERCENTAGE((x, y) -> x%y);
//The constructor of the enum takes in a function "DoubleBinaryOperator"
// which represents operations on two double valued operands that produces a double valued result.
    private DoubleBinaryOperator operator;

    Operation(DoubleBinaryOperator operator) {
        this.operator = operator;
    }
    public DoubleBinaryOperator getOperator() {
        return operator;
    }
}

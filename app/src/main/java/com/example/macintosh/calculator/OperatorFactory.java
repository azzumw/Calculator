package com.example.macintosh.calculator;

/**
 * This class merely uses create method
 * to create an instance of an Operator class.
 */

public class OperatorFactory {

    public Operator create(char operator) {
        switch (operator) {
            case '+':
                return new PlusOperator();
            case '-':
                return new MinusOperator();
            case 'x':
                return new MultiplicationOperator();
            default:
                throw new RuntimeException("Unrecognised operator");
        }
    }
}

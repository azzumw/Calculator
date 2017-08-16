package com.example.macintosh.calculator;

/**
 * Created by macintosh on 16/08/2017.
 */

public class OperatorFactory {

    public Operator create(char operator) {
        switch (operator) {
            case '+':
                return new PlusOperator();
            case '-':
                return new MinusOperator();
            default:
                throw new RuntimeException("Unrecognised operator");
        }
    }
}

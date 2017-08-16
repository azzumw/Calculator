package com.example.macintosh.calculator;

/**
 * Created by macintosh on 02/08/2017.
 */

public class PlusOperator implements Operator {

    @Override
    public int evaluate(int a, int b) {
        return a+ b;
    }

    @Override
    public String toString() {
        return "+";
    }
}

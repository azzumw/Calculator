package com.example.macintosh.calculator;

/**
 * Created by macintosh on 02/08/2017.
 */

public class PlusOperator extends Operator {


    public PlusOperator(char op){
        super(op);
    }
    @Override
    public int evaluate(int a, int b) {
        return a+ b;
    }
}

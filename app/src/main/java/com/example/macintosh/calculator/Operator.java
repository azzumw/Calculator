package com.example.macintosh.calculator;

/**
 * Created by macintosh on 02/08/2017.
 */

public abstract class Operator {

    private  char operator;

    public Operator(char ch){
        operator = ch;
    }

    public void setOperator(char operator){
        this.operator = operator;
    }

    public char getOperator() {
        return operator;
    }

    public abstract int evaluate(int a, int b);
}

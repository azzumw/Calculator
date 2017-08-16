package com.example.macintosh.calculator;

/**
 * Created by macintosh on 16/08/2017.
 */

public class FunctionEvaluator {

    public int evaluate(Function function) {
        int sum = 0;

        for (int i = 0; i < function.getNumbersListSize(); i++) {
            int ithNumber = function.getNumber(i);

            if (i == 0) {
                sum = ithNumber;
            } else {
                Operator operator = function.getOperator(i - 1);
                sum = operator.evaluate(sum, ithNumber);
            }
        }

        return sum;
    }
}

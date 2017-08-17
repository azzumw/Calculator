package com.example.macintosh.calculator;

/**
 * Created by macintosh on 16/08/2017.
 */

public class ViewSummary {

    public String createSummary(Function function){
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < function.getNumbersListSize(); i++) {
            sb.append(function.getNumber(i));

            if (i < function.getOperatorsListSize()) {
                sb.append(function.getOperator(i).toString());
            }
        }

        return sb.toString();
    }
}

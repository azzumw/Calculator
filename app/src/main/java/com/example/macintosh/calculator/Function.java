package com.example.macintosh.calculator;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by macintosh on 23/06/2017.
 */

public class Function {

    private OperatorFactory operatorFactory;

    private ArrayList<StringBuilder> numbers;
    private ArrayList<Operator> operators;

    public Function(OperatorFactory operatorFactory) {
        this.operatorFactory = operatorFactory;

        numbers = new ArrayList<>();
        operators = new ArrayList<>();

        reset();
    }

    public String getSummaryString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numbers.size(); i++) {
            sb.append(numbers.get(i));

            if (i < operators.size()) {
                sb.append(operators.get(i).toString());
            }
        }

        return sb.toString();
    }

    public void onNumberCharacterPressed(char theNumber) {
        if (isOperatorsAndNumbersListsEqual()) {
            numbers.add(new StringBuilder(Character.valueOf(theNumber).toString()));
        } else if (theNumber == '0' && isLastNumberZero()) {
            // nothing to do
        } else {
            getLastNumber().append(theNumber);
        }
    }

    public void onOperatorCharacterPressed(char theOperator) {
        if (numbers.size() == 0) {
            // nothing to do
        } else if (isOperatorsAndNumbersListsEqual()) {
            operators.set(operators.size() - 1, operatorFactory.create(theOperator));
        } else {
            operators.add(operatorFactory.create(theOperator));
        }
    }

    public String getResult() {
        int sum = 0;
        String result = "";

        if (!numbers.isEmpty()) {
            for (int i = 0; i < numbers.size(); i++) {
                sum = sum + Integer.valueOf(numbers.get(i).toString());
            }

            result = String.valueOf(sum);
        }

        return result;
    }

    public void reset() {
        numbers.clear();
        operators.clear();
    }

    public void onClearPressed() {
        if (!numbers.isEmpty() || !operators.isEmpty()) {
            if (numbers.size() == operators.size()) {
                operators.remove(operators.size() - 1);
            } else {
                if (numbers.size() == 1) {
                    if (getLastNumber().length() == 1) {
                        reset();
                    } else {
                        StringBuilder lastNumber = getLastNumber();
                        lastNumber.deleteCharAt(lastNumber.length() - 1);
                    }
                } else {
                    getLastNumber().deleteCharAt(getLastNumber().length() - 1);

                    if (getLastNumber().length() == 0) {
                        numbers.remove(numbers.size() - 1);
                    }
                }
            }
        }
    }

    private StringBuilder getLastNumber() {
        return numbers.get(numbers.size() - 1);
    }

    private boolean isLastNumberZero() {
        return getLastNumber().toString().equals("0");

    }

    private boolean isOperatorsAndNumbersListsEqual() {
        return operators.size() == numbers.size();
    }
}

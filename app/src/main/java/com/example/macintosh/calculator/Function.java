package com.example.macintosh.calculator;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

/**
 * Created by macintosh on 23/06/2017.
 */

public class Function {

    private OperatorFactory operatorFactory;

    private ArrayList<StringBuilder> numbers;
    private ArrayList<Operator> operators;

    //constructor
    public Function(OperatorFactory operatorFactory) {
        this.operatorFactory = operatorFactory;

        numbers = new ArrayList<>();
        operators = new ArrayList<>();

        reset();
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

    public void reset() {
        numbers.clear();
        operators.clear();
    }

   /* public void onClearPressed() {
        if (!numbers.isEmpty() || !operators.isEmpty()) {
            if (numbers.size() == operators.size()) {
                operators.remove(operators.size() - 1);
            } else {
                if (numbers.size() == 1) {
                    if (getLastNumber().length() == 1) {
                        //reset();
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
    }*/

    public StringBuilder getLastNumber() {
        return numbers.get(numbers.size() - 1);
    }

    public int getNumber(int position) {
        return Integer.valueOf(numbers.get(position).toString());
    }

    public int getNumbersListSize(){
        return numbers.size();
    }

    public int getOperatorsListSize(){
        return operators.size();
    }

    public Operator getOperator(int i){
        return operators.get(i);
    }


    public ArrayList<StringBuilder> getNumbersList() {
        return numbers;
    }

    public ArrayList<Operator> getOperatorsList() {
        return operators;
    }

    private boolean isLastNumberZero() {
        return getLastNumber().toString().equals("0");
    }

    public boolean isOperatorsAndNumbersListsEqual() {
        return operators.size() == numbers.size();
    }



}

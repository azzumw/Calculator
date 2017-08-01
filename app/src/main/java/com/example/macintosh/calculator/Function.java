package com.example.macintosh.calculator;

import java.util.ArrayList;

/**
 * Created by macintosh on 23/06/2017.
 */

public class Function {

    private static final char ZERO = '0';

    private ArrayList<StringBuilder> numbers;
    private ArrayList<String> operators;

    public Function() {
        numbers = new ArrayList<>();
        operators = new ArrayList<>();
        reset();
    }

    /**
     * ABSOLUTELY DO NOT CHANGE
     */
    public String getSummaryString() {
        String string = "";
        for (StringBuilder sb : numbers) {
            string += sb;
        }
        return string;
    }

    public void onNumberCharacterPressed(char theNumber) {
        if (isOperatorsAndNumbersListsEqual()) {
            numbers.add(new StringBuilder(Character.valueOf(theNumber).toString()));
        } else if (theNumber == '0' && isLastNumberZero()) {
            // nothing to do
        } else {
            // TODO append the number to the last item in the numbers array
            getLastNumber().append(theNumber);
        }
    }


    public void onOperatorCharacterPressed(char theOperator) {
        if (numbers.size() == 0) {
            // nothing to do
        } else if (isOperatorsAndNumbersListsEqual()) {
            // TODO replace the last operator that was put in the operators list
            operators.set(operators.size()-1,String.valueOf(theOperator));
        } else {
            // TODO append the operator to the operators list
            operators.add(String.valueOf(theOperator));
        }
    }

    /**
     * ABSOLUTELY DO NOT CHANGE
     */
    public int getResult() {
        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sum = sum + Integer.valueOf(numbers.get(i).toString());
        }
        return sum;
    }

    public void reset() {
        numbers.clear();
        operators.clear();
    }

    public void onClearPressed() {
        //text: 1+2
        // when user presses C it needs to delete
        /*
        * if numbers array size is ONE(i.e one element)
        * then check if in this element the length of the
        * stringbuilder isEqual to ONE (has one character); if it is, we need to remove or clear this
        * element from the array; we also need to remove/clear the character in it. We then
        * append zero to the stringBuilder element and re-add that to the numbers array
        * */
        if (numbers.size() == 1) {


            if (getLastNumber().length() == 1) {
                reset();
            }

           /*
                else if the length of stringbuilder object is more than 1 then
                we decrementally delete the characters in this element
            */
            else {
                StringBuilder lastNumber = getLastNumber();
                lastNumber.deleteCharAt(lastNumber.length() - 1);
            }
        }

       /*
       * This else deals with the case when array size is more than one (has more elements than one)
       * we need to grab the last element in the array then we need to delete the last character
       * in the stringBuilder object of this last element. When the length of the strinbuilder object in this
       * last element of array becomes ZERO we need to remove this element of the array
       * */
        else {
            StringBuilder lastNumber = getLastNumber();
            lastNumber.deleteCharAt(lastNumber.length() - 1);

            if (getLastNumber().length() == 0) {
                numbers.remove(numbers.size() - 1);
            }
        }
    }

//    public void printNumbers() {
//        for (int i = 0; i < numbers.size(); i++) {
//            Log.v("Index: " + i, numbers.get(i).toString());
//        }
//    }

    private StringBuilder getLastNumber() {
        return numbers.get(numbers.size() - 1);
    }

    private boolean isLastNumberZero() {
        // TODO: check whether the last item in the numbers list is "0"
        boolean isLastNumberZero = false;
        if(numbers.get(numbers.size()-1).equals("0")){
            isLastNumberZero = true;
        }

        return isLastNumberZero;

    }

    private boolean isOperatorsAndNumbersListsEqual() {
        return operators.size() == numbers.size();
    }
}

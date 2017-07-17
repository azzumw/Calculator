package com.example.macintosh.calculator;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by macintosh on 23/06/2017.
 */

public class Function {

    private static final char ZERO = '0';

    private ArrayList<StringBuilder> numbers;
//    private ArrayList<String> operators;

    public Function() {
        numbers = new ArrayList<>();
        reset();
    }

    public String getStringForTextView() {
        String string = "";
        for (StringBuilder sb : numbers) {
            string += sb;
        }
        return string;
    }

    public void onNumberCharacterPressed(char theNumber) {
        /*
        * When number is pressed, because the default text shows 0, it needs to be first
        * replaced; hence, it first checks whether number displayed is zero; if it is, it
        * replaces zero with the number pressed;
        * */
        if (getLastNumber().charAt(0) == ZERO) {
            getLastNumber().setCharAt(0, theNumber);
        } else {
            if (getLastNumber().toString().equals("+")) {
                numbers.add(new StringBuilder().append(theNumber));
            } else {
                getLastNumber().append(theNumber);
            }
        }

        /*if the last element in the numbers array is a plus character
        * then add a new stringBuilder object; else, append to current
        * stringBuilder object.
        * */

        printNumbers();
    }


    public void onOperatorCharacterPressed(char theOperator) {
        numbers.add(new StringBuilder().append(theOperator));

    }

    public int onEqualPress() {
        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (!numbers.get(i).toString().equals("+")) {
                sum = sum + Integer.valueOf(numbers.get(i).toString());
            }
        }
        return sum;
    }


    public void reset() {
        numbers.clear();
        numbers.add(new StringBuilder().append('0'));
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

    public void printNumbers() {
        for (int i = 0; i < numbers.size(); i++) {
            Log.v("Index: " + i, numbers.get(i).toString());
        }
    }

    private StringBuilder getLastNumber() {
        return numbers.get(numbers.size() - 1);
    }
}

package com.example.macintosh.calculator;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by macintosh on 23/06/2017.
 */

public class Function {

    private ArrayList<StringBuilder> numbers;
    private ArrayList<String> operators;

    public Function() {
        numbers = new ArrayList<>();
        operators = new ArrayList<>();
        reset();
    }

    public String getSummaryString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numbers.size(); i++) {
            sb.append(numbers.get(i));

            if (i < operators.size()) {
                sb.append(operators.get(i));
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
            operators.set(operators.size() - 1, String.valueOf(theOperator));
        } else {
            operators.add(String.valueOf(theOperator));
        }
    }

    public String getResult() {
        int sum = 0;
        String result = "";

        if(!numbers.isEmpty()){
            for (int i = 0; i < numbers.size(); i++) {
                sum = sum + Integer.valueOf(numbers.get(i).toString());
            }

             result= String.valueOf(sum);
        }



        return result;
    }

    public void reset() {
        numbers.clear();
        operators.clear();
    }

    public void onClearPressed(){
        if(!numbers.isEmpty() || !operators.isEmpty()){
            if(numbers.size()==operators.size()){
                operators.remove(operators.size()-1);
            }
            else{
                if(numbers.size()==1){
                    if(getLastNumber().length()==1){
                        reset();
                    }
                    else{
                        StringBuilder lastNumber = getLastNumber();
                        lastNumber.deleteCharAt(lastNumber.length() - 1);
                    }
                }

                else{
                    getLastNumber().deleteCharAt(getLastNumber().length()-1);

                    if(getLastNumber().length()==0){
                        numbers.remove(numbers.size()-1);
                    }
                }
            }
        }


    }

    public void onClear_Pressed() {
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

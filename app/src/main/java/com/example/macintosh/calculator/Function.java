package com.example.macintosh.calculator;

import java.util.ArrayList;

/**
 * Created by macintosh on 23/06/2017.
 */

public class Function {

    private ArrayList<StringBuilder> numbers;

    private StringBuilder currentNumberStringBuilder;

    private boolean isAnswerSet;

    public Function(){
        numbers = new ArrayList<>();
        currentNumberStringBuilder = new StringBuilder();
        currentNumberStringBuilder.append('0');
        isAnswerSet = false;

    }

    public void addNumber(StringBuilder n){
        numbers.add(n);
    }

    public StringBuilder getNumber(int i){
        return numbers.get(i);
    }

    public int getSize(){
        return numbers.size();
    }

    public String getStringForTextView() {
        return currentNumberStringBuilder.toString(); // plus whatever is in numbers and operators;
    }


    public int sum(){
        int sum=0;

        for(int i = 0; i < numbers.size(); i++){
            sum = sum + Integer.parseInt(numbers.get(i));
        }
        return sum;
    }

    public void remove(){
        if(!numbers.isEmpty()){
            numbers.remove(numbers.size()-1);
        }
    }


    //invoked on long press
    public void clear(){
        if(!numbers.isEmpty()){
            numbers.clear();
        }
    }

    public void onNumberCharacterPressed(char theNumber) {

        if (currentNumberStringBuilder.length() == 1 && currentNumberStringBuilder.charAt(0) == '0') {
            currentNumberStringBuilder.setCharAt(0, theNumber);

        } else {
            currentNumberStringBuilder.append(theNumber);

        }
    }


    public void onOperatorCharacterPressed(char theOperator) {


        addNumber(currentNumberStringBuilder.toString());




        //adds string representation of this operator to the operators array
        //str="";
        //currentNumberStringBuilder.append(theOperator);

        //currentNumberStringBuilder = currentNumberStringBuilder.delete(0, currentNumberStringBuilder.length());

    }

    private String reverse(String s){
        String revstring="";
        for(int i=s.length()-1;i>=0;i--){
            revstring+=s.charAt(i);
        }

        return revstring;
    }


    /**invoked when user taps 'C' button
     * this method also invokes deleteStringBuildercharacter()
     * which deletes single character in a stringBuilder object
     * */
    public void onClearPressed(){
        if (getStringForTextView().length() == 1) {
            currentNumberStringBuilder.insert(0,"0");
        }

        if (getStringForTextView().length() > 1){
            deleteStringBuilderCharacter();

            //delete from operators and numbers lists
            //remove();
        }
    }
    /**
    * invoked when user holds down the Clear button
     * clears the stringBuilder object
     * and then replaces last character with '0'
    * */
    public void clearStringBuilder(){
        currentNumberStringBuilder.delete(0,currentNumberStringBuilder.length()-1);
        currentNumberStringBuilder.setCharAt(0,'0');
        clear();
        isAnswerSet = false;
    }

    /**invoked by onClearPressed() when user taps Clear button
     * deletes a character from the stringBuilder object*/
    private void deleteStringBuilderCharacter(){


        //if isAnswer is not set then dont remove anything from the array
        if(isAnswerSet){
            if(!numbers.isEmpty()){
                if(currentNumberStringBuilder.charAt(currentNumberStringBuilder.length()-1)!='+'){
                    System.out.println("char: "+currentNumberStringBuilder.charAt(currentNumberStringBuilder.length()-1));
                    numbers.remove(numbers.size()-1);
                }

            }
        }


        currentNumberStringBuilder.deleteCharAt(currentNumberStringBuilder.length()-1);
    }

    public void onEqualPressed() {
        //get the last character of the strinbuilder object

        //String lastnumber = ""+ currentNumberStringBuilder.charAt(currentNumberStringBuilder.length()-1);
        String lastnumber = ""+ currentNumberStringBuilder.substring(currentNumberStringBuilder.lastIndexOf("+")+1);
        // add that number to the numbers array
        System.out.println("Last number: "+lastnumber);
        addNumber(lastnumber);
        isAnswerSet = true;
        //int sum = sum();

    }
}

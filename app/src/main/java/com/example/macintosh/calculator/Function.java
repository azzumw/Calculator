package com.example.macintosh.calculator;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by macintosh on 23/06/2017.
 */

public class Function {

    private ArrayList<StringBuilder> numbers;
    private ArrayList<String> operators;

    StringBuilder stringBuilderForText;


    private int numbersArrayIndexNumber;
   // private StringBuilder currentNumberStringBuilder;



    public Function(){
        numbers = new ArrayList<StringBuilder>();

        //make a string builder object with value 0
        stringBuilderForText = new StringBuilder('0');

        //add the string builder object to the numbers array
        numbers.add(0,stringBuilderForText);


        numbersArrayIndexNumber =  numbers.size()-1;  //0

    }


    public void addToNumber(StringBuilder n){
        numbers.add(n);
    }



    public String getStringForTextView(){
        String string = "";
        for (StringBuilder sb: numbers) {
          string +=sb;
        }
        return string;
    }

    public void onNumberCharacterPressed(char theNumber) {
        //add theNumber to current stringbuilder Object
        if(numbers.get(numbers.size()-1).toString().equals("+")){
            numbers.add(new StringBuilder().append(theNumber));

        }
        else{
            numbers.get(numbers.size()-1).append(theNumber);
        }

        printNumbers();
    }


    public void onOperatorCharacterPressed(char theOperator) {
        //addNumber(new StringBuilder().insert(numbersArrayIndexNumber,theOperator));
        numbers.add(new StringBuilder().append(theOperator));

    }

    public int onEqualPress(){
        int sum = 0;
        for (int i=0; i<numbers.size();i++){
            if(!numbers.get(i).toString().equals("+")){
                sum = sum + Integer.valueOf(numbers.get(i).toString());
            }
        }
        return sum;
    }


    public void onClearHeld(){
        //delete stringbuilders..
        //clear the array
        numbers.clear();
        stringBuilderForText.delete(0,stringBuilderForText.length()-1);
        stringBuilderForText.insert(0,'0');
        numbers.add(0,stringBuilderForText);
    }
    public void printNumbers(){
        for (int i = 0; i <numbers.size() ; i++) {
            Log.v("Index: "+i, numbers.get(i).toString());
        }
    }
    public void getSize(){
        Log.v("Size of numbers array: ", ""+numbers.size());
    }



}

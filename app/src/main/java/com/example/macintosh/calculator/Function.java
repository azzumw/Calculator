package com.example.macintosh.calculator;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by macintosh on 23/06/2017.
 */

public class Function {

    private ArrayList<StringBuilder> numbers;
    private ArrayList<String> operators;

    private StringBuilder stringBuilderForText;
    private final char ZERO = '0';

    private int numbersArrayIndexNumber;
   // private StringBuilder currentNumberStringBuilder;



    public Function(){
        numbers = new ArrayList<StringBuilder>();

        //make a string builder object with value 0
        stringBuilderForText = new StringBuilder("0");

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
        /*
        * When number is pressed, because the default text shows 0, it needs to be first
        * replaced; hence, it first checks whether number displayed is zero; if it is, it
        * replaces zero with the number pressed;
        * */
        if(stringBuilderForText.charAt(0) == ZERO) {stringBuilderForText.setCharAt(0,theNumber);
        System.out.println(stringBuilderForText);}

        else{

            if(numbers.get(numbers.size()-1).toString().equals("+")){
                numbers.add(new StringBuilder().append(theNumber));

            }
            else{
                numbers.get(numbers.size()-1).append(theNumber);System.out.println(stringBuilderForText);
            }
        }
        /*if the last element in the numbers array is a plus character
        * then add a new stringBuilder object; else, append to current
        * stringBuilder object.
        * */


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
        stringBuilderForText.delete(0,stringBuilderForText.length());
        if(stringBuilderForText.length()==0) stringBuilderForText.append('0');
        //stringBuilderForText.setCharAt(0,'0');
        numbers.add(stringBuilderForText);
        Log.v("StringBuilderForText: ", ""+stringBuilderForText);
    }

    public void onClearPressed(){
        //text: 1+2
        // when user presses C it needs to delete
       if(numbers.size()==1){


           if(stringBuilderForText.length()==1){

               numbers.remove(numbers.size()-1);
               stringBuilderForText.delete(0,stringBuilderForText.length());
               stringBuilderForText.append("0");
               numbers.add(stringBuilderForText);
           }
           else {
               stringBuilderForText.deleteCharAt(stringBuilderForText.length()-1);

           }

       }

       else{

           numbers.get(numbers.size()-1).deleteCharAt(numbers.get(numbers.size()-1).length()-1);
           if(numbers.get(numbers.size()-1).length()==0) numbers.remove(numbers.size()-1);

       }


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

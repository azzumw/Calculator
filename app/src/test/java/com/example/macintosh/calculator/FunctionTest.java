package com.example.macintosh.calculator;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

/**
 * Created by macintosh on 02/08/2017.
 */
@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FunctionTest {

    @Test
    public void test_getSummaryString_afterAddingOneNumber() {
        // Given.
        Function function = new Function();
        function.onNumberCharacterPressed('5');

        // When.
        String result = function.getSummaryString();

        // Then.
        Assert.assertEquals("5", result);
    }

    @Test
    public void test_getSummaryString_afterAddingOneNumberAndOneOperator() {
        // Given.
        Function function = new Function();
        function.onNumberCharacterPressed('5');
        function.onOperatorCharacterPressed('+');

        // When.
        String result = function.getSummaryString();

        // Then.
        Assert.assertEquals("5+", result);
    }

    @Test
    public void test_getSummaryString_afterAddingTwoNumbersAndOneOperator() {
        // Given.
        Function function = new Function();
        function.onNumberCharacterPressed('5');
        function.onNumberCharacterPressed('4');
        function.onOperatorCharacterPressed('+');

        // When.
        String result = function.getSummaryString();

        // Then.
        Assert.assertEquals("54+", result);
    }

    @Test
    public void test_getSummaryString_afterAddingOneNumberOneOperatorAndOneNumber(){
        Function function = new Function();
        function.onNumberCharacterPressed('6');
        function.onOperatorCharacterPressed('+');
        function.onNumberCharacterPressed('6');

        String result = function.getSummaryString();
        Assert.assertEquals("6+6",result);
    }

    @Test
    public void test_getResult_for_oneNumber(){
        Function function = new Function();
        function.onNumberCharacterPressed('5');

        String result = function.getResult();

        Assert.assertEquals("5",result);

    }

    @Test
    public void test_getSummaryString_onZeroPressed(){
        Function function = new Function();
            int count = 0;
            while(count<3){
                function.onNumberCharacterPressed('0');
                count++;
            }


        String result = function.getSummaryString();
        Assert.assertEquals("0",result);


    }

    // TODO: fill in three missing getResult tests
    @Test
    public void test_get_Result_for_oneNumber_oneOperator_oneNumber(){
        Function function = new Function();
        function.onNumberCharacterPressed('5');
        function.onOperatorCharacterPressed('+');
        function.onNumberCharacterPressed('7');

        String result = function.getResult();

        Assert.assertEquals("12",result);
    }

    @Test
    public void test_getResult_for_NumbNumbOperatorZero (){
        Function function = new Function();
        function.onNumberCharacterPressed('4');
        function.onNumberCharacterPressed('8');
        function.onOperatorCharacterPressed('+');
        function.onNumberCharacterPressed('0');

        String result = function.getResult();

        Assert.assertEquals("48",result);

    }


    @Test
    public void test_onClearPressed_afterAddingOneNumber() {
        // Given.
        Function function = new Function();
        function.onNumberCharacterPressed('5');

        // When.
        function.onClearPressed();

        // Then.
        Assert.assertEquals("", function.getSummaryString());
    }

    @Test

    public void test_onClearPressed_whenNothingAdded() {
        // Given.
        Function function = new Function();

        // When.
        function.onClearPressed();

        // Then.
        Assert.assertEquals("", function.getSummaryString());
    }

    @Test
    public void test_onClearPressed_afterAddingTwoNumbers() {
        // Given.
        Function function = new Function();
        function.onNumberCharacterPressed('5');
        function.onNumberCharacterPressed('6');

        // When.
        function.onClearPressed();

        // Then.
        Assert.assertEquals("5", function.getSummaryString());
    }

    @Test
    public void test_onClearPressed_afterAddingOneNumberAndOneOperator() {
        // Given.
        Function function = new Function();
        function.onNumberCharacterPressed('5');
        function.onOperatorCharacterPressed('+');

        // When.
        function.onClearPressed();

        // Then.
        Assert.assertEquals("5", function.getSummaryString());
    }

    @Test
    public void test_onClearPressed_getResult(){
        Function function = new Function();
        function.onNumberCharacterPressed('5');
        function.onNumberCharacterPressed('6');
        function.onOperatorCharacterPressed('+');
        function.onNumberCharacterPressed('4');
        function.onNumberCharacterPressed('4');

        function.onClearPressed();

        String result = function.getResult();

        Assert.assertEquals("60",result);

    }

    @Test
    public void test_onClearPressed_ResultCheck(){
        Function function = new Function();

        function.onNumberCharacterPressed('3');
        function.onNumberCharacterPressed('0');
        function.onOperatorCharacterPressed('+');
        function.onNumberCharacterPressed('2');
        function.onNumberCharacterPressed('5');

        function.onClearPressed();

        String result = function.getResult();

        Assert.assertEquals("32",result);
    }

}
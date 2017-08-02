package com.example.macintosh.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

/**
 * Created by macintosh on 02/08/2017.
 */
@RunWith(JUnit4.class)
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

        int result = function.getResult();

        Assert.assertEquals(5,result);

    }


    // TODO: fill in three missing getResult tests




}
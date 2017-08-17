package com.example.macintosh.calculator;

import org.junit.Assert;
import org.junit.Before;
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

    private Function function;
    private ViewSummary summary;

    @Before
    public void setUp() {
        function = new Function(new OperatorFactory());
        summary = new ViewSummary();
    }

    @Test
    public void test_getSummaryString_afterAddingOneNumber() {
        // Given.
        function.onNumberCharacterPressed('5');

        // When.
        String result = summary.createSummary(function);

        // Then.
        Assert.assertEquals("5", result);
    }

    @Test
    public void test_getSummaryString_afterAddingOneNumberAndOneOperator() {
        // Given.
        function.onNumberCharacterPressed('5');
        function.onOperatorCharacterPressed('+');

        // When.
        String result = summary.createSummary(function);

        // Then.
        Assert.assertEquals("5+", result);
    }

    @Test
    public void test_getSummaryString_afterAddingTwoNumbersAndOneOperator() {
        // Given.
        function.onNumberCharacterPressed('5');
        function.onNumberCharacterPressed('4');
        function.onOperatorCharacterPressed('+');

        // When.
        String result = summary.createSummary(function);

        // Then.
        Assert.assertEquals("54+", result);
    }

    @Test
    public void test_getSummaryString_afterAddingOneNumberOneOperatorAndOneNumber() {
        function.onNumberCharacterPressed('6');
        function.onOperatorCharacterPressed('+');
        function.onNumberCharacterPressed('6');

        String result = summary.createSummary(function);
        Assert.assertEquals("6+6", result);
    }



    @Test
    public void test_getSummaryString_onZeroPressed() {
        int count = 0;
        while (count < 3) {
            function.onNumberCharacterPressed('0');
            count++;
        }


        String result = summary.createSummary(function);
        Assert.assertEquals("0", result);


    }





    @Test
    public void test_onClearPressed_afterAddingOneNumber() {
        // Given.
        function.onNumberCharacterPressed('5');

        // When.
        function.onClearPressed();

        // Then.
        Assert.assertEquals("", summary.createSummary(function));
    }

    @Test

    public void test_onClearPressed_whenNothingAdded() {
        // When.
        function.onClearPressed();

        // Then.
        Assert.assertEquals("", summary.createSummary(function));
    }

    @Test
    public void test_onClearPressed_afterAddingTwoNumbers() {
        // Given.
        function.onNumberCharacterPressed('5');
        function.onNumberCharacterPressed('6');

        // When.
        function.onClearPressed();

        // Then.
        Assert.assertEquals("5", summary.createSummary(function));
    }

    @Test
    public void test_onClearPressed_afterAddingOneNumberAndOneOperator() {
        // Given.
        function.onNumberCharacterPressed('5');
        function.onOperatorCharacterPressed('+');

        // When.
        function.onClearPressed();

        // Then.
        Assert.assertEquals("5", summary.createSummary(function));
    }


}
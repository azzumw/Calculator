package com.example.macintosh.calculator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;

/**
 * Created by macintosh on 02/08/2017.
 */
@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FunctionSummaryProviderTest {

    private Function function;
    private FunctionSummaryProvider summary;

    @Before
    public void setUp() {
        function = new Function(new OperatorFactory());
        summary = new FunctionSummaryProvider();
    }

    @Test
    public void test_provideSummary_afterAddingOneNumber() {
        // Given.
        function.onNumberCharacterPressed('5');

        // When.
        String result = summary.provideSummary(function);

        // Then.
        Assert.assertEquals("5", result);
    }

    @Test
    public void test_provideSummary_afterAddingOneNumberAndOneOperator() {
        // Given.
        function.onNumberCharacterPressed('5');
        function.onOperatorCharacterPressed('+');

        // When.
        String result = summary.provideSummary(function);

        // Then.
        Assert.assertEquals("5+", result);
    }

    @Test
    public void test_provideSummary_afterAddingTwoNumbersAndOneOperator() {
        // Given.
        function.onNumberCharacterPressed('5');
        function.onNumberCharacterPressed('4');
        function.onOperatorCharacterPressed('+');

        // When.
        String result = summary.provideSummary(function);

        // Then.
        Assert.assertEquals("54+", result);
    }

    @Test
    public void test_provideSummary_afterAddingOneNumberOneOperatorAndOneNumber() {
        function.onNumberCharacterPressed('6');
        function.onOperatorCharacterPressed('+');
        function.onNumberCharacterPressed('6');

        String result = summary.provideSummary(function);
        Assert.assertEquals("6+6", result);
    }

    @Test
    public void test_provideSummary_onZeroPressed() {
        int count = 0;
        while (count < 3) {
            function.onNumberCharacterPressed('0');
            count++;
        }


        String result = summary.provideSummary(function);
        Assert.assertEquals("0", result);


    }

    @Test
    public void test_onClearPressed_afterAddingOneNumber() {
        // Given.
        function.onNumberCharacterPressed('5');

        // When.
        function.onClearPressed();

        // Then.
        Assert.assertEquals("", summary.provideSummary(function));
    }

    @Test

    public void test_onClearPressed_whenNothingAdded() {
        // When.
        function.onClearPressed();

        // Then.
        Assert.assertEquals("", summary.provideSummary(function));
    }

    @Test
    public void test_onClearPressed_afterAddingTwoNumbers() {
        // Given.
        function.onNumberCharacterPressed('5');
        function.onNumberCharacterPressed('6');

        // When.
        function.onClearPressed();

        // Then.
        Assert.assertEquals("5", summary.provideSummary(function));
    }

    @Test
    public void test_onClearPressed_afterAddingOneNumberAndOneOperator() {
        // Given.
        function.onNumberCharacterPressed('5');
        function.onOperatorCharacterPressed('+');

        // When.
        function.onClearPressed();

        // Then.
        Assert.assertEquals("5", summary.provideSummary(function));
    }
}
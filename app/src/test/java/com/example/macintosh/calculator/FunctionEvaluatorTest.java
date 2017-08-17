package com.example.macintosh.calculator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by macintosh on 16/08/2017.
 */
public class FunctionEvaluatorTest {

    Function function;
    FunctionEvaluator functionEvaluator;

    @Before
    public void setFunction(){
        function = new Function(new OperatorFactory());
        functionEvaluator = new FunctionEvaluator();

    }

    @Test
    public void test_getResult_for_oneNumber() {
        function.onNumberCharacterPressed('5');

        int result = functionEvaluator.evaluate(function);

        Assert.assertEquals(5, result);

    }


    @Test
    public void test_get_Result_for_oneNumber_oneOperator_oneNumber() {
        function.onNumberCharacterPressed('5');
        function.onOperatorCharacterPressed('+');
        function.onNumberCharacterPressed('7');

        int result = functionEvaluator.evaluate(function);

        Assert.assertEquals(12, result);
    }


    @Test
    public void test_getResult_for_NumbNumbOperatorZero() {
        function.onNumberCharacterPressed('4');
        function.onNumberCharacterPressed('8');
        function.onOperatorCharacterPressed('+');
        function.onNumberCharacterPressed('0');

        int result = functionEvaluator.evaluate(function);

        Assert.assertEquals(48, result);
    }

    @Test
    public void test_subtract_number_Operator_number(){
        function.onNumberCharacterPressed('4');
        function.onOperatorCharacterPressed('-');
        function.onNumberCharacterPressed('1');

        int result = functionEvaluator.evaluate(function);

        assertEquals(3,result);
    }

    @Test
    public void test_multiplication_number_operator_number(){
        function.onNumberCharacterPressed('5');
        function.onOperatorCharacterPressed('x');
        function.onNumberCharacterPressed('3');

        int result = functionEvaluator.evaluate(function);

        assertEquals(15,result);
    }

}
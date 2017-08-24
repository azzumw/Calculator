package com.example.macintosh.calculator;

/**
 * Created by macintosh on 24/08/2017.
 */

public class FunctionClear {


    public void onClearPressed(Function function){
        if (!function.getNumbersList().isEmpty() || !function.getOperatorsList().isEmpty()) {
            if (function.getNumbersListSize() == function.getOperatorsListSize()) {
                function.getOperatorsList().remove(function.getOperatorsList().size() - 1);
            } else {
                if (function.getNumbersListSize()== 1) {
                    if (function.getLastNumber().length() == 1) {
                        onClearHold(function);
                    } else {
                        StringBuilder lastNumber = function.getLastNumber();
                        lastNumber.deleteCharAt(lastNumber.length() - 1);
                    }
                } else {
                    function.getLastNumber().deleteCharAt(function.getLastNumber().length() - 1);

                    if (function.getLastNumber().length() == 0) {
                        function.getNumbersList().remove(function.getNumbersListSize() - 1);
                    }
                }
            }
        }
    }

    public void onClearHold(Function function){
        function.getNumbersList().clear();
        function.getOperatorsList().clear();
    }
}

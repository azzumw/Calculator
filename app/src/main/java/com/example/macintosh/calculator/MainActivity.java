package com.example.macintosh.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtfield;
    TextView txtfieldans;

    FunctionEvaluator functionEvaluator;
    FunctionSummaryProvider functionSummaryProvider;
    Function function;
    FunctionClear functionClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtfield = findViewById(R.id.TextField);
        txtfieldans = findViewById(R.id.TextFieldAnswer);

        OperatorFactory operatorFactory = new OperatorFactory();
        function = new Function(operatorFactory);
        functionSummaryProvider = new FunctionSummaryProvider();
        functionEvaluator = new FunctionEvaluator();
        functionClear = new FunctionClear();

        txtfield.setText(functionSummaryProvider.provideSummary(function));
        txtfieldans.setText("");

        final Button plusBtn =  findViewById(R.id.btnPlus);
        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                function.onOperatorCharacterPressed('+');
                txtfield.setText(functionSummaryProvider.provideSummary(function));

            }
        });

        final Button minusBtn =  findViewById(R.id.btnSubtract);
        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                function.onOperatorCharacterPressed('-');
                txtfield.setText(functionSummaryProvider.provideSummary(function));
            }
        });


        final Button multiplyBtn =  findViewById(R.id.btnMultiply);
        multiplyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                function.onOperatorCharacterPressed('x');
                txtfield.setText(functionSummaryProvider.provideSummary(function));
            }
        });

        final Button clearBtn =  findViewById(R.id.btnClear);
        clearBtn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                //function.reset();
                functionClear.onClearHold(function);
                txtfield.setText(functionSummaryProvider.provideSummary(function));
                txtfieldans.setText("");
                return false;
            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                function.onClearPressed();
                functionClear.onClearPressed(function);
                txtfield.setText(functionSummaryProvider.provideSummary(function));
            }
        });


        final Button equalBtn =  findViewById(R.id.btnEquals);
        equalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtfieldans.setText(String.valueOf(functionEvaluator.evaluate(function)));
            }
        });

    }


    public void numberPress(View view) {
        Button btn = findViewById(view.getId());
        onNumberPressed(btn.getText().charAt(0));
    }

    private void onNumberPressed(char theNumber) {
        function.onNumberCharacterPressed(theNumber);
        txtfield.setText(functionSummaryProvider.provideSummary(function));
    }

    /**
     * @return boolean hasPeriod
     * checkPeriod method checks if there is any period
     * character displayed in the textView
     * if so, returns true, false otherwise.
     */
    public boolean checkPeriod() {
        boolean hasPeriod = false;
        char ch = '.';

        for (int i = 0; i < txtfield.getText().length(); i++) {
            if (txtfield.getText().charAt(i) == ch) {
                hasPeriod = true;
            }
        }

        return hasPeriod;
    }

    //BRACKETs
    //Open Bracket
        /*final Button btnOpenBracket = (Button) findViewById(R.id.btnOpenBracket);
        btnOpenBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(txtfield.getText().charAt(0)!='0'){
                    txtfield.append(btnOpenBracket.getText());
                }

                else{
                    if(checkPeriod()||checkOperator()){
                        txtfield.append(btnOpenBracket.getText());
                    }

                    else{
                        txtfield.setText(btnOpenBracket.getText());
                    }
                }

                numberOfOpenBrackets++;
            }
        });


        final Button btnCloseBracket = (Button) findViewById(R.id.btnCloseBracket);
        btnCloseBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numberOfClosingBrackets<numberOfOpenBrackets){
                    if(hasOpenBracket()){
                        if(txtfield.getText().charAt(0)!='0'){
                            txtfield.append(btnCloseBracket.getText());
                        }

                        else{
                            if(checkPeriod()||checkOperator()){
                                txtfield.append(btnCloseBracket.getText());
                            }

                            else{
                                txtfield.setText(btnCloseBracket.getText());
                            }
                        }

                        numberOfClosingBrackets++;
                    }

                    else{
                        Toast.makeText(MainActivity.this,"Missing Open Bracket",Toast.LENGTH_SHORT).show();
                    }

                }

                else{
                    Toast.makeText(MainActivity.this,"Missing Open Bracket",Toast.LENGTH_SHORT).show();
                }

            }
        });


        //button DOT
        final Button btnPeriod = (Button) findViewById(R.id.btnPeriod);
        btnPeriod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean hasPeriod = false;
                char ch='.';
                for(int i=0;i<txtfield.getText().length();i++){
                    if(txtfield.getText().charAt(i)==ch){
                        Toast.makeText(MainActivity.this,"Not allowed", Toast.LENGTH_SHORT).show();
                        hasPeriod = true;
                        return;
                    }
                }

                if(!hasPeriod){
                    txtfield.append(btnPeriod.getText());
                }


            }
        });*/

}

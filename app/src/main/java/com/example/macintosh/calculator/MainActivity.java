package com.example.macintosh.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.CharacterStyle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtfield;
    TextView txtfieldans;


    Function function;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //final TextView txtfield = (TextView) findViewById(R.id.TextField);
        txtfield = (TextView) findViewById(R.id.TextField);
        txtfieldans = (TextView) findViewById(R.id.TextFieldAnswer);



        function = new Function();
        txtfield.setText(function.getStringForTextView());
        txtfieldans.setText("");



        final Button plusBtn = (Button) findViewById(R.id.btnPlus);
        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                function.onOperatorCharacterPressed('+');
                txtfield.setText(function.getStringForTextView());

            }
        });


        final Button clearBtn = (Button) findViewById(R.id.btnClear);
        clearBtn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                function.onClearHeld();
                txtfield.setText(function.getStringForTextView());
                txtfieldans.setText("");
                return false;
            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                function.onClearPressed();
                txtfield.setText(function.getStringForTextView());
            }
        });


        final Button equalBtn = (Button) findViewById(R.id.btnEquals);
        equalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                txtfieldans.setText(String.valueOf(function.onEqualPress()));
            }
        });

    } //end of oncreate()


    public void numberPress(View view){
        final Button btn = (Button) findViewById(view.getId());
        onNumberPressed(btn.getText().charAt(0));
    }

    private void onNumberPressed(char theNumber) {
        function.onNumberCharacterPressed(theNumber);
        txtfield.setText(function.getStringForTextView());
    }




     /*
        final Button btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onNumberPressed('1');

            }
        });


        //BUTTON TWO
        final Button btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onNumberPressed('2');
            }
        });
           */

    //PLUS function
    @Override
    protected void onResume() {
        super.onResume();

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


    /**
     * checks if there is an operator in the text view.
     * returns true if it has.
     */
    public boolean checkOperator() {
        boolean hasOperator = false;
        char plus = '+';
        char minus = '-';
        char divide = '/';
        char multiply = 'x';

        for (int i = 0; i < txtfield.getText().length(); i++) {
            if (txtfield.getText().charAt(i) == plus || txtfield.getText().charAt(i) == minus ||
                    txtfield.getText().charAt(i) == divide || txtfield.getText().charAt(i) == multiply) {
                hasOperator = true;
            }
        }

        return hasOperator;
    }


    public boolean hasOpenBracket() {
        boolean hasOpenBracket = false;

        for (int i = 0; i < txtfield.getText().length(); i++) {
            if (txtfield.getText().charAt(i) == '(') {
                //numberOfOpenBrackets++;

                hasOpenBracket = true;
            }
        }
        return hasOpenBracket;
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

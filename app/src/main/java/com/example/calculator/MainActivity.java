package com.example.calculator;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import org.mariuszgromada.math.mxparser.*;
import android.view.Display;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.textView);
        display.setShowSoftInputOnFocus(false);

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getString(R.string.display).equals(display.getText().toString())){
                    display.setText("");
                }
            }

        });
    }
    private void fillText(String addedNumber){
        String previousAddition = display.getText().toString();
        int arrowPosition = display.getSelectionStart();
        String leftSide = previousAddition.substring(0, arrowPosition);
        String rightSide = previousAddition.substring(arrowPosition);
        if(getString(R.string.display).equals(display.getText().toString())){
            display.setText(addedNumber);
        }
        else{
            display.setText(String.format("%s%s%s", leftSide, addedNumber,rightSide));
            display.setSelection(arrowPosition+1);
        }
    }


    public void ZeroButton(View view){
        fillText("0");

    }
    public void OneButton(View view){
        fillText("1");

    }
    public void TwoButton(View view){
        fillText("2");

    }
    public void ThreeButton(View view){
        fillText("3");

    }
    public void FourButton(View view){
        fillText("4");

    }
    public void FiveButton(View view){
        fillText("5");

    }
    public void SixButton(View view){
        fillText("6");

    }
    public void SevenButton(View view){
        fillText("7");

    }
    public void EightButton(View view){
        fillText("8");

    }
    public void NineButton(View view){
        fillText("9");

    }
    public void ClearButton(View view){
        display.setText("");

    }
    public void ParenthesisButton(View view){
        int arrowPosition = display.getSelectionStart();
        int openParenthesis=0;
        int closeParenthesis=0;
        int textLength = display.getText().length();

        for(int i=0; i<arrowPosition; i++){
            if(display.getText().toString().substring(i,i+i).equals("(")){
                openParenthesis +=1;
            }
            if(display.getText().toString().substring(i,i+i).equals(")")){
                closeParenthesis +=1;
            }
        }
        if(openParenthesis==closeParenthesis || display.getText().toString().substring(textLength-1, textLength).equals("(")){
            fillText("(");
        }
        else if(closeParenthesis==openParenthesis && display.getText().toString().substring(textLength-1, textLength).equals("(")){
            fillText(")");
        }
        display.setSelection(arrowPosition + 1);

    }
    public void ExponentButton(View view){
        fillText("^");

    }
    public void DivisionButton(View view){
        fillText("/");

    }
    public void MultiplicationButton(View view){
        fillText("*");

    }
    public void SubtractionButton(View view){
        fillText("-");

    }
    public void AdditionButton(View view){
        fillText("+");

    }
    public void EqualButton(View view){
        String userChoice = display.getText().toString();
        Expression expression;
        expression = new Expression(userChoice);
        String result = String.valueOf(expression.calculate());
        display.setText(result);
        display.setSelection(result.length());
    }
    public void PointButton(View view){
        fillText(".");

    }
    public void PlusMinusButton(View view){
        fillText("+/-");

    }
    public void BackspaceButton(View view){
        int arrowPosition = display.getSelectionStart();
        int TextLength= display.getText().length();
        if(arrowPosition !=0 && TextLength !=0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(arrowPosition-1, arrowPosition,"");
            display.setText(selection);
            display.setSelection(arrowPosition-1);
        }

    }



}

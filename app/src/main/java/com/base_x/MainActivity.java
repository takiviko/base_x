package com.base_x;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button enterButton;
    TextView textView;
    EditText editText;

    Button fromMinus;
    Button fromPlus;
    Button toMinus;
    Button toPlus;
    TextView stateDisplay;

    String input;
    long numberInput;

    int fromInt;
    int toInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fromMinus = findViewById(R.id.fromMinus);
        fromPlus = findViewById(R.id.fromPlus);
        toMinus = findViewById(R.id.toMinus);
        toPlus = findViewById(R.id.toPlus);
        stateDisplay = findViewById(R.id.stateDisplay);

        enterButton = findViewById(R.id.enterButton);
        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);

        fromInt = 10;
        toInt = 10;

        stateDisplay.setText("base " + fromInt + " to base " + toInt);

        fromMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fromInt > 2) {
                    fromInt--;
                    stateDisplay.setText("base " + fromInt + " to base " + toInt);
                }
            }
        });

        fromPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(fromInt < 36)
                {
                    fromInt++;
                    stateDisplay.setText("base " + fromInt + " to base " + toInt);
                }
            }
        });

        toMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(toInt > 2) {
                    toInt--;
                    stateDisplay.setText("base " + fromInt + " to base " + toInt);
                }
            }
        });

        toPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(toInt < 36)
                {
                    toInt++;
                    stateDisplay.setText("base " + fromInt + " to base " + toInt);
                }
            }
        });

        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                input = editText.getText().toString();
                try {
                    numberInput = Long.parseLong(input, fromInt);
                    textView.setText(Long.toString(numberInput, toInt));
                }
                catch (NumberFormatException e) {
                    e.printStackTrace();
                    textView.setText("Invalid number!");
                }
            }
        });

    }
}

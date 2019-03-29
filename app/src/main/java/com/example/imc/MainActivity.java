package com.example.imc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText weight;
    EditText height;
    TextView result;
    TextView resultMessage;
    RadioButton maleGender;
    RadioButton femaleGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weight = findViewById(R.id.weightEditText);
        height = findViewById(R.id.heightEditText);
        result = findViewById(R.id.result);
        resultMessage = findViewById(R.id.resultTextMessage);
        maleGender = findViewById(R.id.maleRadioButton);
        femaleGender = findViewById(R.id.femaleRadioButton);
    }

    void setMaleMessage(Double imc){
        String output = "";
        if (imc <= 20.7){
            output = "Abaixo do peso";
        } else if (imc <= 26.4){
            output = "No peso normal";
        } else if (imc <= 27.8){
            output = "Marginalmente acima do peso";
        } else if (imc <= 31.1) {
            output = "Acima do peso ideal";
        } else {
            output = "Obeso";
        }
        resultMessage.setText(output);
    }

    void setFemaleMessage(Double imc){
        String output = "";
        if (imc <= 19.1){
            output = "Abaixo do peso";
        } else if (imc <= 25.8){
            output = "No peso normal";
        } else if (imc <= 27.3){
            output = "Marginalmente acima do peso";
        } else if (imc <= 32.3) {
            output = "Acima do peso ideal";
        } else {
            output = "Obeso";
        }
        resultMessage.setText(output);
    }

    void calc(View view){
        Double finalWeight = Double.valueOf(weight.getText().toString());
        Double finalHeight = Double.valueOf(height.getText().toString());
        Double imc = finalHeight*finalHeight;
        imc = finalWeight/imc;

        if(maleGender.isChecked()){
            setMaleMessage(imc);
        } else {
            setFemaleMessage(imc);
        }

        result.setText(imc.toString());
    }
}

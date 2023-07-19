package com.example.gpacalculator;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.annotation.SuppressLint;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    boolean isNewOp = true;
    boolean isNightModeOn;
    EditText ed1,ed2;
    Double result;
    String newNumber;
    Double totalGP=0.0;
    double totalC = 0.0;
    int count = 0;
    FloatingActionButton fab;
    int input = 1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        getSupportActionBar().setTitle("GPA-Calculator");
//        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.calcButton)));



        fab = findViewById(R.id.fab);
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_NO) {
            isNightModeOn = false;
        } else {
            isNightModeOn = true;
        }
        ed1 = findViewById(R.id.editText);
        ed2 = findViewById(R.id.editText2);

//        fab.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
//                if(isNightModeOn){
//                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//                    isNightModeOn = false;
//                }
//
//                else{
//                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
//                    isNightModeOn= true;
//                }
//            }
//        });

        fab.setOnClickListener(v -> {

            if (isNightModeOn) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                ed2.setText("reopening in 4s");
                isNightModeOn = false;
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                ed2.setText("reopening in 4s");
                isNightModeOn = true;
            }
        });

        ed1.setShowSoftInputOnFocus(false);
        ed2.setShowSoftInputOnFocus(false);

    }
    public void numberEvent(View view){
        double b1,b2,b3,b4,b5;
        if (isNewOp)
            ed1.setText("");
        isNewOp=false;

        String number = ed1.getText().toString();
//        input++;

//        setting the logic for unpredicted input
        if (input % 2 != 0) {
            switch (view.getId()) {
                case R.id.buttonO:
                    number = "O ➡ ";
                    newNumber = "10";
                    ed2.setText("Now credits ;)");
                    input++;
                    break;
                case R.id.buttonAA:
                    number = "A+ ➡ ️";
                    newNumber = "9";
                    ed2.setText("Now credits ;)");
                    input++;
                    break;
                case R.id.buttonA:
                    number = "A ➡ ";
                    newNumber = "8";
                    ed2.setText("Now credits ;)");
                    input++;

                    break;
                case R.id.buttonBB:
                    number = "B+ ➡ ";
                    newNumber = "7";
                    ed2.setText("Now credits ;)");
                    input++;
                    break;
                case R.id.buttonB:
                    number = "B ➡ ";
                    newNumber = "6";
                    ed2.setText("Now credits ;)");
                    input++;
                    break;
                case R.id.buttonC:
                    number = "C ➡ ";
                    newNumber = "5";
                    ed2.setText("Now credits ;)");
                    input++;
                    break;
                case R.id.buttonP:
                    number = "P ➡ ";
                    newNumber = "4";
                    ed2.setText("Now credits ;)");
                    input++;
                    break;
                case R.id.buttonF:
                    number = "F ➡ ";
                    newNumber = "0";
                    ed2.setText("Now credits :(");
                    input++;
                    break;
                case R.id.button5:
                    ed2.setText("Enter grades first");
                    break;
                case (R.id.button4):
                    ed2.setText("Enter grades first");
                    break;
                case (R.id.button3):
                    ed2.setText("Enter grades first");
                    break;
                case (R.id.button2):
                    ed2.setText("Enter grades first");
                    break;
                case (R.id.button1):
                    ed2.setText("Enter grades first");
                    break;
            }
        }
        else{
            switch (view.getId()){
                case R.id.button5:
                    number += "5 ";
                    b5 = 5.0;
                    result = Double.parseDouble(newNumber) * b5;
                    totalC += b5;
                    input++;
                    break;
                case R.id.button4:
                    number += "4 ";
                    b4 = 4.0;
                    result = Double.parseDouble(newNumber) * b4;
                    totalC += b4;
                    input++;
                    break;
                case R.id.button3:
                    number += "3 ";
                    b3 = 3.0;
                    result = Double.parseDouble(newNumber) * b3;
                    totalC += b3;
                    input++;
                    break;
                case R.id.button2:
                    number += "2 ";
                    b2 = 2.0;
                    result = Double.parseDouble(newNumber) * b2;
                    totalC += b2;
                    input++;
                    break;
                case R.id.button1:
                    number += "1 ";
                    b1 = 1.0;
                    result = Double.parseDouble(newNumber) * b1;
                    totalC += b1;
                    input++;
                    break;
            }
        }
        ed1.setText(number);
    }
    public void nextEvent(View view){
        count++;
        ed2.setText(count+" Subject added ");
        ed1.setText("Added ");
        totalGP += result;
        newNumber = "0";
        result = 0.0;

    }
    public void calcEvent(View view){
        ed2.setText("Your GPA for "+count+" subject ");
        double yourGPA = totalGP/totalC;
        ed1.setText(String.format( "%.1f", yourGPA));
    }
    public void acEvent(View view){
        ed1.setText("0");
        input=1;
        isNewOp=true;
        totalC=0.0;
        totalGP=0.0;
        count=0;
        ed2.setText("Data cleared ");

    }

}
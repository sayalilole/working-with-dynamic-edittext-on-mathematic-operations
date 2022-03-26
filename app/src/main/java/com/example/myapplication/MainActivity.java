package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    Button btnAdd,btnsub,btnmul,btnDiv,btnIn;
    LinearLayout linearLayoutInput;
    float edt1,edt2,result;
    ArrayList<EditText>arrEditTexts=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);

        btnAdd = findViewById(R.id.btnAdd);
        btnsub = findViewById(R.id.btnSub);
        btnmul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        btnIn = findViewById(R.id.btnIn);
        linearLayoutInput=findViewById(R.id.container);
        btnAdd.setOnClickListener(new btnAdditionListner());

        btnIn.setOnClickListener( new BtnAddEdtTxt());
        btnsub.setOnClickListener(new btnSubstractionListner());
        btnmul.setOnClickListener(new btnMultiplicationListner());
        btnDiv.setOnClickListener(new btnDivisionListner());

    }
    private class BtnAddEdtTxt implements View.OnClickListener
    {

        @Override
        public void onClick(View view) {
        EditText AddEdTxt= new EditText(MainActivity.this);
        AddEdTxt.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        AddEdTxt.setInputType(InputType.TYPE_CLASS_NUMBER);////set to keyboard numeric format
        linearLayoutInput.addView(AddEdTxt);
        arrEditTexts.add(AddEdTxt);
        }
    }
    private class btnAdditionListner implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            int sum = 0;
            for (int i = 0; i < arrEditTexts.size(); i++) {
                sum = sum + Integer.parseInt(arrEditTexts.get(i).getText().toString());
                textView.setText(sum + "");
            }

        }

        }
    private class btnSubstractionListner implements View.OnClickListener {
        @Override
        public void onClick(View view) {
          float sum = Float.parseFloat(arrEditTexts.get(0).getText().toString());
            for (int i = 1; i < arrEditTexts.size(); i++) {
                sum = sum - Float.parseFloat(arrEditTexts.get(i).getText().toString());
                textView.setText(sum + "");
            }

        }
    }
    private class btnMultiplicationListner implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            float sum = Float.parseFloat(arrEditTexts.get(0).getText().toString());
            for (int i = 1; i < arrEditTexts.size(); i++) {
                sum = sum * Float.parseFloat(arrEditTexts.get(i).getText().toString());
                textView.setText(sum + "");
            }

        }
    }
    private class btnDivisionListner implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            float sum = Float.parseFloat(arrEditTexts.get(0).getText().toString());
            for (int i = 1; i < arrEditTexts.size(); i++) {
                sum = sum / Float.parseFloat(arrEditTexts.get(i).getText().toString());
                textView.setText(sum + "");
            }

        }
    }
}
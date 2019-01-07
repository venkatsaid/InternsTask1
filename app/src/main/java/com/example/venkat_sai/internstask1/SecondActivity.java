package com.example.venkat_sai.internstask1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    int id;
    EditText editText;
    TextView textView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        id=getIntent().getIntExtra("Id",0);
        editText=findViewById(R.id.text);
        textView=findViewById(R.id.result);
        button=findViewById(R.id.submit);
        button.setEnabled(false);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if(s.toString().trim().length()==0){//checking is edit text empty or not
                    button.setEnabled(false);// if empty disabling the button
                } else {
                    button.setEnabled(true);
                }
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textView.setText(null); // when changes in edit text settig the text label to empty
                if(s.toString().trim().length()==0){//checking is edit text empty or not
                    button.setEnabled(false);// if empty disabling the button
                } else {
                    button.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        if(id==1){
            getSupportActionBar().setTitle(R.string.encryption);// setting title according to the id fromm previous activity(FirstActivity)
        }else if(id==2){
            getSupportActionBar().setTitle(R.string.decryption);
        }

    }

    public void submit(View view) { // action of submit button
        String s=editText.getText().toString(),s1="";
        if (id==1){// logic for encryption
            for(int i=0;i<s.length();i++){
                int count=1;
                while(i<s.length()-1 && s.charAt(i)!='\0' && (s.charAt(i)==s.charAt(i+1)))// checking next character is same or end of text
                { count+=1;
                    i++;
                }
                s1=s1+s.charAt(i)+String.valueOf(count);
            }
            textView.setText(s1);//setting result to text label

        }
        else if(id==2){
            for(int i=1;i<s.length();i+=2){//reading numbers at the odd positions
                int j=Character.getNumericValue(s.charAt(i));
                while(j>0)
                {
                    s1=s1+s.charAt(i-1);// adding characters according to the count
                    j--;
                }
            }
            textView.setText(s1);//setting result to the text label
        }
    }
}

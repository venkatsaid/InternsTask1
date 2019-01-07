package com.example.venkat_sai.internstask1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FirstActivity extends AppCompatActivity {
Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        intent=new Intent(this,SecondActivity.class);
        getSupportActionBar().setTitle(R.string.cryptostring);
    }

    public void encryption(View view) {
        intent.putExtra("Id",1);//having an id to know which button is selected
        startActivity(intent);
    }

    public void decryption(View view) {
        intent.putExtra("Id",2);//having an id to know which button is selected
        startActivity(intent);
    }
}

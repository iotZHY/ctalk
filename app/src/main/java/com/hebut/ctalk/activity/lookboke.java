package com.hebut.ctalk.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.hebut.ctalk.R;

public class lookboke extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();//隐藏标题栏
        TextView boke=findViewById(R.id.boke);
        @SuppressLint("WrongViewCast") Button write= findViewById(R.id.write);
        @SuppressLint("WrongViewCast") ImageButton back=findViewById(R.id.bokeback);
        setContentView(R.layout.activity_boke);



    }

}

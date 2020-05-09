package com.hebut.ctalk.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.hebut.ctalk.R;

public class Login extends AppCompatActivity {
    private Button bt1;

    @Override

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);
        Button bt1 = (Button) findViewById(R.id.bt_1);
        bt1.setOnClickListener(new NewClickListner());

    }

    class NewClickListner implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent1 = new Intent(Login.this, after.class);

            switch (v.getId()) {
                case R.id.bt_1:
                    startActivity(intent1);
                    break;
                //case R.id.boke:
                // startActivity(intent2);
                //break;

            }
        }


    }
}










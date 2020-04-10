package com.hebut.ctalk.activity;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.hebut.ctalk.R;
import gr.net.maroulis.library.EasySplashScreen;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();//隐藏标题栏
        View easySplashScreenView = new EasySplashScreen(SplashActivity.this)
                .withFullScreen()
                .withTargetActivity(MainActivity.class)
                .withSplashTimeOut(4000)
                .withBackgroundResource(R.color.white)
                .withFooterText("Don't Have Copyright")
                .withBeforeLogoText("CTalk--技术交流平台")
                .withLogo(R.mipmap.ct)
                .create();
        setContentView(easySplashScreenView);
    }
}

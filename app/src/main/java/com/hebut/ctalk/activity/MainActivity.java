package com.hebut.ctalk.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Bundle;


import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import com.hebut.ctalk.R;
import com.hebut.ctalk.adapter.CPageAdapter;
import com.hebut.ctalk.fragment.Home;
import com.hebut.ctalk.fragment.Message;
import com.hebut.ctalk.fragment.New;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private BottomNavigationBar bottomNavigationBar;

    private ViewPager viewPager;
    private List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();//隐藏标题栏
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.view_page);
        bottomNavigationBar = findViewById(R.id.bottom_bar);
        initViewPage();
        initBottomNavigation();

    }

    private void initViewPage() {
        viewPager.setOffscreenPageLimit(5);
        fragments = new ArrayList<>();

        fragments.add(new Home(new String[]{"1","2","3"}));
        fragments.add(new Home(new String[]{"7","8","9"}));
        fragments.add(new New());
        fragments.add(new Message());

        viewPager.setAdapter(new CPageAdapter(getSupportFragmentManager(),fragments));
        viewPager.setCurrentItem(0);
    }

    @SuppressLint("ResourceAsColor")
    private void initBottomNavigation() {
        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener(){
            @Override
            public void onTabSelected(int position) {
                viewPager.setCurrentItem(position);
            }
            @Override
            public void onTabUnselected(int position) {
            }
            @Override
            public void onTabReselected(int position) {
            }
        });
        bottomNavigationBar.setAutoHideEnabled(true);
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        bottomNavigationBar.setBackgroundColor(R.color.bottomBar);
        bottomNavigationBar.setActiveColor(R.color.blue);
        bottomNavigationBar.setInActiveColor(R.color.black);
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.mipmap.home, "Home"))
                .addItem(new BottomNavigationItem(R.mipmap.html, "Html"))
                .addItem(new BottomNavigationItem(R.mipmap.add, "new"))
                .addItem(new BottomNavigationItem(R.mipmap.message, "Message"))
                .addItem(new BottomNavigationItem(R.mipmap.user, "User"))
                .setFirstSelectedPosition(0)
                .initialise();
    }
}

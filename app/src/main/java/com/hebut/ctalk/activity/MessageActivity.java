//package com.hebut.ctalk.activity;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.viewpager.widget.ViewPager;
//
//import android.os.Bundle;
//
//import com.google.android.material.tabs.TabLayout;
//import com.hebut.ctalk.R;
//import com.hebut.ctalk.adapter.MessagePageFragmentAdapter;
//
//public class MessageActivity extends AppCompatActivity {
//    private ViewPager viewPager;
//    private TabLayout tabLayout;
//    private TabLayout.Tab tab_inform;
//    private TabLayout.Tab tab_message;
//    private MessagePageFragmentAdapter messagePageFragmentAdapter;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_message);
//        initViews();
//
//
//    }
//
//    private void initViews() {
//        //使用适配器将ViewPager与Fragment绑定在一起
//        viewPager = (ViewPager) findViewById(R.id.vp_message);
//        messagePageFragmentAdapter= new MessagePageFragmentAdapter(getSupportFragmentManager());
//        viewPager.setAdapter(messagePageFragmentAdapter);
//
//        //将TabLayout与ViewPager绑定在一起
//        tabLayout = (TabLayout) findViewById(R.id.tl_message);
//        tabLayout.setupWithViewPager(viewPager);
//        //指定Tab的位置
//        tab_message = tabLayout.getTabAt(0);
//        tab_inform = tabLayout.getTabAt(1);
//
//
//    }
//
//
//
//}

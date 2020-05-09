package com.hebut.ctalk.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.hebut.ctalk.R;
import com.hebut.ctalk.adapter.MessagePageFragmentAdapter;

public class Message extends Fragment {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private TabLayout.Tab tab_inform;
    private TabLayout.Tab tab_message;
    private MessagePageFragmentAdapter messagePageFragmentAdapter;
    private View view;

    public Message() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_message, container, false);
        tabLayout = view.findViewById(R.id.tl_message);
        viewPager = view.findViewById(R.id.vp_message);
        initView();
        return view;
    }

    private void initView() {
        messagePageFragmentAdapter = new MessagePageFragmentAdapter(getChildFragmentManager());
        viewPager.setAdapter(messagePageFragmentAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

}

package com.hebut.ctalk.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.hebut.ctalk.R;
import com.hebut.ctalk.activity.lookboke;
import com.hebut.ctalk.activity.Login;

public class fivenew extends Fragment {
    private ImageButton login;
    private ImageButton boke;
    public fivenew() {

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.activity_self, container, false);
    }

    @SuppressLint("WrongViewCast")
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        login=getView().findViewById(R.id.login1);
        login.setOnClickListener(new NewClickListner());
        boke=getView().findViewById(R.id.boke);
        boke.setOnClickListener(new NewClickListner());

    }
    class NewClickListner implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            Intent intent1=new Intent(getActivity(), Login.class);
            Intent intent2=new Intent(getActivity(), lookboke.class);
            switch (v.getId()) {
                case R.id.login1:
                    startActivity(intent1);
                    break;
                case R.id.boke:
                    startActivity(intent2);
                    break;

            }
        }
    }
}

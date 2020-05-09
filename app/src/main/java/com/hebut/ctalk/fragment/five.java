package com.hebut.ctalk.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.hebut.ctalk.R;
import com.hebut.ctalk.activity.MainActivity;
import com.hebut.ctalk.activity.lookboke;
import com.hebut.ctalk.activity.Login;

public class five extends Fragment {
    private Button login;
    private ImageButton boke;
    private ImageButton tiezi;
    private ImageButton shouzang;
    private ImageButton shezhi;
    public five() {

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.activity_selfnew, container, false);
}

    @SuppressLint("WrongViewCast")
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        login=getView().findViewById(R.id.login2);
        login.setOnClickListener(new NewClickListner());
        boke=getView().findViewById(R.id.boke);
        boke.setOnClickListener(new NewClickListner());
        tiezi=getView().findViewById(R.id.tiezi);
        tiezi.setOnClickListener(new NewClickListner());
        shouzang=getView().findViewById(R.id.shouzangjia);
        shouzang.setOnClickListener(new NewClickListner());
        shezhi=getView().findViewById(R.id.shezhi);
        shezhi.setOnClickListener(new NewClickListner());


    }
    class NewClickListner implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            Intent intent1=new Intent(getActivity(), Login.class);
            //Intent intent2=new Intent(getActivity(), lookboke.class);
            switch (v.getId()) {
                case R.id.login2:
                    startActivity(intent1);
                    break;
                case R.id.boke:
                    Toast.makeText(getActivity(),"请您先登陆！",Toast.LENGTH_LONG).show();
                    //startActivity(intent2);
                    break;
                case R.id.tiezi:
                    Toast.makeText(getActivity(),"请您先登陆！",Toast.LENGTH_LONG).show();
                    break;
                case R.id.shouzangjia:
                    Toast.makeText(getActivity(),"请您先登陆！",Toast.LENGTH_LONG).show();
                    break;
                case R.id.shezhi:
                    Toast.makeText(getActivity(),"请您先登陆！",Toast.LENGTH_LONG).show();
                    break;
            }
        }
    }
}

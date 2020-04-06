package com.hebut.ctalk.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.hebut.ctalk.R;
import com.hebut.ctalk.activity.AreToolBarActivity;

public class New extends Fragment {
    private ImageButton blog,question;

    public New(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_new,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        blog = getView().findViewById(R.id.img_btn_blog);
        question = getView().findViewById(R.id.img_btn_question);
        blog.setOnClickListener(new NewClickListener());
        question.setOnClickListener(new NewClickListener());
    }

    class NewClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getActivity(), AreToolBarActivity.class);
            startActivity(intent);
        }
    }
}

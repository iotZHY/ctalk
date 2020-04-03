package com.hebut.ctalk.fragment;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

public class Home extends ListFragment {
    String[] strings;
    public Home(String[] strings){
        this.strings=strings;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_activated_1,strings));
    }
}

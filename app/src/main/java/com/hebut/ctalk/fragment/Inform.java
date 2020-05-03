package com.hebut.ctalk.fragment;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hebut.ctalk.R;
import com.hebut.ctalk.adapter.InformLinearAdapter;
import com.hebut.ctalk.dto.MessageDTO;
import com.hebut.ctalk.dto.UserDTO;

import java.util.ArrayList;


public class Inform extends Fragment {
    private RecyclerView recyclerView;
    private View view;
    private ArrayList<MessageDTO> messageArrayList;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_inform_list, container, false);
        initData();//初始化数据
        initView();//初始化界面+数据
        return view;
    }

    private void initView() {

        recyclerView = (RecyclerView)view.findViewById(R.id.rv_inform_list);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //recyclerView.addItemDecoration(new SimpleDividerDecoration(getContext()));
        InformLinearAdapter myAdapter = new InformLinearAdapter(getActivity(), messageArrayList);
        myAdapter.setOnItemClickListener(new InformLinearAdapter.OnItemClickListener() {
            @Override
            public void OnClick(View v, int position) {
                Toast.makeText(getContext(),"点击："+ position,Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(myAdapter);


    }
    private void initData(){
        messageArrayList = new ArrayList<MessageDTO>();
        //获得用户实体
        UserDTO user = new UserDTO("zxihhihd","zhang","男", "123456", "9", "url:xxxxxx");
        //利用接口插查询
        MessageDTO message1 = new MessageDTO("0112132322", "抗击疫情，我们是认真的！",user,"2019-3-12","为鼓励大家在疫情期间学习，我们开放了免费的VIP权益","inform");
        MessageDTO message2 = new MessageDTO("012121212","你已经完成了任务",user,"2019-04-16","恭喜！您获得了1000金币的奖励！","inform");
        messageArrayList.add(message1);
        messageArrayList.add(message2);
        messageArrayList.add(message1);
        messageArrayList.add(message2);
        messageArrayList.add(message1);
        messageArrayList.add(message2);
        messageArrayList.add(message1);
        messageArrayList.add(message2);
        messageArrayList.add(message1);
        messageArrayList.add(message2);
        messageArrayList.add(message1);
        messageArrayList.add(message2);

    }

    class SimpleDividerDecoration extends RecyclerView.ItemDecoration {

        private int dividerHeight;
        private Paint dividerPaint;

        public SimpleDividerDecoration(Context context) {
            dividerPaint = new Paint();
            dividerPaint.setColor(context.getResources().getColor(R.color.gray));
            dividerHeight = context.getResources().getDimensionPixelSize(R.dimen.divider_height);
        }


        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.bottom = dividerHeight;
        }

        @Override
        public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
            int childCount = parent.getChildCount();
            int left = parent.getPaddingLeft();
            int right = parent.getWidth() - parent.getPaddingRight();

            for (int i = 0; i < childCount; i++) {
                View view = parent.getChildAt(i);
                float top = view.getBottom();
                float bottom = view.getBottom() + dividerHeight;
                c.drawRect(left, top, right, bottom, dividerPaint);
            }
        }
    }


}

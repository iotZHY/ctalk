package com.hebut.ctalk.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hebut.ctalk.R;
import com.hebut.ctalk.dto.MessageDTO;

import java.util.ArrayList;

public class MessageLinearAdapter extends RecyclerView.Adapter<MessageLinearAdapter.LinearViewHolder>{
    private Context mContext;
    private ArrayList<MessageDTO> messageArrayList;

    public MessageLinearAdapter(Context context, ArrayList<MessageDTO> messageArrayList){
        this.mContext = context;
        this.messageArrayList = messageArrayList;

    }




    @NonNull
    @Override
    public LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.message_item, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull LinearViewHolder holder, int position) {
//        //给控件设置内容
        holder.title.setText((CharSequence) messageArrayList.get(position).getTitle());
        holder.content.setText((CharSequence) messageArrayList.get(position).getContent());
        holder.date.setText((CharSequence) messageArrayList.get(position).getDate());

//        int resource = R.drawable.image;
//        Glide.with(mContext).load(resource).into(holder.image);加载应用资源
//        加载url对象
//        Glide.with(mContext).load("https://www.baidu.com/img/bd_logo1.png").into(holder.image);



    }



    @Override
    public int getItemCount() {

        return messageArrayList.size();
    }
    class LinearViewHolder extends RecyclerView.ViewHolder{
        private TextView title;
        private TextView content;
        private TextView date;
        private ImageView image;

        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            //找到控件
            title = (TextView) itemView.findViewById(R.id.tv_message_item_title);
            content = (TextView) itemView.findViewById(R.id.tv_message_item_content);
            date = (TextView) itemView.findViewById(R.id.tv_message_item_date);
            image = itemView.findViewById(R.id.iv_message_item_picture);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(onItemClickListener!=null){
                        onItemClickListener.OnClick(view,getLayoutPosition());
                    }
                }
            });
        }
    }
    private OnItemClickListener onItemClickListener;
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;

    }
    //设置点击时间的接口
    public interface OnItemClickListener{
        void OnClick(View view, int layoutPosition);
    }
}


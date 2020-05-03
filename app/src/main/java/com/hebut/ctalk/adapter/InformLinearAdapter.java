package com.hebut.ctalk.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hebut.ctalk.R;
import com.hebut.ctalk.dto.MessageDTO;

import java.util.ArrayList;

public class InformLinearAdapter extends RecyclerView.Adapter<InformLinearAdapter.LinearViewHolder>{
    private Context mContext;
    private ArrayList<MessageDTO> messageArrayList;

    public InformLinearAdapter(Context context, ArrayList<MessageDTO> messageArrayList){
        this.mContext = context;
        this.messageArrayList = messageArrayList;

    }




    @NonNull
    @Override
    public LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearViewHolder viewHolder = new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.infrom_item, parent, false));

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull LinearViewHolder holder, int position) {
//        //给控件设置内容
        holder.title.setText((CharSequence) messageArrayList.get(position).getTitle());
        holder.content.setText((CharSequence) messageArrayList.get(position).getContent());
        holder.date.setText((CharSequence) messageArrayList.get(position).getDate());
        


    }



    @Override
    public int getItemCount() {

        return messageArrayList.size();
    }
    class LinearViewHolder extends RecyclerView.ViewHolder{
        private TextView title;
        private TextView content;
        private TextView date;

        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            //找到控件
            title = (TextView) itemView.findViewById(R.id.tv_inform_item_title);
            content = (TextView) itemView.findViewById(R.id.tv_inform_item_content);
            date = (TextView) itemView.findViewById(R.id.tv_inform_item_date);

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

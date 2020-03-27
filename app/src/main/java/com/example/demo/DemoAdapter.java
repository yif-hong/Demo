package com.example.demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DemoAdapter extends RecyclerView.Adapter<DemoAdapter.DemoViewHolder> {

    public DemoAdapter(List<String> mDatas, Context context) {
        this.mDatas = mDatas;
        this.context = context;
    }

    private List<String> mDatas;
    private Context context;

    @NonNull
    @Override
    public DemoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent,false);
        return new DemoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DemoViewHolder holder, int position) {
        holder.textView.setText(mDatas.get(position));
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    static class DemoViewHolder extends RecyclerView.ViewHolder{
        TextView textView;

        public DemoViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text);
        }
    }
}

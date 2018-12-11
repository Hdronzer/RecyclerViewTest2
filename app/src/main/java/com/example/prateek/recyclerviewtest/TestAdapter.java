package com.example.prateek.recyclerviewtest;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.ViewHolder> {
    private int mDataSet[];
    private LayoutInflater layoutInflater;
    private int centerPos = -1;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        private RelativeLayout layout;
        public ViewHolder(View v){
            super(v);
            this.textView = (TextView)v.findViewById(R.id.tv);
            this.layout = (RelativeLayout)v.findViewById(R.id.relative);
        }
    }

    public void setCenterPos(int pos){
        this.centerPos = pos;
    }

    public TestAdapter(int mDataSet[], Context context){
        this.mDataSet = mDataSet;
        layoutInflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public TestAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if(layoutInflater == null)
            layoutInflater = LayoutInflater.from(viewGroup.getContext());

        View v = layoutInflater.inflate(R.layout.custom_row,viewGroup,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TestAdapter.ViewHolder viewHolder, int position) {

        viewHolder.textView.setText(""+mDataSet[position]);

        if(position == centerPos){
            viewHolder.layout.setBackgroundColor(Color.parseColor("#ff00ff"));
        }
        else
        {
            viewHolder.layout.setBackgroundColor(Color.parseColor("#ffffff"));
        }
    }

    @Override
    public int getItemCount() {
        return mDataSet.length;
    }
}

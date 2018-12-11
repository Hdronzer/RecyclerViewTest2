package com.example.prateek.recyclerviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewTreeObserver;
import android.widget.Adapter;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private TestAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    private int mDataSet[];
    public static final int MAX_SIZE = 10000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView)findViewById(R.id.mrecycler_view);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        loadData();
        mAdapter = new TestAdapter(mDataSet, this);

        mRecyclerView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int lastPos = mLayoutManager.findLastCompletelyVisibleItemPosition();
                int firstPos = mLayoutManager.findFirstVisibleItemPosition();
                int centerPos = Math.abs(lastPos - firstPos)/2 + firstPos;
                mAdapter.setCenterPos(centerPos);
                mAdapter.notifyDataSetChanged();
            }
        });
        mRecyclerView.setAdapter(mAdapter);


    }

    private void loadData(){
        if(mDataSet == null){
            mDataSet = new int[MAX_SIZE];
            for(int i =0;i< MAX_SIZE;i++){
                mDataSet[i] = i+1;
            }
        }
    }
}

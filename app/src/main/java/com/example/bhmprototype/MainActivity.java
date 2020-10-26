package com.example.bhmprototype;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    private RecyclerView mRecyclerView2;
    private Adapter mAdapter2;
    private RecyclerView.LayoutManager mLayoutManager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new Adapter(this);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Log.d("PROBA",Integer.toString(position) + "Trenutni item na poziciji");
            }
        });
        mAdapter.setOnItemFocusListener(new Adapter.OnItemFocusListener() {
            @Override
            public void onItemFocus(int position) {

            }
        });

        mRecyclerView2 = findViewById(R.id.rv2);
        mRecyclerView2.setHasFixedSize(true);
        mLayoutManager2 = new LinearLayoutManager(this);
        mAdapter2 = new Adapter(this);

        mRecyclerView2.setLayoutManager(mLayoutManager2);
        mRecyclerView2.setAdapter(mAdapter2);


    }
}
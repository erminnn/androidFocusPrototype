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
    private TextView itemText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        itemText = findViewById(R.id.tvItemText);
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
                itemText.setText(Integer.toString(position) + "Ermin");
            }
        });
    }
}
package com.example.bhmprototype;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    int[] data;
    private View previousFocusedView = null;
    private int currentlyFocusedPos = 0;
    private OnItemClickListener mListener;
    private OnItemFocusListener mFocusListener;

    private final static int SELECTOR_COLOR = 0xFFBDBDBD;

    public Adapter(Context context) {
        data = new int[100];
        for(int i=0;i<data.length;i++){
            data[i]=i+1;
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        v.setFocusable(true);
        v.setFocusableInTouchMode(true);
        ViewHolder vh = new ViewHolder(v,mListener,mFocusListener);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder,final int position) {
        holder.textView.setText(Integer.toString(data[position]));
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public ViewHolder(View itemView, final OnItemClickListener listener, final OnItemFocusListener focusListener) {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.tvItem);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        listener.onItemClick(currentlyFocusedPos);
                    }
                }
            });
            itemView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    updateFocusPositions(v,hasFocus,getAdapterPosition());
                    if(focusListener != null){
                        focusListener.onItemFocus(currentlyFocusedPos);
                    }
                }
            });

        }
    }

    private void updateFocusPositions(View view, boolean hasFocus, int position) {
        if (hasFocus) {
            currentlyFocusedPos = position;
            view.setBackgroundColor(Color.parseColor("#03A9F4"));
            if(previousFocusedView !=null){
                previousFocusedView.setBackgroundColor(Color.parseColor("#F19918"));
            }
        } else {
            previousFocusedView = view;
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public interface OnItemFocusListener {
        void onItemFocus(int position);
    }

    public void setOnItemFocusListener(OnItemFocusListener focusListener) {
        mFocusListener = focusListener;
    }

}

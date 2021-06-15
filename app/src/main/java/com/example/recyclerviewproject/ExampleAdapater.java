package com.example.recyclerviewproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExampleAdapater extends RecyclerView.Adapter<ExampleAdapater.ExampleViewHolder>
{
    private  ArrayList<ExampleItem> mExampleList;
    private  onItemClickListener mListener;

    public interface  onItemClickListener
    {
        void onItemClick(int position);
        void onDeleteClick(int position);
    }

    public void setOnItemClickListener(onItemClickListener listener)
    {
        mListener=listener;
    }
    public static class ExampleViewHolder extends RecyclerView.ViewHolder
    {
        public ImageView mImageView;
        public ImageView mDeleteView;
        public TextView mtextView1;
        public TextView mtextView2;
        public ExampleViewHolder(@NonNull  View itemView,onItemClickListener listener) {
            super(itemView);

            mImageView = itemView.findViewById(R.id.imageView);
            mtextView1 = itemView.findViewById(R.id.textView1);
            mtextView2 = itemView.findViewById(R.id.textView2);
            mDeleteView = itemView.findViewById(R.id.image_delete);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener!=null)
                    {
                        int position = getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION)
                        {
                            listener.onItemClick(position);
                        }
                    }

                }
            });

            mDeleteView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener!=null)
                    {
                        int position = getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION)
                        {
                            listener.onDeleteClick(position);
                        }
                    }
                }
            });
        }
    }

    public ExampleAdapater(ArrayList<ExampleItem> exampleItems)
    {
        mExampleList = exampleItems;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item,parent,false);
        ExampleViewHolder evh = new ExampleViewHolder(v,mListener);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull  ExampleAdapater.ExampleViewHolder holder, int position) {

        ExampleItem current = mExampleList.get(position);
        holder.mImageView.setImageResource(current.getmImage());
        holder.mtextView1.setText(current.getMtext1());
        holder.mtextView2.setText(current.getMtext2());
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }
}

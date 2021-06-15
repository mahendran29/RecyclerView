package com.example.recyclerviewproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private  ArrayList<ExampleItem> listItems;
    private RecyclerView mRecyclerView;
    private ExampleAdapater mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    EditText editTextInsert;
    EditText editTextRemove;
    Button buttonInsert;
    Button buttonRemove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createExampleList();
        createRecyclerView();

        editTextInsert=findViewById(R.id.editTextInsert);
        editTextRemove=findViewById(R.id.editTextRemove);
        buttonInsert=findViewById(R.id.buttonInsert);
        buttonRemove=findViewById(R.id.buttonRemove);

        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              int position = Integer.parseInt(editTextInsert.getText().toString());
              insertItem(position);
            }
        });

        buttonRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               int position = Integer.parseInt(editTextRemove.getText().toString());
               removeItem(position);
            }
        });

    }

    public void insertItem(int positon)
    {
           listItems.add(positon,new ExampleItem(R.drawable.ic_android,"This is new line","New Line"));
           mAdapter.notifyItemInserted(positon);
    }

    public void removeItem(int position)
    {
        listItems.remove(position);
        mAdapter.notifyItemRemoved(position);

    }

    public void changeText(int position,String str)
    {
        listItems.get(position).changeText(str);
        mAdapter.notifyItemChanged(position);
    }

    public void createExampleList()
    {
        listItems= new ArrayList<>();
        listItems.add(new ExampleItem(R.drawable.ic_android,"Line1","Line2"));
        listItems.add(new ExampleItem(R.drawable.ic_baseline,"Line3","Line4"));
        listItems.add(new ExampleItem(R.drawable.ic_baseline1,"Line5","Line6"));
    }

    public  void createRecyclerView()
    {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapater(listItems);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new ExampleAdapater.onItemClickListener() {
            @Override
            public void onItemClick(int position) {
                changeText(position,"Clicked");
            }

            @Override
            public void onDeleteClick(int position) {
                removeItem(position);
            }
        });
    }
}
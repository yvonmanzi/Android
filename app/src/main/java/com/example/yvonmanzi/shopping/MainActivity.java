package com.example.yvonmanzi.shopping;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE = 1;
    private LinkedList<String> list = new LinkedList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onAdd(View view) {
        Intent main_intent = new Intent(this, CommonItemsActivity.class);
        startActivityForResult(main_intent, REQUEST_CODE);

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK){
            String itemName = data.getStringExtra(CommonItemsActivity.ITEM_EXTRA);

            //get a handle to the rv
            RecyclerView mRecyclerView = findViewById(R.id.recycler_view_main);
            list.add(itemName);
            //hook rv to the adapter
            mRecyclerView.setAdapter(new ItemListAdapter(this, list));
            //provide default layout
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        }

    }

}

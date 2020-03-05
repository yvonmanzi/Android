package com.example.yvonmanzi.shopping;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.LinkedList;

public class CommonItemsActivity extends AppCompatActivity {
    public static final String ITEM_EXTRA = "com.example.yvonmanzi.shopping.EXTRA.itemNameId";

    public LinkedList<String> mItemList = new LinkedList<>();

    private RecyclerView mRecyclerView;
    private ItemListAdapter mItemListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_items);

        //    populate a linkedlist with items
        for(int i = 0; i < 100; i++) mItemList.add("Item" + i);

        //get a handle to the rv
        mRecyclerView = findViewById(R.id.recycler_view);
        //create an adapter
        mItemListAdapter = new ItemListAdapter(this, mItemList);
        //connect adapter with rv
        mRecyclerView.setAdapter(mItemListAdapter);
        //give rv a default layoutM
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


    }



    public void sendExtra(int layoutPosition, LinkedList<String> list) {
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra(ITEM_EXTRA, list.get(layoutPosition));
        setResult(RESULT_OK, i);
        finish();
    }
}

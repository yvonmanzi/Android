package com.example.yvonmanzi.shopping;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE = 1;


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
         int itemId = data.getIntExtra(CommonItemsActivity.ITEM_EXTRA, R.string.coffee);
            TextView view = findViewById(R.id.second_item);
            view.setText(itemId);
        }

    }

}

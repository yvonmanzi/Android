package com.example.yvonmanzi.shopping;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CommonItemsActivity extends AppCompatActivity {
    public static final String ITEM_EXTRA = "com.example.yvonmanzi.shopping.EXTRA.itemNameId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_items);
    }

    public void onAddItem(View view) {
        int viewId = view.getId();
        int itemId;
        switch (viewId) {
            case R.id.button_coffee:
                itemId = R.string.coffee;
                break;
            case R.id.button_tea:
                itemId = R.string.tea;
                break;
            case R.id.button_mac:
                itemId = R.string.mac;
                break;
            default:
                itemId=R.string.coffee;
        }
        Intent i = new Intent();
        i.putExtra(ITEM_EXTRA, itemId);
        setResult(RESULT_OK, i);
        finish();



    }
}

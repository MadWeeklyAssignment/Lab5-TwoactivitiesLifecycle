package com.example.shoppingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

    startActivityForResult(intent, ITEM_REQUEST);
}

@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ITEM_REQUEST) {
        if (resultCode == RESULT_OK) {
        String itemString = data.getStringExtra(SecondActivity.EXTRA_ITEMS);
        itemsList.add(itemString);
        int i;
        for (i = 0; i < itemsList.size(); i++) {
        if (itemsList.size() > 10) {
        Toast.makeText(MainActivity.this, "Cannot add more items to the list", Toast.LENGTH_LONG).show();
        break;
        }
        item[i].setVisibility(View.VISIBLE);
        item[i].setText(itemsList.get(i));
        }



        }
        }
        }
        } 
package com.example.shopping_list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }


    public void addItemToShoppingList(View view) {
        Button shoppingItemBtn = findViewById(view.getId());

        String shoppingItem = shoppingItemBtn.getText().toString();

        Intent replyIntent = new Intent(this, MainActivity.class);
        replyIntent.putExtra("shoppingItem", shoppingItem);
        setResult(RESULT_OK, replyIntent);
        finish();
    }
}
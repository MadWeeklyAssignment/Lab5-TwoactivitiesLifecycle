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
package com.example.shopping_list;

        import androidx.annotation.NonNull;
        import androidx.annotation.Nullable;
        import androidx.appcompat.app.AppCompatActivity;
        import android.content.Intent;
        import android.os.Bundle;
@@ -9,73 +11,89 @@
        import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final int ITEM_REQUEST = 1;
    private final TextView[] item = new TextView[10];
    private ArrayList<String> itemsList = new ArrayList<>(10);

    private static final int ADD_SHOPPING_ITEM_REQUEST = 1;
    private int currentShoppingListRow = 0;
    private TextView currentShoppingList;
    private String[] shoppingListArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        item[0] = findViewById(R.id.item1);
        item[1] = findViewById(R.id.item2);
        item[2] = findViewById(R.id.item3);
        item[3] = findViewById(R.id.item4);
        item[4] = findViewById(R.id.item5);
        item[5] = findViewById(R.id.item6);
        item[6] = findViewById(R.id.item7);
        item[7] = findViewById(R.id.item8);
        item[8] = findViewById(R.id.item9);
        item[9] = findViewById(R.id.item10);
        shoppingListArray = new String[10];

        if (savedInstanceState != null) {
            itemsList = savedInstanceState.getStringArrayList("ItemsListStringArray");
            int i;
            if (itemsList != null && itemsList.size() > 0) {
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
    shoppingListArray = savedInstanceState.getStringArray("shoppingListArray");
    currentShoppingListRow = savedInstanceState.getInt("currentShoppingListRow");

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (itemsList.size() != 0) {
            outState.putStringArrayList("ItemsListStringArray", itemsList);
            for (int row = 0; row < shoppingListArray.length; row++) {
                currentShoppingList = getCurrentShoppingListTxtView(row);
                currentShoppingList.setText(shoppingListArray[row]);
            }
        }
    }

    public void addItem(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivityForResult(intent, ITEM_REQUEST);
        startActivityForResult(intent, ADD_SHOPPING_ITEM_REQUEST);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == ITEM_REQUEST) {

                if (requestCode == ADD_SHOPPING_ITEM_REQUEST) {
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
                            String item = data.getStringExtra("shoppingItem");

                            if (currentShoppingListRow > 9) {
                                currentShoppingListRow = 0;
                            }

                            currentShoppingList = getCurrentShoppingListTxtView(currentShoppingListRow);

                            if (currentShoppingList != null) {
                                currentShoppingList.setText(item);
                                shoppingListArray[currentShoppingListRow] = item;
                                ++currentShoppingListRow;
                            }
                        }
                    }
                }

                private TextView getCurrentShoppingListTxtView(int currentShoppingListRow) {
                    switch (currentShoppingListRow) {
                        case 0:
                            return findViewById(R.id.list_1);
                        case 1:
                            return findViewById(R.id.list_2);
                        case 2:
                            return findViewById(R.id.list_3);
                        case 3:
                            return findViewById(R.id.list_4);
                        case 4:
                            return findViewById(R.id.list_5);
                        case 5:
                            return findViewById(R.id.list_6);
                        case 6:
                            return findViewById(R.id.list_7);
                        case 7:
                            return findViewById(R.id.list_8);
                        case 8:
                            return findViewById(R.id.list_9);
                        case 9:
                            return findViewById(R.id.list_10);
                    }

                    return null;
                }

                @Override
                protected void onSaveInstanceState(@NonNull Bundle outState) {
                    super.onSaveInstanceState(outState);

                    outState.putStringArray("shoppingListArray", shoppingListArray);
                    outState.putInt("currentShoppingListRow", currentShoppingListRow);
                }
            }
        }
        }
        }
        }
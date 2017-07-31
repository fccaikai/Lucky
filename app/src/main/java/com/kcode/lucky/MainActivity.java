package com.kcode.lucky;

import android.os.Bundle;
import android.util.Log;

import com.kcode.luckylib.core.Item;
import com.kcode.luckylib.core.LuckyBottomActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends LuckyBottomActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    protected List<Item> getItems() {
        Item love = new Item(R.drawable.ic_favorite_border_black_24dp, R.string.love);
        Item account = new Item(R.drawable.ic_account_balance_black_24dp, R.string.account);
        Item lock = new Item(R.drawable.ic_lock_open_black_24dp, R.string.lock);
        Item setting = new Item(R.drawable.setting, R.string.setting);
        List<Item> items = new ArrayList<>();
        items.add(love);
        items.add(account);
        items.add(lock);
        items.add(setting);
        items.add(account);
        return items;
    }

    @Override
    protected void onItemSelected(int position) {
        Log.d(TAG, "" + position);
    }
}

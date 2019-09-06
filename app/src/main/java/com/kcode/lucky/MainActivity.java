package com.kcode.lucky;

import androidx.fragment.app.Fragment;
import android.widget.Toast;

import com.kcode.lucky.fragment.Fragment1;
import com.kcode.lucky.fragment.Fragment2;
import com.kcode.lucky.fragment.Fragment3;
import com.kcode.lucky.fragment.Fragment4;
import com.kcode.lucky.fragment.Fragment5;
import com.kcode.luckylib.core.Item;
import com.kcode.luckylib.core.LuckyBottomActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends LuckyBottomActivity {

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
        Toast.makeText(getApplicationContext(), "选中：" + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected List<Fragment> getFragments() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(Fragment1.newInstance());
        fragments.add(Fragment2.newInstance());
        fragments.add(Fragment3.newInstance());
        fragments.add(Fragment4.newInstance());
        fragments.add(Fragment5.newInstance());
        return fragments;
    }

    @Override
    protected boolean hideToolbar() {
        return false;
    }
}

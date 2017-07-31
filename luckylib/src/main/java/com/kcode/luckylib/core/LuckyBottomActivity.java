package com.kcode.luckylib.core;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.kcode.luckylib.R;
import com.kcode.luckylib.widget.BottomView;

import java.util.List;

/**
 * Created by caik on 2017/7/31.
 */

public abstract class LuckyBottomActivity extends AppCompatActivity {

    protected TextView mTitle;
    protected BottomView mBottomView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lucky_bootom);

        initToolbar();

        mBottomView = (BottomView) findViewById(R.id.bottomView);
        mBottomView.setWeight(getItems().size());
        mBottomView.setOnItemSelectedListener(new BottomView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int position, String title) {
                updateTitle(title);
                LuckyBottomActivity.this.onItemSelected(position);

            }
        });

        mBottomView.setItems(getItems());
    }

    private void updateTitle(String title) {
        mTitle.setText(title);
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mTitle = (TextView) findViewById(R.id.title);
    }

    protected abstract List<Item> getItems();

    protected abstract void onItemSelected(int position);
}

package com.kcode.luckylib.core;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
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

    private final static String FRAGMENT1_FLAG = "Fragment1";
    private final static String FRAGMENT2_FLAG = "Fragment2";
    private final static String FRAGMENT3_FLAG = "Fragment3";
    private final static String FRAGMENT4_FLAG = "Fragment4";
    private final static String FRAGMENT5_FLAG = "Fragment5";

    protected TextView mTitle;
    protected BottomView mBottomView;
    protected int mLastSelected = -1;
    protected List<Fragment> mFragments;
    protected Fragment mFragment1;
    protected Fragment mFragment2;
    protected Fragment mFragment3;
    protected Fragment mFragment4;
    protected Fragment mFragment5;
    protected Fragment mLastFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lucky_bootom);

        initToolbar();
        mFragments = getFragments();
        if (mFragments == null) {
            throw new NullPointerException("mFragments is null");
        }

        List<Item> items = getItems();
        if (items == null) {
            throw new NullPointerException("items is null");
        }

        if(mFragments.size() != items.size()){
            throw new RuntimeException("mFragment size must be equal to items size");
        }

        initBottomView(items);
    }

    private void initBottomView(List<Item> items) {
        mBottomView = (BottomView) findViewById(R.id.bottomView);
        mBottomView.setWeight(getItems().size());
        mBottomView.setOnItemSelectedListener(new BottomView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int position, String title) {
                updateTitle(title);
                changeFragment(position);
                LuckyBottomActivity.this.onItemSelected(position);

            }
        });

        mBottomView.setItems(items);
    }

    private void changeFragment(int position) {

        if (position == mLastSelected) {
            return;
        }
        FragmentTransaction tran = getSupportFragmentManager().beginTransaction();
        if (mLastFragment != null) {
            tran.hide(mLastFragment);
        }
        switch (position) {
            case 0:
                mFragment1 = getSupportFragmentManager().findFragmentByTag(FRAGMENT1_FLAG);
                if (mFragment1 == null) {
                    mFragment1 = mFragments.get(position);
                    tran.add(R.id.container, mFragment1,FRAGMENT1_FLAG);
                }else {
                    tran.show(mFragment1);
                }
                mLastFragment = mFragment1;
                break;
            case 1:
                mFragment2 = getSupportFragmentManager().findFragmentByTag(FRAGMENT2_FLAG);
                if (mFragment2 == null) {
                    mFragment2 = mFragments.get(position);
                    tran.add(R.id.container, mFragment2,FRAGMENT2_FLAG);
                }else {
                    tran.show(mFragment2);
                }
                mLastFragment = mFragment2;
                break;
            case 2:
                mFragment3 = getSupportFragmentManager().findFragmentByTag(FRAGMENT1_FLAG);
                if (mFragment3 == null) {
                    mFragment3 = mFragments.get(position);
                    tran.add(R.id.container, mFragment3,FRAGMENT3_FLAG);
                }else {
                    tran.show(mFragment3);
                }
                mLastFragment = mFragment3;
                break;
            case 3:
                mFragment4 = getSupportFragmentManager().findFragmentByTag(FRAGMENT4_FLAG);
                if (mFragment4 == null) {
                    mFragment4 = mFragments.get(position);
                    tran.add(R.id.container, mFragment4,FRAGMENT4_FLAG);
                }else {
                    tran.show(mFragment4);
                }
                mLastFragment = mFragment4;
                break;
            case 4:
                mFragment4 = getSupportFragmentManager().findFragmentByTag(FRAGMENT5_FLAG);
                if (mFragment4 == null) {
                    mFragment4 = mFragments.get(position);
                    tran.add(R.id.container, mFragment4,FRAGMENT5_FLAG);
                }else {
                    tran.show(mFragment4);
                }
                mLastFragment = mFragment4;
                break;
        }

        tran.commit();
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

    protected abstract List<Fragment> getFragments();
}

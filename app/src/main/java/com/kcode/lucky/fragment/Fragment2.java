package com.kcode.lucky.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kcode.lucky.R;

/**
 * Created by caik on 2017/7/31.
 */

public class Fragment2 extends Fragment {
    public static Fragment2 newInstance() {
        
        Bundle args = new Bundle();
        
        Fragment2 fragment = new Fragment2();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("Fragment2", "onCreateView");
        return inflater.inflate(R.layout.fragment2,container,false);
    }
}

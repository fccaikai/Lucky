package com.kcode.lucky.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by caik on 2017/7/31.
 */

public class Fragment1 extends Fragment {
    public static Fragment1 newInstance() {
        
        Bundle args = new Bundle();
        
        Fragment1 fragment = new Fragment1();
        fragment.setArguments(args);
        return fragment;
    }
}

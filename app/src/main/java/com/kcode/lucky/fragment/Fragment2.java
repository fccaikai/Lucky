package com.kcode.lucky.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

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
}

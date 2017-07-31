package com.kcode.lucky.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by caik on 2017/7/31.
 */

public class Fragment3 extends Fragment {
    public static Fragment3 newInstance() {
        
        Bundle args = new Bundle();
        
        Fragment3 fragment = new Fragment3();
        fragment.setArguments(args);
        return fragment;
    }
}

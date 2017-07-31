package com.kcode.lucky.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by caik on 2017/7/31.
 */

public class Fragment4 extends Fragment {
    public static Fragment4 newInstance() {
        
        Bundle args = new Bundle();
        
        Fragment4 fragment = new Fragment4();
        fragment.setArguments(args);
        return fragment;
    }
}

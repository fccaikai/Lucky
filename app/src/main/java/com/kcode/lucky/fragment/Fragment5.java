package com.kcode.lucky.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by caik on 2017/7/31.
 */

public class Fragment5 extends Fragment {
    public static Fragment5 newInstance() {

        Bundle args = new Bundle();

        Fragment5 fragment = new Fragment5();
        fragment.setArguments(args);
        return fragment;
    }
}

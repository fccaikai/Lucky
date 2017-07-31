package com.kcode.luckylib.core;

/**
 * Created by caik on 2017/7/30.
 */

public class Item {
    private int iconRes;
    private int titleRes;

    public Item(int iconRes, int titleRes) {
        this.iconRes = iconRes;
        this.titleRes = titleRes;
    }

    public int getIconRes() {
        return iconRes;
    }

    public void setIconRes(int iconRes) {
        this.iconRes = iconRes;
    }

    public int getTitleRes() {
        return titleRes;
    }

    public void setTitleRes(int titleRes) {
        this.titleRes = titleRes;
    }
}

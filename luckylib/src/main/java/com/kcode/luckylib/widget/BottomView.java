package com.kcode.luckylib.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kcode.luckylib.R;
import com.kcode.luckylib.core.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by caik on 2017/7/30.
 */

public class BottomView extends LinearLayout {

    private static final String TAG = "BottomView";

    private int mWeight;
    private int mInactiveColor;
    private Context mContext;

    private LinearLayout mItemLayout1;
    private LinearLayout mItemLayout2;
    private LinearLayout mItemLayout3;
    private LinearLayout mItemLayout4;
    private LinearLayout mItemLayout5;

    private ImageView mItemIcon1;
    private ImageView mItemIcon2;
    private ImageView mItemIcon3;
    private ImageView mItemIcon4;
    private ImageView mItemIcon5;

    private TextView mItemTitle1;
    private TextView mItemTitle2;
    private TextView mItemTitle3;
    private TextView mItemTitle4;
    private TextView mItemTitle5;
    private List<Item> mItems;


    public BottomView(Context context) {
        this(context, null);
    }

    public BottomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        getAttrs(context, attrs);
        setBackgroundColor(ContextCompat.getColor(context,R.color.lucky_bottom_bg));
    }

    /**
     * 得到属性值
     *
     * @param context
     * @param attrs
     */
    private void getAttrs(Context context, AttributeSet attrs) {
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.BottomView);
        mInactiveColor = ta.getColor(R.styleable.BottomView_inactiveColor, ContextCompat.getColor(mContext, R.color.lucky_line));
        ta.recycle();
    }

    private void init() {

        if (mWeight < 3 || mWeight > 5) {
            throw new RuntimeException("only support 3~5 item");
        }

        View view = null;
        switch (mWeight) {
            case 3:
                view = LayoutInflater.from(mContext).inflate(R.layout.lucky_bottom_layout_3, null);
                break;
            case 4:
                view = LayoutInflater.from(mContext).inflate(R.layout.lucky_bottom_layout_4, null);
                break;
            case 5:
                view = LayoutInflater.from(mContext).inflate(R.layout.lucky_bottom_layout_5, null);
                break;
        }

        if (view == null) {
            Log.e(TAG, "view is null");
            return;
        }

        LinearLayout.LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        view.setLayoutParams(params);
        addView(view);

        mItemTitle1 = (TextView) view.findViewById(R.id.itemTitle1);
        mItemIcon1 = (ImageView) view.findViewById(R.id.itemIcon1);
        mItemLayout1 = (LinearLayout) view.findViewById(R.id.itemLayout1);
        if (mItemLayout1 != null) {
            mItemLayout1.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnItemSelectedListener != null) {
                        mOnItemSelectedListener.onItemSelected(0, getResources().getString(mItems.get(0).getTitleRes()));
                    }
                    setCurrentItem(0);
                }
            });
        }

        mItemTitle2 = (TextView) view.findViewById(R.id.itemTitle2);
        mItemIcon2 = (ImageView) view.findViewById(R.id.itemIcon2);
        mItemLayout2 = (LinearLayout) view.findViewById(R.id.itemLayout2);
        if (mItemLayout2 != null) {
            mItemLayout2.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnItemSelectedListener != null) {
                        mOnItemSelectedListener.onItemSelected(1, getResources().getString(mItems.get(1).getTitleRes()));
                    }
                    setCurrentItem(1);
                }
            });
        }

        mItemTitle3 = (TextView) view.findViewById(R.id.itemTitle3);
        mItemIcon3 = (ImageView) view.findViewById(R.id.itemIcon3);
        mItemLayout3 = (LinearLayout) view.findViewById(R.id.itemLayout3);
        if (mItemLayout3 != null) {
            mItemLayout3.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnItemSelectedListener != null) {
                        mOnItemSelectedListener.onItemSelected(2, getResources().getString(mItems.get(2).getTitleRes()));
                    }
                    setCurrentItem(2);
                }
            });
        }

        mItemTitle4 = (TextView) view.findViewById(R.id.itemTitle4);
        mItemIcon4 = (ImageView) view.findViewById(R.id.itemIcon4);
        mItemLayout4 = (LinearLayout) view.findViewById(R.id.itemLayout4);
        if (mItemLayout4 != null) {
            mItemLayout4.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnItemSelectedListener != null) {
                        mOnItemSelectedListener.onItemSelected(3, getResources().getString(mItems.get(3).getTitleRes()));
                    }
                    setCurrentItem(3);
                }
            });
        }

        mItemTitle5 = (TextView) view.findViewById(R.id.itemTitle5);
        mItemIcon5 = (ImageView) view.findViewById(R.id.itemIcon5);
        mItemLayout5 = (LinearLayout) view.findViewById(R.id.itemLayout5);
        if (mItemLayout5 != null) {
            mItemLayout5.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnItemSelectedListener != null) {
                        mOnItemSelectedListener.onItemSelected(4, getResources().getString(mItems.get(4).getTitleRes()));
                    }
                    setCurrentItem(4);
                }
            });
        }
    }


    public void setOnItemSelectedListener(OnItemSelectedListener listener) {
        mOnItemSelectedListener = listener;
    }

    private OnItemSelectedListener mOnItemSelectedListener;

    public void setItem(Item item1, Item item2, Item item3) {
        setItem(item1, item2, item3, null, null);
    }

    public void setItem(Item item1, Item item2, Item item3, Item item4) {
        setItem(item1, item2, item3, item4, null);
    }


    public void setItem(Item item1, Item item2, Item item3, Item item4, Item item5) {
        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        if (item4 != null) {
            items.add(item4);
        }

        if (item5 != null) {
            items.add(item5);
        }

        setItems(items);
    }

    public void setItems(List<Item> items) {
        if (items == null) {
            throw new NullPointerException("items is null");
        }

        if (items.size() != mWeight) {
            throw new RuntimeException("items size must equals mWeight");
        }
        mItems = items;

        setUpView();
        mItemLayout1.performClick();
    }

    private void setUpView() {
        int size = mItems.size();
        switch (size) {
            case 5:
                mItemIcon5.setBackgroundResource(mItems.get(4).getIconRes());
                mItemTitle5.setText(mItems.get(4).getTitleRes());
            case 4:
                mItemIcon4.setBackgroundResource(mItems.get(3).getIconRes());
                mItemTitle4.setText(mItems.get(3).getTitleRes());
            case 3:
                mItemIcon3.setBackgroundResource(mItems.get(2).getIconRes());
                mItemTitle3.setText(mItems.get(2).getTitleRes());
                mItemIcon2.setBackgroundResource(mItems.get(1).getIconRes());
                mItemTitle2.setText(mItems.get(1).getTitleRes());
                mItemIcon1.setBackgroundResource(mItems.get(0).getIconRes());
                mItemTitle1.setText(mItems.get(0).getTitleRes());
                break;
        }
    }

    private int mLastSelectedItem = -1;

    public void setCurrentItem(int index) {
        if (index > mItems.size() - 1) {
            throw new IndexOutOfBoundsException("item size is " + mItems.size() + ",but set index is " + index);
        }
        setCurrentItem(index, getIconViewByIndex(index));
    }

    private ImageView getIconViewByIndex(int index) {
        switch (index) {
            case 0:
                return mItemIcon1;
            case 1:
                return mItemIcon2;
            case 2:
                return mItemIcon3;
            case 3:
                return mItemIcon4;
            case 4:
                return mItemIcon5;
        }

        return mItemIcon1;

    }

    private TextView getTitleViewByIndex(int index) {
        switch (index) {
            case 0:
                return mItemTitle1;
            case 1:
                return mItemTitle2;
            case 2:
                return mItemTitle3;
            case 3:
                return mItemTitle4;
            case 4:
                return mItemTitle5;
        }

        return mItemTitle1;

    }


    public void setCurrentItem(int index, ImageView imageView) {
        if (index == mLastSelectedItem) {
            return;
        }

        setItemTint(imageView, mInactiveColor);
        getTitleViewByIndex(index).setTextColor(mInactiveColor);
        if (mLastSelectedItem != -1) {
            setItemTint(getIconViewByIndex(mLastSelectedItem), ContextCompat.getColor(mContext, R.color.lucky_default_item));
            getTitleViewByIndex(mLastSelectedItem).setTextColor(ContextCompat.getColor(mContext, R.color.lucky_default_item));
        }
        mLastSelectedItem = index;

    }

    public void setItemTint(ImageView view,int mIconTint){
        Drawable icon = view.getBackground();
        if (icon != null) {
            Drawable.ConstantState state = icon.getConstantState();
            icon = DrawableCompat.wrap(state == null ? icon : state.newDrawable()).mutate();
            DrawableCompat.setTint(icon, mIconTint);
        }
        view.setImageDrawable(icon);
    }

    public void setWeight(int size) {
        mWeight = size;
        init();
    }

    public interface OnItemSelectedListener {
        void onItemSelected(int position, String title);
    }

}

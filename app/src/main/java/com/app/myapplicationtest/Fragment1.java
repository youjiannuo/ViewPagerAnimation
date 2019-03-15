package com.app.myapplicationtest;

import android.graphics.Color;
import android.widget.TextView;

import com.yn.framework.activity.BaseFragment;

import static android.view.View.GONE;

public class Fragment1 extends BaseFragment {

    float min = 0.95f;

    private int mColors[] = {Color.RED, Color.BLACK, Color.BLUE, Color.LTGRAY};

    private TextView mTextView;

    @Override
    public int getViewResource() {
        return R.layout.a;
    }

    @Override
    protected void initTopBar() {
        super.initTopBar();
        mBarView.setVisibility(GONE);
    }

    @Override
    protected void initView() {
        super.initView();
        mTextView = findById(R.id.a);
    }

    @Override
    protected void setViewData() {
        super.setViewData();
        mTextView.setBackgroundColor(mColors[mIndex]);
    }

    public void changeSize(float p) {
        int l = (int) ((mShowView.getHeight() * (1 - min) * p) / 2.0f);
        int t = (int) ((mShowView.getWidth() * (1 - min) * p) / 2.0f);
        mTextView.layout(l, t, mShowView.getWidth() - l, mShowView.getHeight() - t);
    }

}
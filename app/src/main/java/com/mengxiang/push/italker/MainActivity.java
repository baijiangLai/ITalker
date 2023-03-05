package com.mengxiang.push.italker;

import android.widget.TextView;

import com.mengxiang.push.common.app.CommonActivity;

import butterknife.BindView;

public class MainActivity extends CommonActivity {
    @BindView(R.id.text_test)
    TextView mTextTest;

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initWidget() {
        super.initWidget();
        mTextTest.setText("Test hello");
    }
}
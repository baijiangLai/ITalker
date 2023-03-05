package com.mengxiang.push.common.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.mengxiang.push.common.R;

import java.util.List;

import butterknife.ButterKnife;

public abstract class CommonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);

        //界面未初始化之前调用初始化窗口
        initWindows();

        if (initArgs(getIntent().getExtras())) {
            int layoutId = getContentLayoutId();
            setContentView(layoutId);
            initWidget();
            initData();
        } else {
            finish();
        }
    }
    /**
     * 初始化窗口
     */
    protected void initWindows() {

    }


    protected boolean initArgs(Bundle bundle) {
        return true;
    }

    /**
     * 得到当前资源文件ID
     *
     * @return
     */
    protected abstract int getContentLayoutId();

    /**
     * 初始化空间
     */
    protected void initWidget() {
        ButterKnife.bind(this);

    }

    /**
     * 初始化数据
     */
    protected void initData() {

    }


    @Override
    public boolean onSupportNavigateUp() {

        //得到activity下的所有fragment
        List<Fragment> fragmentList = getSupportFragmentManager().getFragments();
        //判空
        if (fragmentList != null && fragmentList.size() > 0){
            for (Fragment fragment : fragmentList){
                //判断是否为我们能处理的Fragment
                if (fragment instanceof com.mengxiang.push.common.fragment.Fragment){
                    //判断是否拦截了返回按钮
                    if (((com.mengxiang.push.common.fragment.Fragment)fragment).onBackPressed()){
                        return true;
                    }
                }
            }
        }

        //点击返回，finish当前界面
        finish();
        return super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
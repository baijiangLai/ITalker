package com.mengxiang.push.common.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author lbj
 */
public abstract class Fragment extends androidx.fragment.app.Fragment {
    protected View mRoot;
    protected Unbinder mRootUnBinder;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        initArgs(getArguments());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (mRoot == null) {
            int layoutId = getContentLayoutId();
            //初始化当前根布局，但是不在创建的时候就添加到container
            View root = inflater.inflate(layoutId, container, false);
            initWidget(root);
            mRoot = root;
        } else {
            if (mRoot.getParent() != null) {
                ((ViewGroup) mRoot.getParent()).removeView(mRoot);
            }
        }
        return mRoot;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
    }

    /**
     * 得到当前界面的资源文件Id
     *
     * @return
     */
    protected abstract int getContentLayoutId();

    protected void initWidget(View root) {
        mRootUnBinder = ButterKnife.bind(this,root);
    }

    protected void initData() {

    }

    protected void initArgs(Bundle bundle) {

    }

    /**
     * 返回按键触发时调用
     * @return
     * true代表已经处理返回逻辑，activity不用自己finish
     * false代表没有处理逻辑，activity走自己的逻辑
     */
    public boolean onBackPressed(){
        return false;
    }
}

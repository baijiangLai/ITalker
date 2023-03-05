package com.mengxiang.push.common.widget.recycler;

/**
 * @author lbj
 */
public interface AdapterCallback<Data> {
    void update(Data data, RecyclerAdapter.ViewHolder<Data> holder);
}

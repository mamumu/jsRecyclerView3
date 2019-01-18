package com.mumu.jsrecyclerview3;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/**
 * author : zlf
 * date   : 2019/1/18
 * blog   :https://www.jianshu.com/u/281e9668a5a6
 */
public class TableAdapter extends BaseQuickAdapter<TableEntity.ResultBean.ListBean, BaseViewHolder> {

    /**
     * 增加一个构造方法，便于没有数据时候初始化适配器
     */
    public TableAdapter() {
        super(R.layout.item_table);
    }

    /**
     * 继承BaseQuickAdapter后需要重写的方法
     *
     * @param helper view持有者，为重用view而设计，减少每次创建view的内存消耗
     * @param data   我们的列表数据
     */
    @Override
    protected void convert(BaseViewHolder helper, TableEntity.ResultBean.ListBean data) {
        helper.setText(R.id.table_1, data.getTable1())
                .setText(R.id.table_2, data.getTable2())
                .setText(R.id.table_3, data.getTable3());
    }
}

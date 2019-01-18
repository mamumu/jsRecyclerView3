package com.mumu.jsrecyclerview3;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * author : zlf
 * date   : 2019/1/18
 * blog   :https://www.jianshu.com/u/281e9668a5a6
 */
public class MainActivity extends AppCompatActivity {
    @BindView(R.id.rv_table)
    RecyclerView rvTable;
    @BindView(R.id.srl_table)
    SmartRefreshLayout srlTable;
    private TableAdapter mTableAdapter;
    private ArrayList<TableEntity.ResultBean.ListBean> mTableList;
    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);

        initView();
    }

    private void initView() {

        refreshView();
        getData(2);
        smartRefreshView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    /**
     * 刷新消息列表
     */
    private void refreshView() {
        //1,加载空布局文件，便于第五步适配器在没有数据的时候加载
        View emptyView = View.inflate(this, R.layout.empty_view, null);
        //2，设置LayoutManager,LinearLayoutManager表示竖直向下
        rvTable.setLayoutManager(new LinearLayoutManager(this));
        //3，初始化一个无数据的适配器
        mTableAdapter = new TableAdapter();
        //4，绑定recyclerView和适配器
        rvTable.setAdapter(mTableAdapter);
        //5，给recyclerView设置空布局
        mTableAdapter.setEmptyView(emptyView);
        //6，给recyclerView的每一个子列表添加点击事件
        mTableAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(MainActivity.this, "我点击了第" + position + "个子view",
                        Toast.LENGTH_SHORT).show();
            }
        });
        //7，添加头文件和脚文件
        View headView = getLayoutInflater().inflate(R.layout.item_table_header, null);
        View footView = getLayoutInflater().inflate(R.layout.item_table_footer, null);
        mTableAdapter.addHeaderView(headView);
        mTableAdapter.addFooterView(footView);
    }

    /**
     * MainActivity中增加下拉刷新和上拉加载的监听方法
     */
    private void smartRefreshView() {
        srlTable.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                //下拉刷新,一般添加调用接口获取数据的方法
                getData(2);
                refreshLayout.finishRefresh();
            }

            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                //上拉加载，一般添加调用接口获取更多数据的方法
                getData(3);
                refreshLayout.finishLoadMoreWithNoMoreData();
            }
        });
    }

    private void getData(int mode) {
        //添加临时数据，一般直接从接口获取
        switch (mode) {
            case 2:
                mTableList = new ArrayList<>();
                for (int i = 0; i < 15; i++) {
                    mTableList.add(new TableEntity.ResultBean.ListBean("我爱小狗", "我爱小猫","我爱小兔子"));
                }
                //更新数据
                mTableAdapter.setNewData(mTableList);
                break;
            case 3:
                for (int i = 0; i < 15; i++) {
                    mTableList.add(new TableEntity.ResultBean.ListBean("我爱小狗", "我爱小猫","我爱小兔子"));
                }
                mTableAdapter.setNewData(mTableList);
                break;
            default:
                mTableList = new ArrayList<>();
                for (int i = 0; i < 10; i++) {
                    mTableList.add(new TableEntity.ResultBean.ListBean("我爱小狗", "我爱小猫","我爱小兔子"));
                }
                break;
        }
    }
}

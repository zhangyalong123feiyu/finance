package com.bibinet.finance.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.andview.refreshview.XRefreshView;
import com.andview.refreshview.XRefreshViewFooter;
import com.bibinet.finance.R;
import com.bibinet.finance.adapter.FragmentMoreAdapter;
import com.bibinet.finance.bean.SocailBean;
import com.bibinet.finance.presenter.presenterimpl.FragmentMorePresenterImp;
import com.bibinet.finance.view.FragmentMoreView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/4/23.
 */

public class RefreshActivity extends BaseActivity  implements FragmentMoreView {
   RecyclerView recyclerviewmore;
    XRefreshView xrefreshview;
    private RefreshActivity activity;
    private XRefreshViewFooter footerView;
    private int page;
    private FragmentMorePresenterImp presenterImp;
    private FragmentMoreAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_more);
        recyclerviewmore=(RecyclerView) findViewById(R.id.recyclermore);
        xrefreshview=(XRefreshView) findViewById(R.id.xrefreshview);
        activity=this;
        intiView();
    }

    private void intiView() {
        recyclerviewmore.setHasFixedSize(true);
        loadData(false);

        LinearLayoutManager layoutManager = new LinearLayoutManager(activity);
        recyclerviewmore.setLayoutManager(layoutManager);

        xrefreshview.setAutoRefresh(true);
        //设置刷新完成以后，headerview固定的时间
        xrefreshview.setPinnedTime(1000);
        // xrefreshview.setMoveForHorizontal(true);
        xrefreshview.setPullLoadEnable(true);
        xrefreshview.setAutoLoadMore(false);


        footerView=new XRefreshViewFooter(activity);

         xrefreshview.enableReleaseToLoadMore(true);
        xrefreshview.enableRecyclerViewPullUp(true);
        xrefreshview.enablePullUpWhenLoadCompleted(true);
        xrefreshview.setXRefreshViewListener(new XRefreshView.SimpleXRefreshListener(){
            @Override
            public void onRefresh(boolean isPullDown) {
                xrefreshview.startRefresh();
                loadData(false);
            }
            @Override
            public void onLoadMore(boolean isSilence) {
                Toast.makeText(activity,"加载更多",Toast.LENGTH_SHORT).show();

                loadData(true);

            }
        });
    }

    private void loadData( boolean isLoadMore) {
        presenterImp=new FragmentMorePresenterImp(this,isLoadMore);
        presenterImp.LoadData("http://api.tianapi.com/qiwen/?key",page);
    }
    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showData(List<SocailBean.SocailInfo> socailInfo, boolean isLoadMore) {

        if (isLoadMore){
            // adapter.changeMoreStatus(SocailFooterAdapter.LOADING_MORE);
            adapter.setCustomLoadMoreView(footerView);
            page++;
            if (socailInfo.size()==0){
                Toast.makeText(activity,"没有更多数据",Toast.LENGTH_SHORT).show();
              /*  adapter.changeMoreStatus(SocailFooterAdapter.PULLUP_LOAD_MORE);*//*
                // infoListView.scrollToPosition(InfoRefreshFootAdapter.Lastposition);
                recyclerviewmore.smoothScrollToPosition(adapter.getItemCount()-1);*/
                // infoListView.smoothScrollBy(240,1000);
            }else{
                adapter.inSert(socailInfo);
                adapter.notifyDataSetChanged();

            }
        }
        else {
            page=1;
            adapter =new FragmentMoreAdapter(activity,socailInfo);

            recyclerviewmore.setAdapter(adapter);
            xrefreshview.stopRefresh();
        }

    }

    @Override
    public void showLoadFailed(String error) {

    }
}

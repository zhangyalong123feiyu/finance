package com.bibinet.finance.activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.andview.refreshview.XRefreshView;
import com.andview.refreshview.XRefreshViewFooter;
import com.andview.refreshview.recyclerview.BaseRecyclerAdapter;
import com.bibinet.finance.R;
import com.bibinet.finance.adapter.FragmentMoreAdapter;
import com.bibinet.finance.adapter.SocailFooterAdapter;
import com.bibinet.finance.bean.SocailBean;
import com.bibinet.finance.presenter.presenterimpl.FragmentMorePresenterImp;
import com.bibinet.finance.view.FragmentMoreView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentMore extends Fragment implements FragmentMoreView {


    @BindView(R.id.recyclermore)
    RecyclerView recyclerviewmore;
    @BindView(R.id.xrefreshview)
    XRefreshView xrefreshview;
    Unbinder unbinder;
    private View view;
    private LinearLayoutManager layoutManager;
    private FragmentMorePresenterImp presenterImp;
    private int page;
    private FragmentMoreAdapter adapter;
    private XRefreshViewFooter footerView;
    public FragmentMore() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_more, container, false);
        unbinder = ButterKnife.bind(this, view);
        loadData(false);
        initView();
        return view;
    }

    private void loadData(boolean isLoadMore) {
        presenterImp=new FragmentMorePresenterImp(this,isLoadMore);
        presenterImp.LoadData("http://api.tianapi.com/qiwen/?key",page);
    }

    private void initView() {
        recyclerviewmore.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerviewmore.setLayoutManager(layoutManager);
        //设置刷新完成以后，headerview固定的时间
        xrefreshview.setPinnedTime(1000);
        xrefreshview.setMoveForHorizontal(true);
        xrefreshview.setPullLoadEnable(true);
        xrefreshview.setAutoLoadMore(false);

        footerView=new XRefreshViewFooter(getActivity());
        xrefreshview.enableReleaseToLoadMore(true);
        xrefreshview.enableRecyclerViewPullUp(true);
        xrefreshview.enablePullUpWhenLoadCompleted(true);
        xrefreshview.setXRefreshViewListener(new XRefreshView.SimpleXRefreshListener(){
            @Override
            public void onLoadMore(boolean isSilence) {
                super.onLoadMore(isSilence);
                Toast.makeText(getActivity(),"加载更多",Toast.LENGTH_SHORT).show();
                loadData(true);

            }

            @Override
            public void onRefresh(boolean isPullDown) {
                super.onRefresh(isPullDown);
                xrefreshview.startRefresh();
                loadData(false);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
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
                Toast.makeText(getActivity(),"没有更多数据",Toast.LENGTH_SHORT).show();
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
            adapter =new FragmentMoreAdapter(getActivity(),socailInfo);

            recyclerviewmore.setAdapter(adapter);
            xrefreshview.stopRefresh();
        }

    }

    @Override
    public void showLoadFailed(String error) {

    }

}

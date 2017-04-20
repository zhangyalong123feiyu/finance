package com.bibinet.finance.activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bibinet.finance.R;
import com.bibinet.finance.adapter.SocailFooterAdapter;
import com.bibinet.finance.bean.SocailBean;
import com.bibinet.finance.presenter.presenterimpl.FragmentBankPresenterImp;
import com.bibinet.finance.view.FragmentBankView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentBank extends Fragment implements FragmentBankView{


    @BindView(R.id.socailreyclerview)
    RecyclerView socailreyclerview;
    @BindView(R.id.socialrefresh)
    SwipeRefreshLayout socialrefresh;
    Unbinder unbinder;
    private View view;
    private FragmentBankPresenterImp fragmentBankPresenterImp;
    private int lastVisibleItem;
    private SocailFooterAdapter adapter;
    private int page;

    public FragmentBank() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_bank, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        loadData(false);
        return view;
    }

    private void loadData(boolean isLoadMore) {
        fragmentBankPresenterImp=new FragmentBankPresenterImp(this,isLoadMore);
        fragmentBankPresenterImp.LoadData("https://api.tianapi.com/guonei/",1);
    }

    private void initView() {
        final LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        socailreyclerview.setLayoutManager(linearLayoutManager);

        socialrefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadData(false);
            }
        });
        socailreyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1 == adapter.getItemCount()) {
                    loadData(true);
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
            }
        });
        //socialrecylerview.setLayoutManager(layoutManager);
        socialrefresh.setRefreshing(true);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void showProgress() {
        socialrefresh.setRefreshing(true);
    }

    @Override
    public void hideProgress() {
        socialrefresh.setRefreshing(false);
    }

    @Override
    public void showData(List<SocailBean.SocailInfo> socailInfo,boolean isLoadMore) {
//     adapter=new SocailFooterAdapter(getActivity(),socailInfo);
        /*   socailreyclerview.setAdapter(adapter);*/
        if (isLoadMore){
           // adapter.changeMoreStatus(SocailFooterAdapter.LOADING_MORE);
            page++;
            if (socailInfo.size()==0){
                Toast.makeText(getActivity(),"没有更多数据",Toast.LENGTH_SHORT).show();
                adapter.changeMoreStatus(SocailFooterAdapter.PULLUP_LOAD_MORE);
                // infoListView.scrollToPosition(InfoRefreshFootAdapter.Lastposition);
                socailreyclerview.smoothScrollToPosition(adapter.getItemCount()-1);
                // infoListView.smoothScrollBy(240,1000);
            }else{
                adapter.addMoreItem(socailInfo);
                adapter.changeMoreStatus(SocailFooterAdapter.LOADING_MORE);
            }
        }
        else {
            page=1;
        adapter =new SocailFooterAdapter(getActivity(), socailInfo);
        socailreyclerview.setAdapter(adapter);
        socialrefresh.setRefreshing(false);
        }
    }

    @Override
    public void showLoadFailed(String error) {
        socialrefresh.setRefreshing(false);
    }

}
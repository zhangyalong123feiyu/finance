package com.bibinet.finance.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bibinet.finance.R;
import com.bibinet.finance.adapter.CompanyDataAdapter;
import com.bibinet.finance.bean.CompanyData;
import com.bibinet.finance.builder.MyViewPager;
import com.bibinet.finance.constant.ProjectUrl;
import com.bibinet.finance.utils.BannerUtils;
import com.bibinet.finance.view.FragmentCompanyView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import java.util.Arrays;
/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentCompany extends Fragment implements FragmentCompanyView {
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.title_imageleft)
    ImageView titleimageleft;
    @BindView(R.id.viewpager)
    MyViewPager viewpager;
    @BindView(R.id.companyrecylerview)
    RecyclerView companyrecylerview;
    @BindView(R.id.swiprefesh)
    SwipeRefreshLayout swiprefesh;
    @BindView(R.id.group_contain)
    LinearLayout groupContain;
    private View view;
    private List<CompanyData> list = new ArrayList<>();

    public FragmentCompany() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragement_company, container, false);
        ButterKnife.bind(this, view);
        initData();
        initView();
        setListioner();
        return view;
    }

    private void setListioner() {
        titleimageleft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), GuaranteeApplyActivity.class));
            }
        });
    }

    private void initData() {
        list.add(new CompanyData("张亚龙", "2016.10", "今天是个好日子！"));
        list.add(new CompanyData("张亚龙", "2016.10", "今天是个好日子！"));
        list.add(new CompanyData("张亚龙", "2016.10", "今天是个好日子！"));
        list.add(new CompanyData("张亚龙", "2016.10", "今天是个好日子！"));
        list.add(new CompanyData("张亚龙", "2016.10", "今天是个好日子！"));
        list.add(new CompanyData("张亚龙", "2016.10", "今天是个好日子！"));

    }

    private void initView() {
        titleimageleft.setImageResource(R.mipmap.ic_launcher);
        titleimageleft.setVisibility(View.VISIBLE);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        companyrecylerview.setLayoutManager(linearLayoutManager);
        companyrecylerview.setAdapter(new CompanyDataAdapter(getActivity(), list));
        /*轮播图*/
        BannerUtils bannerUtils=new BannerUtils(getActivity(),viewpager,groupContain,Arrays.asList(ProjectUrl.ImageUrls));
        bannerUtils.startPlayBanner();
    }


    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showData() {

    }

    @Override
    public void showLoadFailed() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}

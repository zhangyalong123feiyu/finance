package com.bibinet.finance.activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bibinet.finance.R;
import com.bibinet.finance.adapter.CompanyDataAdapter;
import com.bibinet.finance.bean.CompanyData;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentBankPro extends Fragment {


    @BindView(R.id.brankroinforeyclerview)
    RecyclerView brankroinforeyclerview;
    private List<CompanyData> list=new ArrayList<>();

    public FragmentBankPro() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bankpro, container, false);
        ButterKnife.bind(this, view);
        initData();
        initView();
        return view;
    }
    private void initData() {
        list.add(new CompanyData("张亚龙","2016.10","今天是个好日子！"));
        list.add(new CompanyData("张亚龙","2016.10","今天是个好日子！"));
        list.add(new CompanyData("张亚龙","2016.10","今天是个好日子！"));
        list.add(new CompanyData("张亚龙","2016.10","今天是个好日子！"));
        list.add(new CompanyData("张亚龙","2016.10","今天是个好日子！"));
        list.add(new CompanyData("张亚龙","2016.10","今天是个好日子！"));
    }

    private void initView() {
        brankroinforeyclerview.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false));
        brankroinforeyclerview.setAdapter(new CompanyDataAdapter(getActivity(),list));
    }

}

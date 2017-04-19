package com.bibinet.finance.activity;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.bibinet.finance.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentMy extends Fragment {



    @BindView(R.id.comnaylogin)
    Button comnaylogin;
    @BindView(R.id.banklogin)
    Button banklogin;
    @BindView(R.id.operationlogin)
    Button operationlogin;
    private View view;
    private String logingtype;

    public FragmentMy() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_my, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({R.id.comnaylogin,R.id.banklogin,R.id.operationlogin})
    public void onClick(View view) {
        SharedPreferences sharedPreferences=getActivity().getSharedPreferences("LoginType", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        switch (view.getId()) {
            case R.id.comnaylogin:
                ((MainActivity)getActivity()).companyLogin();
                editor.putString("longintype","1");
                editor.commit();
                initBottomSelect();
                break;

            case R.id.banklogin:
                ((MainActivity)getActivity()).bankLogin();
                editor.putString("longintype","2");
                editor.commit();
                initBottomSelect();
                break;

            case R.id.operationlogin:
                ((MainActivity)getActivity()).operationLogin();
                editor.putString("longintype","3");
                editor.commit();
                initBottomSelect();
                break;
            default:
                break;
        }
    }

    private void initBottomSelect() {
        FragmentManager fm = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        MainActivity.currentTabIndex=1;
        ft.hide(MainActivity.fragments[0]).show(MainActivity.fragments[1]).commit();
        MainActivity.mTabs[1].setSelected(true);
        MainActivity.mTabs[2].setSelected(false);
    }

}

package com.bibinet.finance.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bibinet.finance.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentMore extends Fragment {

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.title_imageright)
    ImageView titleImageright;
    @BindView(R.id.title_imageleft)
    ImageView titleImageleft;
    @BindView(R.id.product)
    LinearLayout product;
    @BindView(R.id.help)
    LinearLayout help;
    @BindView(R.id.together)
    LinearLayout together;
    @BindView(R.id.aboutour)
    LinearLayout aboutour;
    @BindView(R.id.contactour)
    LinearLayout contactour;
    @BindView(R.id.setting)
    LinearLayout setting;
    Unbinder unbinder;
    private View view;

    public FragmentMore() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_more, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.product, R.id.help, R.id.together, R.id.aboutour, R.id.contactour, R.id.setting})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.product:
                startActivity(new Intent(getActivity(),ProductActivity.class));
                break;
            case R.id.help:
                break;
            case R.id.together:
                break;
            case R.id.aboutour:
                break;
            case R.id.contactour:
                break;
            case R.id.setting:
                break;
        }
    }
}

package com.bibinet.finance.activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bibinet.finance.R;
import com.bibinet.finance.adapter.MyPagerAdapter;
import com.bibinet.finance.bean.PieData;
import com.bibinet.finance.builder.PieView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentBank extends Fragment implements ViewPager.OnPageChangeListener {

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.title_imageright)
    ImageView titleImageright;
    @BindView(R.id.title_imageleft)
    ImageView titleImageleft;
    @BindView(R.id.canusemoney)
    TextView canusemoney;
    @BindView(R.id.usedmoney)
    TextView usedmoney;
    @BindView(R.id.todopro)
    TextView todopro;
    @BindView(R.id.doingpro)
    TextView doingpro;
    @BindView(R.id.datapieview)
    PieView datapieview;
    @BindView(R.id.bankproviewpager)
    ViewPager bankproviewpager;
    private List<Fragment> fragments=new ArrayList<>();
    private TextView[] mButtons=new TextView[2];
    private int lastposition;
    private Fragment fragmentbrankpro1=new FragmentBankPro();
    private Fragment fragmentbrankpro2=new FragmentBankPro();
    private ArrayList<PieData> pieDatas=new ArrayList<>();
    public FragmentBank() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bank, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        pieDatas.add(new PieData("a",0.2f,20));
        pieDatas.add(new PieData("b",0.8f,80));
        datapieview.setData(pieDatas);
        datapieview.setStartAngle(0);
        fragments.add(fragmentbrankpro1);
        fragments.add(fragmentbrankpro2);
        mButtons[0]=todopro;
        mButtons[1]=doingpro;
        mButtons[0].setSelected(true);
        bankproviewpager.setOnPageChangeListener(this);

        bankproviewpager.setAdapter(new MyPagerAdapter(getFragmentManager(),fragments,getActivity()));
    }

    @OnClick({R.id.title_imageright, R.id.title_imageleft, R.id.todopro, R.id.doingpro})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.title_imageright:
                break;
            case R.id.title_imageleft:
                break;
            case R.id.todopro:
                bankproviewpager.setCurrentItem(0);
                break;
            case R.id.doingpro:
                bankproviewpager.setCurrentItem(1);
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        bankproviewpager.setCurrentItem(position);
        mButtons[position].setSelected(true);
        mButtons[lastposition].setSelected(false);
        lastposition=position;
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
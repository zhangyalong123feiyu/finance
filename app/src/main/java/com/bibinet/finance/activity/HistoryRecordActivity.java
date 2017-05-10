package com.bibinet.finance.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bibinet.finance.R;
import com.bibinet.finance.adapter.HistoryRecordAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by bibinet on 2017-5-9.
 */

public class HistoryRecordActivity extends BaseActivity {
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.title_imageright)
    ImageView titleImageright;
    @BindView(R.id.title_imageleft)
    ImageView titleImageleft;
    @BindView(R.id.recordhistoryrecyclerview)
    RecyclerView recordhistoryrecyclerview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        title.setText("历史记录");
        titleImageleft.setVisibility(View.VISIBLE);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recordhistoryrecyclerview.setLayoutManager(linearLayoutManager);
        HistoryRecordAdapter adapter=new HistoryRecordAdapter(this);
        recordhistoryrecyclerview.setAdapter(adapter);
    }

    @OnClick(R.id.title_imageleft)
    public void onViewClicked() {
        finish();
    }
}

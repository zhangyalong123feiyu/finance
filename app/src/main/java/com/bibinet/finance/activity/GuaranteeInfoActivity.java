package com.bibinet.finance.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bibinet.finance.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by bibinet on 2017-5-9.
 */

public class GuaranteeInfoActivity extends BaseActivity {
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.title_imageright)
    ImageView titleimageright;
    @BindView(R.id.title_imageleft)
    ImageView titleimageleft;
    @BindView(R.id.projectname)
    TextView projectname;
    @BindView(R.id.allmoney)
    TextView allmoney;
    @BindView(R.id.serialnumber)
    TextView serialnumber;
    @BindView(R.id.benifperson)
    TextView benifperson;
    @BindView(R.id.ensureperson)
    TextView ensureperson;
    @BindView(R.id.endtime)
    TextView endtime;
    @BindView(R.id.vilidatetime)
    TextView vilidatetime;
    @BindView(R.id.ensureimage)
    ImageView ensureimage;
    @BindView(R.id.onlineask)
    LinearLayout onlineask;
    @BindView(R.id.telephoneask)
    LinearLayout telephoneask;
    @BindView(R.id.seeblockinfo)
    LinearLayout seeblockinfo;
    @BindView(R.id.projecinfo)
    LinearLayout projectinfo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guranteeinfo);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        title.setText("保函信息");
        titleimageright.setVisibility(View.VISIBLE);
        titleimageright.setImageResource(R.mipmap.history);
        titleimageleft.setImageResource(R.mipmap.back);
    }

    @OnClick({R.id.ensureimage, R.id.onlineask, R.id.telephoneask, R.id.seeblockinfo,R.id.title_imageright})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ensureimage:
                break;
            case R.id.onlineask:
                break;
            case R.id.telephoneask:
                break;
            case R.id.seeblockinfo:
                if (projectinfo.isSelected()){
                    projectinfo.setSelected(false);
                    projectinfo.setVisibility(View.GONE);
                }else {
                    projectinfo.setSelected(true);
                    projectinfo.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.title_imageright:
                startActivity(new Intent(GuaranteeInfoActivity.this,HistoryRecordActivity.class));
                Toast.makeText(this,"haod",Toast.LENGTH_SHORT).show();
                break;
            case R.id.title_imageleft:
                finish();
                break;
        }
    }
}

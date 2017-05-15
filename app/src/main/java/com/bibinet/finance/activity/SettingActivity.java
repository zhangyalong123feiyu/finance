package com.bibinet.finance.activity;

import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bibinet.finance.R;
import com.bibinet.finance.constant.Constants;
import com.bibinet.finance.utils.DataCleanManagerUtils;
import com.bibinet.finance.utils.SharedPresUtils;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by bibinet on 2017-5-10.
 */

public class SettingActivity extends BaseActivity  {
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.cachesize)
    TextView cachesize;
    @BindView(R.id.title_imageright)
    ImageView titleImageright;
    @BindView(R.id.title_imageleft)
    ImageView titleImageleft;
    @BindView(R.id.clearcache)
    LinearLayout clearcache;
    @BindView(R.id.loginout)
    LinearLayout loginout;
    private String cachePath = Environment.getExternalStorageDirectory() + "/Finance/";
    private File cacheFile;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        title.setText(getString(R.string.setting));
        titleImageleft.setVisibility(View.VISIBLE);
        cacheFile = new File(cachePath);
        try {
            String sizeInfo = DataCleanManagerUtils.getCacheSize(cacheFile);
            cachesize.setText(sizeInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @OnClick({R.id.title_imageleft, R.id.clearcache,R.id.loginout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_imageleft:
                finish();
                break;
            case R.id.clearcache:
                clearCahce();
                break;
            case R.id.loginout:
                Constants.loginData=null;
                SharedPresUtils.getsSharedPresUtils(SettingActivity.this).putString("loginDataInfo",null);
                SharedPresUtils.getsSharedPresUtils(SettingActivity.this).putString("AccountType","0");
                MainActivity.getMainInstance().noLogin();
                initBottomSelect();
                break;
        }
    }

    private void clearCahce() {
        DataCleanManagerUtils.deleteFolderFile(cachePath, false);
        try {
            cachesize.setText(DataCleanManagerUtils.getCacheSize(cacheFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void initBottomSelect() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        MainActivity.currentTabIndex = 1;
        ft.hide(MainActivity.fragments[0]).show(MainActivity.fragments[1]).commit();
        MainActivity.mTabs[1].setSelected(true);
        MainActivity.mTabs[2].setSelected(false);
    }
}

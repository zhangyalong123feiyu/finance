package com.bibinet.finance.activity;

import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bibinet.finance.R;
import com.bibinet.finance.utils.DataCleanManagerUtils;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by bibinet on 2017-5-10.
 */

public class SettingActivity extends BaseActivity {
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
    private String cachePath= Environment.getExternalStorageDirectory()+"/Finance/";
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
         cacheFile=new File(cachePath);
        try {
            String sizeInfo=DataCleanManagerUtils.getCacheSize(cacheFile);
            cachesize.setText(sizeInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @OnClick({R.id.title_imageleft, R.id.clearcache})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_imageleft:
                finish();
                break;
            case R.id.clearcache:
                clearCahce();
                break;
        }
    }

    private void clearCahce() {
        DataCleanManagerUtils.deleteFolderFile(cachePath,false);
        try {
            cachesize.setText(DataCleanManagerUtils.getCacheSize(cacheFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

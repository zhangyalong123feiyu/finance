package com.bibinet.finance.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bibinet.finance.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by bibinet on 2017-5-4.
 */

public class BigPicActivity extends BaseActivity {
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.title_imageright)
    ImageView titleImageright;
    @BindView(R.id.title_imageleft)
    ImageView titleImageleft;
    @BindView(R.id.bigpic)
    ImageView bigpic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bigpic);
        ButterKnife.bind(this);
        initView();
        setData();
    }
    private void setData() {
        Intent intent = getIntent();
        if (intent != null) {
            byte[] bis = intent.getByteArrayExtra("bitmap");
            Bitmap bitmap = BitmapFactory.decodeByteArray(bis, 0, bis.length);
            bigpic.setImageBitmap(bitmap);
        }
    }

    private void initView() {
        title.setText("大图页");

    }

    @OnClick(R.id.title_imageleft)
    public void onViewClicked() {
        finish();
    }
}

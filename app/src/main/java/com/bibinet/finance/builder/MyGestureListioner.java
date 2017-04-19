package com.bibinet.finance.builder;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

/**
 * Created by bibinet on 2017-4-19.
 */

public class MyGestureListioner extends GestureDetector.SimpleOnGestureListener {
    private Context context;
    private ScrollView scrollView;
    private Button button;

    public MyGestureListioner(Context context, ScrollView scrollView,Button button) {
        this.context = context;
        this.scrollView = scrollView;
        this.button=button;
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        if (distanceY>0){
            button.setVisibility(View.GONE);
        }else {
            button.setVisibility(View.VISIBLE);
        }
        return super.onScroll(e1, e2, distanceX, distanceY);
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if (velocityY>0){
            button.setVisibility(View.GONE);
        }else {
            button.setVisibility(View.VISIBLE);
        }
        return super.onFling(e1, e2, velocityX, velocityY);

    }
}

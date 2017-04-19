package com.bibinet.finance.builder;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;


public class ViewAllShowLinearLayout extends LinearLayout {

	private View mView;
	private ViewSwitchListener viewSwitchListener;
	private ScrollView mScrollView;
	private boolean isFlag = true;

	public void initData(View view, ScrollView scrollview,
			ViewSwitchListener viewSwitchListener) {
		this.mView = view;
		this.mScrollView = scrollview;
		this.viewSwitchListener = viewSwitchListener;
	}

	public ViewAllShowLinearLayout(Context context) {
		super(context);
		init();
	}

	public ViewAllShowLinearLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	private void init() {
		setOrientation(LinearLayout.VERTICAL);
	}

	@Override
	public void computeScroll() {
		if (mView != null && mScrollView != null && viewSwitchListener != null) {
			int y = mScrollView.getScrollY();
			if (isFlag) {
				int top = mView.getTop();
				if (y >= top) {
					viewSwitchListener.onViewShow();
					isFlag = false;
					Log.i("TAG", "不能滑动"+isFlag);
				}
			}
			if (!isFlag) {
				int bottom = mView.getBottom();
				if (y <= bottom - mView.getHeight()) {
					viewSwitchListener.onViewGone();
					isFlag = true;
				}
			}
		}
	}

	public interface ViewSwitchListener {
		public void onViewShow();
		public void onViewGone();
	}
}

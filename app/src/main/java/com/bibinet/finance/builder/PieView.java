package com.bibinet.finance.builder;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.bibinet.finance.bean.PieData;

import java.util.ArrayList;


public class PieView extends View {
	// 颜色表(注意: 此处定义颜色使用的是ARGB，带Alpha通道的)
	private int[] mColors = { 0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69, 0xFF808080,
			0xFFE6B800, 0xFF7CFC00 };
	// 饼状图初始绘制角度
	private float mStartAngle = 0;
	// 数据
	private ArrayList<PieData> mData;
	// 宽高
	private int mWidth, mHeight;
	// 画笔
	private Paint mPaint = new Paint();
	private PieData pieMin;
	private PieData pieMax;

	public PieView(Context context) {
		this(context, null);
	}

	public PieView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mPaint.setStyle(Paint.Style.FILL);
		mPaint.setAntiAlias(true);
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		mWidth = w;
		mHeight = h;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		if (null == mData)
			return;
		float currentStartAngle = mStartAngle; // 当前起始角度
		canvas.translate(mWidth / 2, mHeight / 2); // 将画布坐标原点移动到中心位置
		float rMax = (float) (Math.min(mWidth, mHeight) / 2 * 0.8); // 饼状图半径
		RectF rectMax = new RectF(-rMax, -rMax, rMax, rMax); // 饼状图绘制区域
		Log.i("TAG", rMax+"-----------");
		float rMin =rMax-30f;
		RectF rectMin = new RectF(-rMin, -rMin, rMin, rMin);
		PieData pie0 = mData.get(0);
		PieData pie1 = mData.get(1);
		if (pie1.getValue() > pie0.getValue()) {
			pieMin = pie0;
			pieMax=pie1;
		}else{
			pieMin = pie1;
			pieMax=pie0;
		}
		for (int i = 0; i < 2; i++) {
			if (i==0) {
				mPaint.setColor(pieMin.getColor());
				canvas.drawArc(rectMin, currentStartAngle, pieMin.getAngle(), true, mPaint);
				currentStartAngle += pieMin.getAngle();
			}else if(i==1){
				mPaint.setColor(pieMax.getColor());
				canvas.drawArc(rectMax, currentStartAngle, pieMax.getAngle(), true, mPaint);
				currentStartAngle += pieMax.getAngle();
			}

		}

	}

	// 设置起始角度
	public void setStartAngle(int mStartAngle) {
		this.mStartAngle = mStartAngle;
		invalidate(); // 刷新
	}

	// 设置数据
	public void setData(ArrayList<PieData> mData) {
		this.mData = mData;
		initData(mData);
		invalidate(); // 刷新
	}

	// 初始化数据
	private void initData(ArrayList<PieData> mData) {
		if (null == mData || mData.size() == 0) // 数据有问题 直接返回
			return;

		float sumValue = 0;
		for (int i = 0; i < mData.size(); i++) {
			PieData pie = mData.get(i);

			sumValue += pie.getValue(); // 计算数值和

			int j = i % mColors.length; // 设置颜色
			pie.setColor(mColors[j]);
		}

		float sumAngle = 0;
		for (int i = 0; i < mData.size(); i++) {
			PieData pie = mData.get(i);

			float percentage = pie.getValue() / sumValue; // 百分比
			float angle = percentage * 360; // 对应的角度
			pie.setPercentage(percentage); // 记录百分比
			pie.setAngle(angle); // 记录角度大小
			sumAngle += angle;

			Log.i("angle", "" + pie.getAngle());
		}
	}
}
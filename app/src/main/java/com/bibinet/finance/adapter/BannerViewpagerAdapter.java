package com.bibinet.finance.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bibinet.finance.R;
import com.bibinet.finance.constant.ProjectUrl;
import com.bumptech.glide.Glide;

/**
 * Created by bibinet on 2017-5-16.
 */

public class BannerViewpagerAdapter extends PagerAdapter {
    private Context context;

    public BannerViewpagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return Integer.MAX_VALUE;
    }
    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        // TODO Auto-generated method stub
        return arg0==arg1;
    }
    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        // TODO Auto-generated method stub
        ImageView iv=new ImageView(context);
        iv.setScaleType(ImageView.ScaleType.FIT_XY);
        // if (IsNetCanUse){
        Glide.with(context).load(ProjectUrl.ImageUrls[position%(3)]).error(R.mipmap.ic_launcher).into(iv);
        //}
        // iv.setImageBitmap(BitmapFactory.decodeResource(getResources(), pics[position%(pics.length)]));

        container.addView(iv);
        iv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                  /*  Intent intent=new Intent(getActivity(),BannerActivity.class);
                    intent.putExtra("position", String.valueOf(position%(pics.length)));
                    startActivity(intent);*/
            }
        });
        return iv;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((ImageView)object);
        object=null;//编码规范好
        //super.destroyItem(container, position, object);
    }
}

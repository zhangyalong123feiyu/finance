package com.bibinet.finance.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bibinet.finance.R;
import com.bibinet.finance.bean.SocailBean;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.andview.refreshview.recyclerview.BaseRecyclerAdapter;

/**
 * Created by bibinet on 2017-4-21.
 */

public class FragmentMoreAdapter extends BaseRecyclerAdapter<FragmentMoreAdapter.MoreViewHolder> {

    private Context context;
    private List<SocailBean.SocailInfo> socailInfos;

    public FragmentMoreAdapter(Context context, List<SocailBean.SocailInfo> socailInfos) {
        this.context = context;
        this.socailInfos = socailInfos;
    }

    @Override
    public MoreViewHolder getViewHolder(View view) {
        return new MoreViewHolder(view,false);
    }

    @Override
    public MoreViewHolder onCreateViewHolder(ViewGroup parent, int viewType, boolean isItem) {
        View v = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.newsitemone, parent, false);
        MoreViewHolder vh = new MoreViewHolder(v, true);
        return vh;
    }

    @Override
    public void onBindViewHolder(MoreViewHolder holder, int position, boolean isItem) {
        Glide.with(context).load(socailInfos.get(position).getPicUrl()).crossFade().into(holder.ivone);
        holder.newstime.setText(socailInfos.get(position).getCtime());
        holder.newstitle.setText(socailInfos.get(position).getTitle());
    }

    @Override
    public int getAdapterItemCount() {
        return socailInfos.size();
    }

    /*    @Override
        public void onBindViewHolder(MoreViewHolder holder, int position) {
            Glide.with(context).load(socailInfos.get(position).getPicUrl()).crossFade().into(holder.ivone);
            holder.newstime.setText(socailInfos.get(position).getCtime());
            holder.newstitle.setText(socailInfos.get(position).getTitle());
        }

        @Override
        public int getItemCount() {
            return socailInfos.size();
        }*/
    public void inSert(List<SocailBean.SocailInfo> socailInfo){
        socailInfos.addAll(socailInfo);
    }
    class MoreViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ivone)
        ImageView ivone;
        @BindView(R.id.newstitle)
        TextView newstitle;
        @BindView(R.id.newstime)
        TextView newstime;
        public MoreViewHolder(View itemView,boolean isItem) {
            super(itemView);
            if (isItem){
                ButterKnife.bind(this,itemView);
            }
        }
    }
}

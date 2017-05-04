package com.bibinet.finance.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bibinet.finance.R;
import com.bibinet.finance.bean.CompanyData;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by bibinet on 2017-2-16.
 */
public class CompanyDataAdapter extends RecyclerView.Adapter<CompanyDataAdapter.CompanyViewHolder> {


    private Context context;
    private List<CompanyData> datas = new ArrayList<>();

    public CompanyDataAdapter(Context context, List<CompanyData> datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public CompanyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_companyrequest, parent, false);
        CompanyViewHolder companyViewHolder = new CompanyViewHolder(view);
        return companyViewHolder;
    }

    @Override
    public void onBindViewHolder(CompanyViewHolder holder, int position) {
        holder.dataname.setText(datas.get(position).getName());
        holder.datadetail.setText(datas.get(position).getDetail());
        holder.datatime.setText(datas.get(position).getTime());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                context.startActivity(new Intent(context, IncludsionInfomationActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class CompanyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.dataname)
        TextView dataname;
        @BindView(R.id.datadetail)
        TextView datadetail;
        @BindView(R.id.datatime)
        TextView datatime;
        public CompanyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}

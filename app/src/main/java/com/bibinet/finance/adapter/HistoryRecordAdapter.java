package com.bibinet.finance.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bibinet.finance.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by bibinet on 2017-5-10.
 */

public class HistoryRecordAdapter extends RecyclerView.Adapter<HistoryRecordAdapter.RecordHolder> {
    private Context context;

    public HistoryRecordAdapter(Context context) {
        this.context = context;
    }

    private String[] operationame={"张亚龙","李白","墨子","小炮"};
    private String[] operatio={"初审认领","分审认领","终深认领","boss认领"};
    private String[] operationadvi={"ok","no","ok","no"};
    @Override
    public RecordHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_historyrecod, parent,false);
        RecordHolder recordHolder = new RecordHolder(view);
        return recordHolder;
    }

    @Override
    public void onBindViewHolder(RecordHolder holder, int position) {
        if (position == 0) {
            holder.recodstateimage.setImageResource(R.mipmap.ic_launcher_round);
            holder.operationame.setText(operationame[position]);
            holder.operation.setText(operatio[position]);
            holder.addvice.setText(operationadvi[position]);
        }else {
            holder.recodstateimage.setImageResource(R.mipmap.a);
            holder.operationame.setText(operationame[position]);
            holder.operation.setText(operatio[position]);
            holder.addvice.setText(operationadvi[position]);
        }

    }

    @Override
    public int getItemCount() {
        return operatio.length;
    }


    class RecordHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.recodstateimage)
        ImageView recodstateimage;
        @BindView(R.id.operationame)
        TextView operationame;
        @BindView(R.id.operation)
        TextView operation;
        @BindView(R.id.addvice)
        TextView addvice;

        public RecordHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

}

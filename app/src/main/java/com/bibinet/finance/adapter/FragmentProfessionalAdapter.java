package com.bibinet.finance.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bibinet.finance.R;
import com.bibinet.finance.bean.StudentBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by bibinet on 2017-4-20.
 */

public class FragmentProfessionalAdapter extends RecyclerView.Adapter<FragmentProfessionalAdapter.MyViewHolder> {

    private Context context;
    private List<StudentBean> students = new ArrayList<>();

    public FragmentProfessionalAdapter(Context context, List<StudentBean> students) {
        this.context = context;
        this.students = students;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_student, null);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.studenttext.setText(students.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.studenttext)
        TextView studenttext;
        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}

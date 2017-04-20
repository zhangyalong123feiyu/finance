package com.bibinet.finance.activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bibinet.finance.R;
import com.bibinet.finance.adapter.FragmentProfessionalAdapter;
import com.bibinet.finance.bean.StudentBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentProfession extends Fragment {


    @BindView(R.id.professionrecyclerview)
    RecyclerView professionrecyclerview;
    Unbinder unbinder;
    private View view;
    private List<StudentBean> studentList=new ArrayList<>();
    public FragmentProfession() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_profession, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();

        return view;
    }

    private void initView() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        professionrecyclerview.setLayoutManager(linearLayoutManager);
        studentList.add(new StudentBean("zhangyalong",22));
        studentList.add(new StudentBean("zhangyalong",22));
        studentList.add(new StudentBean("zhangyalong",22));
        studentList.add(new StudentBean("zhangyalong",22));
        studentList.add(new StudentBean("zhangyalong",22));
        studentList.add(new StudentBean("zhangyalong",22));
        studentList.add(new StudentBean("zhangyalong",22));
        studentList.add(new StudentBean("zhangyalong",22));
        studentList.add(new StudentBean("zhangyalong",22));
        studentList.add(new StudentBean("zhangyalong",22));
        FragmentProfessionalAdapter adapter=new FragmentProfessionalAdapter(getActivity(),studentList);
        professionrecyclerview.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

package com.bibinet.finance.activity;
import android.gesture.Gesture;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bibinet.finance.R;
import com.bibinet.finance.adapter.FragmentHomeBannerAdapter;
import com.bibinet.finance.builder.MyGestureListioner;
import com.bibinet.finance.builder.ViewAllShowLinearLayout;
import com.bibinet.finance.constant.ProjectUrl;
import com.bibinet.finance.view.FragmentHomeView;
import com.hejunlin.superindicatorlibray.CircleIndicator;
import com.hejunlin.superindicatorlibray.LoopViewPager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentHome extends Fragment implements FragmentHomeView ,View.OnTouchListener{

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.title_imageright)
    ImageView titleImageright;
    @BindView(R.id.title_imageleft)
    ImageView titleImageleft;
    @BindView(R.id.viewpager)
    LoopViewPager viewpager;
    @BindView(R.id.indicator)
    CircleIndicator indicator;
    @BindView(R.id.search_edit)
    EditText searchEdit;
    @BindView(R.id.search_image)
    ImageView searchImage;
    @BindView(R.id.requestbook)
    TextView requestbook;
    @BindView(R.id.requestbooknumber)
    TextView requestbooknumber;
    @BindView(R.id.thoughrequest)
    TextView thoughrequest;
    @BindView(R.id.exaimenumber)
    TextView exaimenumber;
    @BindView(R.id.all)
    TextView all;
    @BindView(R.id.allmoney)
    TextView allmoney;
    @BindView(R.id.bottommore)
    RelativeLayout bottommore;
    @BindView(R.id.professonalmove)
    TextView professonalmove;
    @BindView(R.id.sucess)
    TextView sucess;
    @BindView(R.id.brand)
    TextView brand;
    @BindView(R.id.ll1)
    LinearLayout ll1;
    @BindView(R.id.vi)
    View vi;
    @BindView(R.id.main_container)
    RelativeLayout mainContainer;
    @BindView(R.id.scrollview)
    ScrollView scrollview;
    @BindView(R.id.view_all_show)
    ViewAllShowLinearLayout viewAllShow;
    @BindView(R.id.professonalmove_top)
    TextView professonalmoveTop;
    @BindView(R.id.sucess_top)
    TextView sucessTop;
    @BindView(R.id.brand_top)
    TextView brandTop;
    @BindView(R.id.ll2)
    LinearLayout ll2;
    @BindView(R.id.folatbutton)
    Button folatbutton;
    Unbinder unbinder;
    private View view;
    private List<String> pics=new ArrayList<>();
    private GestureDetector gestureListioner;

    public FragmentHome() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        setListener();
        return view;
    }

    private void initView() {
        //滚动条代码
        ViewAllShowLinearLayout allShowView = (ViewAllShowLinearLayout) view.findViewById(R.id.view_all_show);
        final LinearLayout ll2 = (LinearLayout) view.findViewById(R.id.ll2);
        allShowView.initData(view.findViewById(R.id.ll1), (ScrollView) view.findViewById(R.id.scrollview),
                new ViewAllShowLinearLayout.ViewSwitchListener() {
                    @Override
                    public void onViewShow() {
                        Log.i("TAG", "到达顶部");
                        ll2.setVisibility(View.VISIBLE);
                    }
                    @Override
                    public void onViewGone() {
                        ll2.setVisibility(View.GONE);
                    }
                });
        pics=Arrays.asList(ProjectUrl.ImageUrls);
        FragmentHomeBannerAdapter adapter=new FragmentHomeBannerAdapter(getActivity(),pics);
       //轮播图代码部分
        viewpager.setAdapter(adapter);
        viewpager.setLooperPic(true);
        viewpager.setOnDispatchTouchEventListener(mDispatchOnTouchListener);
        indicator.setViewPager(viewpager);
        //滑动按钮部分
        gestureListioner=new GestureDetector(new MyGestureListioner(getActivity(),scrollview,folatbutton));

    }

    private void setListener() {
        folatbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollview.scrollTo(0,0);
            }
        });

    }

    private LoopViewPager.OnDispatchTouchEventListener mDispatchOnTouchListener = new LoopViewPager.OnDispatchTouchEventListener() {
        @Override
        public void onDispatchKeyEvent(MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                viewpager.setLooperPic(false);
            } else if (event.getAction() == MotionEvent.ACTION_UP
                    || event.getAction() == MotionEvent.ACTION_CANCEL) {
                viewpager.setLooperPic(true);
            }
        }
    };
    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void addData() {

    }

    @Override
    public void showLoadFailed() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.title, R.id.title_imageleft, R.id.search_image, R.id.professonalmove, R.id.sucess, R.id.brand, R.id.professonalmove_top, R.id.sucess_top, R.id.brand_top, R.id.folatbutton})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title:
                break;
            case R.id.title_imageleft:
                break;
            case R.id.search_image:
                break;
            case R.id.professonalmove:
                break;
            case R.id.sucess:
                break;
            case R.id.brand:
                break;
            case R.id.professonalmove_top:
                break;
            case R.id.sucess_top:
                break;
            case R.id.brand_top:
                break;
            case R.id.folatbutton:
                break;
        }
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return gestureListioner.onTouchEvent(event);
    }
}

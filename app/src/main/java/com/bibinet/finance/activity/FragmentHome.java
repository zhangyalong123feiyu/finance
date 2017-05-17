package com.bibinet.finance.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
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
import com.bibinet.finance.adapter.BannerViewpagerAdapter;
import com.bibinet.finance.bean.StudentBean;
import com.bibinet.finance.builder.MyGestureListioner;
import com.bibinet.finance.builder.MyViewPager;
import com.bibinet.finance.builder.ViewAllShowLinearLayout;
import com.bibinet.finance.constant.ProjectUrl;
import com.bibinet.finance.presenter.presenterimpl.FragmentHomePresenterImpl;
import com.bibinet.finance.utils.BannerUtils;
import com.bibinet.finance.utils.DensityUtil;
import com.bibinet.finance.utils.DialogUtils;
import com.bibinet.finance.view.FragmentHomeView;
import com.hejunlin.superindicatorlibray.CircleIndicator;

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
public class FragmentHome extends Fragment implements FragmentHomeView {

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.title_imageright)
    ImageView titleImageright;
    @BindView(R.id.title_imageleft)
    ImageView titleImageleft;
    @BindView(R.id.viewpager)
    MyViewPager viewpager;
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
    @BindView(R.id.group_contain)
    LinearLayout groupContain;
    private View view;
    private List<String> pics = new ArrayList<>();
    private GestureDetector gestureListioner;
    private FragmentHomePresenterImpl fragmentHomePresenter;
    private FragmentProfession fragementprofe;
    private FragmentSucess fragmentSucess;
    private FragmentBrand fragementBrand;
    private Fragment[] fragments;
    private TextView[] mTabsTop;
    private TextView[] mTabs;
    private int index;
    private int currentTabIndex;
    private int lastPosition;
    private boolean isRunning;
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
        loadData();
        setListener();
        return view;
    }

    private void loadData() {
        fragmentHomePresenter = new FragmentHomePresenterImpl(this);
        fragmentHomePresenter.LoadData(ProjectUrl.ImageUrls[0]);
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
        //轮播图代码部分
       BannerUtils bannerUtils=new BannerUtils(getActivity(),viewpager,groupContain,Arrays.asList(ProjectUrl.ImageUrls));
       bannerUtils.startPlayBanner();
        //滑动按钮部分
        gestureListioner = new GestureDetector(new MyGestureListioner(getActivity(), scrollview, folatbutton));
        scrollview.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return gestureListioner.onTouchEvent(event);
            }
        });
        //行业动态，成功案例，旗下品牌三个Fragment部分
        fragementprofe = new FragmentProfession();
        fragmentSucess = new FragmentSucess();
        fragementBrand = new FragmentBrand();
        fragments = new Fragment[]{fragementprofe, fragmentSucess, fragementBrand};

        getChildFragmentManager().beginTransaction().replace(R.id.main_container, fragementprofe).show(fragementprofe).
                add(R.id.main_container, fragmentSucess).hide(fragmentSucess).add(R.id.main_container, fragementBrand).hide(fragementBrand)
                .commit();
        mTabs = new TextView[3];
        mTabs[0] = professonalmove;
        mTabs[1] = sucess;
        mTabs[2] = brand;
        mTabsTop = new TextView[3];
        mTabsTop[0] = professonalmoveTop;
        mTabsTop[1] = sucessTop;
        mTabsTop[2] = brandTop;
        // 把第一个tab设为选中状态
        mTabs[0].setSelected(true);
        mTabsTop[0].setSelected(true);
    }

    private void setListener() {
        folatbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollview.scrollTo(0, 0);
            }
        });
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
                index = 0;
                break;
            case R.id.sucess:
                index = 1;
                break;
            case R.id.brand:
                index = 2;
                break;
            case R.id.professonalmove_top:
                index = 0;
                break;
            case R.id.sucess_top:
                index = 1;
                break;
            case R.id.brand_top:
                index = 2;
                break;
            case R.id.folatbutton:
                scrollview.scrollTo(0, 0);
                break;
        }
        if (currentTabIndex != index) {
            FragmentTransaction trx = getChildFragmentManager().beginTransaction();
            trx.hide(fragments[currentTabIndex]);
            if (!fragments[index].isAdded()) {
                trx.add(R.id.fragementcontainer, fragments[index]);
            }
            trx.show(fragments[index]).commit();
        }
        mTabs[currentTabIndex].setSelected(false);
        mTabsTop[currentTabIndex].setSelected(false);
        // 把当前tab设为选中状态
        mTabs[index].setSelected(true);
        mTabsTop[index].setSelected(true);
        currentTabIndex = index;
    }
    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showData(StudentBean studentBean) {

    }

    @Override
    public void showLoadFailed() {

    }
}

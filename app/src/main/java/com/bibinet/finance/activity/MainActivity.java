package com.bibinet.finance.activity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bibinet.finance.R;
import com.jaeger.library.StatusBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.home)
    ImageView home;
    @BindView(R.id.bottomhome)
    RelativeLayout bottomhome;
    @BindView(R.id.my)
    ImageView my;
    @BindView(R.id.bottommy)
    RelativeLayout bottommy;
    @BindView(R.id.more)
    ImageView more;
    @BindView(R.id.bottommore)
    RelativeLayout bottommore;
    @BindView(R.id.linearbottom)
    LinearLayout linearBottom;
    @BindView(R.id.fragementcontainer)
    RelativeLayout fragementContainer;
    private FragmentHome fragementHome;
    private FragmentCompany fragmentCompany;
    private FragmentBank fragmentBank;
    private FragmentMore fragementmore;
    public static Fragment[] fragments;
    public static RelativeLayout[] mTabs;
    private String logintype;
    private FragmentOperation fragementOperation;
    private FragmentLogin fragementMy;
    private int index;
    public static int currentTabIndex;
    private long mPressedTime=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StatusBarUtil.setColor(MainActivity.this, Color.argb(255,127, 255, 212),0);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        SharedPreferences sharedPreferences=getSharedPreferences("LoginType",MODE_PRIVATE);
        logintype = sharedPreferences.getString("longintype", "0");
        fragementHome = new FragmentHome();
        fragmentCompany = new FragmentCompany();
        fragmentBank=new FragmentBank();
        fragementMy = new FragmentLogin();
        fragementOperation=new FragmentOperation();
        fragementmore = new FragmentMore();
        fragments = new Fragment[]{fragementHome, fragementMy, fragementmore};
        mTabs = new RelativeLayout[3];
        mTabs[0] = (RelativeLayout) findViewById(R.id.bottomhome);
        mTabs[1] = (RelativeLayout) findViewById(R.id.bottommy);
        mTabs[2] = (RelativeLayout) findViewById(R.id.bottommore);
        // 把第一个tab设为选中状态
        mTabs[0].setSelected(true);
        switch (Integer.parseInt(logintype)) {
            case 0:
                noLogin();
                break;
            case 1:
                companyLogin();
                break;
            case 2:
                bankLogin();
                break;
            case 3:
                operationLogin();
                break;
            default:
                break;
        }
    }

    public void bankLogin() {
        fragments = new Fragment[]{fragementHome, fragmentBank, fragementmore};
        getSupportFragmentManager().beginTransaction().replace(R.id.fragementcontainer, fragementHome).show(fragementHome).
                add(R.id.fragementcontainer, fragmentBank).hide(fragmentBank).add(R.id.fragementcontainer, fragementmore).hide(fragementmore)
                .commit();
    }

    @OnClick({R.id.bottomhome, R.id.bottommy, R.id.bottommore})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bottomhome:
                index=0;
                break;
            case R.id.bottommy:
                index=1;
                break;
            case R.id.bottommore:
                index=2;
                break;
        }
    }

    public void operationLogin() {
        fragments = new Fragment[]{fragementHome, fragementOperation, fragementmore};
        getSupportFragmentManager().beginTransaction().replace(R.id.fragementcontainer, fragementHome).show(fragementHome).
                add(R.id.fragementcontainer, fragementOperation).hide(fragementOperation).add(R.id.fragementcontainer, fragementmore).hide(fragementmore)
                .commit();

    }

    public void companyLogin() {
        fragments = new Fragment[]{fragementHome, fragmentCompany, fragementmore};
        getSupportFragmentManager().beginTransaction().replace(R.id.fragementcontainer, fragementHome).show(fragementHome).
                add(R.id.fragementcontainer, fragmentCompany).hide(fragmentCompany).add(R.id.fragementcontainer, fragementmore).hide(fragementmore)
                .commit();
    }

    private void noLogin() {
        fragments = new Fragment[]{fragementHome, fragementMy, fragementmore};
        getSupportFragmentManager().beginTransaction().replace(R.id.fragementcontainer, fragementHome).show(fragementHome).
                add(R.id.fragementcontainer, fragementMy).hide(fragementMy).add(R.id.fragementcontainer, fragementmore).hide(fragementmore)
                .commit();
    }


    @OnClick({R.id.bottomhome, R.id.bottommy, R.id.bottommore})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bottomhome:
                index = 0;
                break;
            case R.id.bottommy:
                index = 1;
                break;
            case R.id.bottommore:
                index = 2;
                break;
        }
        if (currentTabIndex != index) {
            FragmentTransaction trx = getSupportFragmentManager().beginTransaction();
            trx.hide(fragments[currentTabIndex]);
            if (!fragments[index].isAdded()) {
                trx.add(R.id.fragementcontainer, fragments[index]);
            }
            trx.show(fragments[index]).commit();
        }
        mTabs[currentTabIndex].setSelected(false);
        // 把当前tab设为选中状态
        mTabs[index].setSelected(true);
        currentTabIndex = index;
    }

    //双击退出程序
    @Override
    public void onBackPressed() {
        long mNowTime = System.currentTimeMillis();//获取第一次按键时间
        if ((mNowTime - mPressedTime) > 2000) {//比较两次按键时间差
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            mPressedTime = mNowTime;
        } else {//退出程序
            this.finish();
            android.os.Process.killProcess(android.os.Process.myPid());
        }
    }
}

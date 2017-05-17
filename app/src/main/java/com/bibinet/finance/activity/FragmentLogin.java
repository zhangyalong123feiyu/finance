package com.bibinet.finance.activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bibinet.finance.R;
import com.bibinet.finance.bean.LoginResultBean;
import com.bibinet.finance.constant.Constants;
import com.bibinet.finance.presenter.presenterimpl.FragmentBankPresenterImp;
import com.bibinet.finance.presenter.presenterimpl.FragmentLoginPresenterImp;
import com.bibinet.finance.utils.LogUtils;
import com.bibinet.finance.utils.PhoneNumberUtils;
import com.bibinet.finance.utils.ProgressDialogUtils;
import com.bibinet.finance.utils.SharedPresUtils;
import com.bibinet.finance.utils.ToastUtils;
import com.bibinet.finance.view.FragmentLoginView;
import com.google.gson.Gson;
import com.zhy.autolayout.utils.DimenUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentLogin extends Fragment implements FragmentLoginView{


    @BindView(R.id.imageView1)
    ImageView imageView1;
    @BindView(R.id.imageView2)
    ImageView imageView2;
    @BindView(R.id.textView1)
    TextView textView1;
    @BindView(R.id.btn_send)
    Button btnSend;
    @BindView(R.id.inputphone_number)
    EditText inputphoneNumber;
    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.inputpassword)
    EditText inputpassword;
    @BindView(R.id.relativeLayout1)
    LinearLayout relativeLayout1;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.textView3)
    TextView textView3;
    @BindView(R.id.textView9)
    TextView textView9;
    @BindView(R.id.txt_service)
    TextView txtService;
    private View view;
    private Unbinder unbind;
    private FragmentLoginPresenterImp presenterImp;
    private ProgressDialogUtils dialogUtils;

    public FragmentLogin() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_login, container, false);
        unbind=ButterKnife.bind(this, view);
        presenterImp=new FragmentLoginPresenterImp(this);
        return view;
    }

    private void initBottomSelect() {
        FragmentManager fm = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        MainActivity.currentTabIndex = 1;
        ft.hide(MainActivity.fragments[0]).show(MainActivity.fragments[1]).commit();
        MainActivity.mTabs[1].setSelected(true);
        MainActivity.mTabs[2].setSelected(false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbind.unbind();
    }

    @OnClick({R.id.btn_send, R.id.btn_login, R.id.txt_service})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_send:
                break;
            case R.id.btn_login:
                ((MainActivity)getActivity()).companyLogin();//调试
                SharedPresUtils.getsSharedPresUtils(getActivity()).putString("AccountType","1");
                initBottomSelect();//调试
                String number=inputphoneNumber.getText().toString().trim();
                String password=inputpassword.getText().toString().trim();
                	if (TextUtils.isEmpty(number)) {
                        ToastUtils.getToastUtils().ToastMsg(getActivity(),"用户名不能为空");
                			} else if(TextUtils.isEmpty(password)){
                        ToastUtils.getToastUtils().ToastMsg(getActivity(),"密码不能为空");
                    }else {
                        presenterImp.onLoadData(number,password);
                    }
            case R.id.txt_service:
                break;
        }
    }

    @Override
    public void showProgress() {
        dialogUtils=new ProgressDialogUtils();
        dialogUtils.showProgressDialog(getActivity());
    }

    @Override
    public void hideProgress() {
        dialogUtils.hideProgressDialgo();
    }
    @Override
    public void showLoadFailed(String messge) {
        ToastUtils.getToastUtils().ToastMsg(getActivity(),messge);
    }

    @Override
    public void showData(LoginResultBean LoginInfo) {
       	switch (Integer.parseInt(LoginInfo.getResCode())) {
       			case 0000:
                    LoginResultBean.ReturnDataBean loginDataInfo = LoginInfo.getReturnData();
                    //将用户信息保存到常亮中
                    Gson gson=new Gson();
                    Constants.loginData=gson.toJson(loginDataInfo);
                    SharedPresUtils.getsSharedPresUtils(getActivity()).putString("loginDataInfo",Constants.loginData);
       			   // ((MainActivity)getActivity()).companyLogin();
                    MainActivity.getMainInstance().companyLogin();
                    SharedPresUtils.getsSharedPresUtils(getActivity()).putString("AccountType","1");
                    initBottomSelect();
       				break;
       			case 0001:
                    ToastUtils.getToastUtils().ToastMsg(getActivity(),"用户名或密码错误");
                    break;
       			case 0002:
                    ToastUtils.getToastUtils().ToastMsg(getActivity(),"用户名或密码错误");
       				break;

       			default:
       				break;
       			}
    }

}

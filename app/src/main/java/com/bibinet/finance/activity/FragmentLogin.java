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
import com.bibinet.finance.presenter.presenterimpl.FragmentBankPresenterImp;
import com.bibinet.finance.presenter.presenterimpl.FragmentLoginPresenterImp;
import com.bibinet.finance.utils.LogUtils;
import com.bibinet.finance.utils.PhoneNumberUtils;
import com.bibinet.finance.utils.ProgressDialogUtils;
import com.bibinet.finance.utils.SharedPresUtils;
import com.bibinet.finance.utils.ToastUtils;
import com.bibinet.finance.view.FragmentLoginView;
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
    @BindView(R.id.inputexacode)
    EditText inputexacode;
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

    @OnClick({R.id.btn_send, R.id.inputphone_number, R.id.inputexacode, R.id.btn_login, R.id.txt_service})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_send:
                break;
            case R.id.inputphone_number:
                break;
            case R.id.inputexacode:
                break;
            case R.id.btn_login:
                ((MainActivity)getActivity()).companyLogin();
                String number=inputphoneNumber.getText().toString().trim();
                	if (TextUtils.isEmpty(number)) {
                        ToastUtils.getToastUtils().ToastMsg(getActivity(),"手机号不能为空");
                			} else if(PhoneNumberUtils.isMobileNumber(number)){
                        presenterImp.onLoadData(number,"3","3");
                			}else {
                        ToastUtils.getToastUtils().ToastMsg(getActivity(),"请输入正确的手机号");
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
        ToastUtils.getToastUtils().ToastMsg(getActivity(),"yingchang");
        dialogUtils.hideProgressDialgo();
    }
    @Override
    public void showLoadFailed(String messge) {

    }

    @Override
    public void showData(LoginResultBean LoginInfo) {
        String resultCode = LoginInfo.getResultCode();
        	switch (Integer.parseInt(resultCode)) {
        			case 00000000:
                        ((MainActivity)getActivity()).companyLogin();
                        SharedPresUtils.getsSharedPresUtils(getActivity()).putString("AccountType","1");
                        initBottomSelect();
        				break;
        			case 77777777:
                            Toast.makeText(getActivity(),"提交数据错误",Toast.LENGTH_SHORT).show();
                        dialogUtils.hideProgressDialgo();
        				break;

        			default:
        				break;
        			}
    }


}

package com.bibinet.finance.activity;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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
import com.bibinet.finance.presenter.presenterimpl.FragmentBankPresenterImp;
import com.bibinet.finance.presenter.presenterimpl.FragmentLoginPresenterImp;
import com.bibinet.finance.utils.LogUtils;
import com.bibinet.finance.view.FragmentLoginView;

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
                Toast.makeText(getActivity(),"登录",Toast.LENGTH_LONG).show();
                String number=inputphoneNumber.getText().toString().trim();
                LogUtils.getLogInstance().logMessage(number);
                presenterImp.onLoadData(number,"3","3");
                SharedPreferences sharedPreferences=getActivity().getSharedPreferences("LoginType", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
            case R.id.txt_service:
                break;
        }
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showData() {
        Toast.makeText(getActivity(),"成功",Toast.LENGTH_LONG).show();
    }

    @Override
    public void showLoadFailed(String messge) {
	switch (Integer.getInteger(messge)) {
			case 77777777:
                Toast.makeText(getActivity(),"提交信息错误",Toast.LENGTH_SHORT).show();
				break;

			default:
				break;
			}
    }
}

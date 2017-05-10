package com.bibinet.finance.activity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bibinet.finance.R;
import com.bibinet.finance.presenter.presenterimpl.GuranteeApplayPresenterImp;
import com.bibinet.finance.utils.BitMapCompressUtils;
import com.bibinet.finance.utils.DialogUtils;
import com.bibinet.finance.utils.LogUtils;
import com.bibinet.finance.utils.PicUpLoadUtils;
import com.bibinet.finance.utils.ToastUtils;
import com.bibinet.finance.view.GuranteApplayView;

import org.xutils.x;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by bibinet on 2017-5-3.
 */

public class GuaranteeApplyActivity extends BaseActivity implements View.OnClickListener,GuranteApplayView {
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.title_imageright)
    ImageView titleImageright;
    @BindView(R.id.scrollview)
    ScrollView scrollview;
    @BindView(R.id.title_imageleft)
    ImageView titleImageleft;
    @BindView(R.id.edit_projectname)
    EditText editProjectname;
    @BindView(R.id.edit_guranteemoney)
    EditText editGuranteemoney;
    @BindView(R.id.edit_contactperson)
    EditText editContactperson;
    @BindView(R.id.edit_contactphone)
    EditText editContactphone;
    @BindView(R.id.radiobtnisthree)
    RadioButton radiobtnisthree;
    @BindView(R.id.radiobtnnothree)
    RadioButton radiobtnnothree;
    @BindView(R.id.threecetifte)
    LinearLayout threecetifte;
    @BindView(R.id.ivbusinesslicense)
    ImageView ivbusinesslicense;
    @BindView(R.id.businesslicense)
    LinearLayout businesslicense;
    @BindView(R.id.ivorgancode)
    ImageView ivorgancode;
    @BindView(R.id.origancode)
    LinearLayout origancode;
    @BindView(R.id.ivtaxrigsion)
    ImageView ivtaxrigsion;
    @BindView(R.id.taxrigsion)
    LinearLayout taxrigsion;
    @BindView(R.id.isontthreecerifte)
    LinearLayout isontthreecerifte;
    @BindView(R.id.ivopenaccountlicense)
    ImageView ivopenaccountlicense;
    @BindView(R.id.openaccountlicense)
    LinearLayout openaccountlicense;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.ivqualificationprofile)
    ImageView ivqualificationprofile;
    @BindView(R.id.qualificationprofile)
    LinearLayout qualificationprofile;
    @BindView(R.id.ivbidderbook)
    ImageView ivbidderbook;
    @BindView(R.id.bidderbook)
    LinearLayout bidderbook;
    @BindView(R.id.ivlagelprobook)
    ImageView ivlagelprobook;
    @BindView(R.id.lagelprobook)
    LinearLayout lagelprobook;
    @BindView(R.id.ivlagelpersoncard)
    ImageView ivlagelpersoncard;
    @BindView(R.id.lagelpersoncard)
    LinearLayout lagelpersoncard;
    @BindView(R.id.radiobtnishas)
    RadioButton radiobtnishas;
    @BindView(R.id.radiobtnnothas)
    RadioButton radiobtnnothas;
    @BindView(R.id.ivaccerditentrustbook)
    ImageView ivaccerditentrustbook;
    @BindView(R.id.accerditentrustbook)
    LinearLayout accerditentrustbook;
    @BindView(R.id.ivaccerditentrustcard)
    ImageView ivaccerditentrustcard;
    @BindView(R.id.ivthreecetifte)
    ImageView ivthreecetifte;
    @BindView(R.id.accerditentrustcard)
    LinearLayout accerditentrustcard;
    @BindView(R.id.ishasaccerditentruestbook)
    LinearLayout ishasaccerditentruestbook;
    @BindView(R.id.takepic_ivthreecetifte)
    ImageView takepicIvthreecetifte;
    @BindView(R.id.takepic_businesslicense)
    ImageView takepicbusinesslicense;
    @BindView(R.id.takepic_ivorgancode)
    ImageView takepicIvorgancode;
    @BindView(R.id.takepic_ivtaxrigsion)
    ImageView takepicIvtaxrigsion;
    @BindView(R.id.takepic_ivopenaccountlicense)
    ImageView takepicIvopenaccountlicense;
    @BindView(R.id.takepic_ivqualificationprofile)
    ImageView takepicIvqualificationprofile;
    @BindView(R.id.takepic_ivbidderbook)
    ImageView takepicIvbidderbook;
    @BindView(R.id.takepic_ivlagelprobook)
    ImageView takepicIvlagelprobook;
    @BindView(R.id.takepic_ivlagelpersoncard)
    ImageView takepicIvlagelpersoncard;
    @BindView(R.id.takepic_ivaccerditentrustbook)
    ImageView takepicIvaccerditentrustbook;
    @BindView(R.id.takepic_ivaccerditentrustcard)
    ImageView takepicIvaccerditentrustcard;
    @BindView(R.id.ivthreecetifte_delete)
    ImageView ivthreecetifteDelete;
    @BindView(R.id.ivbusinesslicense_delete)
    ImageView ivbusinesslicenseDelete;
    @BindView(R.id.ivorgancode_delete)
    ImageView ivorgancodeDelete;
    @BindView(R.id.ivtaxrigsion_delete)
    ImageView ivtaxrigsionDelete;
    @BindView(R.id.ivopenaccountlicense_delete)
    ImageView ivopenaccountlicenseDelete;
    @BindView(R.id.ivqualificationprofile_delete)
    ImageView ivqualificationprofileDelete;
    @BindView(R.id.ivbidderbook_delete)
    ImageView ivbidderbookDelete;
    @BindView(R.id.ivlagelprobook_delete)
    ImageView ivlagelprobookDelete;
    @BindView(R.id.ivlagelpersoncard_delete)
    ImageView ivlagelpersoncardDelete;
    @BindView(R.id.ivaccerditentrustbook_delete)
    ImageView ivaccerditentrustbookDelete;
    @BindView(R.id.ivaccerditentrustcard_delete)
    ImageView ivaccerditentrustcardDelete;
    @BindView(R.id.rela_ivthreecetifte)
    RelativeLayout relaIvthreecetifte;
    @BindView(R.id.rela_businesslicense)
    RelativeLayout relaBusinesslicense;
    @BindView(R.id.rela_origancode)
    RelativeLayout relaOrigancode;
    @BindView(R.id.rela_taxrigsion)
    RelativeLayout relaTaxrigsion;
    @BindView(R.id.rela_openaccountlicense)
    RelativeLayout relaOpenaccountlicense;
    @BindView(R.id.rela_qualificationprofile)
    RelativeLayout relaQualificationprofile;
    @BindView(R.id.rela_bidderbook)
    RelativeLayout relaBidderbook;
    @BindView(R.id.rela_lagelprobook)
    RelativeLayout relaLagelprobook;
    @BindView(R.id.rela_lagelpersoncard)
    RelativeLayout relaLagelpersoncard;
    @BindView(R.id.rela_ishasentrustbook)
    RadioGroup relaIshasentrustbook;
    @BindView(R.id.rela_accerditentrustbook)
    RelativeLayout relaAccerditentrustbook;
    @BindView(R.id.rela_accerditentrustcard)
    RelativeLayout relaAccerditentrustcard;
    private TextView camera;
    private TextView picstorage;
    private static final int PHOTO_REQUEST_CAMERA = 3;//相机
    private static final int REQUESTCODE_CUTTING = 2;
    private static final int REQUESTCODE_PICK = 1;//图库

    private int TYPE = 11;
    private Bitmap photo;
    private Map picPathList=new HashMap();
    private PicUpLoadUtils upLoadUtils;
    private GuranteeApplayPresenterImp presenterImp;
    private BitMapCompressUtils bitMapCompressUtil;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guaranteeapply);
        ButterKnife.bind(this);
        initView();
        upLoadPic();
//        setListener();
    }

    private void upLoadPic() {
        presenterImp=new GuranteeApplayPresenterImp(this);
    }

    private void initView() {
        title.setText("申请保函");
        titleImageleft.setVisibility(View.VISIBLE);
         upLoadUtils=new PicUpLoadUtils(GuaranteeApplyActivity.this);
        bitMapCompressUtil=new BitMapCompressUtils();

    }

    @OnClick({R.id.radiobtnisthree, R.id.radiobtnnothree,R.id.radiobtnishas,R.id.radiobtnnothas,R.id.takepic_ivthreecetifte,R.id.takepic_businesslicense,R.id.takepic_ivorgancode,R.id.takepic_ivtaxrigsion,R.id.takepic_ivopenaccountlicense,R.id.takepic_ivqualificationprofile,R.id.takepic_ivbidderbook,R.id.takepic_ivlagelprobook,R.id.takepic_ivlagelpersoncard,R.id.accerditentrustbook,R.id.takepic_ivaccerditentrustcard,R.id.rela_businesslicense, R.id.rela_taxrigsion, R.id.rela_openaccountlicense, R.id.rela_qualificationprofile, R.id.rela_bidderbook, R.id.rela_accerditentrustcard})
    public void onViewClicked(View view) {

        switch (view.getId()) {

            case R.id.radiobtnisthree:
                radiobtnisthree.setChecked(true);
                radiobtnnothree.setChecked(false);
                threecetifte.setVisibility(View.VISIBLE);
                isontthreecerifte.setVisibility(View.GONE);
                break;
            case R.id.radiobtnnothree:
                radiobtnisthree.setChecked(false);
                radiobtnnothree.setChecked(true);
                threecetifte.setVisibility(View.GONE);
                isontthreecerifte.setVisibility(View.VISIBLE);
                break;
            case R.id.takepic_ivthreecetifte:
                TYPE = 11;
                break;
            case R.id.takepic_businesslicense:
                TYPE = 12;
                break;
            case R.id.takepic_ivorgancode:
                TYPE = 13;
                break;
            case R.id.takepic_ivtaxrigsion:
                TYPE = 14;
                break;
            case R.id.takepic_ivopenaccountlicense:
                TYPE = 15;
                break;
            case R.id.takepic_ivqualificationprofile:
                TYPE = 16;
                break;
            case R.id.takepic_ivbidderbook:
                TYPE = 17;
                break;
            case R.id.takepic_ivlagelprobook:
                TYPE = 18;
                break;
            case R.id.takepic_ivlagelpersoncard:
                break;
            case R.id.radiobtnishas:
                radiobtnishas.setChecked(true);
                radiobtnnothas.setChecked(false);
                ishasaccerditentruestbook.setVisibility(View.VISIBLE);
                break;
            case R.id.radiobtnnothas:
                radiobtnishas.setChecked(false);
                radiobtnnothas.setChecked(true);
                ishasaccerditentruestbook.setVisibility(View.GONE);
                break;
            case R.id.takepic_ivaccerditentrustbook:
                TYPE = 19;
                break;
            case R.id.takepic_ivaccerditentrustcard:
                TYPE = 20;
                break;
            case R.id.rela_businesslicense:
                break;
            case R.id.rela_taxrigsion:
                break;
            case R.id.rela_openaccountlicense:
                break;
            case R.id.rela_qualificationprofile:
                break;
            case R.id.rela_bidderbook:
                break;
            case R.id.rela_accerditentrustcard:
                break;
        }
        if (view instanceof ImageView) {
            upLoadUtils.setSelectWay(GuaranteeApplyActivity.this,upLoadUtils);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            //从图库选择
            case REQUESTCODE_PICK:
                if (data == null || data.getData() == null) {
                    return;
                }
                Uri uri = data.getData();
                // 查询选择图片
                Cursor cursor = getContentResolver().query(uri,
                        new String[] { MediaStore.Images.Media.DATA }, null,
                        null, null);
                // 光标移动至开头 获取图片路径
                cursor.moveToFirst();
                String pathImage = cursor.getString(cursor
                        .getColumnIndex(MediaStore.Images.Media.DATA));
                File file=new File(pathImage);
                //上传图片
                presenterImp.UpLoadPic(file,1);

                upLoadUtils.setGlleryPicUrl(picPathList,pathImage);
                upLoadUtils.startPhotoZoom(data.getData());
                break;
            //拍照
            case PHOTO_REQUEST_CAMERA:
                if (upLoadUtils.hasSdcard()) {
                    if (upLoadUtils.tempFile!=null) {
                        LogUtils.getLogInstance().logMessage("拍照");
                        presenterImp.UpLoadPic(upLoadUtils.tempFile,1);
                        upLoadUtils.startPhotoZoom(Uri.fromFile(upLoadUtils.tempFile));
                    }

                }else {
                    Toast.makeText(GuaranteeApplyActivity.this, "未找到存储卡，无法存储照片！", Toast.LENGTH_SHORT).show();
                }
                break;
            //裁剪图片
            case REQUESTCODE_CUTTING:
                if (data != null) {
                    Bundle extras = data.getExtras();
                    if (extras != null) {
                        photo = extras.getParcelable("data");
                        try {
                            bitMapCompressUtil.saveBitMapToFile(photo,"baochun.jpg");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        setPhoto(photo);
                    }
                }
                break;

            default:
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    private void setPhoto(Bitmap pic) {
        switch (TYPE) {
            case 11:
                upLoadUtils.hideOrShow(ivthreecetifte,takepicIvthreecetifte,ivthreecetifteDelete,pic);
                break;
            case 12:
                upLoadUtils.hideOrShow(ivbusinesslicense,takepicbusinesslicense,ivbusinesslicenseDelete,pic);
                break;
            case 13:
                upLoadUtils.hideOrShow(ivorgancode,takepicIvorgancode,ivorgancodeDelete,pic);
                break;
            case 14:
                upLoadUtils.hideOrShow(ivtaxrigsion,takepicIvtaxrigsion,ivtaxrigsionDelete,pic);
                break;
            case 15:
                upLoadUtils.hideOrShow(ivopenaccountlicense,takepicIvopenaccountlicense,ivopenaccountlicenseDelete,pic);
                break;
            case 16:
                upLoadUtils.hideOrShow(ivqualificationprofile,takepicIvqualificationprofile,ivqualificationprofileDelete,pic);
                break;
            case 17:
                upLoadUtils.hideOrShow(ivbusinesslicense,takepicIvorgancode,ivorgancodeDelete,pic);
                break;
            case 18:
                upLoadUtils.hideOrShow(ivbusinesslicense,ivorgancode,ivorgancodeDelete,pic);
                break;
            case 19:
                upLoadUtils.hideOrShow(ivbusinesslicense,ivorgancode,ivorgancodeDelete,pic);
                break;
            case 20:
                upLoadUtils.hideOrShow(ivorgancode,takepicIvorgancode,ivorgancodeDelete,pic);
                break;

            default:
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.title_imageleft:
                finish();
                break;
            case R.id.ivthreecetifte_delete:
                upLoadUtils.hideOrShow(ivthreecetifte,takepicIvthreecetifte,ivthreecetifteDelete);
                picPathList.remove("threefitepic");
                break;
            case R.id.ivbusinesslicense_delete:
                upLoadUtils.hideOrShow(ivbusinesslicense,takepicbusinesslicense,ivbusinesslicenseDelete);
                picPathList.remove("threefitepic");
                break;
            case R.id.ivorgancode_delete:
                upLoadUtils.hideOrShow(ivorgancode,takepicIvorgancode,ivorgancodeDelete);
                picPathList.remove("threefitepic");
                break;
            case R.id.ivtaxrigsion_delete:
                upLoadUtils.hideOrShow(ivtaxrigsion,takepicIvtaxrigsion,ivtaxrigsionDelete);
                picPathList.remove("threefitepic");
                break;
            case R.id.ivopenaccountlicense_delete:
                upLoadUtils.hideOrShow(ivopenaccountlicense,takepicIvopenaccountlicense,ivopenaccountlicenseDelete);
                picPathList.remove("threefitepic");
                break;
            case R.id.ivqualificationprofile_delete:
                upLoadUtils.hideOrShow(ivqualificationprofile,takepicIvqualificationprofile,ivqualificationprofileDelete);
                picPathList.remove("threefitepic");
                break;
            case R.id.ivlagelprobook_delete:
                upLoadUtils.hideOrShow(ivlagelprobook,takepicIvlagelprobook,ivlagelprobookDelete);
                picPathList.remove("threefitepic");
                break;
            case R.id.ivlagelpersoncard_delete:
                upLoadUtils.hideOrShow(ivlagelpersoncard,takepicIvlagelpersoncard,ivlagelpersoncardDelete);
                picPathList.remove("threefitepic");
                break;
            case R.id.ivaccerditentrustbook_delete:
                upLoadUtils.hideOrShow(ivaccerditentrustbook,takepicIvaccerditentrustbook,ivaccerditentrustbook);
                picPathList.remove("threefitepic");
                break;
            case R.id.ivaccerditentrustcard_delete:
                upLoadUtils.hideOrShow(ivaccerditentrustcard,takepicIvaccerditentrustcard,ivaccerditentrustcardDelete);
                picPathList.remove("threefitepic");
                break;
            case R.id.ivthreecetifte:
                Intent intent =new Intent(GuaranteeApplyActivity.this,BigPicActivity.class);
                ByteArrayOutputStream baos=new ByteArrayOutputStream();
                photo.compress(Bitmap.CompressFormat.PNG, 100, baos);
                byte [] bitmapByte =baos.toByteArray();
                intent.putExtra("bitmap", bitmapByte);
                startActivity(intent);
            default:
                break;
        }
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }
}
package com.bibinet.finance.activity;

import android.content.Intent;
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
import com.bibinet.finance.utils.DialogUtils;
import com.bibinet.finance.utils.ToastUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by bibinet on 2017-5-3.
 */

public class GuaranteeApplyActivity extends BaseActivity implements View.OnClickListener {
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
    private DialogUtils dialogUtils;
    private TextView camera;
    private TextView picstorage;

    private static final String PHOTO_FILE_NAME = "temp_photo.jpg";
    private static final int PHOTO_REQUEST_CAMERA = 3;
    private static final int REQUESTCODE_CUTTING = 2;
    private static final int REQUESTCODE_PICK = 1;
    private static final int ACOUNT_REQUEST = 4;

    private File tempFile;
    private int TYPE = 11;
    private Bitmap photo;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guaranteeapply);
        ButterKnife.bind(this);
        initView();
//        setListener();
    }

 /*   private void setListener() {
        ivthreecetifteDelete.setOnClickListener(this);
        ivbusinesslicenseDelete.setOnClickListener(this);
    }*/

    private void initView() {
        title.setText("申请保函");
        titleImageleft.setVisibility(View.VISIBLE);
        dialogUtils = new DialogUtils();

    }

    @OnClick({R.id.title_imageleft, R.id.radiobtnisthree, R.id.radiobtnnothree,R.id.takepic_ivthreecetifte,R.id.takepic_businesslicense,R.id.takepic_ivorgancode,R.id.takepic_ivtaxrigsion,R.id.takepic_ivopenaccountlicense,R.id.takepic_ivqualificationprofile,R.id.takepic_ivbidderbook,R.id.takepic_ivlagelprobook,R.id.takepic_ivlagelpersoncard,R.id.accerditentrustbook,R.id.takepic_ivaccerditentrustcard,R.id.rela_businesslicense, R.id.rela_taxrigsion, R.id.rela_openaccountlicense, R.id.rela_qualificationprofile, R.id.rela_bidderbook, R.id.rela_accerditentrustcard})
    public void onViewClicked(View view) {

        switch (view.getId()) {
            case R.id.title_imageleft:
                finish();
                break;
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
            ToastUtils.getToastUtils().ToastMsg(GuaranteeApplyActivity.this, TYPE + "type");
            dialogUtils.diloagShow(GuaranteeApplyActivity.this, R.layout.item_selectphoto);
            View itemview = dialogUtils.getView();
            camera = (TextView) itemview.findViewById(R.id.camera);
            picstorage = (TextView) itemview.findViewById(R.id.picstorage);
            camera.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selectPicFromCamera();
                }
            });
        }
    }

    /**
     * 照相获取图片
     */
    protected void selectPicFromCamera() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        // 判断存储卡是否可以用，可用进行存储
        if (hasSdcard()) {
            intent.putExtra(MediaStore.EXTRA_OUTPUT,
                    Uri.fromFile(new File(Environment
                            .getExternalStorageDirectory(), PHOTO_FILE_NAME)));
        }
        startActivityForResult(intent, PHOTO_REQUEST_CAMERA);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (requestCode) {
            //从图库选择
            case REQUESTCODE_PICK:
                if (data == null || data.getData() == null) {
                    return;
                }
                startPhotoZoom(data.getData());
                break;
            //拍照
            case PHOTO_REQUEST_CAMERA:
                if (hasSdcard()) {
                    tempFile = new File(Environment.getExternalStorageDirectory(),
                            PHOTO_FILE_NAME);
                    startPhotoZoom(Uri.fromFile(tempFile));
                } else {
                    Toast.makeText(GuaranteeApplyActivity.this, "未找到存储卡，无法存储照片！", Toast.LENGTH_SHORT).show();
                }
                break;
            //裁剪图片
            case REQUESTCODE_CUTTING:
                if (data != null) {
                    //    setPicToView(data);
                    Bundle extras = data.getExtras();
                    if (extras != null) {
                         photo = extras.getParcelable("data");
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
                ivthreecetifte.setImageBitmap(pic);
                ivthreecetifte.setVisibility(View.VISIBLE);
                takepicIvthreecetifte.setVisibility(View.GONE);
                ivthreecetifteDelete.setVisibility(View.VISIBLE);
                ivthreecetifte.setOnClickListener(this);
                break;
            case 12:
                ivbusinesslicense.setImageBitmap(pic);
                ivbusinesslicense.setVisibility(View.VISIBLE);
                takepicbusinesslicense.setVisibility(View.GONE);
                ivbusinesslicenseDelete.setVisibility(View.VISIBLE);
                break;
            case 13:
                ivorgancode.setImageBitmap(pic);
                ivorgancode.setVisibility(View.VISIBLE);
                takepicIvorgancode.setVisibility(View.GONE);
                ivorgancodeDelete.setVisibility(View.VISIBLE);
                break;
            case 14:
                ivtaxrigsion.setImageBitmap(pic);
                ivtaxrigsion.setVisibility(View.VISIBLE);
                takepicIvtaxrigsion.setVisibility(View.GONE);
                ivtaxrigsionDelete.setVisibility(View.VISIBLE);
                break;
            case 15:
                ivopenaccountlicense.setImageBitmap(pic);
                ivopenaccountlicense.setVisibility(View.VISIBLE);
                takepicIvopenaccountlicense.setVisibility(View.GONE);
                ivopenaccountlicenseDelete.setVisibility(View.VISIBLE);
                break;
            case 16:
                ivqualificationprofile.setImageBitmap(pic);
                ivqualificationprofile.setVisibility(View.VISIBLE);
                takepicIvqualificationprofile.setVisibility(View.GONE);
                ivqualificationprofileDelete.setVisibility(View.VISIBLE);
                break;
            case 17:
                ivbusinesslicense.setImageBitmap(pic);
                ivbusinesslicense.setVisibility(View.VISIBLE);
                takepicIvorgancode.setVisibility(View.GONE);
                ivorgancodeDelete.setVisibility(View.VISIBLE);
                break;
            case 18:
                ivbusinesslicense.setImageBitmap(pic);
                ivorgancode.setVisibility(View.VISIBLE);
                takepicIvorgancode.setVisibility(View.GONE);
                ivorgancodeDelete.setVisibility(View.VISIBLE);
                break;
            case 19:
                ivbusinesslicense.setImageBitmap(pic);
                ivorgancode.setVisibility(View.VISIBLE);
                takepicIvorgancode.setVisibility(View.GONE);
                ivorgancodeDelete.setVisibility(View.VISIBLE);
                break;
            case 20:
                ivbusinesslicense.setImageBitmap(pic);
                ivorgancode.setVisibility(View.VISIBLE);
                takepicIvorgancode.setVisibility(View.GONE);
                ivorgancodeDelete.setVisibility(View.VISIBLE);
                break;

            default:
                break;
        }
    }

    // 开始裁剪相片
    public void startPhotoZoom(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        // 设置宽高比例
        intent.putExtra("crop", true);
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // 设置裁剪图片宽高
        intent.putExtra("outputX", 300);
        intent.putExtra("outputY", 300);
        // 广播刷新相册
        intent.putExtra("return-data", true);
        intent.putExtra("noFaceDetection", true);
        startActivityForResult(intent, REQUESTCODE_CUTTING);
    }


    private boolean hasSdcard() {
        if (Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            return true;
        } else {
            return false;
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ivthreecetifte_delete:
                ivthreecetifte.setVisibility(View.GONE);
                takepicIvthreecetifte.setVisibility(View.VISIBLE);
                ivthreecetifteDelete.setVisibility(View.GONE);
                break;
            case R.id.ivbusinesslicense_delete:
                ivbusinesslicense.setVisibility(View.GONE);
                takepicbusinesslicense.setVisibility(View.VISIBLE);
                ivbusinesslicenseDelete.setVisibility(View.GONE);
                break;
            case R.id.ivorgancode_delete:
                ivorgancode.setVisibility(View.GONE);
                takepicIvorgancode.setVisibility(View.VISIBLE);
                ivorgancodeDelete.setVisibility(View.GONE);
                break;
            case R.id.ivtaxrigsion_delete:
                ivtaxrigsion.setVisibility(View.GONE);
                takepicIvtaxrigsion.setVisibility(View.VISIBLE);
                ivtaxrigsionDelete.setVisibility(View.GONE);
                break;
            case R.id.ivopenaccountlicense_delete:
                ivopenaccountlicense.setVisibility(View.GONE);
                takepicIvopenaccountlicense.setVisibility(View.VISIBLE);
                ivopenaccountlicenseDelete.setVisibility(View.GONE);
                break;
            case R.id.ivqualificationprofile_delete:
                ivqualificationprofile.setVisibility(View.GONE);
                takepicIvqualificationprofile.setVisibility(View.VISIBLE);
                ivqualificationprofileDelete.setVisibility(View.GONE);
                break;

            case R.id.ivlagelprobook_delete:
                ivlagelprobook.setVisibility(View.GONE);
                takepicIvlagelprobook.setVisibility(View.VISIBLE);
                ivlagelprobookDelete.setVisibility(View.GONE);
                break;
            case R.id.ivlagelpersoncard_delete:
                ivlagelpersoncard.setVisibility(View.GONE);
                takepicIvlagelpersoncard.setVisibility(View.VISIBLE);
                ivlagelpersoncardDelete.setVisibility(View.GONE);
                break;
            case R.id.ivaccerditentrustbook_delete:
                ivaccerditentrustbook.setVisibility(View.GONE);
                takepicIvaccerditentrustbook.setVisibility(View.VISIBLE);
                ivaccerditentrustbook.setVisibility(View.GONE);
                break;
            case R.id.ivaccerditentrustcard_delete:
                ivaccerditentrustcard.setVisibility(View.GONE);
                takepicIvaccerditentrustcard.setVisibility(View.VISIBLE);
                ivaccerditentrustcardDelete.setVisibility(View.GONE);
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

    }
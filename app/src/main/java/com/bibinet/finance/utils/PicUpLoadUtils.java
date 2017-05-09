package com.bibinet.finance.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bibinet.finance.R;
import com.bibinet.finance.activity.GuaranteeApplyActivity;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by bibinet on 2017-5-8.
 */

public class PicUpLoadUtils {
    private Activity activity;

    public File tempFile;
    private int TYPE = 11;
    private static final String PHOTO_THREE_NAME = "threepic.jpg";//三证合一
    private static final String PHOTO_BUSINESS_NAME = "businesspic.jpg";//营业执照
    private static final String PHOTO_ORGANCODE_NAME = "organcodepic.jpg";//组织代码
    private static final String PHOTO_TAXRIGISON_NAME = "taxrigisonpic.jpg";//税务登记
    private static final String PHOTO_OPENACCOUNT_NAME = "openaccountpic.jpg";//开户
    private static final String PHOTO_QUALIFICATION_NAME = "qualificationpic.jpg";//资质证明
    private static final String PHOTO_BIDDER_NAME = "bidderpic.jpg";//投标书
    private static final String PHOTO_LEGALPROBOOK_NAME = "legalprobookpic.jpg";//法人证明书
    private static final String PHOTO_LEGALPERSONCARD_NAME = "legalpersonpic.jpg";//法人身份证
    private static final String PHOTO_ACEERENTRUSTBOOK_NAME = "accerentrustbookpic.jpg";//授权委托书
    private static final String PHOTO_ACEERENTRUSCARD_NAME = "accerentrustcardpic.jpg";//授权委托人身份证
    private static final int PHOTO_REQUEST_CAMERA = 3;//相机
    private static final int REQUESTCODE_CUTTING = 2;
    private static final int REQUESTCODE_PICK = 1;//图库
    private static final int ACOUNT_REQUEST = 4;

    public PicUpLoadUtils(Activity activity) {
        this.activity = activity;
    }

    /*
        * 从相册选着图片
        * */
    public void selectPicFromGallery() {
        Intent intent1 = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);// 图片的存储路径
        activity.startActivityForResult(intent1, REQUESTCODE_PICK);
    }

    /**
     * 照相获取图片
     */
    public void selectPicFromCamera() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        // 判断存储卡是否可以用，可用进行存储
        if (hasSdcard()) {
            switch (TYPE) {
                case 11:
                    File threePic = new File(Environment.getExternalStorageDirectory(), PHOTO_THREE_NAME);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(threePic));
                    tempFile=threePic;
                    break;
                case 12:
                    File businesspic = new File(Environment.getExternalStorageDirectory(), PHOTO_BUSINESS_NAME);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(businesspic));
                    tempFile=businesspic;
                    break;
                case 13:
                    File origanpic = new File(Environment.getExternalStorageDirectory(), PHOTO_ORGANCODE_NAME);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(origanpic));
                    tempFile=origanpic;
                    break;
                case 14:
                    File taxrigisonpic = new File(Environment.getExternalStorageDirectory(), PHOTO_TAXRIGISON_NAME);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(taxrigisonpic));
                    tempFile=taxrigisonpic;
                    break;
                case 15:
                    File openaccountpic = new File(Environment.getExternalStorageDirectory(), PHOTO_OPENACCOUNT_NAME);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(openaccountpic));
                    tempFile=openaccountpic;
                    break;
                case 16:
                    File qulifacitonpic = new File(Environment.getExternalStorageDirectory(), PHOTO_QUALIFICATION_NAME);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(qulifacitonpic));
                    tempFile=qulifacitonpic;
                    break;
                case 17:
                    File bidderpic = new File(Environment.getExternalStorageDirectory(), PHOTO_BIDDER_NAME);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(bidderpic));
                    tempFile=bidderpic;
                    break;
                case 18:
                    File legalprobookpic = new File(Environment.getExternalStorageDirectory(), PHOTO_LEGALPROBOOK_NAME);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(legalprobookpic));
                    tempFile=legalprobookpic;
                    break;
                case 19:
                    File accerentrustbookpic = new File(Environment.getExternalStorageDirectory(), PHOTO_ACEERENTRUSTBOOK_NAME);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(accerentrustbookpic));
                    tempFile=accerentrustbookpic;
                    break;
                case 20:
                    File accerentrustcardpic = new File(Environment.getExternalStorageDirectory(), PHOTO_ACEERENTRUSCARD_NAME);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(accerentrustcardpic));
                    tempFile=accerentrustcardpic;
                    break;
                default:
                    break;
            }
        }
        activity.startActivityForResult(intent, PHOTO_REQUEST_CAMERA);
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
        activity.startActivityForResult(intent, REQUESTCODE_CUTTING);
    }
    public boolean hasSdcard() {
        if (Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            return true;
        } else {
            return false;
        }
    }

    public void hideOrShow(ImageView picview, ImageView takepicview, ImageView deleteimage, Bitmap bitmap){
        picview.setImageBitmap(bitmap);
        picview.setVisibility(View.VISIBLE);
        takepicview.setVisibility(View.GONE);
        deleteimage.setVisibility(View.VISIBLE);

    }
    public void hideOrShow(ImageView picview, ImageView takepicview, ImageView deleteimage){
        picview.setVisibility(View.GONE);
        takepicview.setVisibility(View.VISIBLE);
        deleteimage.setVisibility(View.GONE);
    }
    public void setGlleryPicUrl(Map picPathList, String pathImage){
        switch (TYPE) {
            case 11:
                picPathList.put("threefitepic",pathImage);
                break;
            case 12:
                picPathList.put("businisslicnse",pathImage);
                break;
            case 13:
                picPathList.put("organcode",pathImage);
                break;
            case 14:
                picPathList.put("taxrigison",pathImage);
                break;
            case 15:
                picPathList.put("openaccount",pathImage);
                break;
            case 16:
                picPathList.put("qualiaficationprofile",pathImage);
                break;
            case 17:
                picPathList.put("legalprobook",pathImage);
                break;
            case 18:
                picPathList.put("legalpersoncard",pathImage);
                break;
            case 19:
                picPathList.put("accerentrustbook",pathImage);
                break;
            case 20:
                picPathList.put("accerentrustcard",pathImage);
                break;

            default:
                break;
        }
    }
    public void setSelectWay(Activity activity, final PicUpLoadUtils upLoadUtils){
        ToastUtils.getToastUtils().ToastMsg(activity, TYPE + "type");
       final DialogUtils dialogUtils=new DialogUtils();
        dialogUtils.diloagShow(activity, R.layout.item_selectphoto);
        View itemview = dialogUtils.getView();
         TextView camera = (TextView) itemview.findViewById(R.id.camera);
         TextView picstorage = (TextView) itemview.findViewById(R.id.picstorage);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upLoadUtils.selectPicFromCamera();
                dialogUtils.dialogDismiss();
            }
        });
        picstorage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upLoadUtils.selectPicFromGallery();
                dialogUtils.dialogDismiss();
            }
        });
    }
}

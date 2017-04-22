package com.bibinet.finance.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by bibinet on 2017-4-22.
 */

public class DialogUtils {
    private Context context;
    private int ResourceId;
    private DialogListioner dialogListioner;
    private View view;

    public DialogUtils(Context context, int resourceId) {
        this.context = context;
        ResourceId = resourceId;
    }
    public View getView(){
       return view;
    }
    public void diloagShow(Context context, int ResuoreceId){
        AlertDialog.Builder dialogBuider=new AlertDialog.Builder(context);
        AlertDialog dialog = dialogBuider.create();
         view= LayoutInflater.from(context).inflate(ResuoreceId,null);
        dialog.show();
        dialog.setContentView(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogListioner.onDialogClickListioner(v);
            }
        });

    }
    public void setDialoglistioner(DialogListioner listioner){
        this.dialogListioner=listioner;
    }
   public interface DialogListioner{
        void onDialogClickListioner(View view);
    }
}

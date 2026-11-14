package com.fl.saas.base.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import com.fl.saas.config.utils.DeviceUtil;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class CustomAdDialog extends Dialog {
    private Context mContext;
    private View mView;

    public CustomAdDialog(Context context, View view) {
        super(context);
        this.mContext = context;
        this.mView = view;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        int mobileWidth;
        int i;
        super.onCreate(bundle);
        requestWindowFeature(1);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        Window window = getWindow();
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setGravity(17);
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        window.setAttributes(attributes);
        if (DeviceUtil.getMobileWidth() > DeviceUtil.getMobileHeight()) {
            i = (int) (DeviceUtil.getMobileHeight() * 0.8d);
            mobileWidth = (i / 16) * 8;
        } else {
            mobileWidth = (int) (DeviceUtil.getMobileWidth() * 0.8d);
            i = (mobileWidth / 9) * 16;
        }
        RelativeLayout.LayoutParams BTvldC2 = com.bykv.vk.component.ttvideo.player.A2egSU.BTvldC(mobileWidth, i, 14, 15);
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        relativeLayout.setBackgroundColor(Color.parseColor("#00000000"));
        relativeLayout.removeAllViews();
        relativeLayout.addView(this.mView, BTvldC2);
        setContentView(relativeLayout);
    }
}

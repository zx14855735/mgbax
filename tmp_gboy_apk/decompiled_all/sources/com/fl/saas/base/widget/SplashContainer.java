package com.fl.saas.base.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.fl.saas.config.utils.DeviceUtil;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class SplashContainer extends RelativeLayout {
    private boolean isStand;
    private Context mContext;
    private String standText;

    public SplashContainer(Context context) {
        super(context);
        this.standText = "";
        this.mContext = context;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!DeviceUtil.isViewRange(motionEvent, this, "跳过")) {
            if (this.isStand && !TextUtils.isEmpty(this.standText)) {
                if (!DeviceUtil.isViewRange(motionEvent, this, this.standText)) {
                    return !DeviceUtil.isViewRange(motionEvent, this, this.standText);
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setStand(boolean z) {
        this.isStand = this.isStand;
    }

    public void setStandInfo(String str) {
        this.standText = str;
    }
}

package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.adexpress.dynamic.w.tf;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ClickSlideUpShakeView extends SlideUpView {
    private ShakeClickView xj;

    public ClickSlideUpShakeView(Context context, tf tfVar, boolean z, int i) {
        super(context);
        xj(context, tfVar, z, i);
    }

    private void xj(Context context, tf tfVar, boolean z, int i) {
        ShakeClickView shakeClickView = new ShakeClickView(context, com.bytedance.sdk.component.adexpress.w.xj.w(context), tfVar, z, i);
        this.xj = shakeClickView;
        addView(shakeClickView);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        this.xj.setLayoutParams(layoutParams);
    }

    public ShakeClickView getShakeView() {
        return this.xj;
    }

    public void setShakeText(String str) {
        if (this.xj == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.xj.setShakeText("");
        } else {
            this.xj.setShakeText(str);
        }
    }
}

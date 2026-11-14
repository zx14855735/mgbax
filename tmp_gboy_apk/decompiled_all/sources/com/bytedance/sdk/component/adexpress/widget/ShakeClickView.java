package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.w.tf;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.component.utils.pl;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ShakeClickView extends ShakeAnimationView {
    private TextView hf;

    public ShakeClickView(Context context, View view, tf tfVar, boolean z, int i) {
        super(context, view, tfVar, z, i);
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView
    public void setShakeText(String str) {
        if (this.hf == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            this.hf.setText(str);
            return;
        }
        try {
            this.hf.setText(jk.hf(this.hf.getContext(), "tt_splash_default_click_shake"));
        } catch (Exception e) {
            pl.u("shakeClickView", e.getMessage());
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView
    public void xj(Context context, View view) {
        addView(view);
        this.hf = (TextView) findViewById(2097610747);
    }
}

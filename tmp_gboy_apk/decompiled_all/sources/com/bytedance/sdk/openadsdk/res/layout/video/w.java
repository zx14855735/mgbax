package com.bytedance.sdk.openadsdk.res.layout.video;

import J3FDQU.A2egSU;
import android.R;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w extends xj {
    @Override // com.bytedance.sdk.openadsdk.res.layout.xj
    public View hf(Context context) {
        RelativeLayout xj = xj(context, 2114387616);
        xj.addView(hf(context, 159));
        xj.setVisibility(8);
        TextView AZOQYO2 = A2egSU.AZOQYO(context, 2114387742);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(3, 2114387911);
        layoutParams.addRule(14);
        layoutParams.setMargins(0, r.w(context, 13.0f), 0, 0);
        AZOQYO2.setLayoutParams(layoutParams);
        AZOQYO2.setTextColor(context.getResources().getColor(R.color.white));
        AZOQYO2.setTextSize(2, 16.0f);
        xj.addView(AZOQYO2);
        TextView AZOQYO3 = A2egSU.AZOQYO(context, 2114387807);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(3, 2114387742);
        layoutParams2.addRule(14);
        layoutParams2.setMargins(0, r.w(context, 8.0f), 0, 0);
        AZOQYO3.setLayoutParams(layoutParams2);
        AZOQYO3.setTextColor(context.getResources().getColor(R.color.white));
        AZOQYO3.setTextSize(2, 12.0f);
        AZOQYO3.setText(jk.xj(context, "tt_live_loading_text"));
        xj.addView(AZOQYO3);
        TTProgressBar tTProgressBar = new TTProgressBar(context, null, jk.f(context, "tt_Widget_ProgressBar_Horizontal"));
        tTProgressBar.setId(2114387683);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(r.w(context, 32.0f), r.w(context, 32.0f));
        layoutParams3.addRule(3, 2114387807);
        layoutParams3.addRule(14);
        layoutParams3.setMargins(0, r.w(context, 32.0f), 0, 0);
        tTProgressBar.setLayoutParams(layoutParams3);
        tTProgressBar.setIndeterminateDrawable(jk.w(context, "tt_live_video_loading_progress"));
        xj.addView(tTProgressBar);
        xj.addView(xj(context, 158, 6));
        return xj;
    }
}

package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.live.view.DoubleColorBallAnimationView;
import com.bytedance.sdk.openadsdk.core.ra.h;
import com.bytedance.sdk.openadsdk.core.ra.ws;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class d extends hf {
    LinearLayout am;
    private ImageView qt;
    private DoubleColorBallAnimationView zg;

    public d(TTBaseVideoActivity tTBaseVideoActivity, ws wsVar, boolean z) {
        super(tTBaseVideoActivity, wsVar, z);
    }

    public void hf() {
        DoubleColorBallAnimationView doubleColorBallAnimationView = this.zg;
        if (doubleColorBallAnimationView != null) {
            doubleColorBallAnimationView.hf();
            this.am.setVisibility(0);
        }
    }

    public void w() {
        DoubleColorBallAnimationView doubleColorBallAnimationView = this.zg;
        if (doubleColorBallAnimationView != null) {
            doubleColorBallAnimationView.w();
            this.am.setVisibility(8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.hf
    public void xj() {
        super.xj();
        this.qt = new ImageView(this.hf);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.qt.setAdjustViewBounds(true);
        this.qt.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.qt.setLayoutParams(layoutParams);
        this.c.addView(this.qt);
        View view = new View(this.hf);
        view.setBackgroundColor(Color.parseColor("#A6000000"));
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.c.addView(view);
        LinearLayout linearLayout = new LinearLayout(this.hf);
        this.am = linearLayout;
        linearLayout.setOrientation(1);
        TextView textView = new TextView(this.hf);
        textView.setTextColor(-1);
        textView.setTextSize(14.0f);
        textView.setText(jk.xj(this.hf, "tt_reward_live_grant"));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = 24;
        textView.setLayoutParams(layoutParams2);
        this.zg = new DoubleColorBallAnimationView(this.hf);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(r.w(this.hf, 60.0f), r.w(this.hf, 60.0f));
        layoutParams3.gravity = 17;
        this.zg.setLayoutParams(layoutParams3);
        this.am.addView(this.zg);
        this.am.addView(textView);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 17;
        this.am.setLayoutParams(layoutParams4);
        this.c.addView(this.am);
        this.am.setVisibility(8);
        String hf = h.hf(this.w);
        if (TextUtils.isEmpty(hf)) {
            return;
        }
        com.bytedance.sdk.openadsdk.f.hf.xj(hf).width(this.c.getWidth()).height(this.c.getHeight()).to(this.qt);
    }
}

package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ra.z;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;
import com.bytedance.sdk.openadsdk.widget.RatioImageView;
import com.bytedance.sdk.openadsdk.widget.TTRatingBar;
import com.bytedance.sdk.openadsdk.widget.TTRoundRectImageView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class y extends hf {
    private RatioImageView am;
    private TextView e;
    private TextView jk;
    private UpieImageView pz;
    private TTRoundRectImageView qt;
    private TTRatingBar v;
    private TextView yo;
    private TextView zg;

    public y(TTBaseVideoActivity tTBaseVideoActivity, ws wsVar, boolean z) {
        super(tTBaseVideoActivity, wsVar, z);
    }

    private void hf() {
        z uf;
        r.xj((TextView) this.hf.findViewById(2114387658), this.w);
        if (this.am != null) {
            int rx = this.w.rx();
            if (rx == 3) {
                this.am.setRatio(1.91f);
            } else if (rx != 33) {
                this.am.setRatio(0.56f);
            } else {
                this.am.setRatio(1.0f);
            }
            xj(this.am, this.pz);
        }
        if (this.qt != null && (uf = this.w.uf()) != null) {
            com.bytedance.sdk.openadsdk.f.hf.xj(uf).to(this.qt);
        }
        TextView textView = this.zg;
        if (textView != null) {
            textView.setText(am());
        }
        TextView textView2 = this.e;
        if (textView2 != null) {
            textView2.setText(qt());
        }
        w();
        u();
    }

    private void u() {
        String valueOf;
        if (this.yo == null) {
            return;
        }
        int y = this.w.vh() != null ? this.w.vh().y() : 6870;
        String xj = jk.xj(this.hf, "tt_comment_num_backup");
        if (y > 10000) {
            valueOf = (y / 10000) + "万";
        } else {
            valueOf = String.valueOf(y);
        }
        this.yo.setText(String.format(xj, valueOf));
    }

    private void w() {
        TTRatingBar tTRatingBar = this.v;
        if (tTRatingBar == null) {
            return;
        }
        tTRatingBar.setStarEmptyNum(1);
        this.v.setStarFillNum(4);
        this.v.setStarImageWidth(r.w(this.hf, 16.0f));
        this.v.setStarImageHeight(r.w(this.hf, 16.0f));
        this.v.setStarImagePadding(r.w(this.hf, 4.0f));
        this.v.xj();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.hf
    public void xj() {
        super.xj();
        this.d = (FrameLayout) this.c.findViewById(2114387642);
        this.am = (RatioImageView) this.c.findViewById(2114387766);
        this.qt = (TTRoundRectImageView) this.c.findViewById(2114387722);
        this.zg = (TextView) this.c.findViewById(2114387702);
        this.e = (TextView) this.c.findViewById(2114387934);
        this.yo = (TextView) this.c.findViewById(2114387789);
        this.jk = (TextView) this.c.findViewById(2114387962);
        this.v = (TTRatingBar) this.c.findViewById(2114387787);
        if (com.bytedance.sdk.openadsdk.kd.xj.u(this.w)) {
            UpieImageView upieImageView = new UpieImageView(this.am.getContext(), com.bytedance.sdk.openadsdk.kd.xj.d(this.w), com.bytedance.sdk.openadsdk.kd.xj.tf(this.w));
            this.pz = upieImageView;
            upieImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        }
        hf();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.hf
    public void xj(com.bytedance.sdk.openadsdk.core.hf.hf hfVar, com.bytedance.sdk.openadsdk.core.hf.hf hfVar2) {
        xj(this.jk, hfVar, hfVar);
        xj(this.am, hfVar2, hfVar2);
        xj(this.qt, hfVar2, hfVar2);
        xj(this.zg, hfVar2, hfVar2);
        xj(this.e, hfVar2, hfVar2);
        xj(this.yo, hfVar2, hfVar2);
        xj(this.v, hfVar2, hfVar2);
        xj(this.pz, hfVar2, hfVar2);
    }

    public void xj(View view, com.bytedance.sdk.openadsdk.core.hf.hf hfVar, View.OnTouchListener onTouchListener) {
        if (view == null || this.hf == null) {
            return;
        }
        view.setOnTouchListener(onTouchListener);
        view.setOnClickListener(hfVar);
    }
}

package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ra.z;
import com.bytedance.sdk.openadsdk.core.widget.pl;
import com.bytedance.sdk.openadsdk.widget.TTRatingBar;
import com.bytedance.sdk.openadsdk.widget.TTRoundRectImageView;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w extends hf {
    protected int am;
    private TextView e;
    private FrameLayout ht;
    private TTRatingBar jk;
    private FrameLayout pz;
    protected final AtomicBoolean qt;
    private TextView v;
    private TextView yo;
    private TTRoundRectImageView zg;

    public w(TTBaseVideoActivity tTBaseVideoActivity, ws wsVar, boolean z) {
        super(tTBaseVideoActivity, wsVar, z);
        this.am = 0;
        this.qt = new AtomicBoolean(false);
    }

    private void c() {
        if (this.w.wa() == 3) {
            int[] iArr = {Color.parseColor("#0070FF")};
            int w = r.w(this.hf, 17.0f);
            int parseColor = Color.parseColor("#80000000");
            pl.xj((LinearLayout) this.hf.findViewById(2114387898), new pl.xj().xj(iArr[0]).hf(parseColor).xj(iArr).w(w).u(0).kd(r.w(this.hf, 3.0f)));
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:0|1|(1:3)|4|(2:5|6)|(2:10|(7:12|13|14|15|(1:18)|19|(1:21)(4:23|(2:25|(1:(1:28)(1:(1:30))))(2:36|(2:38|(2:46|(1:(1:51)(1:(1:53))))(1:(1:43)(1:(1:45)))))|(1:34)|35)))|58|13|14|15|(1:18)|19|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0044, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0052 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String f() {
        /*
            r7 = this;
            com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity r0 = r7.hf
            java.lang.String r0 = com.bytedance.sdk.openadsdk.core.a.wo.xj(r0)
            if (r0 != 0) goto La
            java.lang.String r0 = ""
        La:
            r1 = 1
            r2 = 0
            java.util.Locale r3 = java.util.Locale.CHINESE     // Catch: java.lang.Throwable -> L33
            java.lang.String r3 = r3.getLanguage()     // Catch: java.lang.Throwable -> L33
            boolean r3 = r0.equals(r3)     // Catch: java.lang.Throwable -> L33
            if (r3 != 0) goto L35
            java.util.Locale r3 = java.util.Locale.CHINA     // Catch: java.lang.Throwable -> L33
            java.lang.String r3 = r3.getLanguage()     // Catch: java.lang.Throwable -> L33
            boolean r3 = r0.equals(r3)     // Catch: java.lang.Throwable -> L33
            if (r3 != 0) goto L35
            java.util.Locale r3 = java.util.Locale.TRADITIONAL_CHINESE     // Catch: java.lang.Throwable -> L33
            java.lang.String r3 = r3.getLanguage()     // Catch: java.lang.Throwable -> L33
            boolean r3 = r0.equals(r3)     // Catch: java.lang.Throwable -> L33
            if (r3 == 0) goto L31
            goto L35
        L31:
            r3 = 0
            goto L36
        L33:
            goto L43
        L35:
            r3 = 1
        L36:
            java.util.Locale r4 = java.util.Locale.ENGLISH     // Catch: java.lang.Throwable -> L41
            java.lang.String r4 = r4.getLanguage()     // Catch: java.lang.Throwable -> L41
            boolean r0 = r0.equals(r4)     // Catch: java.lang.Throwable -> L41
            goto L45
        L41:
            goto L44
        L43:
            r3 = 1
        L44:
            r0 = 0
        L45:
            java.lang.String r4 = "下载"
            if (r3 == 0) goto L4a
            goto L4e
        L4a:
            if (r0 == 0) goto L4e
            java.lang.String r4 = "Install"
        L4e:
            com.bytedance.sdk.openadsdk.core.ra.ws r5 = r7.w
            if (r5 != 0) goto L53
            return r4
        L53:
            java.lang.String r5 = r5.bh()
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 == 0) goto L70
            com.bytedance.sdk.openadsdk.core.ra.ws r1 = r7.w
            int r1 = r1.vw()
            r2 = 4
            if (r1 == r2) goto Lad
            if (r3 == 0) goto L6b
            java.lang.String r4 = "查看"
            goto Lad
        L6b:
            if (r0 == 0) goto Lad
            java.lang.String r4 = "View"
            goto Lad
        L70:
            com.bytedance.sdk.openadsdk.core.ra.ws r4 = r7.w
            java.lang.String r4 = r4.bh()
            if (r4 == 0) goto Lad
            boolean r5 = com.bytedance.sdk.openadsdk.core.a.wo.c(r4)
            if (r5 == 0) goto L93
            int r5 = r4.length()
            r6 = 2
            if (r5 <= r6) goto L93
            if (r3 == 0) goto L8c
            java.lang.String r4 = r7.xj(r1)
            goto Lad
        L8c:
            if (r0 == 0) goto Lad
            java.lang.String r4 = r7.xj(r2)
            goto Lad
        L93:
            boolean r5 = com.bytedance.sdk.openadsdk.core.a.wo.c(r4)
            if (r5 != 0) goto Lad
            int r5 = r4.length()
            r6 = 7
            if (r5 <= r6) goto Lad
            if (r3 == 0) goto La7
            java.lang.String r4 = r7.xj(r1)
            goto Lad
        La7:
            if (r0 == 0) goto Lad
            java.lang.String r4 = r7.xj(r2)
        Lad:
            if (r0 == 0) goto Lcc
            boolean r0 = com.bytedance.sdk.openadsdk.core.a.wo.c(r4)
            if (r0 != 0) goto Lcc
            android.widget.TextView r0 = r7.v
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r0 = (android.widget.LinearLayout.LayoutParams) r0
            com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity r1 = r7.hf
            r2 = 1082130432(0x40800000, float:4.0)
            int r1 = com.bytedance.sdk.openadsdk.core.a.r.w(r1, r2)
            r0.bottomMargin = r1
            android.widget.TextView r1 = r7.v
            r1.setLayoutParams(r0)
        Lcc:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.component.reward.layout.w.f():java.lang.String");
    }

    private void kd() {
        TextView textView = this.v;
        if (textView != null) {
            textView.setText(this.w.wa() == 3 ? f() : hf());
        }
    }

    private void u() {
        String valueOf;
        if (this.yo == null) {
            return;
        }
        int y = this.w.vh() != null ? this.w.vh().y() : 6870;
        if (y > 10000) {
            valueOf = (y / 10000) + "万";
        } else {
            valueOf = String.valueOf(y);
        }
        this.yo.setText(String.format("%1$s个评分", valueOf));
    }

    private void w() {
        if (this.zg != null) {
            z uf = this.w.uf();
            if (uf == null || TextUtils.isEmpty(uf.xj())) {
                jk.xj((Context) this.hf, "tt_ad_logo_small", (ImageView) this.zg);
            } else {
                com.bytedance.sdk.openadsdk.f.hf.xj(uf).to(this.zg);
            }
        }
        if (this.e != null) {
            if (this.u != 1 || this.w.vh() == null || TextUtils.isEmpty(this.w.vh().w())) {
                this.e.setText(this.w.kr());
            } else {
                this.e.setText(this.w.vh().w());
            }
        }
    }

    private void y() {
        if (this.u == 1) {
            TextView textView = this.e;
            if (textView != null) {
                textView.setMaxWidth(r.w(this.hf, 153.0f));
            }
        } else {
            TextView textView2 = this.e;
            if (textView2 != null) {
                textView2.setMaxWidth(r.w(this.hf, 404.0f));
            }
        }
        if (this.y) {
            return;
        }
        r.xj((View) this.f, 0);
    }

    public String hf() {
        ws wsVar = this.w;
        return wsVar == null ? "立即下载" : TextUtils.isEmpty(wsVar.bh()) ? this.w.vw() != 4 ? "查看详情" : "立即下载" : this.w.bh();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.hf
    public void xj() {
        FrameLayout frameLayout;
        super.xj();
        this.f = (RelativeLayout) this.hf.findViewById(2114387649);
        this.zg = (TTRoundRectImageView) this.hf.findViewById(2114387793);
        this.e = (TextView) this.hf.findViewById(2114387875);
        this.yo = (TextView) this.hf.findViewById(2114387630);
        this.v = (TextView) this.hf.findViewById(2114387830);
        TTRatingBar tTRatingBar = (TTRatingBar) this.hf.findViewById(2114387609);
        this.jk = tTRatingBar;
        if (tTRatingBar != null) {
            tTRatingBar.setStarEmptyNum(1);
            this.jk.setStarFillNum(4);
            this.jk.setStarImageWidth(r.w(this.hf, 15.0f));
            this.jk.setStarImageHeight(r.w(this.hf, 14.0f));
            this.jk.setStarImagePadding(r.w(this.hf, 4.0f));
            this.jk.xj();
        }
        this.tf = (TextView) this.hf.findViewById(2114387658);
        this.d = (FrameLayout) this.hf.findViewById(2114387642);
        this.pz = (FrameLayout) this.hf.findViewById(2114387964);
        this.ht = (FrameLayout) this.hf.findViewById(2114387925);
        r.xj(this.tf, this.w);
        try {
            if (this.u == 2 && this.w.wa() == 1 && (this.v.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.v.getLayoutParams();
                layoutParams.height = r.w(this.hf, 55.0f);
                layoutParams.topMargin = r.w(this.hf, 20.0f);
                this.v.setLayoutParams(layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f.getLayoutParams();
                layoutParams2.bottomMargin = r.w(this.hf, 12.0f);
                this.f.setLayoutParams(layoutParams2);
            }
        } catch (Throwable unused) {
        }
        if (this.w.wa() == 1 && (frameLayout = this.d) != null && (frameLayout.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.d.getLayoutParams();
            int u = r.u((Context) this.hf);
            layoutParams3.width = u;
            int i = (u * 9) / 16;
            layoutParams3.height = i;
            this.d.setLayoutParams(layoutParams3);
            this.am = (r.kd((Context) this.hf) - i) / 2;
        }
        w();
        u();
        kd();
        y();
        c();
        p();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.hf
    public void hf(int i) {
        int i2;
        if (this.f == null || (i2 = this.g) == -1 || i != i2 || this.qt.getAndSet(true)) {
            return;
        }
        r.xj((View) this.f, 0);
        Keyframe ofFloat = Keyframe.ofFloat(0.0f, 0.0f);
        Keyframe ofFloat2 = Keyframe.ofFloat(0.65f, 1.0f);
        Keyframe ofFloat3 = Keyframe.ofFloat(0.765f, 0.9f);
        Keyframe ofFloat4 = Keyframe.ofFloat(0.88f, 1.0f);
        Keyframe ofFloat5 = Keyframe.ofFloat(0.95f, 0.95f);
        Keyframe ofFloat6 = Keyframe.ofFloat(1.0f, 1.0f);
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f, PropertyValuesHolder.ofKeyframe("scaleX", ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat5, ofFloat6), PropertyValuesHolder.ofKeyframe("scaleY", ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat5, ofFloat6));
        ofPropertyValuesHolder.setDuration(1000L);
        ofPropertyValuesHolder.start();
    }

    private String xj(boolean z) {
        ws wsVar = this.w;
        if (wsVar == null) {
            return null;
        }
        return z ? wsVar.vw() == 4 ? "下载" : "查看" : wsVar.vw() == 4 ? "Install" : "View";
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.hf
    public void xj(com.bytedance.sdk.openadsdk.core.hf.hf hfVar, com.bytedance.sdk.openadsdk.core.hf.hf hfVar2) {
        if (this.w == null) {
            return;
        }
        r.xj((View) this.v, (View.OnClickListener) hfVar, (String) null);
        r.xj((View) this.v, (View.OnTouchListener) hfVar, (String) null);
        xj((View.OnTouchListener) hfVar2);
        xj((View.OnClickListener) hfVar2);
        if (this.w.wa() == 1) {
            FrameLayout frameLayout = this.pz;
            if (frameLayout != null) {
                r.xj((View) frameLayout, 0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.pz.getLayoutParams();
                layoutParams.height = this.am;
                this.pz.setLayoutParams(layoutParams);
            }
            FrameLayout frameLayout2 = this.ht;
            if (frameLayout2 != null) {
                r.xj((View) frameLayout2, 0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ht.getLayoutParams();
                layoutParams2.height = this.am;
                this.ht.setLayoutParams(layoutParams2);
            }
        }
    }

    private void xj(View.OnTouchListener onTouchListener) {
        r.xj(this.f, onTouchListener, "TTBaseVideoActivity#mRlDownloadBar");
        r.xj(this.e, onTouchListener, "TTBaseVideoActivity#mTvAppName");
        r.xj(this.zg, onTouchListener, "TTBaseVideoActivity#mIvIcon");
        r.xj(this.yo, onTouchListener, "TTBaseVideoActivity#mTvCommentVertical");
        r.xj(this.jk, onTouchListener, "TTBaseVideoActivity#mRbScore");
        r.xj(this.d, onTouchListener, "TTBaseVideoActivity#mVideoNativeFrame");
        r.xj(this.pz, onTouchListener, "TTBaseVideoActivity#mClickUpperNonContentArea");
        r.xj(this.ht, onTouchListener, "TTBaseVideoActivity#mClickLowerNonContentArea");
    }

    private void xj(View.OnClickListener onClickListener) {
        r.xj(this.f, onClickListener, "TTBaseVideoActivity#mRlDownloadBar");
        r.xj(this.e, onClickListener, "TTBaseVideoActivity#mTvAppName");
        r.xj(this.zg, onClickListener, "TTBaseVideoActivity#mIvIcon");
        r.xj(this.yo, onClickListener, "TTBaseVideoActivity#mTvCommentVertical");
        r.xj(this.jk, onClickListener, "TTBaseVideoActivity#mRbScore");
        r.xj(this.d, onClickListener, "TTBaseVideoActivity#mVideoNativeFrame");
        r.xj(this.pz, onClickListener, "TTBaseVideoActivity#mClickUpperNonContentArea");
        r.xj(this.ht, onClickListener, "TTBaseVideoActivity#mClickLowerNonContentArea");
    }
}

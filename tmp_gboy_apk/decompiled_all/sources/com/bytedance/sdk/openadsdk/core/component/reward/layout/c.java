package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.y.dk;
import com.bytedance.sdk.component.y.zg;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.h;
import com.bytedance.sdk.openadsdk.core.ra.wo;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ra.z;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;
import com.bytedance.sdk.openadsdk.widget.TTRoundRectImageView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class c extends hf {
    private ImageView am;
    private TextView e;
    private TTRoundRectImageView qt;
    private UpieImageView v;
    private TextView yo;
    private TextView zg;

    public c(TTBaseVideoActivity tTBaseVideoActivity, ws wsVar, boolean z) {
        super(tTBaseVideoActivity, wsVar, z);
    }

    private void hf() {
        int i = (int) (this.kd * 1000.0f);
        if (i == 666 || i == 1500 || i == 1777 || i == 562 || i == 1000) {
            return;
        }
        xj(this.u == 1 ? 0.562f : 1.777f);
    }

    private float kd() {
        return r.u(this.hf, r.d((Context) this.hf));
    }

    private void w() {
        TextView textView;
        this.am = (ImageView) this.hf.findViewById(2114387712);
        this.qt = (TTRoundRectImageView) this.hf.findViewById(2114387722);
        this.zg = (TextView) this.hf.findViewById(2114387702);
        this.e = (TextView) this.hf.findViewById(2114387962);
        this.yo = (TextView) this.hf.findViewById(2114387719);
        if (com.bytedance.sdk.openadsdk.kd.xj.u(this.w)) {
            UpieImageView upieImageView = new UpieImageView(this.am.getContext(), com.bytedance.sdk.openadsdk.kd.xj.d(this.w), com.bytedance.sdk.openadsdk.kd.xj.tf(this.w));
            this.v = upieImageView;
            upieImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        if (!TextUtils.isEmpty(this.w.bh()) && (textView = this.e) != null) {
            textView.setText(this.w.bh());
        }
        if (h.am(this.w) == null || !ws.hf(this.w)) {
            xj(this.am, this.v);
            r.xj((View) this.am, 0);
            r.xj((View) this.d, 8);
        } else {
            r.xj((View) this.am, 8);
            r.xj((View) this.d, 0);
        }
        z uf = this.w.uf();
        if (uf != null) {
            com.bytedance.sdk.openadsdk.f.hf.xj(uf).to(this.qt);
        }
        TextView textView2 = this.zg;
        if (textView2 != null) {
            textView2.setText(am());
        }
        TextView textView3 = this.yo;
        if (textView3 != null) {
            textView3.setText(qt());
        }
        r.xj((TextView) this.hf.findViewById(2114387658), this.w);
    }

    private float y() {
        return r.u(this.hf, r.tf((Context) this.hf));
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.hf
    public void u(int i) {
        r.xj((View) this.p, i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.hf
    public void xj() {
        super.xj();
        this.d = (FrameLayout) this.hf.findViewById(2114387915);
        xj(this.c);
        if (com.bytedance.sdk.openadsdk.core.video.w.xj.xj(this.w)) {
            u();
        } else {
            w();
            hf();
        }
    }

    private void u() {
        this.p = (RelativeLayout) this.hf.findViewById(2114387844);
        this.f10315pl = (TextView) this.hf.findViewById(2114387716);
        if (wo.xj(this.w)) {
            String f = wo.f(this.w);
            if (TextUtils.isEmpty(f)) {
                return;
            }
            com.bytedance.sdk.openadsdk.f.hf.xj(f).config(Bitmap.Config.ARGB_4444).type(2).to(new dk<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.c.2
                @Override // com.bytedance.sdk.component.y.dk
                public void onFailed(int i, String str, Throwable th) {
                }

                @Override // com.bytedance.sdk.component.y.dk
                public void onSuccess(zg<Bitmap> zgVar) {
                    Bitmap xj = com.bytedance.sdk.component.adexpress.u.hf.xj(c.this.hf, zgVar.getResult(), 25);
                    if (xj == null) {
                        return;
                    }
                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(c.this.hf.getResources(), xj);
                    com.bytedance.sdk.openadsdk.x.c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.c.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ViewGroup viewGroup = c.this.c;
                            if (viewGroup != null) {
                                viewGroup.setBackground(bitmapDrawable);
                            }
                        }
                    });
                }
            }, 4);
        }
    }

    private void xj(View view) {
        ws wsVar = this.w;
        if (wsVar == null || view == null) {
            return;
        }
        final float iy = wsVar.iy();
        if (iy <= 0.0f) {
            return;
        }
        view.setOutlineProvider(new ViewOutlineProvider() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.c.1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view2, Outline outline) {
                if (outline == null) {
                    return;
                }
                outline.setRoundRect(0, 0, view2.getWidth(), view2.getHeight(), r.w(pz.getContext(), iy));
            }
        });
        view.setClipToOutline(true);
    }

    private void xj(float f) {
        float min;
        float max;
        int max2;
        float kd = kd();
        float y = y();
        if (this.u == 2) {
            min = Math.max(kd, y);
            max = Math.min(kd, y);
        } else {
            min = Math.min(kd, y);
            max = Math.max(kd, y);
        }
        int eq = (int) (this.w.eq() * Math.min(min, max));
        if (this.u != 2) {
            TTBaseVideoActivity tTBaseVideoActivity = this.hf;
            max -= r.u(tTBaseVideoActivity, r.p((Context) tTBaseVideoActivity));
        }
        if (this.u != 2) {
            float f2 = eq;
            eq = (int) Math.max((max - (((min - f2) - f2) / f)) / 2.0f, 0.0f);
            max2 = eq;
        } else {
            float f3 = eq;
            max2 = (int) Math.max((min - (((max - f3) - f3) * f)) / 2.0f, 0.0f);
        }
        float f4 = eq;
        float f5 = max2;
        try {
            this.hf.getWindow().getDecorView().setPadding(r.w(this.hf, f5), r.w(this.hf, f4), r.w(this.hf, f5), r.w(this.hf, f4));
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.hf
    public void xj(com.bytedance.sdk.openadsdk.core.hf.hf hfVar, com.bytedance.sdk.openadsdk.core.hf.hf hfVar2) {
        xj(this.e, hfVar, hfVar);
        xj(this.f10315pl, hfVar, hfVar);
        xj(this.d, hfVar2, hfVar2);
        xj(this.am, hfVar2, hfVar2);
        xj(this.qt, hfVar2, hfVar2);
        xj(this.zg, hfVar2, hfVar2);
        xj(this.yo, hfVar2, hfVar2);
        xj(this.c, hfVar2, hfVar2);
        xj(this.v, hfVar2, hfVar2);
    }

    private void xj(View view, com.bytedance.sdk.openadsdk.core.hf.hf hfVar, View.OnTouchListener onTouchListener) {
        if (view == null) {
            return;
        }
        view.setOnTouchListener(onTouchListener);
        view.setOnClickListener(hfVar);
    }
}

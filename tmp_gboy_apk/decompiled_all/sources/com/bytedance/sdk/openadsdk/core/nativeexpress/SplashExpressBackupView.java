package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bykv.vk.openvk.component.video.api.u.w;
import com.bytedance.sdk.component.adexpress.widget.GifView;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.ra.h;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ra.z;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class SplashExpressBackupView extends BackupView implements w.InterfaceC0013w {
    private View am;
    private Button e;
    private NativeExpressView g;
    private NativeVideoTsView jk;
    private w.InterfaceC0013w pz;
    private GifView qt;
    private com.bytedance.sdk.openadsdk.core.et.xj.hf v;
    private FrameLayout yo;
    private TextView zg;

    public SplashExpressBackupView(Context context) {
        super(context);
        this.xj = context;
        this.kd = "splash_ad";
    }

    private void am() {
        View xj = xj(this.xj);
        if (xj == null) {
            return;
        }
        addView(xj);
    }

    private boolean c() {
        return !(this.g instanceof NativeExpressVideoView);
    }

    private void d() {
        am();
        this.qt.setVisibility(0);
        this.yo.setVisibility(8);
        ViewGroup.LayoutParams layoutParams = this.qt.getLayoutParams();
        layoutParams.height = r.w(this.xj, 291.0f);
        this.qt.setLayoutParams(layoutParams);
        xj(this.qt, this.hf, this.v);
        this.zg.setText(this.hf.uj());
        if (this.hf.mg() != null) {
            r.xj((View) this.e, 8);
        } else {
            r.xj((View) this.e, 0);
            this.e.setText(this.hf.bh());
            xj((View) this.e, true);
        }
        setExpressBackupListener(this.am);
    }

    private boolean f() {
        ws wsVar = this.hf;
        return wsVar != null && wsVar.rs() == 2;
    }

    private void g() {
        GifView gifView = new GifView(this.xj);
        gifView.setScaleType(ImageView.ScaleType.FIT_XY);
        xj(gifView, this.hf, this.v);
        addView(gifView, new ViewGroup.LayoutParams(-1, -1));
        setExpressBackupListener(this);
    }

    private void p() {
        am();
        this.qt.setVisibility(8);
        this.yo.setVisibility(0);
        if (h.am(this.hf) != null) {
            NativeVideoTsView nativeVideoTsView = (NativeVideoTsView) xj(this.g);
            this.jk = nativeVideoTsView;
            nativeVideoTsView.setVideoAdInteractionListener(this);
            if (this.jk == null) {
                return;
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.yo.addView(this.jk, layoutParams);
        }
        this.zg.setText(this.hf.uj());
        if (this.hf.mg() != null) {
            r.xj((View) this.e, 8);
        } else {
            r.xj((View) this.e, 0);
            this.e.setText(this.hf.bh());
            xj((View) this.e, true);
        }
        setExpressBackupListener(this.am);
    }

    private void pl() {
        NativeVideoTsView nativeVideoTsView = (NativeVideoTsView) xj(this.g);
        this.jk = nativeVideoTsView;
        nativeVideoTsView.setVideoAdInteractionListener(this);
        NativeVideoTsView nativeVideoTsView2 = this.jk;
        if (nativeVideoTsView2 == null) {
            return;
        }
        addView(nativeVideoTsView2);
        setExpressBackupListener(this);
    }

    private void setExpressBackupListener(View view) {
        ws wsVar = this.hf;
        if (wsVar == null || wsVar.xv() != 1) {
            return;
        }
        xj(view, true);
    }

    private void tf() {
        am();
        this.qt.setVisibility(0);
        this.yo.setVisibility(8);
        xj(this.qt, this.hf, this.v);
        this.zg.setText(this.hf.uj());
        if (this.hf.mg() != null) {
            r.xj((View) this.e, 8);
        } else {
            r.xj((View) this.e, 0);
            this.e.setText(this.hf.bh());
            xj((View) this.e, true);
        }
        setExpressBackupListener(this.am);
    }

    private void y() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.y, this.c);
        }
        layoutParams.width = this.y;
        layoutParams.height = this.c;
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
        }
        setLayoutParams(layoutParams);
        xj(this.hf.rx(), this.hf);
    }

    public com.bykv.vk.openvk.component.video.api.u.w getVideoController() {
        NativeVideoTsView nativeVideoTsView = this.jk;
        if (nativeVideoTsView == null) {
            return null;
        }
        return nativeVideoTsView.getNativeVideoController();
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w.InterfaceC0013w
    public void q_() {
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w.InterfaceC0013w
    public void r_() {
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w.InterfaceC0013w
    public void s_() {
    }

    public void setVideoAdListener(w.InterfaceC0013w interfaceC0013w) {
        this.pz = interfaceC0013w;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w.InterfaceC0013w
    public void t_() {
        w.InterfaceC0013w interfaceC0013w = this.pz;
        if (interfaceC0013w != null) {
            interfaceC0013w.t_();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u.w.InterfaceC0013w
    public void xj(long j, long j2) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    public void xj(View view, int i, com.bytedance.sdk.openadsdk.core.ra.ra raVar) {
        NativeExpressView nativeExpressView = this.g;
        if (nativeExpressView != null) {
            nativeExpressView.xj(view, i, raVar);
        }
    }

    public void xj(com.bytedance.sdk.openadsdk.core.et.xj.hf hfVar, ws wsVar, NativeExpressView nativeExpressView) {
        this.hf = wsVar;
        this.g = nativeExpressView;
        this.y = r.w(this.xj, nativeExpressView.getExpectExpressWidth());
        this.c = r.w(this.xj, this.g.getExpectExpressWidth());
        this.v = hfVar;
        y();
        this.g.addView(this, new ViewGroup.LayoutParams(-1, -1));
    }

    private void xj(int i, ws wsVar) {
        if (!c()) {
            if (i != 5) {
                pl();
                return;
            } else {
                p();
                return;
            }
        }
        if (i != 2) {
            if (i != 3) {
                if (i != 4) {
                    if (i != 5) {
                        g();
                        return;
                    }
                }
            }
            if (f()) {
                g();
                return;
            } else {
                tf();
                return;
            }
        }
        d();
    }

    private View xj(Context context) {
        if (context == null) {
            return null;
        }
        Resources resources = context.getResources();
        LinearLayout linearLayout = new LinearLayout(context);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams);
        com.bytedance.sdk.component.utils.jk.xj(context, "tt_splash_ad_backup_bg", linearLayout);
        TextView textView = new TextView(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = r.w(context, 79.0f);
        textView.setLayoutParams(layoutParams2);
        textView.setText(com.bytedance.sdk.component.utils.jk.xj(context, "tt_splash_backup_ad_title"));
        textView.setGravity(17);
        textView.setTextSize(2, 30.0f);
        textView.setTypeface(Typeface.defaultFromStyle(1));
        textView.setTextColor(Color.parseColor("#895434"));
        linearLayout.addView(textView);
        TextView textView2 = new TextView(context);
        this.zg = textView2;
        textView2.setId(2114387471);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams((int) TypedValue.applyDimension(1, 218.0f, resources.getDisplayMetrics()), -2);
        layoutParams3.topMargin = r.w(context, 31.0f);
        layoutParams3.gravity = 1;
        this.zg.setLayoutParams(layoutParams3);
        this.zg.setGravity(1);
        this.zg.setTextSize(2, 15.0f);
        this.zg.setTextColor(Color.parseColor("#895434"));
        this.zg.setSingleLine(false);
        linearLayout.addView(this.zg);
        GifView gifView = new GifView(context);
        this.qt = gifView;
        gifView.setId(2114387470);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 219.0f, resources.getDisplayMetrics()));
        layoutParams4.topMargin = r.w(context, 29.0f);
        layoutParams4.setMarginStart(r.w(context, 15.0f));
        layoutParams4.setMarginEnd(r.w(context, 15.0f));
        layoutParams4.gravity = 1;
        this.qt.setLayoutParams(layoutParams4);
        this.qt.setScaleType(ImageView.ScaleType.FIT_XY);
        linearLayout.addView(this.qt);
        FrameLayout frameLayout = new FrameLayout(context);
        this.yo = frameLayout;
        frameLayout.setId(2114387469);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 185.0f, resources.getDisplayMetrics()));
        layoutParams5.setMarginStart(r.w(context, 15.0f));
        layoutParams5.setMarginEnd(r.w(context, 15.0f));
        this.yo.setLayoutParams(layoutParams5);
        this.yo.setVisibility(8);
        linearLayout.addView(this.yo);
        Button button = new Button(context);
        this.e = button;
        button.setId(2114387468);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams((int) TypedValue.applyDimension(1, 145.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 43.0f, resources.getDisplayMetrics()));
        layoutParams6.topMargin = r.w(context, 37.0f);
        layoutParams6.gravity = 1;
        this.e.setLayoutParams(layoutParams6);
        this.e.setText(com.bytedance.sdk.component.utils.jk.xj(context, "tt_splash_backup_ad_btn"));
        this.e.setTextColor(Color.parseColor("#ffffff"));
        this.e.setTypeface(Typeface.defaultFromStyle(1));
        com.bytedance.sdk.component.utils.jk.xj(context, "tt_splash_ad_backup_btn_bg", this.e);
        linearLayout.addView(this.e);
        return linearLayout;
    }

    private void xj(GifView gifView) {
        z zVar = this.hf.lx().get(0);
        if (zVar != null) {
            com.bytedance.sdk.openadsdk.f.hf.xj(zVar).to(gifView);
        }
        if (com.bytedance.sdk.openadsdk.kd.xj.u(this.hf)) {
            UpieImageView upieImageView = new UpieImageView(gifView.getContext(), com.bytedance.sdk.openadsdk.kd.xj.d(this.hf), com.bytedance.sdk.openadsdk.kd.xj.tf(this.hf));
            upieImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            com.bytedance.sdk.openadsdk.kd.xj.xj(gifView, upieImageView);
        }
    }

    public void xj(byte[] bArr, GifView gifView) {
        if (bArr == null || gifView == null) {
            return;
        }
        gifView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        gifView.xj(bArr, false);
    }

    public void xj(Drawable drawable, GifView gifView) {
        if (drawable == null || gifView == null) {
            return;
        }
        gifView.setImageDrawable(drawable);
    }

    public void xj(GifView gifView, ws wsVar, com.bytedance.sdk.openadsdk.core.et.xj.hf hfVar) {
        Drawable xj;
        if (hfVar == null) {
            xj(gifView);
            return;
        }
        if (hfVar.kd()) {
            xj(hfVar.w(), gifView);
            return;
        }
        if (wsVar.lx() == null || wsVar.lx().get(0) == null) {
            return;
        }
        if (hfVar.xj() != null) {
            xj = new BitmapDrawable(hfVar.xj());
        } else {
            xj = com.bytedance.sdk.openadsdk.core.a.yo.xj(hfVar.w(), wsVar.lx().get(0).hf());
        }
        xj(xj, gifView);
        if (com.bytedance.sdk.openadsdk.kd.xj.u(this.hf)) {
            UpieImageView upieImageView = new UpieImageView(gifView.getContext(), com.bytedance.sdk.openadsdk.kd.xj.d(this.hf), com.bytedance.sdk.openadsdk.kd.xj.tf(this.hf));
            upieImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            com.bytedance.sdk.openadsdk.kd.xj.xj(gifView, upieImageView);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    public void xj(View view, boolean z) {
        ws wsVar = this.hf;
        if (wsVar == null || wsVar.mg() == null || this.hf.mg().xj() != 1) {
            return;
        }
        super.xj(view, z);
    }
}

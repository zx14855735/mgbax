package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.f;
import com.bytedance.sdk.openadsdk.core.ra.h;
import com.bytedance.sdk.openadsdk.core.ra.ws;

@SuppressLint({"ViewConstructor"})
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class NativeDrawVideoTsView extends NativeVideoTsView implements View.OnClickListener {
    private int hf;
    private boolean xj;

    public NativeDrawVideoTsView(Context context, ws wsVar) {
        super(context, wsVar);
        this.xj = false;
        setOnClickListener(this);
        this.hf = getResources().getConfiguration().orientation;
    }

    private void f() {
        r.xj((View) this.tf, 0);
        r.xj((View) this.p, 0);
        r.xj((View) this.g, 8);
    }

    private void pz() {
        p();
        RelativeLayout relativeLayout = this.tf;
        if (relativeLayout != null) {
            if (relativeLayout.getVisibility() == 0) {
                return;
            }
            com.bytedance.sdk.openadsdk.f.hf.xj(h.hf(this.u)).to(this.p);
            xj(this.p, h.hf(this.u));
        }
        f();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public void c() {
        this.qt = "draw_ad";
        super.c();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public void hf() {
        if (this.xj) {
            super.hf();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView = this.f10445pl;
        if (imageView != null && imageView.getVisibility() == 0) {
            r.kd(this.tf);
        }
        hf();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        int i = this.hf;
        int i2 = configuration.orientation;
        if (i == i2) {
            return;
        }
        this.hf = i2;
        r.xj(this, new r.xj() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeDrawVideoTsView.1
            @Override // com.bytedance.sdk.openadsdk.core.a.r.xj
            public void xj(View view) {
                NativeDrawVideoTsView nativeDrawVideoTsView = NativeDrawVideoTsView.this;
                if (nativeDrawVideoTsView.kd == null) {
                    return;
                }
                NativeDrawVideoTsView.this.xj(nativeDrawVideoTsView.getWidth(), NativeDrawVideoTsView.this.getHeight());
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        ImageView imageView = this.f10445pl;
        if (imageView == null || imageView.getVisibility() != 0) {
            super.onWindowFocusChanged(z);
        } else {
            pz();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView, android.view.View
    public void onWindowVisibilityChanged(int i) {
        ImageView imageView = this.f10445pl;
        if (imageView == null || imageView.getVisibility() != 0) {
            super.onWindowVisibilityChanged(i);
        } else {
            pz();
        }
    }

    public void setCanInterruptVideoPlay(boolean z) {
        this.xj = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public void u() {
        int i = getResources().getConfiguration().orientation;
        if (this.hf == i) {
            super.u();
        } else {
            this.hf = i;
            r.xj(this, new r.xj() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeDrawVideoTsView.2
                @Override // com.bytedance.sdk.openadsdk.core.a.r.xj
                public void xj(View view) {
                    NativeDrawVideoTsView nativeDrawVideoTsView = NativeDrawVideoTsView.this;
                    if (nativeDrawVideoTsView.kd == null) {
                        return;
                    }
                    NativeDrawVideoTsView.this.xj(nativeDrawVideoTsView.getWidth(), NativeDrawVideoTsView.this.getHeight());
                    NativeDrawVideoTsView.super.u();
                }
            });
        }
    }

    public void xj(Bitmap bitmap, int i) {
        f.zg().xj(bitmap);
        this.zg = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public com.bykv.vk.openvk.component.video.api.u.w xj(Context context, ViewGroup viewGroup, ws wsVar, String str, boolean z, boolean z2, boolean z3) {
        return new w(context, viewGroup, wsVar, str, z, z2, z3);
    }

    public NativeDrawVideoTsView(Context context, ws wsVar, String str, boolean z, boolean z2) {
        super(context, wsVar, str, z, z2);
        this.xj = false;
        setOnClickListener(this);
        this.hf = getResources().getConfiguration().orientation;
    }
}

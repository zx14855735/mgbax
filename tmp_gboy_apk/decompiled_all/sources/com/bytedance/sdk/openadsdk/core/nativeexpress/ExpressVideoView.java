package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.ra.h;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ExpressVideoView extends NativeVideoTsView implements View.OnClickListener {
    public ImageView hf;
    private boolean ht;
    private boolean pz;
    private boolean ra;
    protected int xj;

    public ExpressVideoView(Context context, ws wsVar, String str, boolean z) {
        super(context, wsVar, false, false, str, false, false);
        this.pz = false;
        if ("draw_ad".equals(str)) {
            this.pz = true;
        }
        this.ht = z;
        setOnClickListener(this);
        setNeedNativeVideoPlayBtnVisible(false);
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

    public boolean A_() {
        com.bykv.vk.openvk.component.video.api.u.w wVar = this.kd;
        return (wVar == null || wVar.e() == null || !this.kd.e().g()) ? false : true;
    }

    public com.bykv.vk.openvk.component.video.api.u.w getVideoController() {
        return this.kd;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public void hf() {
        if (this.pz) {
            super.hf(this.xj);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView = this.f10445pl;
        if (imageView != null && imageView.getVisibility() == 0) {
            r.kd(this.tf);
        }
        hf(this.xj);
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
        this.pz = z;
    }

    public void setPauseIcon(boolean z) {
        if (this.hf == null) {
            this.hf = new ImageView(getContext());
            if (com.bytedance.sdk.openadsdk.core.f.zg().eu() != null) {
                this.hf.setImageBitmap(com.bytedance.sdk.openadsdk.core.f.zg().eu());
            } else {
                com.bytedance.sdk.component.utils.jk.xj(com.bytedance.sdk.openadsdk.core.pz.getContext(), "tt_new_play_video", this.hf);
            }
            this.hf.setScaleType(ImageView.ScaleType.FIT_XY);
            int w = r.w(getContext(), this.zg);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(w, w);
            layoutParams.gravity = 17;
            this.y.addView(this.hf, layoutParams);
        }
        if (z) {
            this.hf.setVisibility(0);
        } else {
            this.hf.setVisibility(8);
        }
    }

    public void setShouldCheckNetChange(boolean z) {
        com.bykv.vk.openvk.component.video.api.u.w wVar = this.kd;
        if (wVar != null) {
            wVar.kd(z);
        }
    }

    public void setShowAdInteractionView(boolean z) {
        com.bykv.vk.openvk.component.video.api.u.hf yo;
        com.bykv.vk.openvk.component.video.api.u.w wVar = this.kd;
        if (wVar == null || (yo = wVar.yo()) == null) {
            return;
        }
        yo.xj(z);
    }

    public void setVideoPlayStatus(int i) {
        this.xj = i;
    }

    public void w() {
        ImageView imageView = this.g;
        if (imageView != null) {
            r.xj((View) imageView, 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public com.bykv.vk.openvk.component.video.api.u.w xj(Context context, ViewGroup viewGroup, ws wsVar, String str, boolean z, boolean z2, boolean z3) {
        return this.ht ? new com.bytedance.sdk.openadsdk.core.video.nativevideo.w(context, viewGroup, wsVar, str, z, z2, z3) : super.xj(context, viewGroup, wsVar, str, z, z2, z3);
    }

    public void y() {
        ImageView imageView = this.f10445pl;
        if (imageView != null) {
            r.xj((View) imageView, 8);
        }
    }

    public void y_() {
        ImageView imageView = this.g;
        if (imageView != null) {
            r.xj((View) imageView, 0);
        }
    }

    public void z_() {
        p();
        r.xj((View) this.tf, 0);
    }

    public void hf(boolean z) {
        this.ra = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public void xj(boolean z) {
        if (this.ra) {
            super.xj(z);
        }
    }
}

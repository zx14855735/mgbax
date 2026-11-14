package com.bytedance.sdk.openadsdk.core.ugeno.component.video;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bykv.vk.openvk.component.video.api.u.w;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.ra.h;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.u;
import com.bytedance.sdk.openadsdk.x.tf;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class NativeVideoView extends NativeVideoTsView implements w.xj {
    private xj hf;
    private boolean ht;
    private com.bytedance.adsdk.ugeno.w pz;
    private int xj;

    public NativeVideoView(Context context) {
        super(context);
        w wVar = this.kd;
        if (wVar != null) {
            wVar.xj(true);
        }
        this.jk.set(true);
        setNeedNativeVideoPlayBtnVisible(false);
        setEnableBlur(true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public void B_() {
        super.B_();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView, com.bytedance.sdk.openadsdk.core.video.nativevideo.u.xj
    public void C_() {
        r.xj((View) this.tf, 8);
        super.C_();
    }

    public void M_() {
        xj xjVar = this.hf;
        if (xjVar != null) {
            xjVar.f();
            r.xj((View) this.tf, 8);
        }
    }

    public void f() {
        xj xjVar = this.hf;
        if (xjVar != null) {
            xjVar.y();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView, com.bykv.vk.openvk.component.video.api.u.w.xj
    public void hf(long j, int i) {
        super.hf(j, i);
        r.xj((View) this.tf, 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public void kd() {
        super.kd();
        r.xj((View) this.tf, 0);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        com.bytedance.adsdk.ugeno.w wVar = this.pz;
        if (wVar == null) {
            super.onMeasure(i, i2);
        } else {
            int[] xj = wVar.xj(i, i2);
            super.onMeasure(xj[0], xj[1]);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView, android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (!this.ht && i == 8) {
            kd();
        }
    }

    public void setExtraMap(Map<String, Object> map) {
        w wVar = this.kd;
        if (wVar != null) {
            wVar.hf(map);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public void setIsAutoPlay(boolean z) {
        super.setIsAutoPlay(z);
        r.xj((View) this.tf, 0);
    }

    public void setLp(boolean z) {
        this.ht = z;
    }

    public void setPlayerType(int i) {
        this.xj = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public void u() {
        w wVar = this.kd;
        if (wVar == null) {
            B_();
        } else if ((wVar instanceof u) && !zg()) {
            ((u) this.kd).hl();
        }
        if (this.kd == null || !this.jk.get()) {
            return;
        }
        this.jk.set(false);
        c();
        if (!am()) {
            if (this.kd.jk()) {
                r.xj((View) this.tf, 0);
                return;
            }
            pl.xj("NativeVideoAdView", "attachTask.......mRlImgCover.....VISIBLE");
            p();
            r.xj((View) this.tf, 0);
            return;
        }
        r.xj((View) this.tf, 0);
        ImageView imageView = this.f10445pl;
        if (imageView != null) {
            r.xj((View) imageView, 8);
        }
        if (h.am(this.u) == null) {
            pl.u("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
            return;
        }
        com.bykv.vk.openvk.component.video.api.w.u xj = h.xj(4, this.u);
        xj.hf(this.u.ho());
        xj.hf(this.y.getWidth());
        xj.w(this.y.getHeight());
        xj.w(this.u.jf());
        this.u.dc(this.xj);
        xj.kd(this.xj);
        xj.xj(tf.xj(this.u));
        xj.xj(this.kd.p());
        xj.hf(this.kd.v());
        ((u) this.kd).kd(this.xj);
        ((u) this.kd).xj(this.u);
        xj(xj);
        this.kd.w(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public w xj(Context context, ViewGroup viewGroup, ws wsVar, String str, boolean z, boolean z2, boolean z3) {
        xj xjVar = new xj(context, viewGroup, wsVar, str, z, z2, z3);
        this.hf = xjVar;
        return xjVar;
    }

    public void xj(boolean z, boolean z2) {
        p();
        r.xj((View) this.tf, 0);
        r.xj((View) this.g, z ? 0 : 8);
        r.xj((View) this.p, z2 ? 0 : 8);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public boolean xj(long j, boolean z, boolean z2) {
        this.y.setVisibility(0);
        if (this.kd == null) {
            this.kd = new u(getContext(), this.c, this.u, this.qt, false, false);
        }
        if (pl() || this.d) {
            xj(this.w, 25, h.hf(this.u));
        }
        return false;
    }

    public void xj(com.bytedance.adsdk.ugeno.w wVar) {
        this.pz = wVar;
    }
}

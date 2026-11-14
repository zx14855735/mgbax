package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ra.z;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf {
    protected ViewGroup c;
    protected FrameLayout d;
    protected RelativeLayout f;
    protected int g = 3;
    protected final TTBaseVideoActivity hf;
    protected final float kd;
    protected RelativeLayout p;

    /* renamed from: pl, reason: collision with root package name */
    protected TextView f10315pl;
    protected TextView tf;
    protected final int u;
    protected final ws w;
    protected final String xj;
    protected final boolean y;

    public hf(TTBaseVideoActivity tTBaseVideoActivity, ws wsVar, boolean z) {
        this.hf = tTBaseVideoActivity;
        this.w = wsVar;
        this.u = wsVar.rs();
        this.kd = wsVar.yq();
        this.y = z;
        this.xj = z ? "rewarded_video" : "fullscreen_interstitial_ad";
    }

    public String am() {
        return wo.e(this.w);
    }

    public RelativeLayout g() {
        return this.f;
    }

    public void hf(int i) {
    }

    public void kd(int i) {
        r.xj((View) this.tf, i);
    }

    public void p() {
        if (this.y) {
            int nb = this.w.nb();
            this.g = nb;
            if (nb == -200) {
                com.bytedance.sdk.openadsdk.core.j.tf hf = pz.hf();
                StringBuilder sb = new StringBuilder();
                sb.append(wo.d(this.w));
                this.g = hf.pl(sb.toString());
            }
            if (this.g == -1) {
                r.xj((View) this.f, 0);
            }
        }
    }

    public FrameLayout pl() {
        return this.d;
    }

    public String qt() {
        return wo.yo(this.w);
    }

    public void tf() {
    }

    public void u(int i) {
    }

    public void w(int i) {
    }

    public void xj(DownloadListener downloadListener) {
    }

    public void y(int i) {
        r.xj((View) this.f, i);
    }

    public void zg() {
        ws wsVar = this.w;
        String nn = wsVar != null ? wsVar.nn() : null;
        if (this.tf == null || !TextUtils.isEmpty(nn)) {
            return;
        }
        jk.xj(this.hf, "tt_ad_logo_backup", this.tf);
    }

    public void w(boolean z) {
        this.hf.l().getWidgetFrameContainer().setVisibility(z ? 0 : 8);
    }

    public void xj(com.bytedance.sdk.openadsdk.core.hf.hf hfVar, com.bytedance.sdk.openadsdk.core.hf.hf hfVar2) {
    }

    public void xj() {
        ViewGroup viewGroup = (ViewGroup) this.hf.findViewById(2114387959);
        this.c = viewGroup;
        if (viewGroup != null) {
            viewGroup.setBackgroundColor(com.sigmob.sdk.base.blurkit.d.f13043a);
        }
        com.bytedance.sdk.openadsdk.core.qt.f.xj(this.c);
    }

    public void xj(ImageView imageView, UpieImageView upieImageView) {
        List<z> lx = this.w.lx();
        if (lx == null || lx.size() <= 0) {
            return;
        }
        com.bytedance.sdk.openadsdk.f.hf.xj(lx.get(0)).to(imageView);
        if (com.bytedance.sdk.openadsdk.kd.xj.u(this.w)) {
            com.bytedance.sdk.openadsdk.kd.xj.xj(imageView, upieImageView);
        }
    }
}

package com.bytedance.sdk.openadsdk.core.ugeno.d;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.openadsdk.core.am.y;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ugeno.component.hf.kd;
import com.bytedance.sdk.openadsdk.core.v;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u extends com.bytedance.sdk.openadsdk.core.ugeno.c.xj {
    private boolean dk;
    private List<com.bytedance.sdk.openadsdk.core.ugeno.component.hf.w> ht;
    private int ra;

    public u(Context context, ViewGroup viewGroup, y yVar, ws wsVar, String str, int i) {
        super(context, viewGroup, yVar, wsVar, str, i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void c() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void d() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void f() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public long getActualPlayDuration() {
        return 0L;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public int hf() {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void kd() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void p() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.c.xj
    public List<com.bytedance.sdk.openadsdk.core.ugeno.component.hf.w> pl() {
        this.ht = new ArrayList();
        JSONObject ac = this.kd.ac();
        this.ht.add(0, new com.bytedance.sdk.openadsdk.core.ugeno.component.hf.w(ac, -1221270899));
        this.ht.add(new com.bytedance.sdk.openadsdk.core.ugeno.component.hf.w(ac, -2134548432));
        return this.ht;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void setPauseFromExpressView(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void tf() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void u() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public int w() {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public long xj() {
        return 0L;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void y() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void hf(int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.c.u
    public void kd(com.bytedance.adsdk.ugeno.hf.w<View> wVar) {
        if (wVar == null) {
            return;
        }
        if (this.ra <= 0 && !this.dk && TextUtils.equals(wVar.j(), "header")) {
            u(0);
            this.dk = true;
        }
        JSONObject tf = wVar.tf();
        if (tf == null) {
            return;
        }
        com.bytedance.adsdk.ugeno.hf.w<View> u = wVar.u("video_".concat(String.valueOf(tf.optInt("image_mode"))));
        if (u instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.video.hf) {
            com.bytedance.sdk.openadsdk.core.ugeno.component.video.hf hfVar = (com.bytedance.sdk.openadsdk.core.ugeno.component.video.hf) u;
            hfVar.xj(this.g);
            hfVar.tu();
        }
    }

    public void u(int i) {
        this.ra = i;
        if (i < 0) {
            return;
        }
        final String format = String.format("浏览%d秒可领金币", Integer.valueOf(i));
        if (this.c instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.hf.y) {
            v.y().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.d.u.1
                @Override // java.lang.Runnable
                public void run() {
                    if (((com.bytedance.sdk.openadsdk.core.ugeno.c.xj) u.this).c != null) {
                        try {
                            RecyclerView recyclerView = (RecyclerView) ((com.bytedance.sdk.openadsdk.core.ugeno.component.hf.y) ((com.bytedance.sdk.openadsdk.core.ugeno.c.xj) u.this).c).xj();
                            if (recyclerView.getScrollState() != 0 || recyclerView.am()) {
                                return;
                            }
                            ((com.bytedance.sdk.openadsdk.core.ugeno.component.hf.y) ((com.bytedance.sdk.openadsdk.core.ugeno.c.xj) u.this).c).xj(0, "header");
                        } catch (Exception unused) {
                        }
                    }
                }
            });
            ((com.bytedance.sdk.openadsdk.core.ugeno.component.hf.y) this.c).xj(new kd.u() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.d.u.2
                @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.hf.kd.u
                public void xj(RecyclerView.ra raVar, int i2) {
                    com.bytedance.adsdk.ugeno.hf.w u = ((kd.C0185kd) raVar).x().u("count_down");
                    if (u instanceof com.bytedance.adsdk.ugeno.widget.text.hf) {
                        ((com.bytedance.adsdk.ugeno.widget.text.hf) u).p(format);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void w(int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void xj(float f) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.c.u
    public void y(com.bytedance.adsdk.ugeno.hf.w<View> wVar) {
        JSONObject tf;
        if (wVar == null || (tf = wVar.tf()) == null) {
            return;
        }
        com.bytedance.adsdk.ugeno.hf.w<View> u = wVar.u("video_".concat(String.valueOf(tf.optInt("image_mode"))));
        if (u instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.video.hf) {
            ((com.bytedance.sdk.openadsdk.core.ugeno.component.video.hf) u).qd();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void xj(float f, float f2, float f3, float f4, int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.c.w
    public void w(com.bytedance.adsdk.ugeno.hf.w wVar) {
        ws xj;
        if (wVar == null || (xj = com.bytedance.sdk.openadsdk.core.xj.xj(wVar.tf())) == null) {
            return;
        }
        xj(xj, wVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void xj(int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void xj(int i, String str) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.c.u
    public void xj(RecyclerView recyclerView, int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.c.u
    public void u(com.bytedance.adsdk.ugeno.hf.w<View> wVar) {
        xj(wVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.tf
    public void xj(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.c.u
    public void xj(int i, int i2) {
        if (i2 > 0) {
            this.tf.set(1);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.c.u
    public void xj(com.bytedance.adsdk.ugeno.hf.w wVar, int i, View view, com.bytedance.sdk.openadsdk.core.ugeno.component.hf.w wVar2) {
        if (wVar2 == null || wVar2.xj() == null) {
            return;
        }
        int hashCode = wVar2.xj().hashCode();
        if (this.p.get(Integer.valueOf(hashCode)) != null && this.p.containsKey(Integer.valueOf(hashCode)) && this.p.get(Integer.valueOf(hashCode)).booleanValue()) {
            return;
        }
        xj(wVar2.xj());
        this.p.put(Integer.valueOf(hashCode), Boolean.TRUE);
    }
}

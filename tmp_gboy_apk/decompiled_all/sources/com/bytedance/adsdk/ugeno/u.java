package com.bytedance.adsdk.ugeno;

import android.content.Context;
import com.bytedance.adsdk.ugeno.kd.f;
import com.bytedance.adsdk.ugeno.kd.kd;
import com.bytedance.adsdk.ugeno.kd.tf;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u {
    private static volatile u xj;
    private com.bytedance.adsdk.ugeno.w.xj.xj c;
    private List<com.bytedance.adsdk.ugeno.w.hf> hf;
    private com.bytedance.adsdk.ugeno.u.xj kd;
    private xj u;
    private com.bytedance.adsdk.ugeno.w.w w;
    private com.bytedance.adsdk.ugeno.w.hf.u y;

    private u() {
    }

    public static u xj() {
        if (xj == null) {
            synchronized (u.class) {
                try {
                    if (xj == null) {
                        xj = new u();
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    private void y() {
        ArrayList arrayList = new ArrayList();
        this.hf = arrayList;
        com.bytedance.adsdk.ugeno.w.w wVar = this.w;
        if (wVar != null) {
            arrayList.addAll(wVar.xj());
        }
        com.bytedance.adsdk.ugeno.w.u.xj(this.hf);
    }

    public xj hf() {
        return this.u;
    }

    public com.bytedance.adsdk.ugeno.w.xj.xj kd() {
        return this.c;
    }

    public com.bytedance.adsdk.ugeno.w.hf.u u() {
        return this.y;
    }

    public com.bytedance.adsdk.ugeno.u.xj w() {
        return this.kd;
    }

    public void xj(Context context, com.bytedance.adsdk.ugeno.w.w wVar, xj xjVar) {
        this.w = wVar;
        this.u = xjVar;
        y();
    }

    public void xj(com.bytedance.adsdk.ugeno.u.xj xjVar) {
        this.kd = xjVar;
    }

    public void xj(f fVar) {
        ArrayList arrayList = new ArrayList(new com.bytedance.adsdk.ugeno.kd.xj().xj());
        if (fVar != null) {
            arrayList.addAll(fVar.xj());
        }
        tf.xj(arrayList);
    }

    public void xj(com.bytedance.adsdk.ugeno.kd.w wVar) {
        ArrayList arrayList = new ArrayList(new kd().xj());
        if (wVar != null) {
            arrayList.addAll(wVar.xj());
        }
        com.bytedance.adsdk.ugeno.kd.u.xj(arrayList);
    }

    public void xj(com.bytedance.adsdk.ugeno.w.hf.u uVar) {
        this.y = uVar;
    }

    public void xj(com.bytedance.adsdk.ugeno.w.xj.xj xjVar) {
        this.c = xjVar;
    }
}

package com.bytedance.adsdk.ugeno.xj;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class y {
    private List<xj> hf;
    private com.bytedance.adsdk.ugeno.hf.w u;
    private Context w;
    private List<w> xj;

    public y(Context context, com.bytedance.adsdk.ugeno.hf.w wVar, List<w> list) {
        this.u = wVar;
        this.w = context;
        this.xj = list;
        u();
    }

    private void u() {
        this.hf = new ArrayList();
        List<w> list = this.xj;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i = 0; i < this.xj.size(); i++) {
            w wVar = this.xj.get(i);
            if (wVar != null) {
                this.hf.add(new xj(this.w, this.u, wVar));
            }
        }
    }

    public void hf() {
        List<xj> list = this.hf;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (xj xjVar : this.hf) {
            if (xjVar != null) {
                xjVar.xj();
            }
        }
    }

    public void w() {
        List<xj> list = this.hf;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (xj xjVar : this.hf) {
            if (xjVar != null) {
                xjVar.w();
            }
        }
    }

    public void xj() {
        List<xj> list = this.hf;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (xj xjVar : this.hf) {
            if (xjVar != null) {
                xjVar.u();
            }
        }
    }

    public void xj(Canvas canvas) {
        List<xj> list = this.hf;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (xj xjVar : this.hf) {
            if (xjVar != null) {
                xjVar.xj(canvas);
            }
        }
    }

    public void xj(int i, int i2) {
        List<xj> list = this.hf;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (xj xjVar : this.hf) {
            if (xjVar != null) {
                xjVar.xj(i, i2);
            }
        }
    }

    public xj xj(String str) {
        List<xj> list = this.hf;
        if (list != null && !list.isEmpty()) {
            for (xj xjVar : this.hf) {
                if (xjVar != null && TextUtils.equals(xjVar.kd(), str)) {
                    return xjVar;
                }
            }
        }
        return null;
    }
}

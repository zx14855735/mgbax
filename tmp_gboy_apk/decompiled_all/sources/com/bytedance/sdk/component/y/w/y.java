package com.bytedance.sdk.component.y.w;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bytedance.sdk.component.y.ai;
import com.bytedance.sdk.component.y.io;
import com.bytedance.sdk.component.y.j;
import com.bytedance.sdk.component.y.v;
import com.bytedance.sdk.component.y.x;
import com.bytedance.sdk.component.y.yo;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class y {
    private yo c;
    private io d;
    private ExecutorService f;
    private final v hf;
    private com.bytedance.sdk.component.y.kd y;
    private Map<String, List<w>> xj = new ConcurrentHashMap();
    private Map<String, x> w = new HashMap();
    private Map<String, ai> u = new HashMap();
    private Map<String, com.bytedance.sdk.component.y.u> kd = new HashMap();

    public y(Context context, v vVar) {
        this.hf = (v) f.xj(vVar);
        com.bytedance.sdk.component.y.w.xj.xj.xj(context, vVar.d());
    }

    private com.bytedance.sdk.component.y.kd d() {
        com.bytedance.sdk.component.y.kd u = this.hf.u();
        return u == null ? com.bytedance.sdk.component.y.hf.hf.xj() : u;
    }

    private ai kd(com.bytedance.sdk.component.y.hf hfVar) {
        ai y = this.hf.y();
        return y != null ? y : com.bytedance.sdk.component.y.w.xj.hf.kd.xj(hfVar.getRawMemoryCacheSize());
    }

    private ExecutorService p() {
        ExecutorService hf = this.hf.hf();
        return hf != null ? hf : com.bytedance.sdk.component.y.xj.w.xj();
    }

    private io pl() {
        io f = this.hf.f();
        return f == null ? new c() : f;
    }

    private yo tf() {
        yo xj = this.hf.xj();
        return xj != null ? xj : com.bytedance.sdk.component.y.xj.hf.xj();
    }

    private x u(com.bytedance.sdk.component.y.hf hfVar) {
        x kd = this.hf.kd();
        return kd != null ? com.bytedance.sdk.component.y.w.xj.hf.xj.xj(kd) : com.bytedance.sdk.component.y.w.xj.hf.xj.xj(hfVar.getMemoryCacheSize());
    }

    private com.bytedance.sdk.component.y.u y(com.bytedance.sdk.component.y.hf hfVar) {
        com.bytedance.sdk.component.y.u c = this.hf.c();
        return c != null ? c : new com.bytedance.sdk.component.y.w.xj.xj.hf(hfVar.getCacheDir(), hfVar.getFileCacheSize(), y());
    }

    public Map<String, List<w>> c() {
        return this.xj;
    }

    public io f() {
        if (this.d == null) {
            this.d = pl();
        }
        return this.d;
    }

    public Collection<ai> hf() {
        return this.u.values();
    }

    public Collection<com.bytedance.sdk.component.y.u> w() {
        return this.kd.values();
    }

    public Collection<x> xj() {
        return this.w.values();
    }

    public ai hf(com.bytedance.sdk.component.y.hf hfVar) {
        if (hfVar == null) {
            hfVar = com.bytedance.sdk.component.y.w.xj.xj.xj();
        }
        String file = hfVar.getCacheDir().toString();
        ai aiVar = this.u.get(file);
        if (aiVar != null) {
            return aiVar;
        }
        ai kd = kd(hfVar);
        this.u.put(file, kd);
        return kd;
    }

    public com.bytedance.sdk.component.y.u w(com.bytedance.sdk.component.y.hf hfVar) {
        if (hfVar == null) {
            hfVar = com.bytedance.sdk.component.y.w.xj.xj.xj();
        }
        String file = hfVar.getCacheDir().toString();
        com.bytedance.sdk.component.y.u uVar = this.kd.get(file);
        if (uVar != null) {
            return uVar;
        }
        com.bytedance.sdk.component.y.u y = y(hfVar);
        this.kd.put(file, y);
        return y;
    }

    public x xj(com.bytedance.sdk.component.y.hf hfVar) {
        if (hfVar == null) {
            hfVar = com.bytedance.sdk.component.y.w.xj.xj.xj();
        }
        String file = hfVar.getCacheDir().toString();
        x xVar = this.w.get(file);
        if (xVar != null) {
            return xVar;
        }
        x u = u(hfVar);
        this.w.put(file, u);
        return u;
    }

    public yo kd() {
        if (this.c == null) {
            this.c = tf();
        }
        return this.c;
    }

    public ExecutorService y() {
        ExecutorService xj;
        j w = this.hf.w();
        if (w != null && (xj = w.xj()) != null) {
            return xj;
        }
        if (this.f == null) {
            this.f = p();
        }
        return this.f;
    }

    public com.bytedance.sdk.component.y.kd u() {
        if (this.y == null) {
            this.y = d();
        }
        return this.y;
    }

    public com.bytedance.sdk.component.y.u xj(String str) {
        return w(com.bytedance.sdk.component.y.w.xj.xj.xj(new File(str)));
    }

    public com.bytedance.sdk.component.y.w.hf.xj xj(w wVar) {
        ImageView.ScaleType scaleType = wVar.getScaleType();
        if (scaleType == null) {
            scaleType = com.bytedance.sdk.component.y.w.hf.xj.xj;
        }
        ImageView.ScaleType scaleType2 = scaleType;
        Bitmap.Config u = wVar.u();
        if (u == null) {
            u = com.bytedance.sdk.component.y.w.hf.xj.hf;
        }
        return new com.bytedance.sdk.component.y.w.hf.xj(wVar.getWidth(), wVar.getHeight(), scaleType2, u, wVar.xj(), wVar.hf());
    }
}

package com.bytedance.msdk.w.w.xj;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.msdk.f.q;
import com.bytedance.msdk.w.w.xj.xj;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class c implements xj.InterfaceC0086xj {
    private com.bytedance.msdk.w.y.xj.hf hf;
    private int u;
    private int w;
    private List<xj> xj;

    public c(List<xj> list) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.xj = copyOnWriteArrayList;
        this.w = 0;
        this.u = 0;
        if (list != null) {
            copyOnWriteArrayList.addAll(list);
        }
    }

    public static /* synthetic */ int u(c cVar) {
        int i = cVar.w;
        cVar.w = i + 1;
        return i;
    }

    public static /* synthetic */ int y(c cVar) {
        int i = cVar.u;
        cVar.u = i + 1;
        return i;
    }

    @Override // com.bytedance.msdk.w.w.xj.xj.InterfaceC0086xj
    public void xj(com.bytedance.msdk.w.y.xj.hf hfVar) {
        if (this.hf != hfVar && hfVar != null) {
            this.hf = hfVar;
        }
        if (q.xj(this.xj)) {
            return;
        }
        com.bytedance.msdk.xj.kd.y.xj(new Runnable() { // from class: com.bytedance.msdk.w.w.xj.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.w == 0 && c.this.hf != null) {
                    c.this.hf.hf(SystemClock.elapsedRealtime());
                }
                if (c.this.xj.size() > c.this.w) {
                    ((xj) c.this.xj.get(c.u(c.this))).xj(c.this);
                }
            }
        });
    }

    @Override // com.bytedance.msdk.w.w.xj.xj.InterfaceC0086xj
    public com.bytedance.msdk.w.y.xj.hf xj() {
        return this.hf;
    }

    @Override // com.bytedance.msdk.w.w.xj.xj.InterfaceC0086xj
    public void xj(String str) {
        com.bytedance.msdk.w.y.xj.hf hfVar;
        if (!TextUtils.isEmpty(str) && (hfVar = this.hf) != null) {
            hfVar.hf(str);
        }
        com.bytedance.msdk.xj.kd.y.xj(new Runnable() { // from class: com.bytedance.msdk.w.w.xj.c.2
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.xj.size() > c.this.u) {
                    ((xj) c.this.xj.get(c.y(c.this))).hf(c.this);
                }
            }
        });
    }
}

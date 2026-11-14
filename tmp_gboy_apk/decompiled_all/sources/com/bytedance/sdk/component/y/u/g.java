package com.bytedance.sdk.component.y.u;

import com.baidu.mobads.sdk.internal.cb;
import com.bytedance.sdk.component.y.ai;
import com.bytedance.sdk.component.y.dk;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class g<T> extends xj {
    private com.bytedance.sdk.component.y.c hf;
    private byte[] u;
    private boolean w;
    private T xj;

    public g(T t, byte[] bArr, com.bytedance.sdk.component.y.c cVar, boolean z) {
        this.xj = t;
        this.hf = cVar;
        this.w = z;
        this.u = bArr;
    }

    private Map<String, String> hf() {
        com.bytedance.sdk.component.y.c cVar = this.hf;
        if (cVar != null) {
            return cVar.kd();
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.y.u.d
    public void xj(com.bytedance.sdk.component.y.w.w wVar) {
        String zg = wVar.zg();
        Map<String, List<com.bytedance.sdk.component.y.w.w>> c = wVar.pl().c();
        List<com.bytedance.sdk.component.y.w.w> list = c.get(zg);
        if (list == null) {
            hf(wVar);
            return;
        }
        synchronized (list) {
            try {
                Iterator<com.bytedance.sdk.component.y.w.w> it = list.iterator();
                while (it.hasNext()) {
                    hf(it.next());
                }
                list.clear();
                c.remove(zg);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void hf(com.bytedance.sdk.component.y.w.w wVar) {
        dk w = wVar.w();
        int kd = wVar.kd();
        if (w != null) {
            T t = this.xj;
            if (kd == 3) {
                com.bytedance.sdk.component.y.hf g = wVar.g();
                if (this.u == null && g.isRawMemoryCache()) {
                    this.u = wVar.pl().hf(g).xj((ai) wVar.getRawCacheKey());
                }
                T t2 = (T) this.u;
                if (t2 == null) {
                    t2 = this.xj;
                }
                t = (T) t2;
                if (!(t instanceof byte[])) {
                    w.onFailed(2000, "final data is not raw", new RuntimeException("final data is not raw"));
                }
            } else if (kd == 2 && (t instanceof byte[])) {
                try {
                    t = (T) wVar.pl().xj(wVar).xj((byte[]) t);
                } catch (Throwable th) {
                    w.onFailed(2000, "decode failed", th);
                    return;
                }
            }
            w.onSuccess(new com.bytedance.sdk.component.y.w.u().xj(wVar, t, hf(), this.w));
        }
    }

    @Override // com.bytedance.sdk.component.y.u.d
    public String xj() {
        return cb.o;
    }
}

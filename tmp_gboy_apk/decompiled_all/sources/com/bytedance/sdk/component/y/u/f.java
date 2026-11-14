package com.bytedance.sdk.component.y.u;

import com.bytedance.sdk.component.y.dk;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class f extends xj {
    private int hf;
    private String w;
    private Throwable xj;

    public f(int i, String str, Throwable th) {
        this.hf = i;
        this.w = str;
        this.xj = th;
    }

    private void hf(com.bytedance.sdk.component.y.w.w wVar) {
        dk w = wVar.w();
        if (w != null) {
            w.onFailed(this.hf, this.w, this.xj);
        }
    }

    @Override // com.bytedance.sdk.component.y.u.d
    public void xj(com.bytedance.sdk.component.y.w.w wVar) {
        wVar.xj(new com.bytedance.sdk.component.y.w.xj(this.hf, this.w, this.xj));
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

    @Override // com.bytedance.sdk.component.y.u.d
    public String xj() {
        return "failed";
    }
}

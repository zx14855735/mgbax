package com.bytedance.adsdk.ugeno.w;

import android.text.TextUtils;
import com.czhj.sdk.common.Constants;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class p implements c {
    private pl c;
    private v d;
    private ht f;
    private AtomicInteger hf;
    private AtomicInteger kd;
    private AtomicInteger u;
    private AtomicInteger w;
    private AtomicInteger xj;
    private float y;

    public int hf() {
        int i = (int) (this.y * this.hf.get());
        this.xj.set(i);
        return i;
    }

    public boolean w() {
        return this.xj.get() > 0;
    }

    public void xj(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if ((TextUtils.equals(str, "src") || TextUtils.equals(str, "backgroundImage")) && str2.startsWith(Constants.HTTP)) {
            this.hf.incrementAndGet();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.w.c
    public void hf(com.bytedance.adsdk.ugeno.hf.w wVar, String str) {
        int incrementAndGet = this.kd.incrementAndGet();
        if (incrementAndGet > this.hf.get() - this.xj.get()) {
            synchronized (this) {
                try {
                    if (incrementAndGet > this.hf.get() - this.xj.get() && this.d != null) {
                        pz pzVar = new pz();
                        pzVar.xj(-3);
                        pzVar.xj("image download fail");
                        pzVar.xj(wVar.hf(wVar));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public void xj(v vVar) {
        this.d = vVar;
    }

    public void xj(ht htVar) {
        this.f = htVar;
    }

    @Override // com.bytedance.adsdk.ugeno.w.c
    public void xj() {
        this.u.incrementAndGet();
        if (this.u.get() == 1) {
            synchronized (this) {
                this.u.get();
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.w.c
    public void xj(com.bytedance.adsdk.ugeno.hf.w wVar, String str) {
        if (this.w.incrementAndGet() == this.xj.get()) {
            synchronized (this) {
                try {
                    if (this.w.get() == this.xj.get()) {
                        if (this.c != null) {
                            this.hf.get();
                        }
                        if (this.d != null) {
                            pz pzVar = new pz();
                            pzVar.xj(0);
                            pzVar.xj(wVar.hf(wVar));
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}

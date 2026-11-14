package com.bytedance.sdk.component.d;

import ADYaiT.CtFAbx;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.sdk.component.d.hf.kd;
import com.bytedance.sdk.component.d.hf.w;
import com.bytedance.sdk.component.d.u.w;
import com.bytedance.sdk.component.d.w.c;
import com.bytedance.sdk.component.d.w.y;
import com.bytedance.sdk.component.hf.xj.d;
import com.bytedance.sdk.component.hf.xj.pl;
import com.bytedance.sdk.component.utils.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private y hf;
    private int w;
    private pl xj;

    /* renamed from: com.bytedance.sdk.component.d.xj$xj, reason: collision with other inner class name */
    public static final class C0109xj {
        private Bundle c;
        private com.bytedance.sdk.component.hf.xj.xj.xj.xj f;
        private Set<String> y;
        boolean u = true;
        final List<d> kd = new ArrayList();
        int xj = 10000;
        int hf = 10000;
        int w = 10000;

        public C0109xj hf(long j, TimeUnit timeUnit) {
            this.hf = xj("timeout", j, timeUnit);
            return this;
        }

        public C0109xj w(long j, TimeUnit timeUnit) {
            this.w = xj("timeout", j, timeUnit);
            return this;
        }

        public C0109xj xj(long j, TimeUnit timeUnit) {
            this.xj = xj("timeout", j, timeUnit);
            return this;
        }

        public C0109xj xj(boolean z) {
            this.u = z;
            return this;
        }

        public C0109xj xj(d dVar) {
            this.kd.add(dVar);
            return this;
        }

        public C0109xj xj(Set<String> set) {
            this.y = set;
            return this;
        }

        private static int xj(String str, long j, TimeUnit timeUnit) {
            if (j < 0) {
                throw new IllegalArgumentException(CtFAbx.AcNBzu(str, " < 0"));
            }
            if (timeUnit != null) {
                long millis = timeUnit.toMillis(j);
                if (millis > 2147483647L) {
                    throw new IllegalArgumentException(CtFAbx.AcNBzu(str, " too large."));
                }
                if (millis != 0 || j <= 0) {
                    return (int) millis;
                }
                throw new IllegalArgumentException(CtFAbx.AcNBzu(str, " too small."));
            }
            throw new NullPointerException("unit == null");
        }

        public xj xj() {
            return new xj(this);
        }
    }

    public kd hf() {
        return new kd(this.xj);
    }

    public com.bytedance.sdk.component.d.hf.xj kd() {
        return new com.bytedance.sdk.component.d.hf.xj(this.xj);
    }

    public com.bytedance.sdk.component.d.hf.hf u() {
        return new com.bytedance.sdk.component.d.hf.hf(this.xj);
    }

    public w w() {
        return new w(this.xj);
    }

    public void xj(Context context, boolean z, com.bytedance.sdk.component.d.w.hf hfVar) {
        if (context == null) {
            throw new IllegalArgumentException("tryInitAdTTNet context is null");
        }
        if (hfVar == null) {
            throw new IllegalArgumentException("tryInitAdTTNet ITTAdNetDepend is null");
        }
        int xj = hfVar.xj();
        this.w = xj;
        y yVar = this.hf;
        if (yVar != null) {
            yVar.xj(xj);
        }
        c.xj().xj(this.w).xj(z);
        c.xj().xj(this.w).xj(hfVar);
        c.xj().xj(this.w).xj(context, e.xj(context));
    }

    public pl y() {
        return this.xj;
    }

    private xj(C0109xj c0109xj) {
        pl.xj xjVar = new pl.xj();
        long j = c0109xj.xj;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        pl.xj hf = xjVar.xj(j, timeUnit).w(c0109xj.w, timeUnit).hf(c0109xj.hf, timeUnit);
        if (c0109xj.u) {
            y yVar = new y();
            this.hf = yVar;
            hf.xj(yVar);
        }
        List<d> list = c0109xj.kd;
        if (list != null && list.size() > 0) {
            Iterator<d> it = c0109xj.kd.iterator();
            while (it.hasNext()) {
                hf.xj(it.next());
            }
        }
        if (c0109xj.c != null) {
            hf.xj(c0109xj.c);
        }
        hf.xj(c0109xj.y);
        if (c0109xj.f == null) {
            hf.xj(new com.bytedance.sdk.component.hf.xj.xj.xj.hf());
        } else {
            hf.xj(c0109xj.f);
        }
        this.xj = hf.xj();
    }

    public void xj(Context context, boolean z) {
        com.bytedance.sdk.component.d.w.xj.hf(true);
        if (xj(context) || (!e.xj(context) && z)) {
            c.xj().xj(this.w, context).u();
            c.xj().xj(this.w, context).xj();
        }
        if (e.xj(context)) {
            c.xj().xj(this.w, context).u();
            c.xj().xj(this.w, context).xj();
        }
    }

    public static void xj() {
        com.bytedance.sdk.component.d.u.w.xj(w.xj.DEBUG);
    }

    private static boolean xj(Context context) {
        String hf = e.hf(context);
        if (hf != null) {
            return hf.endsWith(":push") || hf.endsWith(":pushservice");
        }
        return false;
    }
}

package com.bytedance.sdk.openadsdk.core.pl.w.w;

import android.content.Context;
import com.bytedance.sdk.component.utils.am;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.openadsdk.core.f;
import com.bytedance.sdk.openadsdk.core.ra.jk;
import com.bytedance.sdk.openadsdk.core.ra.ws;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class xj {
    protected ws hf;
    protected boolean u = true;
    protected int w;
    protected Context xj;

    public int hf() {
        return this.w;
    }

    public boolean u() {
        int w = am.w(this.xj);
        ws wsVar = this.hf;
        if (wsVar == null) {
            return false;
        }
        int qt = jk.qt(wsVar);
        if (qt == -1) {
            return !f.zg().w(w);
        }
        if (qt != 0) {
            if (qt != 2) {
                if (qt == 3) {
                    return true;
                }
                if (!f.zg().w(w)) {
                    com.bytedance.sdk.openadsdk.core.ra.kd vh = this.hf.vh();
                    if (((vh == null || vh.c() <= 0) ? 104857600 : vh.c()) > jk.zg(this.hf)) {
                        return true;
                    }
                }
                return false;
            }
            if (w != 4) {
                return true;
            }
        }
        return false;
    }

    public abstract boolean w();

    public void xj(Context context) {
        this.xj = context;
    }

    public void xj(ws wsVar) {
        this.hf = wsVar;
    }

    public void xj(boolean z) {
        this.u = z;
    }

    public boolean xj() {
        Context context;
        if (this.hf == null || (context = this.xj) == null) {
            return true;
        }
        if (!this.u) {
            return false;
        }
        if (am.w(context) == 0) {
            try {
                Context context2 = this.xj;
                x.xj(context2, com.bytedance.sdk.component.utils.jk.xj(context2, "tt_no_network"), 0);
            } catch (Throwable unused) {
            }
        }
        boolean w = w();
        if (w) {
            y.xj = true;
            y.w = true;
        }
        return w;
    }
}

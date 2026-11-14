package com.bytedance.sdk.gromore.init;

import IzHBwY.ASJ6gh;
import IzHBwY.AYUAbz;
import J3FDQU.A2egSU;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.pangle.annotations.ForbidWrapParam;
import com.bytedance.sdk.openadsdk.core.AdSdkInitializerHolder;
import com.bytedance.sdk.openadsdk.core.a.j;
import com.bytedance.sdk.openadsdk.core.ai;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class p implements Function<SparseArray<Object>, Object> {
    private com.bytedance.sdk.openadsdk.core.wo.w hf;
    private Bundle kd;
    private w u;
    private final com.bytedance.sdk.openadsdk.core.w w;
    private com.bytedance.sdk.gromore.xj.hf.xj xj;

    public p(Bundle bundle, com.bytedance.sdk.openadsdk.core.w wVar) {
        this.w = wVar;
        this.kd = bundle;
        kd.xj();
        Bundle bundle2 = this.kd;
        if (bundle2 != null) {
            kd.xj = bundle2.getLong("call_init_time");
        }
    }

    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        Object apply;
        if (sparseArray == null) {
            return null;
        }
        ASJ6gh ADYaiT2 = A2egSU.ADYaiT(sparseArray);
        switch (ADYaiT2.intValue(-99999987, 0)) {
            case -999002:
                return Boolean.valueOf(xj());
            case -999001:
                com.bytedance.sdk.gromore.xj.hf.xj xj = com.bytedance.sdk.gromore.xj.hf.xj.xj(ADYaiT2);
                this.xj = xj;
                if (xj.u()) {
                    com.bytedance.msdk.xj.kd.w.xj();
                    com.bytedance.sdk.component.d.xj.xj();
                }
                if (this.xj.pl() && !AdSdkInitializerHolder.isSdkInitSuccess()) {
                    j.xj();
                }
                xj(ADYaiT2);
                Context context = (Context) ADYaiT2.objectValue(-998000, Context.class);
                pz.xj(context);
                boolean zm = pz.hf().zm();
                if (!this.xj.xj() && !zm) {
                    kd.hf = SystemClock.elapsedRealtime();
                    this.w.apply(sparseArray);
                    break;
                } else {
                    com.bytedance.msdk.core.p.xj.xj().hf();
                    com.bytedance.msdk.core.p.xj.xj().xj(zm);
                    xj(context, ADYaiT2);
                    break;
                }
            case -999000:
                if (this.w != null) {
                    com.bytedance.msdk.xj.kd.w.hf("TMe", "getManager mediation");
                    q hf = this.w.hf();
                    if (hf != null) {
                        return new tf(hf);
                    }
                }
                break;
        }
        apply = AYUAbz.f4118ADYaiT.apply(sparseArray);
        return apply;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(Context context, com.bytedance.sdk.gromore.xj.hf.xj xjVar, com.bytedance.sdk.openadsdk.core.wo.w wVar, long j) {
        kd.u = SystemClock.elapsedRealtime();
        w wVar2 = new w();
        this.u = wVar2;
        wVar2.xj(context, xjVar, wVar, j, this.w);
    }

    private void xj(final Context context, final PluginValueSet pluginValueSet) {
        com.bytedance.sdk.openadsdk.core.wo.w wVar = new com.bytedance.sdk.openadsdk.core.wo.w(this.xj.w());
        this.hf = wVar;
        wVar.xj(new com.bytedance.sdk.openadsdk.core.wo.hf() { // from class: com.bytedance.sdk.gromore.init.p.1
            /* JADX WARN: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
            @Override // com.bytedance.sdk.openadsdk.core.wo.hf
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void xj(boolean r9) {
                /*
                    r8 = this;
                    r0 = 0
                    com.bykv.vk.openvk.api.proto.PluginValueSet r2 = r2     // Catch: java.lang.Exception -> L1e
                    long r3 = android.os.SystemClock.elapsedRealtime()     // Catch: java.lang.Exception -> L1e
                    r5 = 1
                    long r2 = r2.longValue(r5, r3)     // Catch: java.lang.Exception -> L1e
                    int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                    if (r4 == 0) goto L1c
                    long r0 = android.os.SystemClock.elapsedRealtime()     // Catch: java.lang.Exception -> L19
                    long r0 = r0 - r2
                    com.bytedance.sdk.gromore.init.kd.y = r0     // Catch: java.lang.Exception -> L19
                    goto L1c
                L19:
                    r0 = r2
                    goto L1f
                L1c:
                    r6 = r2
                    goto L20
                L1e:
                L1f:
                    r6 = r0
                L20:
                    if (r9 == 0) goto L39
                    long r0 = android.os.SystemClock.elapsedRealtime()
                    com.bytedance.sdk.gromore.init.kd.w = r0
                    com.bytedance.sdk.gromore.init.p r2 = com.bytedance.sdk.gromore.init.p.this
                    android.content.Context r3 = r3
                    com.bytedance.sdk.gromore.xj.hf.xj r4 = com.bytedance.sdk.gromore.init.p.xj(r2)
                    com.bytedance.sdk.gromore.init.p r9 = com.bytedance.sdk.gromore.init.p.this
                    com.bytedance.sdk.openadsdk.core.wo.w r5 = com.bytedance.sdk.gromore.init.p.hf(r9)
                    com.bytedance.sdk.gromore.init.p.xj(r2, r3, r4, r5, r6)
                L39:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.gromore.init.p.AnonymousClass1.xj(boolean):void");
            }
        });
        if (this.w != null) {
            kd.hf = SystemClock.elapsedRealtime();
            this.w.xj(context, pluginValueSet, this.hf);
        } else {
            this.hf.xj(0, com.bytedance.sdk.openadsdk.zg.kd.xj().xj(false).xj(MediationConstant.ErrorCode.ADN_INIT_FAIL).xj("init error Initializer is null").hf());
        }
    }

    public boolean xj() {
        com.bytedance.sdk.gromore.xj.hf.xj xjVar = this.xj;
        if (xjVar != null && xjVar.xj()) {
            com.bytedance.sdk.openadsdk.core.w wVar = this.w;
            return wVar != null && this.u != null && wVar.xj() && this.u.xj();
        }
        com.bytedance.sdk.openadsdk.core.w wVar2 = this.w;
        if (wVar2 != null) {
            return wVar2.xj();
        }
        return false;
    }

    private void xj(@ForbidWrapParam PluginValueSet pluginValueSet) {
        try {
            Boolean bool = (Boolean) pluginValueSet.objectValue(14, Boolean.class);
            if (bool != null) {
                ai.hf = bool.booleanValue();
            }
        } catch (Exception unused) {
        }
    }
}

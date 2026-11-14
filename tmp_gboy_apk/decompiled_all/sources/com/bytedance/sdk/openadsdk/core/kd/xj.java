package com.bytedance.sdk.openadsdk.core.kd;

import com.bytedance.sdk.openadsdk.core.ra.tj;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.jk.xj.hf.xj.y;
import com.bytedance.sdk.openadsdk.zg.w.hf.am;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class xj<T, V> {
    com.bytedance.sdk.openadsdk.core.kd.kd.u xj = new com.bytedance.sdk.openadsdk.core.kd.kd.u(xj());

    public abstract int xj();

    public tj xj(boolean z, boolean z2, long j) {
        tj tjVar = new tj();
        tjVar.f = j;
        if (z) {
            tjVar.xj = 2;
        }
        if (z2) {
            tjVar.y = 2;
        }
        return tjVar;
    }

    public abstract void xj(T t, int i, String str);

    public abstract void xj(T t, V v);

    public void xj(final com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, final T t, long j) {
        com.bytedance.sdk.openadsdk.core.kd.kd.u uVar = this.xj;
        if (uVar != null) {
            uVar.xj(hfVar, xj(false, false, j), -1, new com.bytedance.sdk.openadsdk.core.kd.kd.kd<V>() { // from class: com.bytedance.sdk.openadsdk.core.kd.xj.1
                @Override // com.bytedance.sdk.openadsdk.core.kd.kd.kd
                public void hf(V v) {
                    hfVar.u();
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.bytedance.sdk.openadsdk.core.kd.kd.kd
                public void xj(V v) {
                    hfVar.u();
                    xj.this.xj((xj) t, (Object) v);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.bytedance.sdk.openadsdk.core.kd.kd.kd
                public void xj(int i, String str) {
                    hfVar.u();
                    xj.this.xj((xj) t, i, str);
                }
            });
        }
    }

    public void xj(final com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, final y yVar, long j) {
        com.bytedance.sdk.openadsdk.core.kd.kd.u uVar = this.xj;
        if (uVar != null) {
            uVar.xj(hfVar, xj(false, true, j), -1, new com.bytedance.sdk.openadsdk.core.kd.kd.kd<List<am>>() { // from class: com.bytedance.sdk.openadsdk.core.kd.xj.2
                @Override // com.bytedance.sdk.openadsdk.core.kd.kd.kd
                public void hf(List<am> list) {
                    hfVar.u();
                }

                @Override // com.bytedance.sdk.openadsdk.core.kd.kd.kd
                public void xj(List<am> list) {
                    hfVar.u();
                    y yVar2 = yVar;
                    if (yVar2 != null) {
                        yVar2.xj(list);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.kd.kd.kd
                public void xj(int i, String str) {
                    hfVar.u();
                    y yVar2 = yVar;
                    if (yVar2 != null) {
                        yVar2.xj(i, str);
                    }
                }
            });
        }
    }

    public static xj xj(int i) {
        if (i == 1) {
            return com.bytedance.sdk.openadsdk.core.component.xj.xj.hf();
        }
        if (i == 9) {
            return com.bytedance.sdk.openadsdk.core.component.hf.xj.hf();
        }
        if (i == 5) {
            return com.bytedance.sdk.openadsdk.core.component.w.xj.hf();
        }
        if (i != 6) {
            return null;
        }
        return com.bytedance.sdk.openadsdk.core.component.u.xj.hf();
    }

    public void xj(ws wsVar) {
        com.bytedance.sdk.openadsdk.core.kd.kd.u uVar = this.xj;
        if (uVar != null) {
            uVar.xj().xj(wsVar);
        }
    }

    public static void xj(int i, ws wsVar) {
        xj xj = xj(i);
        if (xj != null) {
            xj.xj(wsVar);
        }
    }
}

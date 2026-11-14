package com.bytedance.sdk.openadsdk.core.kd.w;

import android.text.TextUtils;
import com.bytedance.sdk.component.tf.d;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.ra.f;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.x.c;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u implements com.bytedance.sdk.openadsdk.core.kd.w.xj {
    static ReferenceQueue<Object> hf = new ReferenceQueue<>();
    private final int w;
    Map<Object, xj> xj = new ConcurrentHashMap();

    public static class xj {
        String hf;
        String xj;

        public xj(String str, String str2) {
            this.xj = str;
            this.hf = str2;
        }
    }

    static {
        tpafaBk();
    }

    public u(int i) {
        this.w = i;
    }

    private static /* synthetic */ void tpafaBk() {
        char[] charArray = "\u001c\u0010\u0012Q\u0018\u001e\u0012\u001aQ\u001d\u0010\u0006Q\f\u0017\u001a\u0013\u0013Q5\u0011\u0016=\r\u0016\u001b\u0018\u001a".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 127);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u001c\u0013\u0016\u0011\u0016\u000b".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 127);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.w.xj
    public void hf(final com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, final List<ws> list) {
        if (TextUtils.isEmpty(hfVar.pz())) {
            c.u(new d("PreloadStrategyRecovery-onNetworkResponse") { // from class: com.bytedance.sdk.openadsdk.core.kd.w.u.3
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    for (ws wsVar : list) {
                        if (wsVar.o() <= 0) {
                            wsVar.kd((10500000 + currentTimeMillis) / 1000);
                        }
                        com.bytedance.sdk.openadsdk.core.kd.u.kd.xj(u.this.w).xj(hfVar.u(), wsVar.qa(), false);
                        int unused = u.this.w;
                        hfVar.u();
                        System.currentTimeMillis();
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.w.xj
    public boolean xj(String str) {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.w.xj
    public void hf(String str) {
        System.currentTimeMillis();
        for (Reference<? extends Object> poll = hf.poll(); poll != null; poll = hf.poll()) {
            xj xjVar = this.xj.get(poll);
            if (xjVar != null) {
                com.bytedance.sdk.openadsdk.core.kd.u.kd.xj(this.w).xj(xjVar.xj, xjVar.hf, false);
            }
        }
        com.bytedance.sdk.openadsdk.core.kd.u.kd.xj(this.w).hf(str);
        System.currentTimeMillis();
        com.bytedance.sdk.openadsdk.core.kd.u.kd.xj(this.w).w(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.w.xj
    public void xj(final com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, final ws wsVar) {
        if (TextUtils.isEmpty(hfVar.pz())) {
            if (wsVar.o() <= 0) {
                wsVar.kd((System.currentTimeMillis() + 10500000) / 1000);
            }
            c.u(new d("PreloadStrategyRecovery-onNetworkResponse") { // from class: com.bytedance.sdk.openadsdk.core.kd.w.u.1
                @Override // java.lang.Runnable
                public void run() {
                    System.currentTimeMillis();
                    com.bytedance.sdk.openadsdk.core.kd.u.kd.xj(u.this.w).xj(hfVar, wsVar, false);
                    int unused = u.this.w;
                    hfVar.u();
                    System.currentTimeMillis();
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.w.xj
    public void xj(final com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, final List<ws> list) {
        if (TextUtils.isEmpty(hfVar.pz())) {
            f.hf xj2 = f.xj(this.w);
            if (((xj2 != null ? xj2.d() : 0) & 1) == 1) {
                c.u(new d("PreloadStrategyRecovery-onNetworkResponse") { // from class: com.bytedance.sdk.openadsdk.core.kd.w.u.2
                    @Override // java.lang.Runnable
                    public void run() {
                        long currentTimeMillis = System.currentTimeMillis();
                        for (ws wsVar : list) {
                            if (wsVar.o() <= 0) {
                                wsVar.kd((10500000 + currentTimeMillis) / 1000);
                            }
                            com.bytedance.sdk.openadsdk.core.kd.u.kd.xj(u.this.w).xj(hfVar, wsVar, false);
                            int unused = u.this.w;
                            hfVar.u();
                            System.currentTimeMillis();
                        }
                    }
                });
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.w.xj
    public ws xj(String str, long j) {
        f.hf xj2 = f.xj(this.w);
        System.currentTimeMillis();
        ws xj3 = com.bytedance.sdk.openadsdk.core.kd.u.kd.xj(this.w).xj(str, true, j);
        if (xj3 != null && xj2 != null) {
            try {
                if (xj2.xj(xj3) || xj2.xj("delete_on_load", null, xj3)) {
                    com.bytedance.sdk.openadsdk.core.kd.u.kd.xj(this.w).xj(str, xj3.qa());
                }
            } catch (Exception unused) {
                pl.hf("PreloadStrategyRecovery", "deleteCacheMeta error");
            }
        }
        System.currentTimeMillis();
        return xj3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.w.xj
    public List<ws> xj(String str, long j, int i) {
        f.hf xj2 = f.xj(this.w);
        System.currentTimeMillis();
        List<ws> xj3 = com.bytedance.sdk.openadsdk.core.kd.u.kd.xj(this.w).xj(str, true, j, i);
        for (ws wsVar : xj3) {
            if (wsVar != null && xj2 != null) {
                try {
                    if (xj2.xj(wsVar) || xj2.xj("delete_on_load", null, wsVar)) {
                        com.bytedance.sdk.openadsdk.core.kd.u.kd.xj(this.w).xj(str, wsVar.qa());
                    }
                } catch (Exception unused) {
                    pl.hf("PreloadStrategyRecovery", "deleteCacheMeta error");
                }
            }
        }
        xj3.size();
        System.currentTimeMillis();
        return xj3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.w.xj
    public void xj(final com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, final ws wsVar, final Object obj, final boolean z) {
        final String u = hfVar.u();
        c.u(new d("PreloadStrategyRecovery-onLoad") { // from class: com.bytedance.sdk.openadsdk.core.kd.w.u.4
            @Override // java.lang.Runnable
            public void run() {
                f.hf xj2 = f.xj(u.this.w);
                if (xj2 != null) {
                    try {
                        if (xj2.xj(wsVar)) {
                            return;
                        }
                        if (xj2.xj("disable_trans_cache", null, wsVar)) {
                            return;
                        }
                    } catch (Exception unused) {
                        pl.hf("PreloadStrategyRecovery", "isDisableSdkBidding error");
                    }
                }
                System.currentTimeMillis();
                if (wsVar.nu() != 0) {
                    u.this.xj.put(new PhantomReference(obj, u.hf), new xj(u, wsVar.qa()));
                }
                if (z) {
                    return;
                }
                if (((xj2 != null ? xj2.d() : 0) & 2) == 2) {
                    com.bytedance.sdk.openadsdk.core.kd.u.kd.xj(u.this.w).xj(hfVar, wsVar, true);
                    System.currentTimeMillis();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.w.xj
    public void xj(final ws wsVar) {
        final int d = wo.d(wsVar);
        c.u(new d("PreloadStrategyRecovery-onShow") { // from class: com.bytedance.sdk.openadsdk.core.kd.w.u.5
            @Override // java.lang.Runnable
            public void run() {
                System.currentTimeMillis();
                com.bytedance.sdk.openadsdk.core.kd.u.kd xj2 = com.bytedance.sdk.openadsdk.core.kd.u.kd.xj(u.this.w);
                StringBuilder sb = new StringBuilder();
                sb.append(d);
                xj2.xj(sb.toString(), wsVar.qa());
                System.currentTimeMillis();
            }
        });
        f.hf xj2 = f.xj(this.w);
        if (xj2 != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(d);
            com.bytedance.sdk.openadsdk.core.kd.kd.xj(sb.toString(), xj2.tf()).hf(xj2.tf());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.w.xj
    public void xj(String str, ws wsVar) {
        com.bytedance.sdk.openadsdk.core.kd.u.kd.xj(this.w).xj(str, wsVar.qa());
    }
}

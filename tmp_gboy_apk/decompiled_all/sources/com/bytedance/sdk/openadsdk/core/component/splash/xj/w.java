package com.bytedance.sdk.openadsdk.core.component.splash.xj;

import ADYaiT.CtFAbx;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.component.splash.w.xj.c;
import com.bytedance.sdk.openadsdk.core.component.splash.w.xj.d;
import com.bytedance.sdk.openadsdk.core.kd.u.y;
import com.bytedance.sdk.openadsdk.core.ra.f;
import com.bytedance.sdk.openadsdk.core.ra.qd;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w extends xj {
    private volatile y p;
    static ConcurrentHashMap<String, hf> c = new ConcurrentHashMap<>();
    static ConcurrentHashMap<String, List<String>> f = new ConcurrentHashMap<>();
    static ReferenceQueue<Object> d = new ReferenceQueue<>();
    static Map<Object, hf> tf = new ConcurrentHashMap();

    static {
        poKOR();
    }

    private String hf(String str, String str2) {
        return CtFAbx.AcNBzu(str, str2);
    }

    private void kd() {
        if (y() != 3) {
            return;
        }
        try {
            for (Reference<? extends Object> poll = d.poll(); poll != null; poll = d.poll()) {
                hf hfVar = tf.get(poll);
                if (hfVar != null) {
                    xj(hfVar.w, hfVar.xj);
                }
                tf.remove(poll);
            }
        } catch (Exception unused) {
        }
    }

    private static /* synthetic */ void poKOR() {
        char[] charArray = "\u0087\u008b\u0089Ê\u0083\u0085\u0089\u0081Ê\u0086\u008b\u009dÊ\u0097\u008c\u0081\u0088\u0088Ê®\u008a\u008d¦\u0096\u008d\u0080\u0083\u0081".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 228);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0087\u0088\u008d\u008a\u008d\u0090".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 228);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private void u() {
        long currentTimeMillis = System.currentTimeMillis();
        this.p = new y(3);
        com.bytedance.sdk.openadsdk.core.c.xj.xj("lqmt", "NewCache 初始化耗时: " + (System.currentTimeMillis() - currentTimeMillis));
    }

    private static int y() {
        if (f.xj() == null) {
            return 1;
        }
        return f.xj().u();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.xj.xj
    public void w() {
        if (this.p == null) {
            hf();
        }
        if (this.p != null) {
            this.p.xj();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.xj.xj
    public void xj(final qd qdVar, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, boolean z) {
        if (hfVar == null || qdVar == null || qdVar.xj() == null) {
            return;
        }
        if (this.p == null) {
            hf();
        }
        try {
            final String u = hfVar.u();
            com.bytedance.sdk.openadsdk.core.c.xj.xj("lqmt", "saveCache start >>  rit: " + u + "  isUsing: " + z);
            final ws xj = qdVar.xj();
            String zf = xj.zf();
            String hf = hf(u, zf);
            if (c.contains(hf)) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.c.xj.xj("lqmt", "save-updateMemoryRecord start >>  rit: " + u + "  reqId: " + zf);
            xj(hf, u, zf, z ? 2 : 1);
            xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.xj.w.1
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    w.this.p.xj(u, new y.hf(com.bytedance.sdk.component.utils.xj.hf(qdVar.hf().w().toString()), xj.nu(), 1000 * xj.o(), xj.zf()), false, wo.qt(xj));
                    com.bytedance.sdk.openadsdk.core.c.xj.xj("lqmt", "saveMeta >>  rit: " + u + " saveDb cost: " + (System.currentTimeMillis() - currentTimeMillis));
                }
            });
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.xj.xj
    public void hf() {
        if (this.p == null) {
            synchronized (this) {
                try {
                    if (this.p == null) {
                        u();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    @Override // com.bytedance.sdk.openadsdk.core.component.splash.xj.xj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void xj(com.bytedance.sdk.openadsdk.core.component.splash.w.xj.c r10, final java.lang.String r11, com.bytedance.sdk.openadsdk.core.component.splash.xj.xj.InterfaceC0156xj r12, com.bytedance.sdk.openadsdk.core.component.splash.xj.kd r13) {
        /*
            Method dump skipped, instructions count: 332
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.component.splash.xj.w.xj(com.bytedance.sdk.openadsdk.core.component.splash.w.xj.c, java.lang.String, com.bytedance.sdk.openadsdk.core.component.splash.xj.xj$xj, com.bytedance.sdk.openadsdk.core.component.splash.xj.kd):void");
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.xj.xj
    public void xj(com.bytedance.sdk.openadsdk.core.component.splash.w.w.u<d, c> uVar, final ws wsVar, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, boolean z) {
        final String u;
        String zf;
        String hf;
        if (wsVar == null || hfVar == null) {
            return;
        }
        if (this.p == null) {
            hf();
        }
        try {
            com.bytedance.sdk.openadsdk.core.c.xj.xj("lqmt", "removeCache>> start ");
            u = hfVar.u();
            zf = wsVar.zf();
            hf = hf(u, zf);
        } catch (Throwable unused) {
        }
        if (this.kd.get()) {
            com.bytedance.sdk.openadsdk.core.c.xj.xj("lqmt", "removeCache-mIsRemoveCacheAd: true");
            return;
        }
        this.kd.set(true);
        xj(hf, u, zf, 3);
        com.bytedance.sdk.openadsdk.core.c.xj.xj("lqmt", "removeCache-updateMemoryRecord: 完成");
        xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.xj.w.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    w.this.p.xj(u, wsVar.zf());
                    com.bytedance.sdk.openadsdk.core.c.xj.xj("lqmt", "removeCache-deleteCacheMeta  rit: " + u + "  cost: " + (System.currentTimeMillis() - currentTimeMillis));
                } catch (Throwable unused2) {
                }
            }
        });
        if (uVar != null) {
            uVar.xj();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.xj.xj
    public void xj(String str, ws wsVar) {
        if (this.p == null) {
            hf();
        }
        if (this.p != null) {
            this.p.xj(str, wsVar.zf());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.xj.xj
    public void xj(String str, String str2, boolean z, boolean z2, Object obj) {
        if (y() != 3 || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        if (!z2 && z) {
            xj(obj, str, str2);
        } else {
            xj(str, str2);
        }
    }

    private void xj(final Runnable runnable) {
        if (com.bytedance.sdk.openadsdk.x.c.xj()) {
            com.bytedance.sdk.component.tf.c.hf(new com.bytedance.sdk.component.tf.d("") { // from class: com.bytedance.sdk.openadsdk.core.component.splash.xj.w.4
                @Override // java.lang.Runnable
                public void run() {
                    runnable.run();
                }
            });
        } else {
            runnable.run();
        }
    }

    private List<String> xj(String str) {
        List<String> list = f.get(str);
        StringBuilder sb = new StringBuilder("getUsedReqIdList: list : ");
        sb.append(list == null ? 0 : list.size());
        com.bytedance.sdk.openadsdk.core.c.xj.xj("lqmt", sb.toString());
        return list;
    }

    private void xj(String str, String str2, String str3, int i) {
        List<String> list;
        int y = y();
        com.bytedance.sdk.openadsdk.core.c.xj.xj("lqmt", "updateMemoryRecord>> start rit: " + str2 + ", status: " + i + ", cacheStrategyType: " + y);
        if (y != 3) {
            return;
        }
        c.put(str, new hf(str3, i, str2));
        if (i <= 1) {
            com.bytedance.sdk.openadsdk.core.c.xj.xj("lqmt", "updateMemoryRecord>> :status <= CACHE_STATUS_NOUSE");
            return;
        }
        List<String> list2 = f.get(str2);
        StringBuilder sb = new StringBuilder("updateMemoryRecord>>: list1 : ");
        sb.append(list2 == null ? 0 : list2.size());
        com.bytedance.sdk.openadsdk.core.c.xj.xj("lqmt", sb.toString());
        if (list2 == null) {
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            copyOnWriteArrayList.add(str3);
            list = copyOnWriteArrayList;
        } else {
            if (list2.contains(str3)) {
                return;
            }
            list2.add(str3);
            list = list2;
        }
        com.bytedance.sdk.openadsdk.core.c.xj.xj("lqmt", "updateMemoryRecord>>: list2 : " + list.size());
        f.put(str2, list);
    }

    private void xj(Object obj, String str, String str2) {
        try {
            hf hfVar = c.get(hf(str, str2));
            if (hfVar != null && obj != null) {
                PhantomReference phantomReference = new PhantomReference(obj, d);
                com.bytedance.sdk.openadsdk.core.c.xj.xj("lqmt", hfVar.w + "，uuid：" + hfVar.xj + " watching");
                tf.put(phantomReference, hfVar);
            }
        } catch (Exception unused) {
        }
    }

    private void xj(String str, String str2) {
        c.remove(hf(str, str2));
        List<String> list = f.get(str);
        StringBuilder sb = new StringBuilder("checkCaches>>: list1 : ");
        sb.append(list == null ? 0 : list.size());
        com.bytedance.sdk.openadsdk.core.c.xj.xj("lqmt", sb.toString());
        if (list == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.c.xj.xj("lqmt", "checkCaches>>: rmCache : " + str2);
        list.remove(str2);
        f.put(str, list);
    }
}

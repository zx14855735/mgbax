package com.bytedance.sdk.openadsdk.core.a;

import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class l {
    public static final int xj = com.bytedance.sdk.component.utils.jk.y(com.bytedance.sdk.openadsdk.core.pz.getContext(), "tt_shake_tag_key");
    private static final ConcurrentHashMap<ViewGroup, Object> hf = new ConcurrentHashMap<>();
    private static final Object w = new Object();
    private static volatile boolean u = false;

    static {
        EDEYegT();
    }

    private l() {
    }

    private static /* synthetic */ void EDEYegT() {
        char[] charArray = "]QS\u0010Y_S[\u0010\\QG\u0010MV[RR\u0010tPW|LWZY[".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '>');
        }
        String str = new String(charArray);
        char[] charArray2 = "]RWPWJ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '>');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0091, code lost:
    
        if (r0.top < r1.top) goto L39;
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00dd A[LOOP:1: B:32:0x0097->B:40:0x00dd, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00bd A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void u() {
        /*
            Method dump skipped, instructions count: 232
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.a.l.u():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0090, code lost:
    
        if (r0.top < r1.top) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void w() {
        /*
            java.util.concurrent.ConcurrentHashMap<android.view.ViewGroup, java.lang.Object> r0 = com.bytedance.sdk.openadsdk.core.a.l.hf
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto La
            goto Lb4
        La:
            android.content.Context r1 = com.bytedance.sdk.openadsdk.core.pz.getContext()
            int r1 = com.bytedance.sdk.openadsdk.core.a.r.kd(r1)
            java.util.Set r0 = r0.keySet()
            java.util.Iterator r0 = r0.iterator()
            r2 = 2147483647(0x7fffffff, float:NaN)
            r3 = 0
            r5 = r3
            r6 = r5
            r4 = 2147483647(0x7fffffff, float:NaN)
        L23:
            boolean r7 = r0.hasNext()
            if (r7 == 0) goto L77
            java.lang.Object r7 = r0.next()
            android.view.ViewGroup r7 = (android.view.ViewGroup) r7
            if (r7 == 0) goto L23
            android.graphics.Rect r8 = new android.graphics.Rect
            r8.<init>()
            boolean r9 = r7.getGlobalVisibleRect(r8)
            if (r9 != 0) goto L42
            java.util.concurrent.ConcurrentHashMap<android.view.ViewGroup, java.lang.Object> r8 = com.bytedance.sdk.openadsdk.core.a.l.hf
            r8.remove(r7)
            goto L23
        L42:
            boolean r9 = com.bytedance.sdk.openadsdk.core.l.xj(r7)
            if (r9 != 0) goto L4e
            java.util.concurrent.ConcurrentHashMap<android.view.ViewGroup, java.lang.Object> r8 = com.bytedance.sdk.openadsdk.core.a.l.hf
            r8.remove(r7)
            goto L23
        L4e:
            int r9 = r1 / 2
            int r10 = r8.bottom
            if (r10 > r9) goto L57
            int r11 = r9 - r10
            goto L5a
        L57:
            r11 = 2147483647(0x7fffffff, float:NaN)
        L5a:
            int r8 = r8.top
            if (r8 < r9) goto L61
            int r12 = r8 - r9
            goto L64
        L61:
            r12 = 2147483647(0x7fffffff, float:NaN)
        L64:
            if (r10 <= r9) goto L6a
            if (r8 >= r9) goto L6a
            r5 = r7
            goto L77
        L6a:
            int r8 = java.lang.Math.min(r12, r11)
            if (r8 >= r4) goto L73
            r5 = r7
            r4 = r8
            goto L23
        L73:
            if (r8 != r4) goto L23
            r6 = r7
            goto L23
        L77:
            if (r5 != 0) goto L7a
            goto Lb4
        L7a:
            if (r6 == 0) goto L93
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r5.getGlobalVisibleRect(r0)
            android.graphics.Rect r1 = new android.graphics.Rect
            r1.<init>()
            r6.getGlobalVisibleRect(r1)
            int r0 = r0.top
            int r1 = r1.top
            if (r0 >= r1) goto L93
            goto L94
        L93:
            r6 = r5
        L94:
            java.util.concurrent.ConcurrentHashMap<android.view.ViewGroup, java.lang.Object> r0 = com.bytedance.sdk.openadsdk.core.a.l.hf
            java.lang.Object r1 = r0.get(r6)
            boolean r1 = r1 instanceof com.bytedance.sdk.openadsdk.core.hf.w
            if (r1 == 0) goto La5
            java.lang.Object r1 = r0.get(r6)
            r3 = r1
            com.bytedance.sdk.openadsdk.core.hf.w r3 = (com.bytedance.sdk.openadsdk.core.hf.w) r3
        La5:
            r1 = 1
            xj(r6, r1)
            r0.clear()
            r0 = 0
            com.bytedance.sdk.openadsdk.core.a.l.u = r0
            if (r3 == 0) goto Lb4
            r3.xj()
        Lb4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.a.l.w():void");
    }

    public static void xj(WeakReference<ViewGroup> weakReference, com.bytedance.sdk.openadsdk.core.hf.w wVar) {
        if (weakReference == null || wVar == null) {
            return;
        }
        ViewGroup viewGroup = weakReference.get();
        if (!com.bytedance.sdk.openadsdk.core.l.xj(viewGroup)) {
            xj(viewGroup, false);
            return;
        }
        hf.put(viewGroup, wVar);
        if (u) {
            xj(viewGroup, false);
            return;
        }
        synchronized (l.class) {
            try {
                if (u) {
                    xj(viewGroup, false);
                } else {
                    u = true;
                    com.bytedance.sdk.openadsdk.core.v.y().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.l.1
                        @Override // java.lang.Runnable
                        public void run() {
                            l.w();
                        }
                    }, 50L);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean xj(View view) {
        if (view == null) {
            return false;
        }
        Object tag = view.getTag(xj);
        if (tag instanceof Map) {
            Object obj = ((Map) tag).get("is_shake_efficient");
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
        }
        return false;
    }

    private static void xj(ViewGroup viewGroup, boolean z) {
        if (viewGroup == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("is_shake_efficient", Boolean.valueOf(z));
        int i = xj;
        Object tag = viewGroup.getTag(i);
        if (tag != null) {
            try {
                if (!(tag instanceof HashMap)) {
                    return;
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.pl.u("TTShakeChecker", th.getMessage());
                xj(xj, th.getMessage());
                return;
            }
        }
        viewGroup.setTag(i, hashMap);
    }

    public static void xj(final int i, final String str) {
        com.bytedance.sdk.openadsdk.core.ht.hf.w().xj(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.a.l.2
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("shake_tag", i);
                    jSONObject.put("error_msg", str);
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj("stats_shake_tag_key").hf(jSONObject.toString());
            }
        }, "stats_shake_tag_key", false);
    }

    public static void xj(WeakReference<ViewGroup> weakReference, float f, float f2, long j) {
        if (weakReference == null) {
            return;
        }
        ViewGroup viewGroup = weakReference.get();
        if (com.bytedance.sdk.openadsdk.core.l.xj(viewGroup) && xj(f, f2, j)) {
            hf.put(viewGroup, w);
            if (u) {
                return;
            }
            synchronized (l.class) {
                try {
                    if (u) {
                        return;
                    }
                    u = true;
                    com.bytedance.sdk.openadsdk.core.v.y().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.l.3
                        @Override // java.lang.Runnable
                        public void run() {
                            l.u();
                        }
                    }, 50L);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private static boolean xj(float f, float f2, long j) {
        if (f == -1.0f) {
            return true;
        }
        if (f < 0.0f) {
            return false;
        }
        if (f == 0.0f && f2 == 2.14748365E9f) {
            return true;
        }
        if (f2 <= f) {
            return false;
        }
        float currentTimeMillis = (System.currentTimeMillis() - j) / 1000.0f;
        return currentTimeMillis >= f && currentTimeMillis <= f2;
    }
}

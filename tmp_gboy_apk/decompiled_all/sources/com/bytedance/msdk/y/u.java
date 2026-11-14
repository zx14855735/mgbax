package com.bytedance.msdk.y;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.msdk.f.dk;
import com.bytedance.msdk.kd.y;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u {
    private static volatile xj hf;
    private static volatile xj w;
    private static Context xj;

    public static class xj {
        private final JSONObject c;
        private final long f;
        private final int kd;
        private Map<String, Object> tf;
        private final long u;
        private final String w;
        private final Handler xj;
        private final int y;
        private volatile boolean hf = false;
        private int d = 0;

        public xj(String str, long j, long j2, int i, int i2, JSONObject jSONObject, Map<String, Object> map) {
            this.f = j == -1 ? System.currentTimeMillis() : j;
            this.w = str;
            this.u = j2;
            this.kd = i;
            this.y = i2;
            this.c = jSONObject;
            this.tf = map;
            this.xj = new Handler(Looper.getMainLooper());
        }

        public static /* synthetic */ int hf(xj xjVar) {
            int i = xjVar.d;
            xjVar.d = i + 1;
            return i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void xj() {
            this.xj.postDelayed(new Runnable() { // from class: com.bytedance.msdk.y.u.xj.1
                @Override // java.lang.Runnable
                public void run() {
                    xj.hf(xj.this);
                    if (xj.this.d >= 5 || u.xj()) {
                        xj.this.xj(1);
                        return;
                    }
                    com.bytedance.msdk.xj.kd.w.xj("TMe", "--==-- 重试一次 eventType:" + xj.this.w + ", 重试次数：" + xj.this.d);
                    xj.this.xj();
                }
            }, 500L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:19:0x008d  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x00a1 A[Catch: all -> 0x003e, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x003e, blocks: (B:3:0x0001, B:9:0x000e, B:11:0x0012, B:12:0x0065, B:23:0x0090, B:24:0x00a1, B:27:0x0076, B:30:0x0080, B:35:0x0044), top: B:2:0x0001 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public synchronized void xj(int r10) {
            /*
                r9 = this;
                monitor-enter(r9)
                android.os.Handler r0 = r9.xj     // Catch: java.lang.Throwable -> L3e
                r1 = 0
                r0.removeCallbacksAndMessages(r1)     // Catch: java.lang.Throwable -> L3e
                boolean r0 = r9.hf     // Catch: java.lang.Throwable -> L3e
                if (r0 == 0) goto Ld
                monitor-exit(r9)
                return
            Ld:
                r0 = 1
                r9.hf = r0     // Catch: java.lang.Throwable -> L3e
                if (r10 != r0) goto L41
                java.lang.String r10 = "TMe"
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3e
                java.lang.String r2 = "--==-- 最终上报：eventType:"
                r1.<init>(r2)     // Catch: java.lang.Throwable -> L3e
                java.lang.String r2 = r9.w     // Catch: java.lang.Throwable -> L3e
                r1.append(r2)     // Catch: java.lang.Throwable -> L3e
                java.lang.String r2 = ", 重试次数："
                r1.append(r2)     // Catch: java.lang.Throwable -> L3e
                int r2 = r9.d     // Catch: java.lang.Throwable -> L3e
                r1.append(r2)     // Catch: java.lang.Throwable -> L3e
                java.lang.String r2 = ", did: "
                r1.append(r2)     // Catch: java.lang.Throwable -> L3e
                java.lang.String r2 = com.bytedance.msdk.y.u.u()     // Catch: java.lang.Throwable -> L3e
                r1.append(r2)     // Catch: java.lang.Throwable -> L3e
                java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L3e
                com.bytedance.msdk.xj.kd.w.xj(r10, r1)     // Catch: java.lang.Throwable -> L3e
                goto L65
            L3e:
                r0 = move-exception
                r10 = r0
                goto La8
            L41:
                r1 = 2
                if (r10 != r1) goto L65
                java.lang.String r10 = "TMe"
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3e
                java.lang.String r2 = "--==-- 最终上报：eventType:"
                r1.<init>(r2)     // Catch: java.lang.Throwable -> L3e
                java.lang.String r2 = r9.w     // Catch: java.lang.Throwable -> L3e
                r1.append(r2)     // Catch: java.lang.Throwable -> L3e
                java.lang.String r2 = ", 从applog回调中上报, did: "
                r1.append(r2)     // Catch: java.lang.Throwable -> L3e
                java.lang.String r2 = com.bytedance.msdk.y.u.u()     // Catch: java.lang.Throwable -> L3e
                r1.append(r2)     // Catch: java.lang.Throwable -> L3e
                java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L3e
                com.bytedance.msdk.xj.kd.w.xj(r10, r1)     // Catch: java.lang.Throwable -> L3e
            L65:
                java.lang.String r10 = r9.w     // Catch: java.lang.Throwable -> L3e
                int r1 = r10.hashCode()     // Catch: java.lang.Throwable -> L3e
                r2 = -834688111(0xffffffffce3fab91, float:-8.0392301E8)
                if (r1 == r2) goto L80
                r2 = 270071285(0x1018f5f5, float:3.0166193E-29)
                if (r1 == r2) goto L76
                goto L8a
            L76:
                java.lang.String r1 = "sdk_init"
                boolean r10 = r10.equals(r1)     // Catch: java.lang.Throwable -> L3e
                if (r10 == 0) goto L8a
                r10 = 0
                goto L8b
            L80:
                java.lang.String r1 = "sdk_init_end"
                boolean r10 = r10.equals(r1)     // Catch: java.lang.Throwable -> L3e
                if (r10 == 0) goto L8a
                r10 = 1
                goto L8b
            L8a:
                r10 = -1
            L8b:
                if (r10 == 0) goto La1
                if (r10 == r0) goto L90
                goto L9f
            L90:
                long r1 = r9.u     // Catch: java.lang.Throwable -> L3e
                int r3 = r9.kd     // Catch: java.lang.Throwable -> L3e
                int r4 = r9.y     // Catch: java.lang.Throwable -> L3e
                long r5 = r9.f     // Catch: java.lang.Throwable -> L3e
                org.json.JSONObject r7 = r9.c     // Catch: java.lang.Throwable -> L3e
                java.util.Map<java.lang.String, java.lang.Object> r8 = r9.tf     // Catch: java.lang.Throwable -> L3e
                com.bytedance.msdk.y.u.xj(r1, r3, r4, r5, r7, r8)     // Catch: java.lang.Throwable -> L3e
            L9f:
                monitor-exit(r9)
                return
            La1:
                long r0 = r9.f     // Catch: java.lang.Throwable -> L3e
                com.bytedance.msdk.y.u.hf(r0)     // Catch: java.lang.Throwable -> L3e
                monitor-exit(r9)
                return
            La8:
                monitor-exit(r9)     // Catch: java.lang.Throwable -> L3e
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.y.u.xj.xj(int):void");
        }
    }

    public static void hf() {
        new com.bytedance.sdk.openadsdk.core.u.hf("track_start_up").hf(new Runnable() { // from class: com.bytedance.msdk.y.u.1
            @Override // java.lang.Runnable
            public void run() {
                y.hf();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String kd() {
        return dk.xj();
    }

    public static void w() {
        new com.bytedance.sdk.openadsdk.core.u.hf("track_mediation_sdk_init").hf(new Runnable() { // from class: com.bytedance.msdk.y.u.2
            @Override // java.lang.Runnable
            public void run() {
                y.xj();
            }
        });
    }

    public static void xj(Context context) {
        xj = context;
    }

    public static void hf(final long j) {
        new com.bytedance.sdk.openadsdk.core.u.hf("track_sdk_init").hf(new Runnable() { // from class: com.bytedance.msdk.y.u.3
            @Override // java.lang.Runnable
            public void run() {
                y.xj(j);
            }
        });
    }

    public static void xj(long j) {
        xj xjVar = new xj("sdk_init", j, 0L, 0, 0, null, null);
        hf = xjVar;
        xjVar.xj();
    }

    public static void xj(long j, int i, int i2, JSONObject jSONObject, Map<String, Object> map) {
        xj xjVar = new xj("sdk_init_end", -1L, j, i, i2, jSONObject, map);
        w = xjVar;
        xjVar.xj();
    }

    public static boolean xj() {
        return !TextUtils.isEmpty(dk.xj());
    }

    public static void xj(final long j, final int i, final int i2, final long j2, final JSONObject jSONObject, final Map<String, Object> map) {
        new com.bytedance.sdk.openadsdk.core.u.hf("track_sdk_init_end").hf(new Runnable() { // from class: com.bytedance.msdk.y.u.4
            @Override // java.lang.Runnable
            public void run() {
                y.xj(j, i, i2, j2, jSONObject, (Map<String, Object>) map);
            }
        });
    }

    public static void xj(final boolean z) {
        new com.bytedance.sdk.openadsdk.core.u.hf("track_get_config_start").hf(new Runnable() { // from class: com.bytedance.msdk.y.u.5
            @Override // java.lang.Runnable
            public void run() {
                y.xj(z);
            }
        });
    }

    public static void xj(final int i, final int i2, final long j, final boolean z, final boolean z2, final JSONObject jSONObject, final long j2, final JSONObject jSONObject2) {
        new com.bytedance.sdk.openadsdk.core.u.hf("track_get_config_final").hf(new Runnable() { // from class: com.bytedance.msdk.y.u.6
            @Override // java.lang.Runnable
            public void run() {
                y.xj(i, i2, j, z, z2, jSONObject, j2, jSONObject2);
            }
        });
    }
}

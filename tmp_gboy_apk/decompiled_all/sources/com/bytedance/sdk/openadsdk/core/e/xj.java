package com.bytedance.sdk.openadsdk.core.e;

import android.text.TextUtils;
import com.bytedance.sdk.component.d.hf;
import com.bytedance.sdk.component.d.hf.u;
import com.bytedance.sdk.component.d.hf.w;
import com.bytedance.sdk.component.tf.c;
import com.bytedance.sdk.component.tf.d;
import com.bytedance.sdk.component.utils.kd;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.a.j;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.ff;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {
    public static String hf = "";
    public static String xj = "";

    /* renamed from: com.bytedance.sdk.openadsdk.core.e.xj$xj, reason: collision with other inner class name */
    public static class RunnableC0161xj implements Runnable {
        private WeakReference<Runnable> xj;

        public RunnableC0161xj(Runnable runnable) {
            if (runnable != null) {
                this.xj = new WeakReference<>(runnable);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            WeakReference<Runnable> weakReference = this.xj;
            Runnable runnable = weakReference != null ? weakReference.get() : null;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public static void xj(final RunnableC0161xj runnableC0161xj) {
        ff s = pz.hf().s();
        final String xj2 = s == null ? null : s.xj();
        if (TextUtils.isEmpty(xj2)) {
            return;
        }
        if (TextUtils.isEmpty(hf)) {
            hf = xj2;
        }
        c.hf(new d("loadPfJs") { // from class: com.bytedance.sdk.openadsdk.core.e.xj.1
            @Override // java.lang.Runnable
            public void run() {
                RunnableC0161xj runnableC0161xj2;
                String str = xj2;
                if (str != null && str.equalsIgnoreCase(xj.hf)) {
                    if (TextUtils.isEmpty(xj.xj)) {
                        xj.xj = j.xj("js_pform").get(kd.hf(xj2), "");
                    }
                    if (!TextUtils.isEmpty(xj.xj) && (runnableC0161xj2 = runnableC0161xj) != null) {
                        runnableC0161xj2.run();
                        return;
                    }
                }
                w w = com.bytedance.sdk.openadsdk.core.et.kd.xj().hf().w();
                w.xj(xj2);
                HashMap hashMap = new HashMap();
                hashMap.put("content-type", "application/json; charset=utf-8");
                w.u(hashMap);
                w.xj(new com.bytedance.sdk.component.d.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.e.xj.1.1
                    @Override // com.bytedance.sdk.component.d.xj.xj
                    public void xj(u uVar, IOException iOException) {
                    }

                    @Override // com.bytedance.sdk.component.d.xj.xj
                    public void xj(u uVar, hf hfVar) {
                        try {
                            xj.xj = hfVar.u();
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            xj.hf = xj2;
                            RunnableC0161xj runnableC0161xj3 = runnableC0161xj;
                            if (runnableC0161xj3 != null) {
                                runnableC0161xj3.run();
                            }
                            j.xj("js_pform").clear();
                            j.xj("js_pform").put(kd.hf(xj2), xj.xj);
                        } catch (Throwable th) {
                            pl.w("performanceH5", "TTWebViewClient : onPageFinished", th);
                        }
                    }
                });
            }
        });
    }

    public static void xj(StringBuilder sb, String str, String str2) {
        int indexOf;
        if (sb == null || TextUtils.isEmpty(str) || (indexOf = sb.indexOf(str)) <= 0) {
            return;
        }
        sb.replace(indexOf, str.length() + indexOf, str2);
    }
}

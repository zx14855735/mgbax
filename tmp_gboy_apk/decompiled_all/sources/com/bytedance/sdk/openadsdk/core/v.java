package com.bytedance.sdk.openadsdk.core;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.a.wo;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class v {
    public static volatile boolean xj;
    private static volatile Handler y;
    public static AtomicBoolean hf = new AtomicBoolean(false);
    public static AtomicBoolean w = new AtomicBoolean(false);
    public static AtomicBoolean u = new AtomicBoolean(false);
    public static final long kd = SystemClock.elapsedRealtime();

    public static final class xj implements com.bytedance.sdk.component.y.ht {
        private xj() {
        }

        @Override // com.bytedance.sdk.component.y.ht
        public void clearMemoryCache(double d) {
            com.bytedance.sdk.openadsdk.f.hf.xj().clearMemoryCache(d);
        }

        @Override // com.bytedance.sdk.component.y.ht
        public com.bytedance.sdk.component.y.am from(String str) {
            return com.bytedance.sdk.openadsdk.f.hf.xj().from(str);
        }

        @Override // com.bytedance.sdk.component.y.ht
        public InputStream getCacheStream(String str, String str2) {
            return com.bytedance.sdk.openadsdk.f.hf.xj().getCacheStream(str, str2);
        }
    }

    static {
        BloVGzf();
    }

    private static /* synthetic */ void BloVGzf() {
        char[] charArray = "\u008c\u0080\u0082Á\u0088\u008e\u0082\u008aÁ\u008d\u0080\u0096Á\u009c\u0087\u008a\u0083\u0083Á¥\u0081\u0086\u00ad\u009d\u0086\u008b\u0088\u008a".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 239);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u008c\u0083\u0086\u0081\u0086\u009b".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 239);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private static void c() {
        if (Build.VERSION.SDK_INT < 28) {
            return;
        }
        try {
            Class.forName("android.content.pm.PackageParser$Package").getDeclaredConstructor(String.class).setAccessible(true);
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mHiddenApiWarningShown");
            declaredField.setAccessible(true);
            declaredField.setBoolean(invoke, true);
        } catch (Throwable unused) {
        }
    }

    private static void f() {
        com.bytedance.sdk.openadsdk.core.w.u.xj().u(UUID.randomUUID().toString());
    }

    public static void hf() {
        pz.hf().xj(1);
        if (!u.get()) {
            xj();
        }
        Context context = pz.getContext();
        if (context == null) {
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.core.et.kd.xj().hf().xj(context, com.bytedance.sdk.openadsdk.core.multipro.hf.w());
        } catch (Exception unused) {
        }
    }

    public static void kd() {
        com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().xj(new com.bytedance.sdk.component.adexpress.xj.xj.hf() { // from class: com.bytedance.sdk.openadsdk.core.v.3
            @Override // com.bytedance.sdk.component.adexpress.xj.xj.hf
            public int delete(String str, String str2, String[] strArr) {
                return com.bytedance.sdk.openadsdk.core.multipro.xj.xj.delete(pz.getContext(), str, str2, strArr);
            }

            @Override // com.bytedance.sdk.component.adexpress.xj.xj.hf
            public void insert(String str, ContentValues contentValues) {
                com.bytedance.sdk.openadsdk.core.multipro.xj.xj.insert(pz.getContext(), str, contentValues);
            }

            @Override // com.bytedance.sdk.component.adexpress.xj.xj.hf
            public Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
                return com.bytedance.sdk.openadsdk.core.multipro.xj.xj.query(pz.getContext(), str, strArr, str2, strArr2, str3, str4, str5);
            }

            @Override // com.bytedance.sdk.component.adexpress.xj.xj.hf
            public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
                return com.bytedance.sdk.openadsdk.core.multipro.xj.xj.update(pz.getContext(), str, contentValues, str2, strArr);
            }
        });
        com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().xj(new com.bytedance.sdk.component.adexpress.xj.xj.u() { // from class: com.bytedance.sdk.openadsdk.core.v.4
            @Override // com.bytedance.sdk.component.adexpress.xj.xj.u
            public void xj(final int i) {
                com.bytedance.sdk.openadsdk.core.ht.am.xj().kd(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.v.4.1
                    @Override // com.bytedance.sdk.openadsdk.p.xj.xj
                    public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                        return com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().hf(i).c(c.xj(i));
                    }
                });
            }
        });
        com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().xj(new xj());
        com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().xj(new com.bytedance.sdk.component.adexpress.xj.xj.kd() { // from class: com.bytedance.sdk.openadsdk.core.v.5
            @Override // com.bytedance.sdk.component.adexpress.xj.xj.kd
            public void delete(String str, String str2) {
                com.bytedance.sdk.openadsdk.core.w.hf.xj().xj(str, str2);
            }

            @Override // com.bytedance.sdk.component.adexpress.xj.xj.kd
            public void update(String str, com.bytedance.sdk.component.adexpress.xj.w.w wVar) {
                com.bytedance.sdk.openadsdk.core.w.hf.xj().xj(str, wVar);
            }
        });
    }

    public static void u() {
        com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().xj(new com.bytedance.sdk.component.adexpress.xj.xj.w() { // from class: com.bytedance.sdk.openadsdk.core.v.2
            @Override // com.bytedance.sdk.component.adexpress.xj.xj.w
            public ExecutorService am() {
                return null;
            }

            @Override // com.bytedance.sdk.component.adexpress.xj.xj.w
            public int c() {
                return 0;
            }

            @Override // com.bytedance.sdk.component.adexpress.xj.xj.w
            public int d() {
                return pz.hf().ho();
            }

            @Override // com.bytedance.sdk.component.adexpress.xj.xj.w
            public int f() {
                return pz.hf().bh();
            }

            @Override // com.bytedance.sdk.component.adexpress.xj.xj.w
            public ExecutorService g() {
                return null;
            }

            @Override // com.bytedance.sdk.component.adexpress.xj.xj.w
            public Context getContext() {
                return pz.getContext();
            }

            @Override // com.bytedance.sdk.component.adexpress.xj.xj.w
            public Handler hf() {
                return v.y();
            }

            @Override // com.bytedance.sdk.component.adexpress.xj.xj.w
            public com.bytedance.sdk.component.d.hf.w kd() {
                return com.bytedance.sdk.openadsdk.core.et.kd.xj().hf().w();
            }

            @Override // com.bytedance.sdk.component.adexpress.xj.xj.w
            public int p() {
                return pz.hf().nt();
            }

            @Override // com.bytedance.sdk.component.adexpress.xj.xj.w
            public boolean pl() {
                return com.bytedance.sdk.openadsdk.core.multipro.hf.w();
            }

            @Override // com.bytedance.sdk.component.adexpress.xj.xj.w
            public int qt() {
                return r.u(pz.getContext());
            }

            @Override // com.bytedance.sdk.component.adexpress.xj.xj.w
            public int tf() {
                return f.zg().wn();
            }

            @Override // com.bytedance.sdk.component.adexpress.xj.xj.w
            public com.bytedance.sdk.component.d.hf.hf u() {
                return com.bytedance.sdk.openadsdk.core.et.kd.xj().hf().u();
            }

            @Override // com.bytedance.sdk.component.adexpress.xj.xj.w
            public com.bytedance.sdk.component.adexpress.xj.w.xj w() {
                return pz.xj().xj(1);
            }

            @Override // com.bytedance.sdk.component.adexpress.xj.xj.w
            public int xj() {
                if (pz.hf() == null) {
                    return 0;
                }
                return pz.hf().ol();
            }

            @Override // com.bytedance.sdk.component.adexpress.xj.xj.w
            public String y() {
                return f.zg().pz();
            }
        });
    }

    public static void w() {
        com.bytedance.sdk.component.u.hf.w xj2 = hf.xj();
        long j = xj2.get("sdk_first_init_timestamp", 0L);
        if (j == 0) {
            j = System.currentTimeMillis();
            xj2.put("sdk_first_init_timestamp", j);
        }
        long currentTimeMillis = System.currentTimeMillis();
        String hf2 = wo.hf(j, currentTimeMillis);
        long j2 = xj2.get("sdk_init_timestamp", 0L);
        StringBuilder sb = new StringBuilder();
        sb.append(j2 != 0 ? (currentTimeMillis - j2) / 1000 : 0L);
        com.bytedance.sdk.openadsdk.core.ht.am.xj().xj(hf2, sb.toString());
        xj2.put("sdk_init_timestamp", System.currentTimeMillis());
    }

    public static void xj() {
        Context context;
        if (u.get() || !pz.hf().wo() || (context = pz.getContext()) == null) {
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.core.et.kd.xj().hf().xj(context, true, new com.bytedance.sdk.openadsdk.core.et.u(context));
        } catch (Exception unused) {
        }
        u.set(true);
    }

    public static Handler y() {
        if (y == null) {
            synchronized (v.class) {
                try {
                    if (y == null) {
                        y = new Handler(Looper.getMainLooper());
                    }
                } finally {
                }
            }
        }
        return y;
    }

    public static void xj(Context context) {
        hf.set(true);
        w.set(true);
        c();
        r.xj(context);
        f();
        String w2 = yo.w();
        com.bytedance.sdk.component.utils.pl.xj("appLogID", w2);
        if (!TextUtils.isEmpty(w2)) {
            com.bytedance.sdk.openadsdk.core.ht.hf.xj(w2);
        }
        if (com.bytedance.sdk.openadsdk.xj.xj.xj.xj() != null) {
            com.bytedance.sdk.openadsdk.xj.xj.xj.xj().xj(w2);
        }
        com.bytedance.sdk.component.adexpress.xj.hf.hf.xj();
        new com.bytedance.sdk.openadsdk.core.u.hf("playable_engine_init").hf(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.v.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.xj.hf.hf.hf();
            }
        });
    }
}

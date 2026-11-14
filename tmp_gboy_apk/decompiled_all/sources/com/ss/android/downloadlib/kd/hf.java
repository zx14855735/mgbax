package com.ss.android.downloadlib.kd;

import android.text.TextUtils;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class hf {

    public interface xj<T> {
        T hf();
    }

    public static <T> T xj(boolean z, String str, xj<T> xjVar) {
        try {
            return xjVar.hf();
        } catch (Throwable th) {
            if (th instanceof com.ss.android.downloadlib.kd.xj) {
                throw th;
            }
            w.xj().xj(z, th, str);
            if (TextUtils.isEmpty(str)) {
                throw th;
            }
            return null;
        }
    }

    public static <T> T xj(xj<T> xjVar) {
        return (T) xj(true, null, xjVar);
    }

    public static void xj(final Runnable runnable) {
        xj(new xj<Void>() { // from class: com.ss.android.downloadlib.kd.hf.1
            @Override // com.ss.android.downloadlib.kd.hf.xj
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public Void hf() {
                runnable.run();
                return null;
            }
        });
    }
}

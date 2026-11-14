package com.bytedance.msdk.core.pl;

import android.os.Handler;
import android.os.Looper;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class y {
    private static final String xj = "y";
    private Looper hf = Looper.getMainLooper();
    private final Set<String> w = new HashSet(1);

    /* renamed from: com.bytedance.msdk.core.pl.y$5, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] xj;

        static {
            int[] iArr = new int[u.values().length];
            xj = iArr;
            try {
                iArr[u.GRANTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                xj[u.DENIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                xj[u.NOT_FOUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public synchronized boolean hf(String str) {
        com.bytedance.msdk.xj.kd.w.hf(xj, "permission not found:".concat(String.valueOf(str)));
        return true;
    }

    public abstract void xj();

    public abstract void xj(String str);

    public final synchronized boolean xj(String str, int i) {
        if (i == 0) {
            return xj(str, u.GRANTED);
        }
        return xj(str, u.DENIED);
    }

    public final synchronized boolean xj(final String str, u uVar) {
        this.w.remove(str);
        int i = AnonymousClass5.xj[uVar.ordinal()];
        if (i != 1) {
            if (i == 2) {
                new Handler(this.hf).post(new Runnable() { // from class: com.bytedance.msdk.core.pl.y.2
                    @Override // java.lang.Runnable
                    public void run() {
                        y.this.xj(str);
                    }
                });
                return true;
            }
            if (i == 3) {
                if (hf(str)) {
                    if (this.w.isEmpty()) {
                        new Handler(this.hf).post(new Runnable() { // from class: com.bytedance.msdk.core.pl.y.3
                            @Override // java.lang.Runnable
                            public void run() {
                                y.this.xj();
                            }
                        });
                        return true;
                    }
                } else {
                    new Handler(this.hf).post(new Runnable() { // from class: com.bytedance.msdk.core.pl.y.4
                        @Override // java.lang.Runnable
                        public void run() {
                            y.this.xj(str);
                        }
                    });
                    return true;
                }
            }
        } else if (this.w.isEmpty()) {
            new Handler(this.hf).post(new Runnable() { // from class: com.bytedance.msdk.core.pl.y.1
                @Override // java.lang.Runnable
                public void run() {
                    y.this.xj();
                }
            });
            return true;
        }
        return false;
    }

    public final synchronized void xj(String[] strArr) {
        Collections.addAll(this.w, strArr);
    }
}

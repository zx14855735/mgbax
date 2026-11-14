package com.ss.android.socialbase.downloader.network;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class p {
    private static final String xj = "p";
    private int c;
    private final u hf;
    private AtomicReference<pl> kd;
    private final AtomicReference<pl> u;
    private volatile boolean w;
    private final ArrayList<Object> y;

    /* renamed from: com.ss.android.socialbase.downloader.network.p$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] xj;

        static {
            int[] iArr = new int[pl.values().length];
            xj = iArr;
            try {
                iArr[pl.POOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                xj[pl.MODERATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                xj[pl.GOOD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                xj[pl.EXCELLENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static class xj {
        public static final p xj = new p(null);

        static {
            MZzsnE();
        }

        private static /* synthetic */ void MZzsnE() {
            char[] charArray = "²¾¼ÿ¶°¼´ÿ³¾¨ÿ¢¹´½½ÿ\u009b¿¸\u0093£¸µ¶´".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 209);
            }
            String str = new String(charArray);
            char[] charArray2 = "²½¸¿¸¥".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 209);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public /* synthetic */ p(AnonymousClass1 anonymousClass1) {
        this();
    }

    private void u() {
        try {
            int size = this.y.size();
            for (int i = 0; i < size; i++) {
                this.y.get(i);
                this.u.get();
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
        }
    }

    private boolean w() {
        double d;
        if (this.hf == null) {
            return false;
        }
        try {
            int i = AnonymousClass1.xj[this.u.get().ordinal()];
            double d2 = 150.0d;
            if (i == 1) {
                d = 0.0d;
            } else if (i == 2) {
                d = 150.0d;
                d2 = 550.0d;
            } else if (i == 3) {
                d = 550.0d;
                d2 = 2000.0d;
            } else {
                if (i != 4) {
                    return true;
                }
                d2 = 3.4028234663852886E38d;
                d = 2000.0d;
            }
            double xj2 = this.hf.xj();
            if (xj2 > d2) {
                if (xj2 > d2 * 1.25d) {
                    return true;
                }
            } else if (xj2 < d * 0.8d) {
                return true;
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
        }
        return false;
    }

    public static p xj() {
        return xj.xj;
    }

    public synchronized pl hf() {
        u uVar = this.hf;
        if (uVar == null) {
            return pl.UNKNOWN;
        }
        try {
            return xj(uVar.xj());
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
            return pl.UNKNOWN;
        }
    }

    private p() {
        this.hf = new u(0.05d);
        this.w = false;
        this.u = new AtomicReference<>(pl.UNKNOWN);
        this.y = new ArrayList<>();
    }

    public synchronized void xj(long j, long j2) {
        double d = ((j * 1.0d) / j2) * 8.0d;
        if (j2 == 0 || d < 3.0d) {
            return;
        }
        try {
            this.hf.xj(d);
            pl hf = hf();
            if (!this.w) {
                if (this.u.get() != hf) {
                    this.w = true;
                    this.kd = new AtomicReference<>(hf);
                }
                return;
            }
            this.c++;
            if (hf != this.kd.get()) {
                this.w = false;
                this.c = 1;
            }
            if (this.c >= 5.0d && w()) {
                this.w = false;
                this.c = 1;
                this.u.set(this.kd.get());
                u();
            }
        } catch (Throwable unused) {
        }
    }

    private pl xj(double d) {
        if (d < 0.0d) {
            return pl.UNKNOWN;
        }
        if (d < 150.0d) {
            return pl.POOR;
        }
        if (d < 550.0d) {
            return pl.MODERATE;
        }
        if (d < 2000.0d) {
            return pl.GOOD;
        }
        return pl.EXCELLENT;
    }
}

package com.bytedance.sdk.component.w.xj;

import java.io.InterruptedIOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class jk {
    public static final jk w = new jk() { // from class: com.bytedance.sdk.component.w.xj.jk.1
        @Override // com.bytedance.sdk.component.w.xj.jk
        public void c() {
        }

        @Override // com.bytedance.sdk.component.w.xj.jk
        public jk xj(long j) {
            return this;
        }

        @Override // com.bytedance.sdk.component.w.xj.jk
        public jk xj(long j, TimeUnit timeUnit) {
            return this;
        }
    };
    private long hf;
    private long u;
    private boolean xj;

    static {
        XIFDAU();
    }

    private static /* synthetic */ void XIFDAU() {
        char[] charArray = "ÑÝß\u009cÕÓß×\u009cÐÝË\u009cÁÚ×ÞÞ\u009cøÜÛðÀÛÖÕ×".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 178);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÑÞÛÜÛÆ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 178);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public void c() {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
        if (this.xj && this.hf - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public jk kd() {
        this.u = 0L;
        return this;
    }

    public long n_() {
        return this.u;
    }

    public long o_() {
        if (this.xj) {
            return this.hf;
        }
        throw new IllegalStateException("No deadline");
    }

    public boolean w() {
        return this.xj;
    }

    public jk xj(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException("timeout < 0: ".concat(String.valueOf(j)));
        }
        if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        }
        this.u = timeUnit.toNanos(j);
        return this;
    }

    public jk y() {
        this.xj = false;
        return this;
    }

    public jk xj(long j) {
        this.xj = true;
        this.hf = j;
        return this;
    }
}

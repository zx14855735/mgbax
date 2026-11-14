package com.kwad.sdk.utils;

import android.content.Context;
import android.os.PowerManager;
import android.os.SystemClock;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class aw {
    private static volatile aw bfd = new aw();
    private volatile boolean bfe;
    private volatile long bff = 0;
    private volatile PowerManager bfg;

    static {
        pIWFGV();
    }

    public static aw SX() {
        return bfd;
    }

    private static /* synthetic */ void pIWFGV() {
        char[] charArray = "ÈÄÆ\u0085ÌÊÆÎ\u0085ÉÄÒ\u0085ØÃÎÇÇ\u0085áÅÂéÙÂÏÌÎ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 171);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÈÇÂÅÂß".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 171);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final boolean dx(Context context) {
        if (this.bff > 0 && SystemClock.elapsedRealtime() - this.bff < 600) {
            return this.bfe;
        }
        if (this.bfg == null && context != null) {
            synchronized (this) {
                try {
                    if (this.bfg == null) {
                        this.bfg = (PowerManager) context.getApplicationContext().getSystemService("power");
                    }
                } finally {
                }
            }
        }
        this.bfe = this.bfg != null ? this.bfg.isInteractive() : false;
        this.bff = SystemClock.elapsedRealtime();
        return this.bfe;
    }
}

package com.kwad.components.ad.splashscreen;

import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class SplashPlayModuleCache {
    private HashMap<String, WeakReference<com.kwad.components.ad.splashscreen.d.a>> FI;

    public enum Holder {
        INSTANCE;

        private SplashPlayModuleCache mInstance = new SplashPlayModuleCache(0);

        static {
            vImq();
        }

        Holder() {
        }

        private static /* synthetic */ void vImq() {
            char[] charArray = "3?=~71=5~2?)~#85<<~\u001a>9\u0012\"9475".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 'P');
            }
            String str = new String(charArray);
            char[] charArray2 = "3<9>9$".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 'P');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        public final SplashPlayModuleCache getInstance() {
            return this.mInstance;
        }
    }

    public /* synthetic */ SplashPlayModuleCache(byte b) {
        this();
    }

    private SplashPlayModuleCache() {
        this.FI = new HashMap<>(1);
    }
}

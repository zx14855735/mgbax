package com.kwad.sdk.core.video.videoview;

import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class AdVideoPlayerViewCache {
    private HashMap<String, WeakReference<a>> FI;

    public enum Holder {
        INSTANCE;

        private AdVideoPlayerViewCache mInstance = new AdVideoPlayerViewCache(0);

        static {
            uUBBPY();
        }

        Holder() {
        }

        private static /* synthetic */ void uUBBPY() {
            char[] charArray = "^RP\u0013Z\\PX\u0013_RD\u0013NUXQQ\u0013wST\u007fOTYZX".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ '=');
            }
            String str = new String(charArray);
            char[] charArray2 = "^QTSTI".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ '=');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        public final AdVideoPlayerViewCache getInstance() {
            return this.mInstance;
        }
    }

    public /* synthetic */ AdVideoPlayerViewCache(byte b) {
        this();
    }

    public static AdVideoPlayerViewCache getInstance() {
        return Holder.INSTANCE.getInstance();
    }

    public final void a(String str, a aVar) {
        this.FI.put(str, new WeakReference<>(aVar));
    }

    public final a eV(String str) {
        WeakReference<a> weakReference = this.FI.get(str);
        if (weakReference != null) {
            a aVar = weakReference.get();
            if (aVar != null) {
                return aVar;
            }
            this.FI.remove(str);
        }
        return null;
    }

    public final void remove(String str) {
        this.FI.remove(str);
    }

    private AdVideoPlayerViewCache() {
        this.FI = new HashMap<>(1);
    }
}

package com.kwad.sdk.core.threads;

import ADYaiT.CtFAbx;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class a {
    private static Map<String, WeakReference<C0368a>> aOe = new ConcurrentHashMap();

    /* renamed from: com.kwad.sdk.core.threads.a$a, reason: collision with other inner class name */
    public static class C0368a {
        private HandlerThread aOf;
        private Handler iK;

        public C0368a(String str) {
            HandlerThread handlerThread = new HandlerThread(TextUtils.isEmpty(str) ? "ksad-HT" : CtFAbx.BChYOn("ksad-", str));
            this.aOf = handlerThread;
            handlerThread.start();
            this.iK = new Handler(this.aOf.getLooper());
        }

        public final Handler getHandler() {
            return this.iK;
        }
    }

    static {
        erLPyrg();
    }

    public static synchronized Handler La() {
        Handler handler;
        synchronized (a.class) {
            handler = eR("reportHT").getHandler();
        }
        return handler;
    }

    private static C0368a eR(String str) {
        WeakReference<C0368a> weakReference = aOe.get(str);
        if (weakReference != null && weakReference.get() != null) {
            return weakReference.get();
        }
        C0368a c0368a = new C0368a(str);
        aOe.put(str, new WeakReference<>(c0368a));
        return c0368a;
    }

    private static /* synthetic */ void erLPyrg() {
        char[] charArray = "eik(agkc(di\u007f(uncjj(LhoDtobac".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 6);
        }
        String str = new String(charArray);
        char[] charArray2 = "ejohor".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 6);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}

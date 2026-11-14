package com.kwad.components.core.c;

import com.kwad.sdk.core.response.model.AdResultData;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class f {
    private Map<Integer, AdResultData> Of = new ConcurrentHashMap();
    private AtomicInteger Og = new AtomicInteger(0);
    private Map<Integer, h> Oh = new ConcurrentHashMap();
    private AtomicInteger Oi = new AtomicInteger(0);

    public static class a {
        static f Oj = new f();

        static {
            uoZrYkX();
        }

        private static /* synthetic */ void uoZrYkX() {
            char[] charArray = "\u001c\u0010\u0012Q\u0018\u001e\u0012\u001aQ\u001d\u0010\u0006Q\f\u0017\u001a\u0013\u0013Q5\u0011\u0016=\r\u0016\u001b\u0018\u001a".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 127);
            }
            String str = new String(charArray);
            char[] charArray2 = "\u001c\u0013\u0016\u0011\u0016\u000b".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 127);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public static f oy() {
        return a.Oj;
    }

    public final int a(h hVar) {
        int incrementAndGet = this.Oi.incrementAndGet();
        this.Oh.put(Integer.valueOf(incrementAndGet), hVar);
        return incrementAndGet;
    }

    public final AdResultData d(int i, boolean z) {
        AdResultData adResultData = this.Of.get(Integer.valueOf(i));
        this.Of.remove(Integer.valueOf(i));
        return adResultData;
    }

    public final h e(int i, boolean z) {
        h hVar = this.Oh.get(Integer.valueOf(i));
        this.Oh.remove(Integer.valueOf(i));
        return hVar;
    }

    public final int l(AdResultData adResultData) {
        if (adResultData == null) {
            return 0;
        }
        int incrementAndGet = this.Og.incrementAndGet();
        this.Of.put(Integer.valueOf(incrementAndGet), adResultData);
        return incrementAndGet;
    }
}

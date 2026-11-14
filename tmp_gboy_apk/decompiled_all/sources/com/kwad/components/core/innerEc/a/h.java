package com.kwad.components.core.innerEc.a;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class h {
    private final List<g> RW;

    public static class a {
        private static final h RX = new h(0);

        static {
            GynZvSr();
        }

        private static /* synthetic */ void GynZvSr() {
            char[] charArray = "ÍÁÃ\u0080ÉÏÃË\u0080ÌÁ×\u0080ÝÆËÂÂ\u0080äÀÇìÜÇÊÉË".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 174);
            }
            String str = new String(charArray);
            char[] charArray2 = "ÍÂÇÀÇÚ".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 174);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public /* synthetic */ h(byte b) {
        this();
    }

    public static h qX() {
        return a.RX;
    }

    public final void a(g gVar) {
        this.RW.add(gVar);
    }

    public final void b(g gVar) {
        if (gVar != null) {
            this.RW.remove(gVar);
        }
    }

    public final void qY() {
        Iterator<g> it = this.RW.iterator();
        while (it.hasNext()) {
            it.next().di();
        }
    }

    public final void qZ() {
        Iterator<g> it = this.RW.iterator();
        while (it.hasNext()) {
            it.next().dj();
        }
    }

    private h() {
        this.RW = new CopyOnWriteArrayList();
    }
}

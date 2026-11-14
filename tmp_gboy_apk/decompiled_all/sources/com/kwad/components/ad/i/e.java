package com.kwad.components.ad.i;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class e {
    private final AtomicBoolean qZ;
    private final List<com.kwad.components.ad.b.a.b> ra;

    public static class a {
        private static final e rb = new e(0);

        static {
            KOAAetb();
        }

        private static /* synthetic */ void KOAAetb() {
            char[] charArray = "COM\u000eGAME\u000eBOY\u000eSHELL\u000ejNIbRIDGE".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ ' ');
            }
            String str = new String(charArray);
            char[] charArray2 = "CLINIT".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ ' ');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public /* synthetic */ e(byte b) {
        this();
    }

    public static e gf() {
        return a.rb;
    }

    public final boolean T() {
        return this.qZ.get();
    }

    public final void a(com.kwad.components.ad.b.a.b bVar) {
        if (bVar != null) {
            this.ra.add(bVar);
        }
    }

    public final void b(com.kwad.components.ad.b.a.b bVar) {
        if (bVar != null) {
            this.ra.remove(bVar);
        }
    }

    public final void gb() {
        this.qZ.set(true);
        Iterator<com.kwad.components.ad.b.a.b> it = this.ra.iterator();
        while (it.hasNext()) {
            it.next().U();
        }
    }

    public final void gd() {
        this.qZ.set(false);
        Iterator<com.kwad.components.ad.b.a.b> it = this.ra.iterator();
        while (it.hasNext()) {
            it.next().V();
        }
    }

    private e() {
        this.qZ = new AtomicBoolean();
        this.ra = new CopyOnWriteArrayList();
    }
}

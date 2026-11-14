package com.kwad.components.core.s;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class c {
    private Set<b> acv;

    public static class a {
        private static c acw = new c(0);

        static {
            TLsFy();
        }

        private static /* synthetic */ void TLsFy() {
            char[] charArray = "VZX\u001bRTXP\u001bWZL\u001bF]PYY\u001b\u007f[\\wG\\QRP".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ '5');
            }
            String str = new String(charArray);
            char[] charArray2 = "VY\\[\\A".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ '5');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public interface b {
        void onPageClose();
    }

    public /* synthetic */ c(byte b2) {
        this();
    }

    public static c uu() {
        return a.acw;
    }

    public final void a(b bVar) {
        this.acv.add(bVar);
    }

    public final void b(b bVar) {
        this.acv.remove(bVar);
    }

    public final void uv() {
        if (this.acv.size() == 0) {
            return;
        }
        Iterator<b> it = this.acv.iterator();
        while (it.hasNext()) {
            it.next().onPageClose();
        }
    }

    private c() {
        this.acv = new HashSet();
    }
}

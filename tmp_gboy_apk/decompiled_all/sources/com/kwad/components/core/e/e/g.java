package com.kwad.components.core.e.e;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class g {
    private final List<f> Qz;

    public static class a {
        private static final g QA = new g(0);

        static {
            lPEP();
        }

        private static /* synthetic */ void lPEP() {
            char[] charArray = "òþü¿öðüô¿óþè¿âùôýý¿ÛÿøÓãøõöô".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 145);
            }
            String str = new String(charArray);
            char[] charArray2 = "òýøÿøå".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 145);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public /* synthetic */ g(byte b) {
        this();
    }

    public static g qo() {
        return a.QA;
    }

    public final void a(f fVar) {
        this.Qz.add(fVar);
    }

    public final void b(f fVar) {
        if (fVar != null) {
            this.Qz.remove(fVar);
        }
    }

    public final void qp() {
        Iterator<f> it = this.Qz.iterator();
        while (it.hasNext()) {
            it.next().show();
        }
    }

    public final void qq() {
        Iterator<f> it = this.Qz.iterator();
        while (it.hasNext()) {
            it.next().dismiss();
        }
    }

    private g() {
        this.Qz = new CopyOnWriteArrayList();
    }
}

package com.kwad.components.core.k;

import java.lang.reflect.Method;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class a {
    private CopyOnWriteArrayList<b> SH = new CopyOnWriteArrayList<>();
    private volatile boolean SI;

    /* renamed from: com.kwad.components.core.k.a$a, reason: collision with other inner class name */
    public static final class C0299a {
        private static final a SJ = new a();

        static {
            RyqE();
        }

        private static /* synthetic */ void RyqE() {
            char[] charArray = "«§¥æ¯©¥\u00adæª§±æ» \u00ad¤¤æ\u0082¦¡\u008aº¡¬¯\u00ad".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 200);
            }
            String str = new String(charArray);
            char[] charArray2 = "«¤¡¦¡¼".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 200);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public static class b {
        private final c SK;
        public boolean SL;

        public b(c cVar) {
            this.SK = cVar;
        }
    }

    public interface c {
        void bE();
    }

    public static boolean b(b bVar) {
        if (bVar == null) {
            return true;
        }
        return bVar.SL;
    }

    public static a rg() {
        return C0299a.SJ;
    }

    public final void a(b bVar) {
        if (this.SH.contains(bVar)) {
            return;
        }
        if (!this.SI) {
            this.SI = true;
            bVar.SL = true;
        }
        this.SH.add(bVar);
    }

    public final void c(b bVar) {
        if (bVar == null) {
            return;
        }
        if (bVar.SL) {
            bVar.SL = false;
            this.SI = false;
        }
        this.SH.remove(bVar);
        if (this.SH.size() == 0 || this.SI) {
            return;
        }
        this.SH.get(0).SL = true;
        this.SI = true;
        this.SH.get(0).SK.bE();
    }
}

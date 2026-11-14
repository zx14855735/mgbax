package com.kwad.framework.filedownloader.download;

import com.kwad.framework.filedownloader.a.c;
import com.kwad.framework.filedownloader.f.c;
import com.kwad.framework.filedownloader.services.c;
import java.io.File;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class b {
    private com.kwad.framework.filedownloader.services.c ars;
    private c.a art;
    private c.b aru;
    private c.e arv;
    private volatile com.kwad.framework.filedownloader.b.a arw;
    private c.d arx;

    public static final class a {
        private static final b ary = new b();

        static {
            LRiAA();
        }

        private static /* synthetic */ void LRiAA() {
            char[] charArray = "ìàâ¡èîâê¡íàö¡üçêãã¡ÅáæÍýæëèê".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 143);
            }
            String str = new String(charArray);
            char[] charArray2 = "ìãæáæû".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 143);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public static b zG() {
        return a.ary;
    }

    private c.a zL() {
        c.a aVar = this.art;
        if (aVar != null) {
            return aVar;
        }
        synchronized (this) {
            try {
                if (this.art == null) {
                    this.art = zO().AM();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.art;
    }

    private c.b zM() {
        c.b bVar = this.aru;
        if (bVar != null) {
            return bVar;
        }
        synchronized (this) {
            try {
                if (this.aru == null) {
                    this.aru = zO().AL();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.aru;
    }

    private c.e zN() {
        c.e eVar = this.arv;
        if (eVar != null) {
            return eVar;
        }
        synchronized (this) {
            try {
                if (this.arv == null) {
                    this.arv = zO().AK();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.arv;
    }

    private com.kwad.framework.filedownloader.services.c zO() {
        com.kwad.framework.filedownloader.services.c cVar = this.ars;
        if (cVar != null) {
            return cVar;
        }
        synchronized (this) {
            try {
                if (this.ars == null) {
                    this.ars = new com.kwad.framework.filedownloader.services.c();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.ars;
    }

    public final void a(c.b bVar) {
        synchronized (this) {
            this.ars = new com.kwad.framework.filedownloader.services.c(bVar);
            this.aru = null;
            this.arv = null;
            this.arw = null;
            this.arx = null;
        }
    }

    public final void b(c.b bVar) {
        synchronized (this) {
            this.ars = new com.kwad.framework.filedownloader.services.c(bVar);
        }
    }

    public final com.kwad.framework.filedownloader.a.b bD(String str) {
        try {
            return zM().bA(str);
        } catch (Throwable unused) {
            c.b bVar = new c.b();
            this.aru = bVar;
            return bVar.bA(str);
        }
    }

    public final c.d zH() {
        c.d dVar = this.arx;
        if (dVar != null) {
            return dVar;
        }
        synchronized (this) {
            try {
                if (this.arx == null) {
                    this.arx = zO().AN();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.arx;
    }

    public final synchronized com.kwad.framework.filedownloader.b.a zI() {
        if (this.arw != null) {
            return this.arw;
        }
        this.arw = zO().AJ();
        a(this.arw.zx());
        return this.arw;
    }

    public final int zJ() {
        return zO().zJ();
    }

    public final boolean zK() {
        zN();
        return true;
    }

    public final com.kwad.framework.filedownloader.e.a b(File file) {
        return zN().c(file);
    }

    public final int a(int i, String str, String str2, long j) {
        return zL().V(j);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0068 A[Catch: all -> 0x0054, TRY_LEAVE, TryCatch #1 {all -> 0x0054, blocks: (B:8:0x002b, B:10:0x0038, B:12:0x003e, B:14:0x0045, B:16:0x004b, B:19:0x005c, B:22:0x00ec, B:25:0x0068, B:75:0x00b1, B:29:0x00cb, B:31:0x00d2, B:34:0x00db, B:37:0x00e6, B:39:0x00f5, B:41:0x010b, B:43:0x010f, B:83:0x0059), top: B:7:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x010b A[Catch: all -> 0x0054, TryCatch #1 {all -> 0x0054, blocks: (B:8:0x002b, B:10:0x0038, B:12:0x003e, B:14:0x0045, B:16:0x004b, B:19:0x005c, B:22:0x00ec, B:25:0x0068, B:75:0x00b1, B:29:0x00cb, B:31:0x00d2, B:34:0x00db, B:37:0x00e6, B:39:0x00f5, B:41:0x010b, B:43:0x010f, B:83:0x0059), top: B:7:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0139  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void a(com.kwad.framework.filedownloader.b.a.InterfaceC0333a r30) {
        /*
            Method dump skipped, instructions count: 443
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.framework.filedownloader.download.b.a(com.kwad.framework.filedownloader.b.a$a):void");
    }
}

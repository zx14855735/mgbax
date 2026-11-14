package com.sigmob.sdk.downloader;

import com.sigmob.sdk.downloader.f;
import java.io.File;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class l {

    public enum a {
        PENDING,
        RUNNING,
        COMPLETED,
        IDLE,
        CANCELED,
        UNKNOWN;

        static {
            ESzou();
        }

        private static /* synthetic */ void ESzou() {
            char[] charArray = "\u008e\u0082\u0080Ã\u008a\u008c\u0080\u0088Ã\u008f\u0082\u0094Ã\u009e\u0085\u0088\u0081\u0081Ã§\u0083\u0084¯\u009f\u0084\u0089\u008a\u0088".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 237);
            }
            String str = new String(charArray);
            char[] charArray2 = "\u008e\u0081\u0084\u0083\u0084\u0099".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 237);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public static a a(String str, String str2, String str3) {
        return b(d(str, str2, str3));
    }

    public static a b(f fVar) {
        a d = d(fVar);
        a aVar = a.COMPLETED;
        if (d == aVar) {
            return aVar;
        }
        com.sigmob.sdk.downloader.core.dispatcher.b a2 = g.j().a();
        return a2.f(fVar) ? a.PENDING : a2.d(fVar) ? a.RUNNING : a2.e(fVar) ? a.CANCELED : d;
    }

    public static com.sigmob.sdk.downloader.core.breakpoint.c c(String str, String str2, String str3) {
        return e(d(str, str2, str3));
    }

    public static f d(String str, String str2, String str3) {
        return new f.a(str, str2, str3).a();
    }

    public static com.sigmob.sdk.downloader.core.breakpoint.c e(f fVar) {
        com.sigmob.sdk.downloader.core.breakpoint.g c = g.j().c();
        com.sigmob.sdk.downloader.core.breakpoint.c a2 = c.a(c.b(fVar));
        if (a2 == null) {
            return null;
        }
        return a2.p();
    }

    public static boolean a(f fVar) {
        return g.j().a().c(fVar) != null;
    }

    public static boolean b(String str, String str2, String str3) {
        return c(d(str, str2, str3));
    }

    public static boolean c(f fVar) {
        return d(fVar) == a.COMPLETED;
    }

    public static a d(f fVar) {
        com.sigmob.sdk.downloader.core.breakpoint.g c = g.j().c();
        com.sigmob.sdk.downloader.core.breakpoint.c a2 = c.a(fVar.c());
        String d = fVar.d();
        File l = fVar.l();
        File n = fVar.n();
        if (a2 != null) {
            if (!a2.b() && a2.j() <= 0) {
                return a.UNKNOWN;
            }
            if (n != null && n.equals(a2.o()) && n.exists() && a2.i() == a2.j()) {
                return a.COMPLETED;
            }
            if (d == null && a2.o() != null && a2.o().exists()) {
                return a.IDLE;
            }
            if (n != null && n.equals(a2.o()) && n.exists()) {
                return a.IDLE;
            }
        } else {
            if (c.a() || c.c(fVar.c())) {
                return a.UNKNOWN;
            }
            if (n != null && n.exists()) {
                return a.COMPLETED;
            }
            String a3 = c.a(fVar.i());
            if (a3 != null && new File(l, a3).exists()) {
                return a.COMPLETED;
            }
        }
        return a.UNKNOWN;
    }
}

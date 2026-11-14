package com.kwad.sdk.core.d;

import ADYaiT.CtFAbx;
import B4ZgIw.AYUAbz;
import android.util.Log;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;
import com.ksad.annotation.invoker.ForInvoker;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class c {
    public static boolean aIN = true;
    private static boolean aIO = com.kwad.sdk.core.d.a.oy.booleanValue();
    private static final com.kwad.sdk.core.d.a.a aIP = new b();
    private static final List<com.kwad.sdk.core.d.a.a> aIQ = new CopyOnWriteArrayList();

    public interface a {
        void b(com.kwad.sdk.core.d.a.a aVar);
    }

    static {
        cMLEy();
    }

    private static String Bn() {
        int i;
        String str;
        if (!aIO) {
            return "";
        }
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace.length > 3) {
            str = stackTrace[3].getFileName();
            i = stackTrace[3].getLineNumber();
        } else {
            i = -1;
            str = MediationConfigUserInfoForSegment.GENDER_UNKNOWN;
        }
        return "(" + str + ':' + i + ')';
    }

    @ForInvoker(methodId = "registerLogger")
    private static void Jq() {
        com.kwad.sdk.commercial.h.a.register();
    }

    private static void S(final String str, final String str2) {
        a(new a() { // from class: com.kwad.sdk.core.d.c.1
            @Override // com.kwad.sdk.core.d.c.a
            public final void b(com.kwad.sdk.core.d.a.a aVar) {
                aVar.d(str, str2);
            }
        });
    }

    private static void T(String str, String str2) {
        if (str2 == null || str2.length() <= 4000) {
            S(str, str2);
        } else {
            S(str, str2.substring(0, TTAdConstant.INIT_LOCAL_FAIL_CODE));
            T(str, str2.substring(TTAdConstant.INIT_LOCAL_FAIL_CODE));
        }
    }

    public static void U(final String str, String str2) {
        final String el = el(str2);
        a(new a() { // from class: com.kwad.sdk.core.d.c.5
            @Override // com.kwad.sdk.core.d.c.a
            public final void b(com.kwad.sdk.core.d.a.a aVar) {
                aVar.v(c.ek(str), el, true);
            }
        });
    }

    public static void a(com.kwad.sdk.core.d.a.a aVar) {
        List<com.kwad.sdk.core.d.a.a> list = aIQ;
        if (list.contains(aVar)) {
            return;
        }
        list.add(aVar);
    }

    private static /* synthetic */ void cMLEy() {
        char[] charArray = "1=?|53?7|0=+|!:7>>|\u0018<;\u0010 ;657".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'R');
        }
        String str = new String(charArray);
        char[] charArray2 = "1>;<;&".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'R');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void d(String str, String str2) {
        T(ek(str), el(str2));
    }

    public static void e(final String str, String str2) {
        final String el = el(str2);
        a(new a() { // from class: com.kwad.sdk.core.d.c.9
            @Override // com.kwad.sdk.core.d.c.a
            public final void b(com.kwad.sdk.core.d.a.a aVar) {
                aVar.e(c.ek(str), el);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String ek(String str) {
        return CtFAbx.BChYOn("KSAd_", str);
    }

    private static String el(String str) {
        StringBuilder A5SV6n2 = AYUAbz.A5SV6n(str, " ");
        A5SV6n2.append(Bn());
        return A5SV6n2.toString();
    }

    public static void i(final String str, String str2) {
        final String el = el(str2);
        a(new a() { // from class: com.kwad.sdk.core.d.c.6
            @Override // com.kwad.sdk.core.d.c.a
            public final void b(com.kwad.sdk.core.d.a.a aVar) {
                aVar.i(c.ek(str), el);
            }
        });
    }

    public static void init(boolean z) {
        aIN = z;
        List<com.kwad.sdk.core.d.a.a> list = aIQ;
        list.clear();
        list.add(aIP);
        Jq();
    }

    public static void printStackTrace(final Throwable th) {
        if (th != null) {
            a(new a() { // from class: com.kwad.sdk.core.d.c.2
                @Override // com.kwad.sdk.core.d.c.a
                public final void b(com.kwad.sdk.core.d.a.a aVar) {
                    aVar.printStackTraceOnly(th);
                }
            });
        }
        if (com.kwad.sdk.core.d.a.oy.booleanValue()) {
            throw new RuntimeException(th);
        }
    }

    public static void printStackTraceOnly(final Throwable th) {
        if (th != null) {
            a(new a() { // from class: com.kwad.sdk.core.d.c.3
                @Override // com.kwad.sdk.core.d.c.a
                public final void b(com.kwad.sdk.core.d.a.a aVar) {
                    aVar.printStackTraceOnly(th);
                }
            });
        }
    }

    public static void v(final String str, String str2) {
        final String el = el(str2);
        a(new a() { // from class: com.kwad.sdk.core.d.c.4
            @Override // com.kwad.sdk.core.d.c.a
            public final void b(com.kwad.sdk.core.d.a.a aVar) {
                aVar.v(c.ek(str), el);
            }
        });
    }

    public static void w(final String str, String str2) {
        final String el = el(str2);
        a(new a() { // from class: com.kwad.sdk.core.d.c.7
            @Override // com.kwad.sdk.core.d.c.a
            public final void b(com.kwad.sdk.core.d.a.a aVar) {
                aVar.w(c.ek(str), el);
            }
        });
    }

    public static void d(String str, Throwable th) {
        d(str, th.getMessage());
    }

    private static void a(a aVar) {
        for (com.kwad.sdk.core.d.a.a aVar2 : aIQ) {
            if (aVar2 != null) {
                try {
                    aVar.b(aVar2);
                } catch (Exception unused) {
                }
            }
        }
    }

    public static void e(final String str, String str2, Throwable th) {
        final String el = el(str2 + '\n' + Log.getStackTraceString(th));
        a(new a() { // from class: com.kwad.sdk.core.d.c.10
            @Override // com.kwad.sdk.core.d.c.a
            public final void b(com.kwad.sdk.core.d.a.a aVar) {
                aVar.e(c.ek(str), el);
            }
        });
    }

    public static void w(final String str, Throwable th) {
        final String el = el(Log.getStackTraceString(th));
        a(new a() { // from class: com.kwad.sdk.core.d.c.8
            @Override // com.kwad.sdk.core.d.c.a
            public final void b(com.kwad.sdk.core.d.a.a aVar) {
                aVar.w(c.ek(str), el, com.kwad.sdk.core.d.a.oy.booleanValue());
            }
        });
    }
}

package com.kwad.sdk.core.video.a;

import android.content.Context;
import com.kwad.sdk.core.report.g;
import com.kwad.sdk.core.report.n;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.av;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class e {
    private static AtomicBoolean aPi = null;
    private static int aPj = -1;
    private static final AtomicBoolean aPk = new AtomicBoolean(false);
    private static final AtomicBoolean aPl = new AtomicBoolean(false);
    private static int aPm;
    private static boolean adD;

    static {
        KQVL();
    }

    public static boolean Ft() {
        return aPl.get() || com.kwad.framework.a.a.Nt.booleanValue();
    }

    private static /* synthetic */ void KQVL() {
        char[] charArray = "¿³±ò»½±¹ò¾³¥ò¯´¹°°ò\u0096²µ\u009e®µ¸»¹".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 220);
        }
        String str = new String(charArray);
        char[] charArray2 = "¿°µ²µ¨".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 220);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static int LS() {
        return aPm;
    }

    public static boolean LT() {
        AtomicBoolean atomicBoolean = aPi;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        AtomicBoolean atomicBoolean2 = new AtomicBoolean(true);
        aPi = atomicBoolean2;
        return atomicBoolean2.get();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static c a(Context context, boolean z, boolean z2, boolean z3, int i) {
        boolean z4;
        b bVar;
        b bVar2;
        try {
            if (Ft() && z2 && LT()) {
                com.kwad.sdk.core.d.c.i("MediaPlayerImpl", "constructPlayer KwaiMediaPlayer");
                d dVar = new d(i);
                aPm = 2;
                dVar.by(z);
                bVar2 = dVar;
            } else {
                com.kwad.sdk.core.d.c.i("MediaPlayerImpl", "constructPlayer AndroidMediaPlayer");
                b bVar3 = new b();
                aPm = 1;
                bVar2 = bVar3;
            }
            z4 = false;
            bVar = bVar2;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.e("MediaPlayerImpl", "constructPlayer exception, using AndroidMediaPlayer", th);
            if (!adD) {
                adD = true;
                com.kwad.sdk.service.d.gatherException(th);
            }
            b bVar4 = new b();
            aPm = 1;
            z4 = true;
            bVar = bVar4;
        }
        int a2 = av.a(Ft(), ServiceProvider.get(com.kwad.sdk.service.a.f.class) != null && ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).CT(), z2, LT(), z4, z3, bVar.getMediaPlayerType());
        com.kwad.sdk.core.d.c.U("KwaiPlayHelper", "player v=" + Integer.toBinaryString(a2));
        if (aPj != a2) {
            aPj = a2;
            ed(a2);
        }
        return bVar;
    }

    private static void ed(int i) {
        n nVar = new n(10212L);
        nVar.aLX = i;
        g.a2(nVar);
    }
}

package com.kwad.sdk.utils.a;

import ADYaiT.CtFAbx;
import android.content.Context;
import android.util.Log;
import com.kwad.sdk.utils.a.c;
import com.kwad.sdk.utils.w;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class e {
    static ExecutorService aYa = Executors.newSingleThreadExecutor();
    static boolean beB = init();

    static {
        szFLJZ();
    }

    public static c aB(Context context, String str) {
        if (!beB) {
            init();
        }
        return new c.a(w.R(context, "ks_union"), str).UB();
    }

    private static boolean init() {
        d.setExecutor(aYa);
        d.a(new c.d() { // from class: com.kwad.sdk.utils.a.e.1
            @Override // com.kwad.sdk.utils.a.c.d
            public final void a(String str, Exception exc) {
                StringBuilder B3GDIM2 = CtFAbx.B3GDIM("name:", str, " msg:");
                B3GDIM2.append(Log.getStackTraceString(exc));
                com.kwad.sdk.core.d.c.w("UnionKv", B3GDIM2.toString());
            }

            @Override // com.kwad.sdk.utils.a.c.d
            public final void e(String str, Throwable th) {
                StringBuilder B3GDIM2 = CtFAbx.B3GDIM("name:", str, " msg:");
                B3GDIM2.append(Log.getStackTraceString(th));
                com.kwad.sdk.core.d.c.e("UnionKv", B3GDIM2.toString());
            }

            @Override // com.kwad.sdk.utils.a.c.d
            public final void i(String str, String str2) {
                com.kwad.sdk.core.d.c.i("UnionKv", "name:" + str + " msg:" + str2);
            }
        });
        beB = true;
        return true;
    }

    private static /* synthetic */ void szFLJZ() {
        char[] charArray = "ÙÕ×\u0094ÝÛ×ß\u0094ØÕÃ\u0094ÉÒßÖÖ\u0094ðÔÓøÈÓÞÝß".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 186);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÙÖÓÔÓÎ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 186);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}

package com.kwad.components.core.widget;

import android.graphics.Color;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class e {
    public static final int ane = Color.parseColor("#FFFE3666");
    private int anf = ane;

    static {
        MrmXkQ();
    }

    private static /* synthetic */ void MrmXkQ() {
        char[] charArray = "áíï¬åãïç¬àíû¬ñêçîî¬ÈìëÀðëæåç".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 130);
        }
        String str = new String(charArray);
        char[] charArray2 = "áîëìëö".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 130);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final int xG() {
        return this.anf;
    }
}

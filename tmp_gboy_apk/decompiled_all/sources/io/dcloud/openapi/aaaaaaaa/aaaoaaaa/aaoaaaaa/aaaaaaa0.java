package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaoaaaaa;

import android.content.Context;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.acaaaaaa.aaaaaaan;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class aaaaaaa0 {
    private static List aaaaaaa0 = new ArrayList();
    private static aaaaaaa0 aaaaaaaa;

    static {
        AuCi();
    }

    private aaaaaaa0() {
    }

    private static /* synthetic */ void AuCi() {
        char[] charArray = "¾²°óº¼°¸ó¿²¤ó®µ¸±±ó\u0097³´\u009f¯´¹º¸".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 221);
        }
        String str = new String(charArray);
        char[] charArray2 = "¾±´³´©".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 221);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static aaaaaaa0 aaaaaaaa(Context context) {
        if (aaaaaaaa == null) {
            synchronized (aaaaaaa0.class) {
                try {
                    if (aaaaaaaa == null) {
                        aaaaaaaa = new aaaaaaa0();
                    }
                } finally {
                }
            }
        }
        return aaaaaaaa;
    }

    public void aaaaaaa0(aaaaaaaa aaaaaaaaVar) {
        aaaaaaa0.remove(aaaaaaaaVar);
    }

    public void aaaaaaaa(aaaaaaaa aaaaaaaaVar) {
        aaaaaaa0.add(aaaaaaaaVar);
        aaaaaaan.aaaaaaaa().aaaaaaaa(aaaaaaaaVar);
    }

    public List aaaaaaaa() {
        return aaaaaaa0;
    }
}

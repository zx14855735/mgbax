package com.kwad.components.ad.reward;

import com.kwad.sdk.core.response.model.AdTemplate;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class i {
    private Map<String, List<AdTemplate>> te;

    public static class a {
        private static final i tf = new i(0);

        static {
            Zril();
        }

        private static /* synthetic */ void Zril() {
            char[] charArray = "óÿý¾÷ñýõ¾òÿé¾ãøõüü¾ÚþùÒâùô÷õ".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 144);
            }
            String str = new String(charArray);
            char[] charArray2 = "óüùþùä".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 144);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public /* synthetic */ i(byte b) {
        this();
    }

    public static i ht() {
        return a.tf;
    }

    public final void H(String str) {
        this.te.remove(str);
    }

    private i() {
        this.te = new ConcurrentHashMap();
    }
}

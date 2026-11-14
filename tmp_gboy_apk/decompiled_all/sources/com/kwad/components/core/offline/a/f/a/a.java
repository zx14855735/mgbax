package com.kwad.components.core.offline.a.f.a;

import com.kwad.sdk.core.response.model.AdResultData;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class a {
    private static final Map<Integer, WeakReference<AdResultData>> ST = new HashMap();

    static {
        eMEWQ();
    }

    public static void a(int i, AdResultData adResultData) {
        if (adResultData == null) {
            return;
        }
        ST.put(Integer.valueOf(i), new WeakReference<>(adResultData));
    }

    public static AdResultData aK(int i) {
        WeakReference<AdResultData> weakReference = ST.get(Integer.valueOf(i));
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return weakReference.get();
    }

    private static /* synthetic */ void eMEWQ() {
        char[] charArray = "ôøú¹ðöúò¹õøî¹äÿòûû¹ÝùþÕåþóðò".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 151);
        }
        String str = new String(charArray);
        char[] charArray2 = "ôûþùþã".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 151);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}

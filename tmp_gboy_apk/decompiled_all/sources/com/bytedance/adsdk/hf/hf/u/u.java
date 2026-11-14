package com.bytedance.adsdk.hf.hf.u;

import com.sigmob.sdk.base.views.r;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public enum u implements kd {
    LEFT_PAREN("("),
    RIGHT_PAREN(")"),
    LEFT_BRACKET("["),
    RIGHT_BRACKET("]"),
    COMMA(",");

    private static final Map<String, u> y;
    private final String c;

    static {
        HashMap hashMap = new HashMap(r.b.d);
        y = hashMap;
        for (u uVar : hashMap.values()) {
            y.put(uVar.xj(), uVar);
        }
        KMAkTI();
    }

    u(String str) {
        this.c = str;
    }

    private static /* synthetic */ void KMAkTI() {
        char[] charArray = "MAC\u0000IOCK\u0000LAW\u0000]FKBB\u0000d@Gl\\GJIK".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '.');
        }
        String str = new String(charArray);
        char[] charArray2 = "MBG@GZ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '.');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static boolean xj(kd kdVar) {
        return kdVar instanceof u;
    }

    public String xj() {
        return this.c;
    }
}

package com.bytedance.adsdk.hf.hf.u;

import com.sigmob.sdk.base.views.r;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public enum w implements kd {
    QUESTION("?", 0),
    COLON(":", 0),
    DOUBLE_AMP("&&", 1),
    DOUBLE_BAR("||", 1),
    EQ("==", 2),
    GT(">", 2),
    LT("<", 2),
    LT_EQ("<=", 2),
    GT_EQ(">=", 2),
    NOT_EQ("!=", 2),
    PLUS("+", 3),
    MINUS("-", 3),
    MULTI("*", 4),
    DIVISION("/", 4),
    MOD("%", 4);

    private final int v;
    private final String yo;
    private static final Map<String, w> zg = new HashMap(r.b.d);
    private static final Set<w> e = new HashSet();

    static {
        for (w wVar : values()) {
            zg.put(wVar.xj(), wVar);
            e.add(wVar);
        }
        SqyWT();
    }

    w(String str, int i) {
        this.yo = str;
        this.v = i;
    }

    private static /* synthetic */ void SqyWT() {
        char[] charArray = "$(*i &*\"i%(>i4/\"++i\r).\u00055.# \"".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'G');
        }
        String str = new String(charArray);
        char[] charArray2 = "$+.).3".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'G');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static w xj(String str) {
        return zg.get(str);
    }

    public int hf() {
        return this.v;
    }

    public static boolean xj(kd kdVar) {
        return kdVar instanceof w;
    }

    public String xj() {
        return this.yo;
    }
}

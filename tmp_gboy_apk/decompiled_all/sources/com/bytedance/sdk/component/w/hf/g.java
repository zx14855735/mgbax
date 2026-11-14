package com.bytedance.sdk.component.w.hf;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public interface g {
    public static final g xj = new g() { // from class: com.bytedance.sdk.component.w.hf.g.1
        @Override // com.bytedance.sdk.component.w.hf.g
        public List<pl> xj(v vVar) {
            return Collections.EMPTY_LIST;
        }
    };

    static {
        QMscktC();
    }

    private static /* synthetic */ void QMscktC() {
        char[] charArray = "zvt7~xt|7{v`7jq|uu7Swp[kp}~|".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 25);
        }
        String str = new String(charArray);
        char[] charArray2 = "zupwpm".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 25);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    List<pl> xj(v vVar);
}

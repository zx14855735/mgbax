package com.bytedance.sdk.openadsdk.core.component.reward.xj;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.pz;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf extends w {
    private static final hf hf = new hf(pz.getContext());

    static {
        yVONrX();
    }

    private hf(Context context) {
        super(context);
    }

    public static hf xj() {
        return hf;
    }

    private static /* synthetic */ void yVONrX() {
        char[] charArray = "L@B\u0001HNBJ\u0001M@V\u0001\\GJCC\u0001eAFm]FKHJ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '/');
        }
        String str = new String(charArray);
        char[] charArray2 = "LCFAF[".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '/');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.xj.w
    public int hf() {
        return 8;
    }
}

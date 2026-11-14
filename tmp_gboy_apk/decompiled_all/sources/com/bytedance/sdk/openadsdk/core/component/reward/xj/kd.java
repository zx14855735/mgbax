package com.bytedance.sdk.openadsdk.core.component.reward.xj;

import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.f;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class kd {
    private static final com.bytedance.sdk.openadsdk.core.kd.w.xj xj = new com.bytedance.sdk.openadsdk.core.kd.w.hf(7);
    private static final com.bytedance.sdk.openadsdk.core.kd.w.xj hf = new com.bytedance.sdk.openadsdk.core.kd.w.hf(8);
    private static final com.bytedance.sdk.openadsdk.core.kd.w.xj w = new com.bytedance.sdk.openadsdk.core.kd.w.kd(7);
    private static final com.bytedance.sdk.openadsdk.core.kd.w.xj u = new com.bytedance.sdk.openadsdk.core.kd.w.kd(8);
    private static final com.bytedance.sdk.openadsdk.core.kd.w.xj kd = new com.bytedance.sdk.openadsdk.core.kd.w.u(7);
    private static final com.bytedance.sdk.openadsdk.core.kd.w.xj y = new com.bytedance.sdk.openadsdk.core.kd.w.u(8);
    private static final com.bytedance.sdk.openadsdk.core.kd.w.xj c = new com.bytedance.sdk.openadsdk.core.kd.w.w(7);
    private static final com.bytedance.sdk.openadsdk.core.kd.w.xj f = new com.bytedance.sdk.openadsdk.core.kd.w.w(8);

    static {
        yPZL();
    }

    public static int xj(boolean z) {
        f.hf xj2 = com.bytedance.sdk.openadsdk.core.ra.f.xj(z ? 7 : 8);
        if (!xj2.c() || !pz.hf().ie()) {
            return -1;
        }
        int u2 = xj2.u();
        if (u2 < 0 || u2 == 2 || u2 > 4) {
            return 1;
        }
        return u2;
    }

    private static /* synthetic */ void yPZL() {
        char[] charArray = "\u0012\u001e\u001c_\u0016\u0010\u001c\u0014_\u0013\u001e\b_\u0002\u0019\u0014\u001d\u001d_;\u001f\u00183\u0003\u0018\u0015\u0016\u0014".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'q');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0012\u001d\u0018\u001f\u0018\u0005".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'q');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static com.bytedance.sdk.openadsdk.core.kd.w.xj xj(boolean z, boolean z2) {
        if (z2) {
            return z ? c : f;
        }
        int xj2 = xj(z);
        return xj2 != -1 ? xj2 != 0 ? xj2 != 3 ? z ? w : u : z ? kd : y : z ? xj : hf : z ? c : f;
    }
}

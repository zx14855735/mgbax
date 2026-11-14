package com.bytedance.adsdk.lottie.model.hf;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class f {
    private final com.bytedance.adsdk.lottie.model.xj.f hf;
    private final boolean u;
    private final com.bytedance.adsdk.lottie.model.xj.u w;
    private final xj xj;

    public enum xj {
        MASK_MODE_ADD,
        MASK_MODE_SUBTRACT,
        MASK_MODE_INTERSECT,
        MASK_MODE_NONE;

        static {
            pRFEnP();
        }

        private static /* synthetic */ void pRFEnP() {
            char[] charArray = "ÎÂÀ\u0083ÊÌÀÈ\u0083ÏÂÔ\u0083ÞÅÈÁÁ\u0083çÃÄïßÄÉÊÈ".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 173);
            }
            String str = new String(charArray);
            char[] charArray2 = "ÎÁÄÃÄÙ".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 173);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public f(xj xjVar, com.bytedance.adsdk.lottie.model.xj.f fVar, com.bytedance.adsdk.lottie.model.xj.u uVar, boolean z) {
        this.xj = xjVar;
        this.hf = fVar;
        this.w = uVar;
        this.u = z;
    }

    public com.bytedance.adsdk.lottie.model.xj.f hf() {
        return this.hf;
    }

    public boolean u() {
        return this.u;
    }

    public com.bytedance.adsdk.lottie.model.xj.u w() {
        return this.w;
    }

    public xj xj() {
        return this.xj;
    }
}

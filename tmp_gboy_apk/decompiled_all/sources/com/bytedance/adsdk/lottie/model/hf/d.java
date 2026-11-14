package com.bytedance.adsdk.lottie.model.hf;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class d implements w {
    private final xj hf;
    private final boolean w;
    private final String xj;

    public enum xj {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;

        static {
            hTTiU();
        }

        private static /* synthetic */ void hTTiU() {
            char[] charArray = "îâà£êìàè£ïâô£þåèáá£ÇãäÏÿäéêè".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 141);
            }
            String str = new String(charArray);
            char[] charArray2 = "îáäãäù".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 141);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        public static xj xj(int i) {
            return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? MERGE : EXCLUDE_INTERSECTIONS : INTERSECT : SUBTRACT : ADD : MERGE;
        }
    }

    public d(String str, xj xjVar, boolean z) {
        this.xj = str;
        this.hf = xjVar;
        this.w = z;
    }

    public xj hf() {
        return this.hf;
    }

    public String toString() {
        return "MergePaths{mode=" + this.hf + '}';
    }

    public boolean w() {
        return this.w;
    }

    public String xj() {
        return this.xj;
    }

    @Override // com.bytedance.adsdk.lottie.model.hf.w
    public com.bytedance.adsdk.lottie.xj.xj.w xj(com.bytedance.adsdk.lottie.f fVar, com.bytedance.adsdk.lottie.y yVar, com.bytedance.adsdk.lottie.model.layer.w wVar) {
        return new com.bytedance.adsdk.lottie.xj.xj.pl(this);
    }
}

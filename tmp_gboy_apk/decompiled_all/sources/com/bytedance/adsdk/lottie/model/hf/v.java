package com.bytedance.adsdk.lottie.model.hf;

import com.bytedance.adsdk.lottie.xj.xj.pz;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class v implements w {
    private final xj hf;
    private final com.bytedance.adsdk.lottie.model.xj.hf kd;
    private final com.bytedance.adsdk.lottie.model.xj.hf u;
    private final com.bytedance.adsdk.lottie.model.xj.hf w;
    private final String xj;
    private final boolean y;

    public enum xj {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        static {
            PzpnkZ();
        }

        private static /* synthetic */ void PzpnkZ() {
            char[] charArray = ";75v?95=v:7!v+0=44v\u001261\u001a*1<?=".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 'X');
            }
            String str = new String(charArray);
            char[] charArray2 = ";4161,".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 'X');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        public static xj xj(int i) {
            if (i == 1) {
                return SIMULTANEOUSLY;
            }
            if (i == 2) {
                return INDIVIDUALLY;
            }
            throw new IllegalArgumentException("Unknown trim path type ".concat(String.valueOf(i)));
        }
    }

    public v(String str, xj xjVar, com.bytedance.adsdk.lottie.model.xj.hf hfVar, com.bytedance.adsdk.lottie.model.xj.hf hfVar2, com.bytedance.adsdk.lottie.model.xj.hf hfVar3, boolean z) {
        this.xj = str;
        this.hf = xjVar;
        this.w = hfVar;
        this.u = hfVar2;
        this.kd = hfVar3;
        this.y = z;
    }

    public xj getType() {
        return this.hf;
    }

    public com.bytedance.adsdk.lottie.model.xj.hf hf() {
        return this.u;
    }

    public boolean kd() {
        return this.y;
    }

    public String toString() {
        return "Trim Path: {start: " + this.w + ", end: " + this.u + ", offset: " + this.kd + "}";
    }

    public com.bytedance.adsdk.lottie.model.xj.hf u() {
        return this.kd;
    }

    public com.bytedance.adsdk.lottie.model.xj.hf w() {
        return this.w;
    }

    public String xj() {
        return this.xj;
    }

    @Override // com.bytedance.adsdk.lottie.model.hf.w
    public com.bytedance.adsdk.lottie.xj.xj.w xj(com.bytedance.adsdk.lottie.f fVar, com.bytedance.adsdk.lottie.y yVar, com.bytedance.adsdk.lottie.model.layer.w wVar) {
        return new pz(wVar, this);
    }
}

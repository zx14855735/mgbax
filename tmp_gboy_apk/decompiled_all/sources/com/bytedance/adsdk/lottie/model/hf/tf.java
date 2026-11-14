package com.bytedance.adsdk.lottie.model.hf;

import android.graphics.PointF;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class tf implements w {
    private final com.bytedance.adsdk.lottie.model.xj.hf c;
    private final com.bytedance.adsdk.lottie.model.xj.hf d;
    private final com.bytedance.adsdk.lottie.model.xj.hf f;
    private final xj hf;
    private final com.bytedance.adsdk.lottie.model.xj.hf kd;
    private final boolean p;
    private final boolean tf;
    private final com.bytedance.adsdk.lottie.model.xj.g<PointF, PointF> u;
    private final com.bytedance.adsdk.lottie.model.xj.hf w;
    private final String xj;
    private final com.bytedance.adsdk.lottie.model.xj.hf y;

    public enum xj {
        STAR(1),
        POLYGON(2);

        private final int w;

        static {
            ApQhwfE();
        }

        xj(int i) {
            this.w = i;
        }

        private static /* synthetic */ void ApQhwfE() {
            char[] charArray = "kge&oiem&jgq&{`mdd&BfaJzalom".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ '\b');
            }
            String str = new String(charArray);
            char[] charArray2 = "kdafa|".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ '\b');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        public static xj xj(int i) {
            for (xj xjVar : values()) {
                if (xjVar.w == i) {
                    return xjVar;
                }
            }
            return null;
        }
    }

    public tf(String str, xj xjVar, com.bytedance.adsdk.lottie.model.xj.hf hfVar, com.bytedance.adsdk.lottie.model.xj.g<PointF, PointF> gVar, com.bytedance.adsdk.lottie.model.xj.hf hfVar2, com.bytedance.adsdk.lottie.model.xj.hf hfVar3, com.bytedance.adsdk.lottie.model.xj.hf hfVar4, com.bytedance.adsdk.lottie.model.xj.hf hfVar5, com.bytedance.adsdk.lottie.model.xj.hf hfVar6, boolean z, boolean z2) {
        this.xj = str;
        this.hf = xjVar;
        this.w = hfVar;
        this.u = gVar;
        this.kd = hfVar2;
        this.y = hfVar3;
        this.c = hfVar4;
        this.f = hfVar5;
        this.d = hfVar6;
        this.tf = z;
        this.p = z2;
    }

    public com.bytedance.adsdk.lottie.model.xj.hf c() {
        return this.f;
    }

    public boolean d() {
        return this.tf;
    }

    public com.bytedance.adsdk.lottie.model.xj.hf f() {
        return this.d;
    }

    public xj getType() {
        return this.hf;
    }

    public com.bytedance.adsdk.lottie.model.xj.hf hf() {
        return this.w;
    }

    public com.bytedance.adsdk.lottie.model.xj.hf kd() {
        return this.y;
    }

    public boolean tf() {
        return this.p;
    }

    public com.bytedance.adsdk.lottie.model.xj.hf u() {
        return this.kd;
    }

    public com.bytedance.adsdk.lottie.model.xj.g<PointF, PointF> w() {
        return this.u;
    }

    public String xj() {
        return this.xj;
    }

    public com.bytedance.adsdk.lottie.model.xj.hf y() {
        return this.c;
    }

    @Override // com.bytedance.adsdk.lottie.model.hf.w
    public com.bytedance.adsdk.lottie.xj.xj.w xj(com.bytedance.adsdk.lottie.f fVar, com.bytedance.adsdk.lottie.y yVar, com.bytedance.adsdk.lottie.model.layer.w wVar) {
        return new com.bytedance.adsdk.lottie.xj.xj.am(fVar, wVar, this);
    }
}

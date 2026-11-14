package com.bytedance.adsdk.lottie.model.hf;

import android.graphics.Paint;
import com.bytedance.adsdk.lottie.xj.xj.jk;
import java.lang.reflect.Method;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class yo implements w {
    private final xj c;
    private final float d;
    private final hf f;
    private final com.bytedance.adsdk.lottie.model.xj.hf hf;
    private final com.bytedance.adsdk.lottie.model.xj.u kd;
    private final boolean tf;
    private final com.bytedance.adsdk.lottie.model.xj.xj u;
    private final List<com.bytedance.adsdk.lottie.model.xj.hf> w;
    private final String xj;
    private final com.bytedance.adsdk.lottie.model.xj.hf y;

    /* renamed from: com.bytedance.adsdk.lottie.model.hf.yo$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] hf;
        static final /* synthetic */ int[] xj;

        static {
            int[] iArr = new int[hf.values().length];
            hf = iArr;
            try {
                iArr[hf.BEVEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                hf[hf.MITER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                hf[hf.ROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[xj.values().length];
            xj = iArr2;
            try {
                iArr2[xj.BUTT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                xj[xj.ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                xj[xj.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public enum hf {
        MITER,
        ROUND,
        BEVEL;

        static {
            yiihVeM();
        }

        private static /* synthetic */ void yiihVeM() {
            char[] charArray = "#/-n'!-%n\"/9n3(%,,n\n.)\u00022)$'%".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ '@');
            }
            String str = new String(charArray);
            char[] charArray2 = "#,).)4".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ '@');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        public Paint.Join xj() {
            int i = AnonymousClass1.hf[ordinal()];
            if (i == 1) {
                return Paint.Join.BEVEL;
            }
            if (i == 2) {
                return Paint.Join.MITER;
            }
            if (i != 3) {
                return null;
            }
            return Paint.Join.ROUND;
        }
    }

    public enum xj {
        BUTT,
        ROUND,
        UNKNOWN;

        static {
            kRJfkz();
        }

        private static /* synthetic */ void kRJfkz() {
            char[] charArray = "~rp3z|px3\u007frd3nuxqq3Wst_otyzx".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 29);
            }
            String str = new String(charArray);
            char[] charArray2 = "~qtsti".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 29);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        public Paint.Cap xj() {
            int i = AnonymousClass1.xj[ordinal()];
            return i != 1 ? i != 2 ? Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT;
        }
    }

    public yo(String str, com.bytedance.adsdk.lottie.model.xj.hf hfVar, List<com.bytedance.adsdk.lottie.model.xj.hf> list, com.bytedance.adsdk.lottie.model.xj.xj xjVar, com.bytedance.adsdk.lottie.model.xj.u uVar, com.bytedance.adsdk.lottie.model.xj.hf hfVar2, xj xjVar2, hf hfVar3, float f, boolean z) {
        this.xj = str;
        this.hf = hfVar;
        this.w = list;
        this.u = xjVar;
        this.kd = uVar;
        this.y = hfVar2;
        this.c = xjVar2;
        this.f = hfVar3;
        this.d = f;
        this.tf = z;
    }

    public xj c() {
        return this.c;
    }

    public float d() {
        return this.d;
    }

    public hf f() {
        return this.f;
    }

    public com.bytedance.adsdk.lottie.model.xj.xj hf() {
        return this.u;
    }

    public List<com.bytedance.adsdk.lottie.model.xj.hf> kd() {
        return this.w;
    }

    public boolean tf() {
        return this.tf;
    }

    public com.bytedance.adsdk.lottie.model.xj.hf u() {
        return this.y;
    }

    public com.bytedance.adsdk.lottie.model.xj.u w() {
        return this.kd;
    }

    @Override // com.bytedance.adsdk.lottie.model.hf.w
    public com.bytedance.adsdk.lottie.xj.xj.w xj(com.bytedance.adsdk.lottie.f fVar, com.bytedance.adsdk.lottie.y yVar, com.bytedance.adsdk.lottie.model.layer.w wVar) {
        return new jk(fVar, wVar, this);
    }

    public com.bytedance.adsdk.lottie.model.xj.hf y() {
        return this.hf;
    }

    public String xj() {
        return this.xj;
    }
}

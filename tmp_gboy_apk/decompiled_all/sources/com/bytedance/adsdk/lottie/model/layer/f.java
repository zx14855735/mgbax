package com.bytedance.adsdk.lottie.model.layer;

import B4ZgIw.AYUAbz;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class f {
    private final float am;
    private final String c;
    private final com.bytedance.adsdk.lottie.model.xj.pl d;
    private final com.bytedance.adsdk.lottie.u.tf dk;
    private final com.bytedance.adsdk.lottie.model.xj.tf e;
    private final List<com.bytedance.adsdk.lottie.model.hf.f> f;
    private final float g;
    private final com.bytedance.adsdk.lottie.y hf;
    private final boolean ht;
    private final List<com.bytedance.adsdk.lottie.y.xj<Float>> jk;
    private final xj kd;
    private final int p;

    /* renamed from: pl, reason: collision with root package name */
    private final int f10046pl;
    private final hf pz;
    private final float qt;
    private final com.bytedance.adsdk.lottie.model.hf.xj ra;
    private final int tf;
    private final long u;
    private final com.bytedance.adsdk.lottie.model.xj.hf v;
    private final String w;
    private final List<com.bytedance.adsdk.lottie.model.hf.w> xj;
    private final long y;
    private final com.bytedance.adsdk.lottie.model.xj.p yo;
    private final float zg;

    public enum hf {
        NONE,
        ADD,
        INVERT,
        LUMA,
        LUMA_INVERTED,
        UNKNOWN;

        static {
            JwMgyEz();
        }

        private static /* synthetic */ void JwMgyEz() {
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
    }

    public enum xj {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN;

        static {
            Nbxgk();
        }

        private static /* synthetic */ void Nbxgk() {
            char[] charArray = "\u0018\u0014\u0016U\u001c\u001a\u0016\u001eU\u0019\u0014\u0002U\b\u0013\u001e\u0017\u0017U1\u0015\u00129\t\u0012\u001f\u001c\u001e".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ '{');
            }
            String str = new String(charArray);
            char[] charArray2 = "\u0018\u0017\u0012\u0015\u0012\u000f".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ '{');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public f(List<com.bytedance.adsdk.lottie.model.hf.w> list, com.bytedance.adsdk.lottie.y yVar, String str, long j, xj xjVar, long j2, String str2, List<com.bytedance.adsdk.lottie.model.hf.f> list2, com.bytedance.adsdk.lottie.model.xj.pl plVar, int i, int i2, int i3, float f, float f2, float f3, float f4, com.bytedance.adsdk.lottie.model.xj.tf tfVar, com.bytedance.adsdk.lottie.model.xj.p pVar, List<com.bytedance.adsdk.lottie.y.xj<Float>> list3, hf hfVar, com.bytedance.adsdk.lottie.model.xj.hf hfVar2, boolean z, com.bytedance.adsdk.lottie.model.hf.xj xjVar2, com.bytedance.adsdk.lottie.u.tf tfVar2) {
        this.xj = list;
        this.hf = yVar;
        this.w = str;
        this.u = j;
        this.kd = xjVar;
        this.y = j2;
        this.c = str2;
        this.f = list2;
        this.d = plVar;
        this.tf = i;
        this.p = i2;
        this.f10046pl = i3;
        this.g = f;
        this.am = f2;
        this.qt = f3;
        this.zg = f4;
        this.e = tfVar;
        this.yo = pVar;
        this.jk = list3;
        this.pz = hfVar;
        this.v = hfVar2;
        this.ht = z;
        this.ra = xjVar2;
        this.dk = tfVar2;
    }

    public List<com.bytedance.adsdk.lottie.model.hf.w> am() {
        return this.xj;
    }

    public String c() {
        return this.c;
    }

    public float d() {
        return this.zg;
    }

    public com.bytedance.adsdk.lottie.u.tf dk() {
        return this.dk;
    }

    public int e() {
        return this.p;
    }

    public float f() {
        return this.qt;
    }

    public long g() {
        return this.y;
    }

    public float hf() {
        return this.g;
    }

    public boolean ht() {
        return this.ht;
    }

    public com.bytedance.adsdk.lottie.model.xj.p jk() {
        return this.yo;
    }

    public long kd() {
        return this.u;
    }

    public xj p() {
        return this.kd;
    }

    public hf pl() {
        return this.pz;
    }

    public com.bytedance.adsdk.lottie.model.xj.hf pz() {
        return this.v;
    }

    public com.bytedance.adsdk.lottie.model.xj.pl qt() {
        return this.d;
    }

    public com.bytedance.adsdk.lottie.model.hf.xj ra() {
        return this.ra;
    }

    public List<com.bytedance.adsdk.lottie.model.hf.f> tf() {
        return this.f;
    }

    public String toString() {
        return xj("");
    }

    public List<com.bytedance.adsdk.lottie.y.xj<Float>> u() {
        return this.jk;
    }

    public com.bytedance.adsdk.lottie.model.xj.tf v() {
        return this.e;
    }

    public float w() {
        return this.am / this.hf.yo();
    }

    public String xj(String str) {
        StringBuilder A4TApA2 = AYUAbz.A4TApA(str);
        A4TApA2.append(y());
        A4TApA2.append("\n");
        f xj2 = this.hf.xj(g());
        if (xj2 != null) {
            A4TApA2.append("\t\tParents: ");
            A4TApA2.append(xj2.y());
            f xj3 = this.hf.xj(xj2.g());
            while (xj3 != null) {
                A4TApA2.append("->");
                A4TApA2.append(xj3.y());
                xj3 = this.hf.xj(xj3.g());
            }
            A4TApA2.append(str);
            A4TApA2.append("\n");
        }
        if (!tf().isEmpty()) {
            A4TApA2.append(str);
            A4TApA2.append("\tMasks: ");
            A4TApA2.append(tf().size());
            A4TApA2.append("\n");
        }
        if (yo() != 0 && e() != 0) {
            A4TApA2.append(str);
            A4TApA2.append("\tBackground: ");
            A4TApA2.append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(yo()), Integer.valueOf(e()), Integer.valueOf(zg())));
        }
        if (!this.xj.isEmpty()) {
            A4TApA2.append(str);
            A4TApA2.append("\tShapes:\n");
            for (com.bytedance.adsdk.lottie.model.hf.w wVar : this.xj) {
                A4TApA2.append(str);
                A4TApA2.append("\t\t");
                A4TApA2.append(wVar);
                A4TApA2.append("\n");
            }
        }
        return A4TApA2.toString();
    }

    public String y() {
        return this.w;
    }

    public int yo() {
        return this.tf;
    }

    public int zg() {
        return this.f10046pl;
    }

    public com.bytedance.adsdk.lottie.y xj() {
        return this.hf;
    }
}

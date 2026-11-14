package com.octopus.ad.internal.video;

import android.graphics.Matrix;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private c f12537a;
    private c b;

    /* renamed from: com.octopus.ad.internal.video.a$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12538a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[EnumC0416a.values().length];
            b = iArr;
            try {
                iArr[EnumC0416a.LEFT_TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[EnumC0416a.LEFT_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[EnumC0416a.LEFT_BOTTOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[EnumC0416a.CENTER_TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[EnumC0416a.CENTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[EnumC0416a.CENTER_BOTTOM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[EnumC0416a.RIGHT_TOP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                b[EnumC0416a.RIGHT_CENTER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                b[EnumC0416a.RIGHT_BOTTOM.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            int[] iArr2 = new int[b.values().length];
            f12538a = iArr2;
            try {
                iArr2[b.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f12538a[b.FIT_XY.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f12538a[b.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f12538a[b.FIT_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f12538a[b.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f12538a[b.LEFT_TOP.ordinal()] = 6;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f12538a[b.LEFT_CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f12538a[b.LEFT_BOTTOM.ordinal()] = 8;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f12538a[b.CENTER_TOP.ordinal()] = 9;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f12538a[b.CENTER.ordinal()] = 10;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f12538a[b.CENTER_BOTTOM.ordinal()] = 11;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f12538a[b.RIGHT_TOP.ordinal()] = 12;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f12538a[b.RIGHT_CENTER.ordinal()] = 13;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f12538a[b.RIGHT_BOTTOM.ordinal()] = 14;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f12538a[b.LEFT_TOP_CROP.ordinal()] = 15;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f12538a[b.LEFT_CENTER_CROP.ordinal()] = 16;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f12538a[b.LEFT_BOTTOM_CROP.ordinal()] = 17;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f12538a[b.CENTER_TOP_CROP.ordinal()] = 18;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                f12538a[b.CENTER_CROP.ordinal()] = 19;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                f12538a[b.CENTER_BOTTOM_CROP.ordinal()] = 20;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                f12538a[b.RIGHT_TOP_CROP.ordinal()] = 21;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                f12538a[b.RIGHT_CENTER_CROP.ordinal()] = 22;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                f12538a[b.RIGHT_BOTTOM_CROP.ordinal()] = 23;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                f12538a[b.START_INSIDE.ordinal()] = 24;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                f12538a[b.CENTER_INSIDE.ordinal()] = 25;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                f12538a[b.END_INSIDE.ordinal()] = 26;
            } catch (NoSuchFieldError unused35) {
            }
        }
    }

    /* renamed from: com.octopus.ad.internal.video.a$a, reason: collision with other inner class name */
    public enum EnumC0416a {
        LEFT_TOP,
        LEFT_CENTER,
        LEFT_BOTTOM,
        CENTER_TOP,
        CENTER,
        CENTER_BOTTOM,
        RIGHT_TOP,
        RIGHT_CENTER,
        RIGHT_BOTTOM;

        static {
            SlVDowi();
        }

        private static /* synthetic */ void SlVDowi() {
            char[] charArray = "åéë¨áçëã¨äéÿ¨õîãêê¨ÌèïÄôïâáã".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 134);
            }
            String str = new String(charArray);
            char[] charArray2 = "åêïèïò".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 134);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public enum b {
        NONE,
        FIT_XY,
        FIT_START,
        FIT_CENTER,
        FIT_END,
        LEFT_TOP,
        LEFT_CENTER,
        LEFT_BOTTOM,
        CENTER_TOP,
        CENTER,
        CENTER_BOTTOM,
        RIGHT_TOP,
        RIGHT_CENTER,
        RIGHT_BOTTOM,
        LEFT_TOP_CROP,
        LEFT_CENTER_CROP,
        LEFT_BOTTOM_CROP,
        CENTER_TOP_CROP,
        CENTER_CROP,
        CENTER_BOTTOM_CROP,
        RIGHT_TOP_CROP,
        RIGHT_CENTER_CROP,
        RIGHT_BOTTOM_CROP,
        START_INSIDE,
        CENTER_INSIDE,
        END_INSIDE;

        static {
            LeYOp();
        }

        private static /* synthetic */ void LeYOp() {
            char[] charArray = "\u008a\u0086\u0084Ç\u008e\u0088\u0084\u008cÇ\u008b\u0086\u0090Ç\u009a\u0081\u008c\u0085\u0085Ç£\u0087\u0080«\u009b\u0080\u008d\u008e\u008c".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 233);
            }
            String str = new String(charArray);
            char[] charArray2 = "\u008a\u0085\u0080\u0087\u0080\u009d".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 233);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private int f12541a;
        private int b;

        public c(int i, int i2) {
            this.f12541a = i;
            this.b = i2;
        }

        public int a() {
            return this.f12541a;
        }

        public int b() {
            return this.b;
        }
    }

    public a(c cVar, c cVar2) {
        this.f12537a = cVar;
        this.b = cVar2;
    }

    private Matrix b() {
        return a(1.0f, 1.0f, EnumC0416a.LEFT_TOP);
    }

    private Matrix c() {
        return a(EnumC0416a.LEFT_TOP);
    }

    private Matrix d() {
        return a(EnumC0416a.CENTER);
    }

    private Matrix e() {
        return a(EnumC0416a.RIGHT_BOTTOM);
    }

    private Matrix f() {
        return (this.b.b() > this.f12537a.a() || this.b.b() > this.f12537a.b()) ? c() : b(EnumC0416a.LEFT_TOP);
    }

    private Matrix g() {
        return (this.b.b() > this.f12537a.a() || this.b.b() > this.f12537a.b()) ? d() : b(EnumC0416a.CENTER);
    }

    private Matrix h() {
        return (this.b.b() > this.f12537a.a() || this.b.b() > this.f12537a.b()) ? e() : b(EnumC0416a.RIGHT_BOTTOM);
    }

    public Matrix a(b bVar) {
        switch (AnonymousClass1.f12538a[bVar.ordinal()]) {
            case 1:
                return a();
            case 2:
                return b();
            case 3:
                return d();
            case 4:
                return c();
            case 5:
                return e();
            case 6:
                return b(EnumC0416a.LEFT_TOP);
            case 7:
                return b(EnumC0416a.LEFT_CENTER);
            case 8:
                return b(EnumC0416a.LEFT_BOTTOM);
            case 9:
                return b(EnumC0416a.CENTER_TOP);
            case 10:
                return b(EnumC0416a.CENTER);
            case 11:
                return b(EnumC0416a.CENTER_BOTTOM);
            case 12:
                return b(EnumC0416a.RIGHT_TOP);
            case 13:
                return b(EnumC0416a.RIGHT_CENTER);
            case 14:
                return b(EnumC0416a.RIGHT_BOTTOM);
            case 15:
                return c(EnumC0416a.LEFT_TOP);
            case 16:
                return c(EnumC0416a.LEFT_CENTER);
            case 17:
                return c(EnumC0416a.LEFT_BOTTOM);
            case 18:
                return c(EnumC0416a.CENTER_TOP);
            case 19:
                return c(EnumC0416a.CENTER);
            case 20:
                return c(EnumC0416a.CENTER_BOTTOM);
            case 21:
                return c(EnumC0416a.RIGHT_TOP);
            case 22:
                return c(EnumC0416a.RIGHT_CENTER);
            case 23:
                return c(EnumC0416a.RIGHT_BOTTOM);
            case 24:
                return f();
            case 25:
                return g();
            case 26:
                return h();
            default:
                return null;
        }
    }

    private Matrix b(EnumC0416a enumC0416a) {
        return a(this.b.a() / this.f12537a.a(), this.b.b() / this.f12537a.b(), enumC0416a);
    }

    private Matrix c(EnumC0416a enumC0416a) {
        float a2 = this.f12537a.a() / this.b.a();
        float b2 = this.f12537a.b() / this.b.b();
        float max = Math.max(a2, b2);
        return a(max / a2, max / b2, enumC0416a);
    }

    private Matrix a(float f, float f2, float f3, float f4) {
        Matrix matrix = new Matrix();
        matrix.setScale(f, f2, f3, f4);
        return matrix;
    }

    private Matrix a(float f, float f2, EnumC0416a enumC0416a) {
        switch (AnonymousClass1.b[enumC0416a.ordinal()]) {
            case 1:
                return a(f, f2, 0.0f, 0.0f);
            case 2:
                return a(f, f2, 0.0f, this.f12537a.b() / 2.0f);
            case 3:
                return a(f, f2, 0.0f, this.f12537a.b());
            case 4:
                return a(f, f2, this.f12537a.a() / 2.0f, 0.0f);
            case 5:
                return a(f, f2, this.f12537a.a() / 2.0f, this.f12537a.b() / 2.0f);
            case 6:
                return a(f, f2, this.f12537a.a() / 2.0f, this.f12537a.b());
            case 7:
                return a(f, f2, this.f12537a.a(), 0.0f);
            case 8:
                return a(f, f2, this.f12537a.a(), this.f12537a.b() / 2.0f);
            case 9:
                return a(f, f2, this.f12537a.a(), this.f12537a.b());
            default:
                throw new IllegalArgumentException("Illegal PivotPoint");
        }
    }

    private Matrix a() {
        return a(this.b.a() / this.f12537a.a(), this.b.b() / this.f12537a.b(), EnumC0416a.LEFT_TOP);
    }

    private Matrix a(EnumC0416a enumC0416a) {
        float a2 = this.f12537a.a() / this.b.a();
        float b2 = this.f12537a.b() / this.b.b();
        float min = Math.min(a2, b2);
        return a(min / a2, min / b2, enumC0416a);
    }
}

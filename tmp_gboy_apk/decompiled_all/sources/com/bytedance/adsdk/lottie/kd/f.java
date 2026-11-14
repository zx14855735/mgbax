package com.bytedance.adsdk.lottie.kd;

import ADYaiT.CtFAbx;
import android.graphics.Path;
import android.graphics.PointF;
import com.bytedance.adsdk.lottie.model.hf.am;
import com.bytedance.component.sdk.annotation.FloatRange;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class f {
    private static final PointF xj = new PointF();

    static {
        efgBjlx();
    }

    private static /* synthetic */ void efgBjlx() {
        char[] charArray = "ÕÙÛ\u0098Ñ×ÛÓ\u0098ÔÙÏ\u0098ÅÞÓÚÚ\u0098üØßôÄßÒÑÓ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 182);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÕÚßØßÂ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 182);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private static int hf(int i, int i2) {
        int i3 = i / i2;
        return (((i ^ i2) >= 0) || i % i2 == 0) ? i3 : i3 - 1;
    }

    public static boolean w(float f, float f2, float f3) {
        return f >= f2 && f <= f3;
    }

    public static int xj(int i, int i2, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        return (int) ((f * (i2 - i)) + i);
    }

    public static PointF xj(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static float hf(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }

    public static void xj(am amVar, Path path) {
        Path path2;
        path.reset();
        PointF xj2 = amVar.xj();
        path.moveTo(xj2.x, xj2.y);
        xj.set(xj2.x, xj2.y);
        int i = 0;
        while (i < amVar.w().size()) {
            com.bytedance.adsdk.lottie.model.xj xjVar = amVar.w().get(i);
            PointF xj3 = xjVar.xj();
            PointF hf = xjVar.hf();
            PointF w = xjVar.w();
            PointF pointF = xj;
            if (xj3.equals(pointF) && hf.equals(w)) {
                path.lineTo(w.x, w.y);
                path2 = path;
            } else {
                path2 = path;
                path2.cubicTo(xj3.x, xj3.y, hf.x, hf.y, w.x, w.y);
            }
            pointF.set(w.x, w.y);
            i++;
            path = path2;
        }
        Path path3 = path;
        if (amVar.hf()) {
            path3.close();
        }
    }

    public static float xj(float f, float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3) {
        return CtFAbx.A4TApA(f2, f, f3, f);
    }

    public static int xj(float f, float f2) {
        return xj((int) f, (int) f2);
    }

    private static int xj(int i, int i2) {
        return i - (i2 * hf(i, i2));
    }

    public static int xj(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i3, i));
    }
}

package com.bytedance.adsdk.lottie.model;

import android.graphics.PointF;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.component.sdk.annotation.ColorInt;
import com.bytedance.component.sdk.annotation.RestrictTo;
import java.lang.reflect.Method;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf {
    public float c;

    @ColorInt
    public int d;

    @ColorInt
    public int f;
    public PointF g;
    public String hf;
    public int kd;
    public boolean p;

    /* renamed from: pl, reason: collision with root package name */
    public PointF f10043pl;
    public float tf;
    public xj u;
    public float w;
    public String xj;
    public float y;

    public enum xj {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER;

        static {
            CfAE();
        }

        private static /* synthetic */ void CfAE() {
            char[] charArray = "vzx;rtxp;wzl;f}pyy;_{|Wg|qrp".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 21);
            }
            String str = new String(charArray);
            char[] charArray2 = "vy|{|a".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 21);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public hf(String str, String str2, float f, xj xjVar, int i, float f2, float f3, @ColorInt int i2, @ColorInt int i3, float f4, boolean z, PointF pointF, PointF pointF2) {
        xj(str, str2, f, xjVar, i, f2, f3, i2, i3, f4, z, pointF, pointF2);
    }

    public int hashCode() {
        int ordinal = ((this.u.ordinal() + (((int) (A2egSU.A2egSU(this.xj.hashCode() * 31, 31, this.hf) + this.w)) * 31)) * 31) + this.kd;
        long floatToRawIntBits = Float.floatToRawIntBits(this.y);
        return (((ordinal * 31) + ((int) (floatToRawIntBits ^ (floatToRawIntBits >>> 32)))) * 31) + this.f;
    }

    public void xj(String str, String str2, float f, xj xjVar, int i, float f2, float f3, @ColorInt int i2, @ColorInt int i3, float f4, boolean z, PointF pointF, PointF pointF2) {
        this.xj = str;
        this.hf = str2;
        this.w = f;
        this.u = xjVar;
        this.kd = i;
        this.y = f2;
        this.c = f3;
        this.f = i2;
        this.d = i3;
        this.tf = f4;
        this.p = z;
        this.f10043pl = pointF;
        this.g = pointF2;
    }

    public hf() {
    }
}

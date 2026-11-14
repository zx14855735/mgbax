package com.bytedance.adsdk.ugeno.xj;

import com.baidu.mobads.sdk.api.IAdInterListener;
import com.czhj.sdk.common.Database.SQLiteMTAHelper;
import com.sigmob.sdk.base.common.a;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public enum kd {
    TRANSLATE("translate", "translation", SQLiteMTAHelper.TABLE_POINT),
    TRANSLATE_X("translateX", "translationX", "float"),
    TRANSLATE_Y("translateY", "translationY", "float"),
    ROTATE_X("rotateX", "rotationX", "float"),
    ROTATE_Y("rotateY", "rotationY", "float"),
    ROTATE_Z("rotateZ", a.B, "float"),
    SCALE("scale", "scale", SQLiteMTAHelper.TABLE_POINT),
    SCALE_X("scaleX", "scaleX", "float"),
    SCALE_Y("scaleY", "scaleY", "float"),
    ALPHA("opacity", "alpha", "float"),
    BACKGROUND_COLOR("backgroundColor", "backgroundColor", IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL),
    BORDER_RADIUS("borderRadius", "borderRadius", "float"),
    RIPPLE("ripple", "ripple", "float"),
    SHINE("shine", "shine", "float");

    private final String e;
    private final String qt;
    private final String zg;

    static {
        KOgv();
    }

    kd(String str, String str2, String str3) {
        this.qt = str;
        this.zg = str2;
        this.e = str3;
    }

    private static /* synthetic */ void KOgv() {
        char[] charArray = "eik(agkc(di\u007f(uncjj(LhoDtobac".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 6);
        }
        String str = new String(charArray);
        char[] charArray2 = "ejohor".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 6);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public String hf() {
        return this.zg;
    }

    public String w() {
        return this.e;
    }

    public String xj() {
        return this.qt;
    }

    public static kd xj(String str) {
        str.getClass();
        switch (str) {
            case "translateX":
                return TRANSLATE_X;
            case "translateY":
                return TRANSLATE_Y;
            case "opacity":
                return ALPHA;
            case "ripple":
                return RIPPLE;
            case "scaleX":
                return SCALE_X;
            case "scaleY":
                return SCALE_Y;
            case "scale":
                return SCALE;
            case "translate":
                return TRANSLATE;
            case "backgroundColor":
                return BACKGROUND_COLOR;
            case "borderRadius":
                return BORDER_RADIUS;
            case "rotateX":
                return ROTATE_X;
            case "rotateY":
                return ROTATE_Y;
            case "rotateZ":
                return ROTATE_Z;
            default:
                return TRANSLATE_X;
        }
    }
}

package com.bytedance.adsdk.ugeno.widget.ratingbar;

import android.content.Context;
import android.graphics.Color;
import com.bytedance.adsdk.ugeno.hf.w;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj extends w<UGRatingBar> {
    private static final int no = Color.parseColor("#FFC642");
    private static final int qi = Color.parseColor("#e3e3e4");
    private float cu;
    private float lm;
    private int my;
    private float vi;
    private int xj;

    static {
        rLVB();
    }

    public xj(Context context) {
        super(context);
        this.xj = no;
        this.my = qi;
        this.lm = 4.0f;
        this.vi = 20.0f;
    }

    private static /* synthetic */ void rLVB() {
        char[] charArray = "\u0097\u009b\u0099Ú\u0093\u0095\u0099\u0091Ú\u0096\u009b\u008dÚ\u0087\u009c\u0091\u0098\u0098Ú¾\u009a\u009d¶\u0086\u009d\u0090\u0093\u0091".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 244);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0097\u0098\u009d\u009a\u009d\u0080".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 244);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public UGRatingBar xj() {
        UGRatingBar uGRatingBar = new UGRatingBar(this.hf);
        uGRatingBar.xj(this);
        return uGRatingBar;
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    public void hf() {
        super.hf();
        if (q()) {
            ((UGRatingBar) this.kd).xj(this.lm, this.xj, this.my, this.vi, (int) this.cu);
        } else {
            ((UGRatingBar) this.kd).xj(this.lm, this.xj, this.my, this.vi, 5);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    public void xj(String str, String str2) {
        super.xj(str, str2);
        str.getClass();
        switch (str) {
            case "highLightColor":
            case "highlightColor":
                this.xj = com.bytedance.adsdk.ugeno.y.xj.xj(str2);
                break;
            case "lowLightColor":
            case "lowlightColor":
                this.my = com.bytedance.adsdk.ugeno.y.xj.xj(str2, qi);
                break;
            case "gap":
                this.cu = com.bytedance.adsdk.ugeno.y.w.xj(str2, 0.0f);
                break;
            case "size":
                this.vi = com.bytedance.adsdk.ugeno.y.w.xj(str2, 20.0f);
                break;
            case "score":
                this.lm = com.bytedance.adsdk.ugeno.y.w.xj(str2, 4.0f);
                break;
        }
    }
}

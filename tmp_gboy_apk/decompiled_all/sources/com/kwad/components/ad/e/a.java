package com.kwad.components.ad.e;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.config.item.s;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class a {
    public static s dd = new s("kwaiLogoUrl", null);
    public static s de = new s("attentionTips", "去关注TA");
    public static s df = new s("viewHomeTips", "查看TA的主页");
    public static s dg = new s("buyNowTips", "立即抢购");

    static {
        gbJEnDH();
    }

    private static /* synthetic */ void gbJEnDH() {
        char[] charArray = "\u0085\u0089\u008bÈ\u0081\u0087\u008b\u0083È\u0084\u0089\u009fÈ\u0095\u008e\u0083\u008a\u008aÈ¬\u0088\u008f¤\u0094\u008f\u0082\u0081\u0083".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 230);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0085\u008a\u008f\u0088\u008f\u0092".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 230);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @InvokeBy(invokerClass = e.class, methodId = "initConfigList")
    public static void init() {
    }
}

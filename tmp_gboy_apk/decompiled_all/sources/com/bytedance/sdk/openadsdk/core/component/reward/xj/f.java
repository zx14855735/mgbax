package com.bytedance.sdk.openadsdk.core.component.reward.xj;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.pz;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class f extends w {
    private static final f hf = new f(pz.getContext());

    static {
        EZiLD();
    }

    private f(Context context) {
        super(context);
    }

    private static /* synthetic */ void EZiLD() {
        char[] charArray = "ÌÀÂ\u0081ÈÎÂÊ\u0081ÍÀÖ\u0081ÜÇÊÃÃ\u0081åÁÆíÝÆËÈÊ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 175);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÌÃÆÁÆÛ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 175);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static f xj() {
        return hf;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.xj.w
    public int hf() {
        return 7;
    }

    public void xj(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, String str, int i, u uVar) {
        com.bytedance.sdk.openadsdk.core.component.reward.business.hf.w wVar = new com.bytedance.sdk.openadsdk.core.component.reward.business.hf.w();
        wVar.xj(str);
        wVar.xj(i + 1);
        xj(hfVar, uVar, wVar);
    }
}

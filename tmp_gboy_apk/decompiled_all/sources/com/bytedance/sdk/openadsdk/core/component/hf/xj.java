package com.bytedance.sdk.openadsdk.core.component.hf;

import com.bytedance.sdk.openadsdk.zg.w.hf.d;
import java.lang.reflect.Method;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj extends com.bytedance.sdk.openadsdk.core.kd.xj<com.bytedance.sdk.openadsdk.jk.xj.hf.xj.hf, List<d>> {
    private static final xj hf = new xj();

    static {
        tArm();
    }

    private xj() {
    }

    public static xj hf() {
        return hf;
    }

    private static /* synthetic */ void tArm() {
        char[] charArray = "BNL\u000fF@LD\u000fCNX\u000fRIDMM\u000fkOHcSHEFD".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '!');
        }
        String str = new String(charArray);
        char[] charArray2 = "BMHOHU".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '!');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.xj
    public int xj() {
        return 9;
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.xj
    public void xj(com.bytedance.sdk.openadsdk.jk.xj.hf.xj.hf hfVar, List<d> list) {
        if (hfVar != null) {
            hfVar.xj(list);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.xj
    public void xj(com.bytedance.sdk.openadsdk.jk.xj.hf.xj.hf hfVar, int i, String str) {
        if (hfVar != null) {
            hfVar.xj(i, str);
        }
    }
}

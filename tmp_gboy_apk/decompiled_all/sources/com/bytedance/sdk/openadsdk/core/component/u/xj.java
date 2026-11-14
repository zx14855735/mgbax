package com.bytedance.sdk.openadsdk.core.component.u;

import com.bytedance.sdk.openadsdk.jk.xj.hf.xj.w;
import com.bytedance.sdk.openadsdk.zg.w.hf.tf;
import java.lang.reflect.Method;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj extends com.bytedance.sdk.openadsdk.core.kd.xj<w, List<tf>> {
    private static final xj hf = new xj();

    static {
        zmXNpM();
    }

    private xj() {
    }

    public static xj hf() {
        return hf;
    }

    private static /* synthetic */ void zmXNpM() {
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

    @Override // com.bytedance.sdk.openadsdk.core.kd.xj
    public int xj() {
        return 6;
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.xj
    public void xj(w wVar, List<tf> list) {
        if (wVar != null) {
            wVar.xj(list);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.xj
    public void xj(w wVar, int i, String str) {
        if (wVar != null) {
            wVar.xj(i, str);
        }
    }
}

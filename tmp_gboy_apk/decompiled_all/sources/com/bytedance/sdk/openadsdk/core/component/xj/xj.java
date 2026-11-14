package com.bytedance.sdk.openadsdk.core.component.xj;

import com.bytedance.sdk.openadsdk.jk.xj.hf.xj.kd;
import com.bytedance.sdk.openadsdk.zg.w.hf.g;
import java.lang.reflect.Method;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj extends com.bytedance.sdk.openadsdk.core.kd.xj<kd, List<g>> {
    private static final xj hf = new xj();

    static {
        CsAgTd();
    }

    private xj() {
    }

    private static /* synthetic */ void CsAgTd() {
        char[] charArray = "\b\u0004\u0006E\f\n\u0006\u000eE\t\u0004\u0012E\u0018\u0003\u000e\u0007\u0007E!\u0005\u0002)\u0019\u0002\u000f\f\u000e".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'k');
        }
        String str = new String(charArray);
        char[] charArray2 = "\b\u0007\u0002\u0005\u0002\u001f".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'k');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static xj hf() {
        return hf;
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.xj
    public int xj() {
        return 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.xj
    public void xj(kd kdVar, List<g> list) {
        if (kdVar != null) {
            kdVar.xj(list);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.xj
    public void xj(kd kdVar, int i, String str) {
        if (kdVar != null) {
            kdVar.xj(i, str);
        }
    }
}

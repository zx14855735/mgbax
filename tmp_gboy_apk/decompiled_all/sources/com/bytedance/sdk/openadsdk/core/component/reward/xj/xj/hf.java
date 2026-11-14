package com.bytedance.sdk.openadsdk.core.component.reward.xj.xj;

import android.text.TextUtils;
import com.bytedance.sdk.component.u.hf.w;
import com.bytedance.sdk.openadsdk.core.a.ai;
import com.bytedance.sdk.openadsdk.core.a.j;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf {
    private static final w xj = j.xj("full_reward_adslot");

    static {
        fluhugC();
    }

    private static /* synthetic */ void fluhugC() {
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

    public com.bytedance.sdk.openadsdk.zg.w.w.hf xj(String str) {
        try {
            return ai.xj(xj.get(str, (String) null));
        } catch (Throwable unused) {
            return null;
        }
    }

    public void xj(String str, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar) {
        if (hfVar != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                xj.put(str, ai.xj(hfVar, str).toString());
            } catch (Throwable unused) {
            }
        }
    }
}
